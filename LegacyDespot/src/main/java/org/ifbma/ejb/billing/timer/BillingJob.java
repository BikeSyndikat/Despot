package org.ifbma.ejb.billing.timer;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.*;
import org.ifbma.ejb.*;
import org.ifbma.entity.*;

@Singleton
@LocalBean
public class BillingJob {

    static final int BILLING_RUN_DELAY = 10000;

    private static final Logger log = Logger.getLogger(BillingJob.class.getName());
    @Resource
    TimerService timerService;
    @EJB
    ConsignmentFacade consignmentFacade;
    @EJB
    CustomerFacade customerFacade;
    @EJB
    AddressFacade addressFacade;
    @EJB
    ConsignmentStatusFacade consignmentStatusFacade;
    @EJB
    DueBillsSummedFacade dueBillsSummedFacade;

    private Date billingStart;
    private Date billingEnd;
    private boolean active = false;
    private boolean billingsDue = false;
    private Date lastProgrammaticTimeout;
    private Date lastAutomaticTimeout;
    private Timer timer;

    @Schedule(minute = "*", second = "*/2", hour = "*", persistent = true)
    public void checkForBillingsDue() {
        if (active && !billingsDue) {
            log.log(Level.FINEST,
                    "check if billings are due: {0} - {1}",
                    new Object[]{new Date(), System.currentTimeMillis()});
            this.setLastAutomaticTimeout(new Date());
            if (isBillingsDue()) {
                log.log(Level.INFO,
                        "Billings scheduled: {0} - {1}",
                        new Object[]{new Date(), System.currentTimeMillis()});
                billingsDue = true;
                setTimer(BILLING_RUN_DELAY);
            }
        }
    }

    @Timeout
    public void processDueBillings(Timer timer) {
        this.setLastProgrammaticTimeout(new Date());
        if (billingsDue) {
            // TODO: fire a grouped statement per customer
            // TODO: sum up in SQL
            // TODO: read into new customerBill object
            // TODO: fire a find statement on Consignment per customer
            // TODO: fill those bill details into blob
            // TODO: persist each sum and each detail blob
            log.log(Level.INFO,
                    "Processing due billings.{0} - {1}",
                    new Object[]{new Date(), System.currentTimeMillis()});
            List<Consignment> billableConsignments
                    = consignmentFacade.findBillable(billingStart, billingEnd,
                                                     getBillableConsignmentStatus());
            double sum = 0.0;
            for (Consignment c : billableConsignments) {
                sum += c.getPrice();
            }
            billingsDue = false;
            billingStart = null;
        }
    }

    private ConsignmentStatus getBillableConsignmentStatus() {
        List<ConsignmentStatus> status = consignmentStatusFacade.findAll();
        ConsignmentStatus s = status.get(getRandomInt(status.size()));
        log.log(Level.INFO, "Status for billing is {0}", s.getName());
        return s;
    }

    private boolean isBillingsDue() {
        // do we have a start date for a billing run?
        if (billingStart != null) {
            // do we have an end date for a billing run?
            if (billingEnd != null) {
                return true;
            }
        }
        return false;
    }

    public Date getBillingStart() {
        return billingStart;
    }

    public void setBillingStart(Date billingStart) {
        this.billingStart = billingStart;
    }

    public Date getBillingEnd() {
        return billingEnd;
    }

    public void setBillingEnd(Date billingEnd) {
        this.billingEnd = billingEnd;
    }

    private void generateConsignment() {
        List<Customer> cashCustomers = customerFacade.findReservedCashEntry();
        List<Address> addresses = addressFacade.findAll();
        List<ConsignmentStatus> status = consignmentStatusFacade.findAll();
        if (cashCustomers.size() > 0 && addresses.size() > 1 && status.size() > 0) {
            Consignment consignment = new Consignment();
            consignment.setCustomer(cashCustomers.get(0));
            consignment.setPickup(addresses.get(getRandomInt(addresses.size())));
            consignment.setDelivery(addresses.get(getRandomInt(addresses.size())));
            consignment.setScheduled(new Date());
            consignment.setStatus(status.get(getRandomInt(status.size())));
            consignment.setPrice(-3.0);
            try {
                consignmentFacade.create(consignment);
//                log.info("Found a special cash customer, creted pickup. "
//                        + consignment.getId() + ": "
//                        + consignment.getPickup().getLine1());
            } catch (Exception e) {
                log.log(Level.SEVERE,
                        "Could not create consignment {0} {1}",
                        new Object[]{consignment.toString(), e.getMessage()});
            }
        }
    }

    private int getRandomInt(int max) {
        double random = Math.round(Math.random() * ((double) max - 0.5));
        return (new Double(random)).intValue();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    void setTimer(long intervalDuration) {
        log.log(Level.INFO,
                "Setting a programmatic timeout for {0} milliseconds from now at {1}",
                new Object[]{intervalDuration, System.currentTimeMillis() + intervalDuration});
        this.timer = timerService.createTimer(intervalDuration,
                                              "Created new programmatic timer");
    }

    public void enableActivity() {
        active = true;
    }

    public void disableActivity() {
        active = false;
    }

    public String getLastAutomaticTimeout() {
        if (lastAutomaticTimeout != null) {
            return lastAutomaticTimeout.toString();
        } else {
            return "never";
        }
    }

    public void setLastAutomaticTimeout(Date lastAutomaticTimeout) {
        this.lastAutomaticTimeout = lastAutomaticTimeout;
    }

    public String getLastProgrammaticTimeout() {
        if (lastProgrammaticTimeout != null) {
            return lastProgrammaticTimeout.toString();
        } else {
            return "never";
        }
    }

    public void setLastProgrammaticTimeout(Date lastProgrammaticTimeout) {
        this.lastProgrammaticTimeout = lastProgrammaticTimeout;
    }

    public TimerService getTimerService() {
        return timerService;
    }

    public void setTimerService(TimerService timerService) {
        this.timerService = timerService;
    }

    public String getNextTimeout() {
        if (this.timer == null) {
            return "never";
        }
        return this.timer.getNextTimeout() + ", remaining: "
                + this.timer.getTimeRemaining();
    }

}
