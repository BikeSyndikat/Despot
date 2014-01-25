package org.ifbma.entity;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ShortElementTest {

    /**
     * Test of getClazz method, of class ShortElement.
     */
    @Test
    public void testGetIdClazz() {
        ShortableElement shortableElement = new ShortableElementImpl();
        ShortElement instance = new ShortElement(shortableElement);
        assertEquals(new Integer(17), instance.getId());
        assertEquals("shortableelementimpl", instance.getClazz());
    }
}

class ShortableElementImpl extends ShortableElement {

    @Override
    public Integer getId() {
        return 17;
    }

    @Override
    public String getClazz() {
        return "someCLaZZ";
    }
}
