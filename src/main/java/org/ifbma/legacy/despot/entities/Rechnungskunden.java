package org.ifbma.legacy.despot.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author norbert
 */
@Entity
@Table(name = "\"Rechnungskunden\"", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Kuerzel"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rechnungskunden.findAll", query = "SELECT r FROM Rechnungskunden r"),
    @NamedQuery(name = "Rechnungskunden.findById", query = "SELECT r FROM Rechnungskunden r WHERE r.id = :id"),
    @NamedQuery(name = "Rechnungskunden.findByKuerzel", query = "SELECT r FROM Rechnungskunden r WHERE r.kuerzel = :kuerzel"),
    @NamedQuery(name = "Rechnungskunden.findByKdNr", query = "SELECT r FROM Rechnungskunden r WHERE r.kdNr = :kdNr"),
    @NamedQuery(name = "Rechnungskunden.findByKundeKuerzel", query = "SELECT r FROM Rechnungskunden r WHERE r.kundeKuerzel = :kundeKuerzel")})
public class Rechnungskunden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "\"ID\"", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "\"Kuerzel\"", nullable = false, length = 254)
    private String kuerzel;
    @Size(max = 254)
    @Column(name = "\"Firmierung1\"", length = 254)
    private String firmierung1;
    @Size(max = 254)
    @Column(name = "\"Firmierung2\"", length = 254)
    private String firmierung2;
    @Size(max = 254)
    @Column(name = "\"Straße\"", length = 254)
    private String straße;
    @Size(max = 8)
    @Column(name = "\"PLZ\"", length = 8)
    private String plz;
    @Size(max = 254)
    @Column(name = "\"Ort\"", length = 254)
    private String ort;
    @Size(max = 254)
    @Column(name = "\"Kd-Nr\"", length = 254)
    private String kdNr;
    @Size(max = 254)
    @Column(name = "\"Zonenkuerzel\"", length = 254)
    private String zonenKürzel;
    @Size(max = 254)
    @Column(name = "\"Telefon\"", length = 254)
    private String telefon;
    @Size(max = 254)
    @Column(name = "\"Durchwahl\"", length = 254)
    private String durchwahl;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "\"Fax\"", length = 254)
    private String fax;
    @Size(max = 254)
    @Column(name = "\"Ansprechpartner\"", length = 254)
    private String ansprechpartner;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "\"e-mail\"", length = 254)
    private String eMail;
    @Size(max = 254)
    @Column(name = "\"Homepage\"", length = 254)
    private String homepage;
    @Size(max = 254)
    @Column(name = "\"Branche\"", length = 254)
    private String branche;
    @Size(max = 254)
    @Column(name = "\"Rechtsform HRA/HRB/Ust-Id\"", length = 254)
    private String ustId;
    @Size(max = 254)
    @Column(name = "\"Sonstiges\"", length = 254)
    private String sonstiges;
    @Size(max = 254)
    @Column(name = "\"Fragebogen\"", length = 254)
    private String fragebogen;
    @Size(max = 254)
    @Column(name = "\"Bemerkung\"", length = 254)
    private String bemerkung;
    @Size(max = 254)
    @Column(name = "\"Anrede\"", length = 254)
    private String anrede;
    @Size(max = 254)
    @Column(name = "\"Skonto\"", length = 254)
    private String skonto;
    @Size(max = 254)
    @Column(name = "\"Kunde-Kuerzel\"", length = 254)
    private String kundeKuerzel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kuerzel")
    private List<Auftragsannahme> auftragsannahmeList;

    public Rechnungskunden() {
    }

    public Rechnungskunden(Integer id) {
        this.id = id;
    }

    public Rechnungskunden(Integer id, String kuerzel) {
        this.id = id;
        this.kuerzel = kuerzel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public String getFirmierung1() {
        return firmierung1;
    }

    public void setFirmierung1(String firmierung1) {
        this.firmierung1 = firmierung1;
    }

    public String getFirmierung2() {
        return firmierung2;
    }

    public void setFirmierung2(String firmierung2) {
        this.firmierung2 = firmierung2;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getKdNr() {
        return kdNr;
    }

    public void setKdNr(String kdNr) {
        this.kdNr = kdNr;
    }

    public String getZonenKürzel() {
        return zonenKürzel;
    }

    public void setZonenKürzel(String zonenKürzel) {
        this.zonenKürzel = zonenKürzel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDurchwahl() {
        return durchwahl;
    }

    public void setDurchwahl(String durchwahl) {
        this.durchwahl = durchwahl;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public String getUstId() {
        return ustId;
    }

    public void setUstId(String ustId) {
        this.ustId = ustId;
    }

    public String getSonstiges() {
        return sonstiges;
    }

    public void setSonstiges(String sonstiges) {
        this.sonstiges = sonstiges;
    }

    public String getFragebogen() {
        return fragebogen;
    }

    public void setFragebogen(String fragebogen) {
        this.fragebogen = fragebogen;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getSkonto() {
        return skonto;
    }

    public void setSkonto(String skonto) {
        this.skonto = skonto;
    }

    public String getKundeKuerzel() {
        return kundeKuerzel;
    }

    public void setKundeKuerzel(String kundeKuerzel) {
        this.kundeKuerzel = kundeKuerzel;
    }

    @XmlTransient
    public List<Auftragsannahme> getAuftragsannahmeList() {
        return auftragsannahmeList;
    }

    public void setAuftragsannahmeList(List<Auftragsannahme> auftragsannahmeList) {
        this.auftragsannahmeList = auftragsannahmeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rechnungskunden)) {
            return false;
        }
        Rechnungskunden other = (Rechnungskunden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ifbma.legacy.despot.entities.Rechnungskunden[ id=" + id + " ]";
    }

}
