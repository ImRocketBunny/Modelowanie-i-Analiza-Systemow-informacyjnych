package ordered;

public class Osoba {
    private String Pesel;
    private String imie;
    private String nazwisko;

    public String getPesel() {
        return Pesel;
    }

    public void setPesel(String pesel) {
        Pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Osoba(String pesel, String imie, String nazwisko) {
        Pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}
