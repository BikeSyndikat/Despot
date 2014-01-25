package org.ifbma.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Short element that just contains original class (or alike for
 * identification) and the id of an entry. Id must be enumerable, thus of type
 * representable by Integer.
 * <p>
 * @author norbert
 * @param <T> Type to shorten, will use the getId and getClass from that.
 */
@XmlRootElement
public class ShortElement<T extends ShortableElement> extends ShortableElement {

    /**
     * Id of object.
     */
    private Integer id;
    /**
     * Class identifier, so type of object.
     */
    private String clazz = "someDefault";

    /**
     * Empty default constructor for jersey.
     */
    public ShortElement() {
    }

    /**
     * Construct ShortElement by arbitrary entity example.
     * <p>
     * @param entity Entity to get class and id from.
     */
    public ShortElement(final T entity) {
        id = entity.getId();
        clazz = entity.getClass().getSimpleName().toLowerCase();
    }

    /**
     * Retrieve class name.
     * <p>
     * @return Name of class.
     */
    @Override
    public final String getClazz() {
        return clazz;
    }

    /**
     * Set class name for client side generic URL construction.
     * <p>
     * @param clazz Class name.
     */
    public final void setClazz(final String clazz) {
        this.clazz = clazz;
    }

    /**
     * Retrieve enumerable identifier.
     * <p>
     * @return Enumerable Identifier.
     */
    @Override
    public final Integer getId() {
        return id;
    }

    /**
     * Set id of the element.
     * <p>
     * @param id Integer with enumerable identifier.
     */
    public final void setId(final Integer id) {
        this.id = id;
    }
}
