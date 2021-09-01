package Models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Osoba {

    @Id
    @GeneratedValue
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @OneToOne
    private Pracownik pracownik=null;
    @OneToOne
    private KlientPrywatny klientPrywatny=null;

    private String pesel;
    private String imie;
    private String nazwisko;
    private String adresZamieszkania;
    private String adresEmail;
    private LocalDate dataUrodzenia;

    @OneToOne
    public Pracownik getPracownik() {
        return pracownik;
    }

    public Osoba(){

    }

    public void setPracownik(Pracownik pracownik) throws Exception {
        if(pracownik==null){
            throw new Exception("Bledny pracownik");
        }
        this.pracownik = pracownik;
    }
    @OneToOne
    public KlientPrywatny getKlientPrywatny() {
        return klientPrywatny;
    }

    public void setKlientPrywatny(KlientPrywatny klientPrywatny) throws Exception {
        if(klientPrywatny==null){
            throw new Exception("Bledny klient");
        }
        this.klientPrywatny = klientPrywatny;
    }
    @Basic
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {

        this.pesel = pesel;
    }
    @Basic
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
    @Basic
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    @Basic
    public String getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void setAdresZamieszkania(String adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
    }
    @Basic
    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }
    @Basic
    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    protected Osoba(Pracownik pracownik, KlientPrywatny klientPrywatny, String pesel, String imie, String nazwisko, String adresZamieszkania, String adresEmail, LocalDate dataUrodzenia) throws Exception {
        setPracownik(pracownik);
        setKlientPrywatny(klientPrywatny);
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresZamieszkania = adresZamieszkania;
        this.adresEmail = adresEmail;
        this.dataUrodzenia = dataUrodzenia;
    }
    protected Osoba(KlientPrywatny klientPrywatny, String pesel, String imie, String nazwisko, String adresZamieszkania, String adresEmail, LocalDate dataUrodzenia) throws Exception {
        setKlientPrywatny(klientPrywatny);
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresZamieszkania = adresZamieszkania;
        this.adresEmail = adresEmail;
        this.dataUrodzenia = dataUrodzenia;
    }
    protected Osoba(Pracownik pracownik,String pesel, String imie, String nazwisko, String adresZamieszkania, String adresEmail, LocalDate dataUrodzenia) throws Exception {
        setPracownik(pracownik);
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresZamieszkania = adresZamieszkania;
        this.adresEmail = adresEmail;
        this.dataUrodzenia = dataUrodzenia;
    }
    protected Osoba(String pesel, String imie, String nazwisko, String adresZamieszkania, String adresEmail, LocalDate dataUrodzenia) throws Exception {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adresZamieszkania = adresZamieszkania;
        this.adresEmail = adresEmail;
        this.dataUrodzenia = dataUrodzenia;
    }


    public void dodajPracownika(Pracownik pracownik) throws Exception {
        if(this.pracownik!=pracownik)
            setPracownik(pracownik);

    }

    public void usunPracownika(Pracownik pracownik){
        if(this.pracownik==pracownik){
            this.pracownik=null;
            pracownik.usunOsobe(this);
        }
    }


    public void dodajKlienta(KlientPrywatny klient) throws Exception {
        if(this.klientPrywatny!=klient)
            setKlientPrywatny(klient);
    }
    public void usunKlienta(KlientPrywatny klientPrywatny){
        if(this.klientPrywatny==klientPrywatny){
            this.klientPrywatny=null;
            klientPrywatny.usunOsobe(this);
        }
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", pracownik=" + pracownik +
                ", klientPrywatny=" + klientPrywatny +
                ", pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", adresZamieszkania='" + adresZamieszkania + '\'' +
                ", adresEmail='" + adresEmail + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                '}';
    }
}
