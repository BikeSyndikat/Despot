package org.ifbma.legacy.despot.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "\"Auftragsannahme\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auftragsannahme.findAll", query = "SELECT a FROM Auftragsannahme a ORDER BY a.id DESC"),
    @NamedQuery(name = "Auftragsannahme.findById", query = "SELECT a FROM Auftragsannahme a WHERE a.id = :id"),
    @NamedQuery(name = "Auftragsannahme.findByDat", query = "SELECT a FROM Auftragsannahme a WHERE a.dat = :dat"),
    @NamedQuery(name = "Auftragsannahme.findByUhr", query = "SELECT a FROM Auftragsannahme a WHERE a.uhr = :uhr"),
    @NamedQuery(name = "Auftragsannahme.findByVon", query = "SELECT a FROM Auftragsannahme a WHERE a.von = :von"),
    @NamedQuery(name = "Auftragsannahme.findByUeber", query = "SELECT a FROM Auftragsannahme a WHERE a.ueber = :ueber"),
    @NamedQuery(name = "Auftragsannahme.findByNach", query = "SELECT a FROM Auftragsannahme a WHERE a.nach = :nach"),
    @NamedQuery(name = "Auftragsannahme.findByJob", query = "SELECT a FROM Auftragsannahme a WHERE a.job = :job"),
    @NamedQuery(name = "Auftragsannahme.findByFahrscheckNr", query = "SELECT a FROM Auftragsannahme a WHERE a.fahrscheckNr = :fahrscheckNr"),
    @NamedQuery(name = "Auftragsannahme.findByPreis", query = "SELECT a FROM Auftragsannahme a WHERE a.preis = :preis"),
    @NamedQuery(name = "Auftragsannahme.findByFahrerNr", query = "SELECT a FROM Auftragsannahme a WHERE a.fahrerNr = :fahrerNr"),
    @NamedQuery(name = "Auftragsannahme.findByTyp", query = "SELECT a FROM Auftragsannahme a WHERE a.typ = :typ"),
    @NamedQuery(name = "Auftragsannahme.findByPreisCheck", query = "SELECT a FROM Auftragsannahme a WHERE a.preisCheck = :preisCheck"),
    @NamedQuery(name = "Auftragsannahme.findByFahrscheckCheck", query = "SELECT a FROM Auftragsannahme a WHERE a.fahrscheckCheck = :fahrscheckCheck"),
    @NamedQuery(name = "Auftragsannahme.findBySonderkonditionen", query = "SELECT a FROM Auftragsannahme a WHERE a.sonderkonditionen = :sonderkonditionen"),
    @NamedQuery(name = "Auftragsannahme.findBySumme", query = "SELECT a FROM Auftragsannahme a WHERE a.summe = :summe")})
public class Auftragsannahme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "\"Id\"", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"Dat\"", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "\"Uhr\"", nullable = false, length = 20)
    private String uhr;
    @Size(max = 50)
    @Column(name = "\"Von\"", length = 50)
    private String von;
    @Size(max = 50)
    @Column(name = "\"Ueber\"", length = 50)
    private String ueber;
    @Size(max = 50)
    @Column(name = "\"Nach\"", length = 50)
    private String nach;
    @Size(max = 50)
    @Column(name = "\"Job\"", length = 50)
    private String job;
    @Size(max = 50)
    @Column(name = "\"FahrscheckNr\"", length = 50)
    private String fahrscheckNr;
    @Column(name = "\"Preis\"")
    private BigInteger preis;
    @Column(name = "\"FahrerNr\"")
    private Integer fahrerNr;
    @Size(max = 50)
    @Column(name = "\"Typ\"", length = 50)
    private String typ;
    @Size(max = 50)
    @Column(name = "\"PreisCheck\"", length = 50)
    private String preisCheck;
    @Size(max = 50)
    @Column(name = "\"FahrscheckCheck\"", length = 50)
    private String fahrscheckCheck;
    @Column(name = "\"Sonderkonditionen\"")
    private Integer sonderkonditionen;
    @Column(name = "\"Summe\"")
    private BigInteger summe;
    @JoinColumn(name = "\"Kuerzel\"", referencedColumnName = "\"ID\"", nullable = false)
    @ManyToOne(optional = false)
    private Rechnungskunden kuerzel;

    public Auftragsannahme() {
    }

    public Auftragsannahme(Integer id) {
        this.id = id;
    }

    public Auftragsannahme(Integer id, Date dat, String uhr) {
        this.id = id;
        this.dat = dat;
        this.uhr = uhr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public String getUhr() {
        return uhr;
    }

    public void setUhr(String uhr) {
        this.uhr = uhr;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getUeber() {
        return ueber;
    }

    public void setUeber(String ueber) {
        this.ueber = ueber;
    }

    public String getNach() {
        return nach;
    }

    public void setNach(String nach) {
        this.nach = nach;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getFahrscheckNr() {
        return fahrscheckNr;
    }

    public void setFahrscheckNr(String fahrscheckNr) {
        this.fahrscheckNr = fahrscheckNr;
    }

    public BigInteger getPreis() {
        return preis;
    }

    public void setPreis(BigInteger preis) {
        this.preis = preis;
    }

    public Integer getFahrerNr() {
        return fahrerNr;
    }

    public void setFahrerNr(Integer fahrerNr) {
        this.fahrerNr = fahrerNr;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getPreisCheck() {
        return preisCheck;
    }

    public void setPreisCheck(String preisCheck) {
        this.preisCheck = preisCheck;
    }

    public String getFahrscheckCheck() {
        return fahrscheckCheck;
    }

    public void setFahrscheckCheck(String fahrscheckCheck) {
        this.fahrscheckCheck = fahrscheckCheck;
    }

    public Integer getSonderkonditionen() {
        return sonderkonditionen;
    }

    public void setSonderkonditionen(Integer sonderkonditionen) {
        this.sonderkonditionen = sonderkonditionen;
    }

    public BigInteger getSumme() {
        return summe;
    }

    public void setSumme(BigInteger summe) {
        this.summe = summe;
    }

    public Rechnungskunden getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(Rechnungskunden kuerzel) {
        this.kuerzel = kuerzel;
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
        if (!(object instanceof Auftragsannahme)) {
            return false;
        }
        Auftragsannahme other = (Auftragsannahme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ifbma.legacy.despot.entities.Auftragsannahme[ id=" + id + " ]";
    }

}
