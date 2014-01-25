package org.ifbma.entity;

import org.junit.*;

import static org.junit.Assert.*;

public class RiderTest {

    /**
     * Test of toString method, of class Rider.
     */
    @Test
    public void testToString() {
        Rider instance = new Rider(3, "nick");
        String expResult = "nick (3) ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClazz method, of class Rider.
     */
    @Test
    public void testGetClazz() {
        Rider instance = new Rider();
        assertNull(instance.getClazz());
    }
}
