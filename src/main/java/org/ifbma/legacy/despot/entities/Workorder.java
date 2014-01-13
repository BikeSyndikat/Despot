package org.ifbma.legacy.despot.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Cacheable(false)
@NamedQueries({
    @NamedQuery(name = "Workorder.findAll", query = "SELECT w FROM Workorder w"),
    @NamedQuery(name = "Workorder.findById", query = "SELECT w FROM Workorder w WHERE w.id = :id"),
    @NamedQuery(name = "Workorder.findByDat", query = "SELECT w FROM Workorder w WHERE w.dat = :dat"),
    @NamedQuery(name = "Workorder.findByUhr", query = "SELECT w FROM Workorder w WHERE w.uhr = :uhr"),
    @NamedQuery(name = "Workorder.findByVon", query = "SELECT w FROM Workorder w WHERE w.von = :von"),
    @NamedQuery(name = "Workorder.findByUeber", query = "SELECT w FROM Workorder w WHERE w.ueber = :ueber"),
    @NamedQuery(name = "Workorder.findByNach", query = "SELECT w FROM Workorder w WHERE w.nach = :nach"),
    @NamedQuery(name = "Workorder.findByJob", query = "SELECT w FROM Workorder w WHERE w.job = :job"),
    @NamedQuery(name = "Workorder.findByFahrschecknr", query = "SELECT w FROM Workorder w WHERE w.fahrschecknr = :fahrschecknr"),
    @NamedQuery(name = "Workorder.findByPreis", query = "SELECT w FROM Workorder w WHERE w.preis = :preis"),
    @NamedQuery(name = "Workorder.findByFahrernr", query = "SELECT w FROM Workorder w WHERE w.fahrernr = :fahrernr"),
    @NamedQuery(name = "Workorder.findByTyp", query = "SELECT w FROM Workorder w WHERE w.typ = :typ"),
    @NamedQuery(name = "Workorder.findByPreischeck", query = "SELECT w FROM Workorder w WHERE w.preischeck = :preischeck"),
    @NamedQuery(name = "Workorder.findByFahrscheckcheck", query = "SELECT w FROM Workorder w WHERE w.fahrscheckcheck = :fahrscheckcheck"),
    @NamedQuery(name = "Workorder.findBySonderkonditionen", query = "SELECT w FROM Workorder w WHERE w.sonderkonditionen = :sonderkonditionen"),
    @NamedQuery(name = "Workorder.findBySumme", query = "SELECT w FROM Workorder w WHERE w.summe = :summe"),
    @NamedQuery(name = "Workorder.findByKuerzel", query = "SELECT w FROM Workorder w WHERE w.kuerzel = :kuerzel"),
    @NamedQuery(name = "Workorder.findByFirmierung1", query = "SELECT w FROM Workorder w WHERE w.firmierung1 = :firmierung1")})
public class Workorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double dat;
    @Size(max = 20)
    @Column(length = 20)
    private String uhr;
    @Size(max = 50)
    @Column(length = 50)
    private String von;
    @Size(max = 50)
    @Column(length = 50)
    private String ueber;
    @Size(max = 50)
    @Column(length = 50)
    private String nach;
    @Size(max = 50)
    @Column(length = 50)
    private String job;
    @Size(max = 50)
    @Column(length = 50)
    private String fahrschecknr;
    private BigInteger preis;
    private Integer fahrernr;
    @Size(max = 50)
    @Column(length = 50)
    private String typ;
    @Size(max = 50)
    @Column(length = 50)
    private String preischeck;
    @Size(max = 50)
    @Column(length = 50)
    private String fahrscheckcheck;
    private Integer sonderkonditionen;
    private BigInteger summe;
    private String kuerzel;
    @Size(max = 254)
    @Column(length = 254)
    private String firmierung1;

    @Transient
    private Boolean undispatched;

    public Workorder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDat() {
        return dat;
    }

    public void setDat(Double dat) {
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

    public String getFahrschecknr() {
        return fahrschecknr;
    }

    public void setFahrschecknr(String fahrschecknr) {
        this.fahrschecknr = fahrschecknr;
    }

    public BigInteger getPreis() {
        return preis;
    }

    public void setPreis(BigInteger preis) {
        this.preis = preis;
    }

    public Integer getFahrernr() {
        return fahrernr;
    }

    public void setFahrernr(Integer fahrernr) {
        this.fahrernr = fahrernr;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getPreischeck() {
        return preischeck;
    }

    public void setPreischeck(String preischeck) {
        this.preischeck = preischeck;
    }

    public String getFahrscheckcheck() {
        return fahrscheckcheck;
    }

    public void setFahrscheckcheck(String fahrscheckcheck) {
        this.fahrscheckcheck = fahrscheckcheck;
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

    public Boolean isUndispatched() {
        if (fahrernr == null) {
            undispatched = Boolean.TRUE;
        } else if (fahrernr.intValue() <= 1) {
            undispatched = Boolean.TRUE;
        } else {
            undispatched = Boolean.FALSE;
        }
        return undispatched;
    }

    public void setUndispatched(Boolean open) {
        this.undispatched = open;
        this.fahrernr = 0;
    }

}
