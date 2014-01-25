package org.ifbma.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class EntityShortenerTest {

    /**
     * Test of unmarshal method, of class EntityShortener.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testUnmarshal() throws Exception {
        ShortElement vt = null;
        EntityShortener instance = new EntityShortener();
        ShortableElement expResult = null;
        ShortableElement result = instance.unmarshal(vt);
    }

    /**
     * Test of marshal method, of class EntityShortener.
     */
    @Test
    public void testMarshalNull() throws Exception {
        ShortableElement bt = null;
        EntityShortener instance = new EntityShortener();
        ShortElement expResult = null;
        ShortElement result = instance.marshal(bt);
        assertEquals(expResult, result);
    }

    /**
     * Test of marshal method, of class EntityShortener.
     */
    @Test
    public void testMarshal() throws Exception {
        ShortableElement bt = new ShortableElement() {
            @Override
            public Integer getId() {
                return 3;
            }

            @Override
            public String getClazz() {
                return "org.ifbma.ShortElement";
            }
        };
        ShortElement expResult = new ShortElement(bt);

        EntityShortener instance = new EntityShortener();
        ShortElement result = instance.marshal(bt);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getClazz(), result.getClazz());
    }
}
