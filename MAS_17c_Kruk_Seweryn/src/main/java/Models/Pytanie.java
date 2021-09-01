package Models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Pytanie {

    public Pytanie() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private final static Integer maxDlugoscTresc = 500;

    private LocalDate data;
    private String tresc;
    @ManyToOne
    private Klient klient=null;
    @ManyToOne
    private DoradcaKlienta daradcaKlienta=null;
    @ManyToOne
    private PodzespolKomputerowy podzespolKomputerowy=null;
    @OneToOne
    private Odpowiedz odpowiedz = null;
    @Id
    @GeneratedValue
    private Long id;


    private Pytanie(String tresc, Klient klient,PodzespolKomputerowy podzespolKomputerowy,DoradcaKlienta doradcaKlienta,LocalDate data) throws Exception {
        this.data = data;
        setTresc(tresc);
        setKlient(klient);
        setPodzespolKomputerowy(podzespolKomputerowy);
        setDaradcaKlienta(doradcaKlienta);
    }
    @Basic
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    @Basic
    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) throws Exception {
        if(tresc.length()>maxDlugoscTresc){
            throw new Exception("Tresc jest zbyt dluga");
        }
        this.tresc=tresc;
    }
    @ManyToOne
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) throws Exception {
        if(klient==null){
            throw  new Exception("Bledny klient");
        }
        this.klient=klient;
    }
    @ManyToOne
    public DoradcaKlienta getDaradcaKlienta() {
        return daradcaKlienta;
    }

    public void setDaradcaKlienta(DoradcaKlienta daradcaKlienta) throws Exception {
        if(daradcaKlienta==null){
            throw new Exception("Bledny doradca klienta");
        }
        this.daradcaKlienta = daradcaKlienta;
    }
    @ManyToOne
    public PodzespolKomputerowy getPodzespolKomputerowy() {
        return podzespolKomputerowy;
    }

    public void setPodzespolKomputerowy(PodzespolKomputerowy podzespolKomputerowy) throws Exception {
        if(podzespolKomputerowy==null){
            throw new Exception("Bledny podzespol");
        }
        this.podzespolKomputerowy = podzespolKomputerowy;
    }

    @Override
    public String toString() {
        return "Pytanie{" +
                "data=" + data +
                ", tresc='" + tresc + '\'' +
                '}';
    }

    public static Pytanie stworzPytanie(Klient klient, String tresc, PodzespolKomputerowy podzespolKomputerowy, DoradcaKlienta doradcaKlienta) throws Exception {
        Pytanie pytanie = new Pytanie(tresc,klient, podzespolKomputerowy,doradcaKlienta,LocalDate.now());
        klient.dodajPytanie(pytanie);
        podzespolKomputerowy.dodajPytanie(pytanie);
        doradcaKlienta.dodajPytanie(pytanie);
        return pytanie;
    }

    public void usunKlienta(Klient klient) throws Exception {
        if(this.klient==klient) {
            klient.usunPytanie(this);
            this.klient = null;
        }
    }

    public void dodajPodzespol(PodzespolKomputerowy podzespolKomputerowy) throws Exception {
        if(this.podzespolKomputerowy==null){
            this.setPodzespolKomputerowy(podzespolKomputerowy);
            podzespolKomputerowy.dodajPytanie(this);
        }

    }

    public void usunPodzespol(PodzespolKomputerowy podzespolKomputerowy) throws Exception {
        if(this.podzespolKomputerowy==podzespolKomputerowy) {
            this.podzespolKomputerowy = null;
            podzespolKomputerowy.usunPytanie(this);
        }
    }

    public void usunOdpowiedz(Odpowiedz odpowiedz){
        if(this.odpowiedz==odpowiedz){
            this.odpowiedz=null;
        }
    }

    public static Integer getMaxDlugoscTresc() {
        return maxDlugoscTresc;
    }
    @OneToOne
    public Odpowiedz getOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(Odpowiedz odpowiedz) throws Exception {
        if(odpowiedz==null){
            throw new Exception("Bledna odpowiedz");
        }
        this.odpowiedz = odpowiedz;
    }

    public void dodajOdpowiedz(Odpowiedz odpowiedz) throws Exception {
        if(this.odpowiedz==null) {
            setOdpowiedz(odpowiedz);
            odpowiedz.setPytanie(this);
        }

    }

    public void dodajDoradce(DoradcaKlienta doradcaKlienta) throws Exception {
        if(this.daradcaKlienta==null){
            setDaradcaKlienta(doradcaKlienta);
            doradcaKlienta.dodajPytanie(this);
        }
    }

    public void dodajKlienta(Klient klient) throws Exception {
        if(this.klient==null){
            setKlient(klient);
            klient.dodajPytanie(this);
        }
    }


    public void usunDoradce(DoradcaKlienta doradcaKlienta) {
        if(this.daradcaKlienta==doradcaKlienta){
            this.daradcaKlienta=null;
            doradcaKlienta.usunPytanie(this);
        }
    }
}
