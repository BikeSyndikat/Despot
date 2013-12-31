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
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Kuerzel"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rechnungskunden.findAll", query = "SELECT r FROM Rechnungskunden r"),
    @NamedQuery(name = "Rechnungskunden.findById", query = "SELECT r FROM Rechnungskunden r WHERE r.id = :id"),
    @NamedQuery(name = "Rechnungskunden.findByKuerzel", query = "SELECT r FROM Rechnungskunden r WHERE r.kuerzel = :kuerzel"),
    @NamedQuery(name = "Rechnungskunden.findByFirmierung1", query = "SELECT r FROM Rechnungskunden r WHERE r.firmierung1 = :firmierung1"),
    @NamedQuery(name = "Rechnungskunden.findByFirmierung2", query = "SELECT r FROM Rechnungskunden r WHERE r.firmierung2 = :firmierung2"),
    @NamedQuery(name = "Rechnungskunden.findByStra\u00dfe", query = "SELECT r FROM Rechnungskunden r WHERE r.stra\u00dfe = :stra\u00dfe"),
    @NamedQuery(name = "Rechnungskunden.findByPlz", query = "SELECT r FROM Rechnungskunden r WHERE r.plz = :plz"),
    @NamedQuery(name = "Rechnungskunden.findByOrt", query = "SELECT r FROM Rechnungskunden r WHERE r.ort = :ort"),
    @NamedQuery(name = "Rechnungskunden.findByKdNr", query = "SELECT r FROM Rechnungskunden r WHERE r.kdNr = :kdNr"),
    @NamedQuery(name = "Rechnungskunden.findByZonenK\u00fcrzel", query = "SELECT r FROM Rechnungskunden r WHERE r.zonenK\u00fcrzel = :zonenK\u00fcrzel"),
    @NamedQuery(name = "Rechnungskunden.findByTelefon", query = "SELECT r FROM Rechnungskunden r WHERE r.telefon = :telefon"),
    @NamedQuery(name = "Rechnungskunden.findByDurchwahl", query = "SELECT r FROM Rechnungskunden r WHERE r.durchwahl = :durchwahl"),
    @NamedQuery(name = "Rechnungskunden.findByFax", query = "SELECT r FROM Rechnungskunden r WHERE r.fax = :fax"),
    @NamedQuery(name = "Rechnungskunden.findByAnsprechpartner", query = "SELECT r FROM Rechnungskunden r WHERE r.ansprechpartner = :ansprechpartner"),
    @NamedQuery(name = "Rechnungskunden.findByEMail", query = "SELECT r FROM Rechnungskunden r WHERE r.eMail = :eMail"),
    @NamedQuery(name = "Rechnungskunden.findByHomepage", query = "SELECT r FROM Rechnungskunden r WHERE r.homepage = :homepage"),
    @NamedQuery(name = "Rechnungskunden.findByBranche", query = "SELECT r FROM Rechnungskunden r WHERE r.branche = :branche"),
    @NamedQuery(name = "Rechnungskunden.findByUstId", query = "SELECT r FROM Rechnungskunden r WHERE r.ustId = :ustId"),
    @NamedQuery(name = "Rechnungskunden.findBySonstiges", query = "SELECT r FROM Rechnungskunden r WHERE r.sonstiges = :sonstiges"),
    @NamedQuery(name = "Rechnungskunden.findByFragebogen", query = "SELECT r FROM Rechnungskunden r WHERE r.fragebogen = :fragebogen"),
    @NamedQuery(name = "Rechnungskunden.findByBemerkung", query = "SELECT r FROM Rechnungskunden r WHERE r.bemerkung = :bemerkung"),
    @NamedQuery(name = "Rechnungskunden.findByAnrede", query = "SELECT r FROM Rechnungskunden r WHERE r.anrede = :anrede"),
    @NamedQuery(name = "Rechnungskunden.findBySkonto", query = "SELECT r FROM Rechnungskunden r WHERE r.skonto = :skonto"),
    @NamedQuery(name = "Rechnungskunden.findByKundeKuerzel", query = "SELECT r FROM Rechnungskunden r WHERE r.kundeKuerzel = :kundeKuerzel")})
public class Rechnungskunden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(nullable = false, length = 254)
    private String kuerzel;
    @Size(max = 254)
    @Column(length = 254)
    private String firmierung1;
    @Size(max = 254)
    @Column(length = 254)
    private String firmierung2;
    @Size(max = 254)
    @Column(length = 254)
    private String straße;
    @Size(max = 8)
    @Column(length = 8)
    private String plz;
    @Size(max = 254)
    @Column(length = 254)
    private String ort;
    @Size(max = 254)
    @Column(name = "Kd-Nr", length = 254)
    private String kdNr;
    @Size(max = 254)
    @Column(name = "Zonen K\u00fcrzel", length = 254)
    private String zonenKürzel;
    @Size(max = 254)
    @Column(length = 254)
    private String telefon;
    @Size(max = 254)
    @Column(length = 254)
    private String durchwahl;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(length = 254)
    private String fax;
    @Size(max = 254)
    @Column(length = 254)
    private String ansprechpartner;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "e-mail", length = 254)
    private String eMail;
    @Size(max = 254)
    @Column(length = 254)
    private String homepage;
    @Size(max = 254)
    @Column(length = 254)
    private String branche;
    @Size(max = 254)
    @Column(name = "Ust-Id", length = 254)
    private String ustId;
    @Size(max = 254)
    @Column(length = 254)
    private String sonstiges;
    @Size(max = 254)
    @Column(length = 254)
    private String fragebogen;
    @Size(max = 254)
    @Column(length = 254)
    private String bemerkung;
    @Size(max = 254)
    @Column(length = 254)
    private String anrede;
    @Size(max = 254)
    @Column(length = 254)
    private String skonto;
    @Size(max = 254)
    @Column(name = "Kunde-Kuerzel", length = 254)
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
