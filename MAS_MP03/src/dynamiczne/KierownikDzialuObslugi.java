package dynamiczne;

public class KierownikDzialuObslugi extends Osoba{
    private Double pensjaKierownicza;
    private String kierowanyDzial;

    public KierownikDzialuObslugi(String imie, String nazwisko, String plec, String email, Double pensjaKierownicza, String kierowanyDzial) {
        super(imie, nazwisko, plec, email);
        this.pensjaKierownicza = pensjaKierownicza;
        this.kierowanyDzial = kierowanyDzial;
    }

    public KierownikDzialuObslugi(Osoba osoba, Double pensjaKierownicza, String kierowanyDzial){
        super(osoba.getImie(),osoba.getNazwisko(),osoba.getPlec(),osoba.getEmail());
        this.pensjaKierownicza = pensjaKierownicza;
        this.kierowanyDzial = kierowanyDzial;

    }

    @Override
    public Double getPensja() {
        return pensjaKierownicza;
    }
    public String toString(){
        return super.toString()+this.kierowanyDzial+" "+this.pensjaKierownicza;
    }
}
