package org.ifbma.entity;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Marshalling and Unmarshalling class for generic entity representation by
 * class and enumerable id. To save some XML in REST payloads.
 * <p>
 * @author norbert
 */
public final class EntityShortener
        extends XmlAdapter<ShortElement, ShortableElement> {

    /**
     * Logger for diagnostic output and statistics.
     */
    private static final Logger LOG = Logger.getLogger(EntityShortener.class.getName());

    /**
     * Not supported yet. Unmarshal Short element to retrieve original entity.
     * <p>
     * @param vt Short element to unmarshal
     * @return Entity by class and id of given short element.
     * @throws Exception UnsupportedOperationException as not yet implemented.
     */
    @Override
    public ShortableElement unmarshal(final ShortElement vt) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Marshal Element to reduced Xml.
     * <p>
     * @param bt Element to shorten.
     * @return Short Xml Element.
     * @throws Exception All Marshalling and Object creation exceptions are
     *                   given to the caller.
     */
    @Override
    public ShortElement marshal(final ShortableElement bt) throws Exception {
        LOG.log(Level.INFO, "ConsignmentStatusAdaptor marshal: {0}", bt);
        if (bt == null) {
            return null;
        }
        return new ShortElement(bt);
    }
}
