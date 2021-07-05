package dynamiczne;

public class PracownikDzialuObslugi extends Osoba{
    private Double pensjaPracownikaObslugi;
    private String nazwaDzialu;

    public PracownikDzialuObslugi(String imie, String nazwisko, String plec, String email, Double pensjaPracownikaObslugi, String nazwaDzialu) {
        super(imie, nazwisko, plec, email);
        this.pensjaPracownikaObslugi = pensjaPracownikaObslugi;
        this.nazwaDzialu = nazwaDzialu;
    }

    public PracownikDzialuObslugi(Osoba osoba, Double pensjaPracownikaObslugi, String nazwaDzialu){
        super(osoba.getImie(),osoba.getNazwisko(),osoba.getPlec(),osoba.getEmail());
        this.pensjaPracownikaObslugi = pensjaPracownikaObslugi;
        this.nazwaDzialu = nazwaDzialu;
    }

    @Override
    public Double getPensja() {
        return pensjaPracownikaObslugi;
    }

    public String toString(){
        return super.toString()+this.nazwaDzialu+" "+this.pensjaPracownikaObslugi;
    }
}
