package subset;

public class Zolnierz {
    private String imie;
    private String nazwisko;
    private String stopien;

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

    public String getStopien() {
        return stopien;
    }

    public void setStopien(String stopien) {
        this.stopien = stopien;
    }

    public Zolnierz(String imie, String nazwisko, String stopien) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stopien = stopien;
    }
}
