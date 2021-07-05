package dynamiczne;

public abstract class Osoba {
    private String imie;
    private String nazwisko;
    private String plec;
    private String email;

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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Osoba(String imie, String nazwisko, String plec, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.email = email;
    }

    public abstract Double getPensja();
    @Override
    public String toString(){
        return this.getClass().getSimpleName()+" "+this.imie+" "+this.nazwisko+" "+this.plec+" "+this.email+" ";
    }
}
