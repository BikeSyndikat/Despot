package org.ifbma.entity;

import org.junit.*;

import static org.junit.Assert.*;

public class ConsignmentStatusTest {

    /**
     * Test of getId method, of class ConsignmentStatus.
     */
    @Test
    public void testGetIdName() {
        Integer id = 7;
        String name = "some name";
        ConsignmentStatus instance = new ConsignmentStatus(id, name);
        assertEquals(id, instance.getId());
        assertEquals(name, instance.getName());
    }

    /**
     * Test of hashCode method, of class Bill.
     */
    @Test
    public void testHashCodeNull() {
        ConsignmentStatus instance = new ConsignmentStatus();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ConsignmentStatus.
     */
    @Test
    public void testHashCode() {
        ConsignmentStatus instance = new ConsignmentStatus(5);
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
        ConsignmentStatus instance = new ConsignmentStatus();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bill.
     */
    @Test
    public void testEqualsNull() {
        Object object = new ConsignmentStatus();
        ConsignmentStatus instance = new ConsignmentStatus(5);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ConsignmentStatus.
     */
    @Test
    public void testEquals() {
        Object object = new ConsignmentStatus(5);
        ConsignmentStatus instance = new ConsignmentStatus();
        instance.setId(5);
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ConsignmentStatus.
     */
    @Test
    public void testToString() {
        ConsignmentStatus instance = new ConsignmentStatus();
        instance.setName("instance name");
        instance.setComment("instance comment");
        String expResult = "instance name (instance comment) ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClazz method, of class ConsignmentStatus.
     */
    @Test
    public void testGetClazz() {
        ConsignmentStatus instance = new ConsignmentStatus();
        String expResult = null;
        String result = instance.getClazz();
        assertEquals(expResult, result);
    }
}
