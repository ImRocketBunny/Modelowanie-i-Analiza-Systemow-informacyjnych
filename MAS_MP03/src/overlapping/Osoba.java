package overlapping;

import java.util.EnumSet;

public class Osoba {
    enum osobaType {KierownikDzialuObslugi, PrawcownikObslugi, Osoba};

    private String imie;
    private String nazwisko;
    private String plec;
    private String email;
    private EnumSet<osobaType> role =  EnumSet.of(osobaType.Osoba);
    private Double pensjaKierownicza;
    private Double pensjaPracownikaObslugi;
    private String kierowanyDzial;
    private String nazwaDzialu;

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

    public EnumSet<osobaType> getRole() {
        return role;
    }

    public void setRole(EnumSet<osobaType> role) {
        this.role = role;
    }

    public Double setPensjaKierownicza(Double pensja) throws Exception{
        if(role.contains(osobaType.KierownikDzialuObslugi)) {
            this.pensjaKierownicza=pensja;
        }
        throw new Exception("Ta osoba nie jest kierownikiem");
    }

    public Double setPensaPracownikaObslugi(Double pensja) throws Exception{
        if(role.contains(osobaType.PrawcownikObslugi)) {
            this.pensjaPracownikaObslugi=pensja;
        }
        throw new Exception("Ta osoba nie pracuje w dziale obslugi!");
    }

    public Double getPensjaKierownicza() throws Exception{
            if(role.contains(osobaType.KierownikDzialuObslugi)) {
                return pensjaKierownicza;
            }
            throw new Exception("Ta osoba nie jest kierownikiem");
    }

    public Double getPensjaPracownikaObslugi() throws Exception{
        if(role.contains(osobaType.PrawcownikObslugi)){
            return pensjaPracownikaObslugi;
        }
        throw new Exception("Ta osoba nie pracuje w dziale obslugi!");
    }

    public Double getPensjaColkowita() throws Exception{
        Double pensja = 0.0;
        if(role.contains(osobaType.KierownikDzialuObslugi)) {
            pensja+=pensjaKierownicza;
        }
        if(role.contains(osobaType.PrawcownikObslugi)){
            pensja+= pensjaPracownikaObslugi;
        }
        return pensja;
    }

    public String getKierowanyDzial() throws Exception{
        if(role.contains(osobaType.KierownikDzialuObslugi)) {
            return kierowanyDzial;
        }
        throw new Exception("Ta osoba nie jest kierownikiem!");
    }

    public String getNazwaDzialu() throws Exception{
        if(role.contains(osobaType.PrawcownikObslugi)) {
            return nazwaDzialu;
        }
        throw new Exception("Ta osoba nie jest pracownikiem obslugi!");
    }

    public Osoba(String imie, String nazwisko, String plec, String email,Double pensjaPracownikaObslugi,String nazwaDzialu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.email = email;
        this.pensjaPracownikaObslugi=pensjaPracownikaObslugi;
        this.nazwaDzialu=nazwaDzialu;
        role.add(osobaType.PrawcownikObslugi);
    }
    public Osoba(String imie, String nazwisko, String plec, String email,String kierowanyDzial,Double pensjaKierownicza) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.email = email;
        this.pensjaKierownicza=pensjaKierownicza;
        this.kierowanyDzial=kierowanyDzial;
        role.add(osobaType.KierownikDzialuObslugi);
    }

    public Osoba(String imie, String nazwisko, String plec, String email, Double pensjaKierownicza, Double pensjaPracownikaObslugi, String kierowanyDzial, String nazwaDzialu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.email = email;
        this.pensjaKierownicza = pensjaKierownicza;
        this.pensjaPracownikaObslugi = pensjaPracownikaObslugi;
        this.kierowanyDzial = kierowanyDzial;
        this.nazwaDzialu = nazwaDzialu;
        role.add(osobaType.PrawcownikObslugi);
        role.add(osobaType.KierownikDzialuObslugi);//kontruktor z iwloma parametrami
    }
}
