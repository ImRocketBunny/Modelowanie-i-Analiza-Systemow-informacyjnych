package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public abstract class Klient {

    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    private String adresZamieszkania;
    private String telefonKontaktowy;
    @OneToMany
    private List<Pytanie> pytania = new ArrayList<>();
    @OneToMany
    private List<Zamowienie> zamowienia = new ArrayList<>();


    @Basic
    public String getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void setAdresZamieszkania(String adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
    }
    @Basic
    public String getTelefonKontaktowy() {
        return telefonKontaktowy;
    }

    public void setTelefonKontaktowy(String telefonKontaktowy) {
        this.telefonKontaktowy = telefonKontaktowy;
    }

    @OneToMany
    public List<Pytanie> getPytania() {
        return pytania;
    }

    public void setPytania(List<Pytanie> pytania) {
        this.pytania = pytania;
    }
    @OneToMany
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "adresZamieszkania='" + adresZamieszkania + '\'' +
                ", telefonKontaktowy='" + telefonKontaktowy + '\'' +
                '}';
    }

    public Klient(){

    }

    public Klient(String adresZamieszkania, String telefonKontaktowy) {
        this.adresZamieszkania = adresZamieszkania;
        this.telefonKontaktowy = telefonKontaktowy;
    }

    public abstract void dodajPytanie(Pytanie pytanie) throws Exception;

    public abstract void usunPytanie(Pytanie pytanie) throws  Exception;

    public abstract void dodajZamowienie(Zamowienie zamowienie) throws Exception;

    public abstract void usunZamowienie(Zamowienie zamowienie) throws Exception;


}
