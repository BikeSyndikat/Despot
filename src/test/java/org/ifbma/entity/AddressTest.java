package org.ifbma.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    /**
     * Test of getId method, of class Address.
     */
    @Test
    public void testGetId() {
        Address instance = new Address(5);
        Integer expResult = 5;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Address.
     */
    @Test
    public void testGetIdCountry() {
        Integer id = 5;
        String country = "some country";
        Address instance = new Address(id, country);
        assertEquals(id, instance.getId());
        assertEquals(country, instance.getCountry());
    }

    /**
     * Test of hashCode method, of class Address.
     */
    @Test
    public void testHashCodeNull() {
        System.out.println("hashCode");
        Address instance = new Address();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Address.
     */
    @Test
    public void testHashCode() {
        Address instance = new Address(5);
        int expResult = new Integer(5).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Address.
     */
    @Test
    public void testEqualsOtherObject() {
        Object object = null;
        Address instance = new Address();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Address.
     */
    @Test
    public void testEqualsFalse() {
        Object object = new Address(5);
        Address instance = new Address();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Address.
     */
    @Test
    public void testEquals() {
        Object object = new Address(5);
        Address instance = new Address(5);
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Address.
     */
    @Test
    public void testToString() {
        Address instance = new Address();
        instance.setLine1("line1");
        String expResult = "line1";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClazz method, of class Address.
     */
    @Test
    public void testGetClazz() {
        Address instance = new Address();
        String expResult = null;
        String result = instance.getClazz();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormattedAddress method, of class Address.
     */
    @Test
    public void testGetFormattedAddress() {
        final String lf = "\n";
        Address instance = new Address();
        instance.setLine1("line1");
        instance.setLine2("line2");
        instance.setAdditionalDetail("additionalDetail");
        instance.setStreet("street");
        instance.setNumber("number");
        instance.setZip("zip");
        instance.setCity("city");
        instance.setCountry("country");
        instance.setProvince("province");
        String expResult = "line1" + lf + "line2" + lf + "additionalDetail" + lf
                + "street" + " " + "number" + lf
                + "zip" + " " + "city"
                + "country" + ", " + "province";
        String result = instance.getFormattedAddress();
        assertEquals(expResult, result);
    }
}
