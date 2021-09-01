package Models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Reklamacja {
    @OneToOne
    private Zamowienie zamowienie;
    @ManyToOne
    private SpecjalistaDsReklamacji specjalistaDsReklamacji;
    @Id
    @GeneratedValue
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }




    public enum statusy{ZLOZONA,W_TRAKCIE_ROZPATRYWANIA,ROZPATRZONA}

    private static Integer limitZnakowReklamacja = 500;

    private LocalDate dataZlozenia;
    private Enum status;
    private String powodRelamacji;
    private String decyzjaSklepu;
    @OneToOne
    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) throws Exception {
        if(zamowienie==null){
            throw new Exception("Blendne zamowienie");
        }
        this.zamowienie = zamowienie;
    }
    @ManyToOne
    public SpecjalistaDsReklamacji getSpecjalistaDsReklamacji() {
        return specjalistaDsReklamacji;
    }

    public void setSpecjalistaDsReklamacji(SpecjalistaDsReklamacji specjalistaDsReklamacji) throws Exception {
        if(specjalistaDsReklamacji==null){
            throw new Exception("Blendny specjalista ds reklamacji");
        }
        this.specjalistaDsReklamacji = specjalistaDsReklamacji;
    }

    public static Integer getLimitZnakowReklamacja() {
        return limitZnakowReklamacja;
    }

    public static void setLimitZnakowReklamacja(Integer limitZnakowReklamacja) {
        Reklamacja.limitZnakowReklamacja = limitZnakowReklamacja;
    }
    @Basic
    public LocalDate getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(LocalDate dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    @Enumerated
    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
    @Basic
    public String getPowodRelamacji() {
        return powodRelamacji;
    }

    public void setPowodRelamacji(String powodRelamacji) throws Exception {
        if(powodRelamacji.length()<=limitZnakowReklamacja)
            this.powodRelamacji = powodRelamacji;
        else{
            throw new Exception("Za dlugi powod");
        }
    }
    @Basic
    public String getDecyzjaSklepu() {
        return decyzjaSklepu;
    }

    public void setDecyzjaSklepu(String decyzjaSklepu) {
        this.decyzjaSklepu = decyzjaSklepu;
    }

    public Reklamacja() {

    }

    private Reklamacja(Zamowienie zamowienie,SpecjalistaDsReklamacji specjalistaDsReklamacji, LocalDate dataZlozenia, Enum status,String powodRelamacji) throws Exception {
        setZamowienie(zamowienie);
        setSpecjalistaDsReklamacji(specjalistaDsReklamacji);
        this.dataZlozenia=dataZlozenia;
        setPowodRelamacji(powodRelamacji);
    }
    private Reklamacja(Zamowienie zamowienie, LocalDate dataZlozenia, Enum status,String powodRelamacji) throws Exception {
        setZamowienie(zamowienie);
        this.dataZlozenia=dataZlozenia;
        setPowodRelamacji(powodRelamacji);
    }

    public static Reklamacja stworzreklamacje(Zamowienie zamowienie,LocalDate dataZlozenia, Enum status, String powodRelamacji) throws Exception {
        Reklamacja reklamacja = new Reklamacja(zamowienie, dataZlozenia,status,powodRelamacji);
        zamowienie.dodajReklamacje(reklamacja);
        return reklamacja;

    }

//    public void dodajZamowienie(Zamowienie zamowienie) throws Exception {
//        setZamowienie(zamowienie);
//        zamowienie.dodajReklamacje(this);
//    }

    public void usunZamowienie(Zamowienie zamowienie){
        if(this.zamowienie==zamowienie){
            this.zamowienie=null;
            zamowienie.usunReklamacje(this);
        }
    }

    public void dodajSpecjalisteDsReklamacji(SpecjalistaDsReklamacji specjalistaDsReklamacji) throws Exception {
        setSpecjalistaDsReklamacji(specjalistaDsReklamacji);
        specjalistaDsReklamacji.dodajReklamacje(this);
    }

    public void usunSpecjalisteDsReklamacji(SpecjalistaDsReklamacji specjalistaDsReklamacji) {
        if(specjalistaDsReklamacji==specjalistaDsReklamacji){
            this.specjalistaDsReklamacji=null;
            specjalistaDsReklamacji.usunReklamacje(this);
        }
    }


    @Override
    public String toString() {
        return "Reklamacja{" +
                "zamowienie=" + zamowienie +
                ", specjalistaDsReklamacji=" + specjalistaDsReklamacji +
                ", id=" + id +
                ", dataZlozenia=" + dataZlozenia +
                ", status=" + status +
                ", powodRelamacji='" + powodRelamacji + '\'' +
                ", decyzjaSklepu='" + decyzjaSklepu + '\'' +
                '}';
    }

}
