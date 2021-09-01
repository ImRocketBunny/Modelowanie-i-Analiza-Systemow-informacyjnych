package Models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public abstract class Pracownik{
    @OneToOne
    private Osoba osoba;

    //public enum stanowisko{MAGAZYNIER,SPECJALISTA_DS_REKLAMACJI,DORADCA_KLIENTA}
    private Double pensja;
    private String plec;
    private Integer premia = null;
    private LocalDate dataZatrudnienia;
    @Id
    @GeneratedValue
    private Long id;


    @Basic
    public Double getPensja() {
        return pensja;
    }

    public void setPensja(Double pensja) {
        this.pensja = pensja;
    }
    @Basic
    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }
    @Basic
    public Integer getPremia() {
        return premia;
    }

    public void setPremia(Integer premia) {
        this.premia = premia;
    }
    @Basic
    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }
    @OneToOne
    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    protected Pracownik(Double pensja, String plec,LocalDate dataZatrudnienia) throws Exception {
        this.pensja = pensja;
        this.plec = plec;
        this.dataZatrudnienia =dataZatrudnienia;
    }


    public Pracownik(){

    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public abstract void usunOsobe(Osoba osoba);




}
