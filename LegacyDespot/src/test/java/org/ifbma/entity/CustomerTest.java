package org.ifbma.entity;

import java.util.Date;
import org.junit.*;

import static org.junit.Assert.*;

public class CustomerTest {

    /**
     * Test of getId method, of class Customer.
     */
    @Test
    public void testGetIdCreatedModifiedPaymentstatus() { //(Integer id, Date created, Date modified, int paymentstatus)
        Integer id = 7;
        Date created = new Date(2332L);
        Date modified = new Date(283792L);
        int paymentstatus = 27;
        Customer instance = new Customer(id, created, modified, paymentstatus);
        assertEquals(id, instance.getId());
        assertEquals(created, instance.getCreated());
        assertEquals(modified, instance.getModified());
        assertEquals(paymentstatus, instance.getPaymentstatus());
    }

    /**
     * Test of setComment method, of class Customer.
     */
    @Test
    public void testSetComment() {
        String comment = "some comment";
        Customer instance = new Customer();
        Date modified = new Date(24234L);
        instance.setModified(modified);
        instance.setComment(comment);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setPaymentstatus method, of class Customer.
     */
    @Test
    public void testSetPaymentstatus() {
        int paymentstatus = 20;
        Customer instance = new Customer();
        Date modified = new Date(3242L);
        instance.setModified(modified);
        instance.setPaymentstatus(paymentstatus);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of setAddress method, of class Customer.
     */
    @Test
    public void testSetAddress() {
        Address address = null;
        Customer instance = new Customer();
        Date modified = new Date(234L);
        instance.setModified(modified);
        instance.setAddress(address);
        assertTrue(instance.getModified().after(modified));
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        Customer instance = new Customer();
        String expResult = "comment (3 )";
        instance.setComment("comment");
        instance.setId(3);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormattedAddress method, of class Customer.
     */
    @Test
    public void testGetFormattedAddress() {
        Customer instance = new Customer();
        Address address = new Address();
        final String LF = "\n";
        String expResult = "comment" + LF + "4" + LF + LF + " ==== "
                + address.getFormattedAddress();
        instance.setComment("comment");
        instance.setPaymentstatus(4);
        instance.setAddress(address);
        String result = instance.getFormattedAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClazz method, of class Customer.
     */
    @Test
    public void testGetClazz() {
        Customer instance = new Customer();
        String expResult = null;
        String result = instance.getClazz();
        assertEquals(expResult, result);
    }
}
