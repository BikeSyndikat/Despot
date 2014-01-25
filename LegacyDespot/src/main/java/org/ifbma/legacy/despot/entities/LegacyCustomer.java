package org.ifbma.legacy.despot.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByKuerzel", query = "SELECT c FROM Customer c WHERE c.kuerzel = :kuerzel"),
    @NamedQuery(name = "Customer.findByFirmierung1", query = "SELECT c FROM Customer c WHERE c.firmierung1 = :firmierung1"),
    @NamedQuery(name = "Customer.findByFirmierung2", query = "SELECT c FROM Customer c WHERE c.firmierung2 = :firmierung2"),
    @NamedQuery(name = "Customer.findByStrasse", query = "SELECT c FROM Customer c WHERE c.strasse = :strasse"),
    @NamedQuery(name = "Customer.findByPlz", query = "SELECT c FROM Customer c WHERE c.plz = :plz"),
    @NamedQuery(name = "Customer.findByOrt", query = "SELECT c FROM Customer c WHERE c.ort = :ort"),
    @NamedQuery(name = "Customer.findByKundennummer", query = "SELECT c FROM Customer c WHERE c.kundennummer = :kundennummer"),
    @NamedQuery(name = "Customer.findByTelefon", query = "SELECT c FROM Customer c WHERE c.telefon = :telefon"),
    @NamedQuery(name = "Customer.findByDurchwahl", query = "SELECT c FROM Customer c WHERE c.durchwahl = :durchwahl")})
public class LegacyCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 254)
    @Column(length = 254)
    private String kuerzel;
    @Size(max = 254)
    @Column(length = 254)
    private String firmierung1;
    @Size(max = 254)
    @Column(length = 254)
    private String firmierung2;
    @Size(max = 254)
    @Column(length = 254)
    private String strasse;
    @Size(max = 8)
    @Column(length = 8)
    private String plz;
    @Size(max = 254)
    @Column(length = 254)
    private String ort;
    @Size(max = 254)
    @Column(length = 254)
    private String kundennummer;
    @Size(max = 254)
    @Column(length = 254)
    private String telefon;
    @Size(max = 254)
    @Column(length = 254)
    private String durchwahl;

    public LegacyCustomer() {
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

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
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

    public String getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(String kundennummer) {
        this.kundennummer = kundennummer;
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

}
