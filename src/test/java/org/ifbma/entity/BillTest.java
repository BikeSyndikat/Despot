package org.ifbma.entity;

import java.util.Date;
import org.junit.*;

import static org.junit.Assert.*;

public class BillTest {

    /**
     * Test of getId method, of class Bill.
     */
    @Test
    public void testGetId() {
        Bill instance = new Bill(5);
        Integer expResult = 5;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Bill.
     */
    @Test
    public void testGetIdStartdateEnddateAmountDueBillType() {
        Integer id = 3;
        Date startdate = new Date(7L);
        Date enddate = new Date(8L);
        double amountDue = 9.0;
        int billType = 10;
        Bill instance = new Bill(id, startdate, enddate, amountDue, billType);
        assertEquals(id, instance.getId());
        assertEquals(startdate, instance.getStartdate());
        assertEquals(enddate, instance.getEnddate());
        assertEquals(amountDue, instance.getAmountDue(), 0.0);
        assertEquals(billType, instance.getBillType());
    }

    /**
     * Test of hashCode method, of class Bill.
     */
    @Test
    public void testHashCodeNull() {
        Bill instance = new Bill();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Bill.
     */
    @Test
    public void testHashCode() {
        Bill instance = new Bill(5);
        int expResult = new Integer(5).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bill.
     */
    @Test
    public void testEqualsOtherObject() {
        Object object = null;
        Bill instance = new Bill();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bill.
     */
    @Test
    public void testEqualsNull() {
        Object object = new Bill();
        Bill instance = new Bill(5);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bill.
     */
    @Test
    public void testEquals() {
        Object object = new Bill(5);
        Bill instance = new Bill();
        instance.setId(5);
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Bill.
     */
    @Test
    public void testToString() {
        Bill instance = new Bill();
        Customer customer = new Customer();
        customer.setComment("customercomment");
        instance.setCustomer(customer);
        instance.setEnddate(new Date(1000L));
        String expResult = "customercomment Thu Jan 01 01:00:01 CET 1970";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
