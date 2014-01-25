package org.ifbma.entity;

import java.util.Date;
import org.junit.*;

import static org.junit.Assert.*;

public class ConsignmentTest {

    /**
     * Test of getId method, of class Consignment.
     */
    @Test
    public void testGetIdPriceCreatedModified() { //Integer id, double price, Date created, Date modified) {
        Integer id = 5;
        double price = 2.9;
        Date created = new Date(2000L);
        Date modified = new Date(3000L);
        Consignment instance = new Consignment(id, price, created, modified);
        assertEquals(id, instance.getId());
        assertEquals(price, instance.getPrice(), 0.0);
        assertEquals(created, instance.getCreated());
        assertEquals(modified, instance.getModified());
    }

    /**
     * Test of setPrice method, of class Consignment.
     */
    @Test
    public void testSetPrice() {
        double price = 0.9;
        Consignment instance = new Consignment();
        Date modified = new Date(10000L);
        instance.setModified(modified);
        instance.setPrice(price);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setComment method, of class Consignment.
     */
    @Test
    public void testSetComment() {
        String comment = "setComment";
        Consignment instance = new Consignment();
        Date modified = new Date(10000L);
        instance.setModified(modified);
        instance.setComment(comment);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setScheduled method, of class Consignment.
     */
    @Test
    public void testSetScheduled() {
        Date modified = new Date(10000L);
        Date scheduled = new Date();
        Consignment instance = new Consignment();
        instance.setModified(modified);
        instance.setScheduled(scheduled);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setRider method, of class Consignment.
     */
    @Test
    public void testSetRider() {
        Rider rider = new Rider();
        Consignment instance = new Consignment();
        Date modified = new Date(10000L);
        instance.setModified(modified);
        instance.setRider(rider);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setStatus method, of class Consignment.
     */
    @Test
    public void testSetStatus() {
        ConsignmentStatus status = null;
        Consignment instance = new Consignment();
        Date modified = new Date(10000L);
        instance.setModified(modified);
        instance.setStatus(status);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setPickup method, of class Consignment.
     */
    @Test
    public void testSetPickup() {
        Address pickup = null;
        Consignment instance = new Consignment();
        Date modified = new Date(10000L);
        instance.setModified(modified);
        instance.setPickup(pickup);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setCustomer method, of class Consignment.
     */
    @Test
    public void testSetCustomer() {
        Customer customer = null;
        Consignment instance = new Consignment();
        Date modified = new Date(10000L);
        instance.setModified(modified);
        instance.setCustomer(customer);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setDelivery method, of class Consignment.
     */
    @Test
    public void testSetDelivery() {
        Address delivery = null;
        Consignment instance = new Consignment();
        Date modified = new Date(10000L);
        instance.setModified(modified);
        instance.setDelivery(delivery);
        assertTrue(instance.getModified().after(modified));
    }

}
