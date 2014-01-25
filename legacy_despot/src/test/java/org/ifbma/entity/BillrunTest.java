package org.ifbma.entity;

import java.util.Date;
import org.junit.*;

import static org.junit.Assert.*;

public class BillrunTest {

    public BillrunTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Billrun.
     */
    @Test
    public void testGetId() {
        Billrun instance = new Billrun(2);
        Integer expResult = 2;
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Billrun.
     */
    @Test
    public void testGetIdStartdateEnddateStatus() {
        Integer id = 6;
        Date startdate = new Date(7L);
        Date enddate = new Date(9L);
        int status = 20;
        Billrun instance = new Billrun(id, startdate, enddate, status);
        assertEquals(id, instance.getId());
        assertEquals(startdate, instance.getStartdate());
        assertEquals(enddate, instance.getEnddate());
        assertEquals(status, instance.getStatus());
    }

    /**
     * Test of hashCode method, of class Bill.
     */
    @Test
    public void testHashCodeNull() {
        Billrun instance = new Billrun();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Bill.
     */
    @Test
    public void testHashCode() {
        Billrun instance = new Billrun(5);
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
        Billrun instance = new Billrun();
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
        Billrun instance = new Billrun(5);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bill.
     */
    @Test
    public void testEquals() {
        Object object = new Billrun(5);
        Billrun instance = new Billrun();
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
        Billrun instance = new Billrun(5);
        String expResult = instance.getClass().getCanonicalName() + "[ id=5 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
