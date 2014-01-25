package org.ifbma.entity;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author norbert
 */
public abstract class ShortableElement {

    /**
     * Get Identifiable object (URL).
     * <p>
     * @return Integer with enumerated Id.
     */
    @XmlElement
    public abstract Integer getId();

    /**
     * Get class (for generic URL construction).
     * <p>
     * @return String with class name.
     */
    @XmlElement
    public abstract String getClazz();
}
