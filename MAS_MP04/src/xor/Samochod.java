package xor;

public class Samochod {
    public enum sellType{KUPNO,LEASING}
    private String marka;
    private String silnik;
    private Kupno kupno;
    private Leasing leasing;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSilnik() {
        return silnik;
    }

    public void setSilnik(String silnik) {
        this.silnik = silnik;
    }

    public Kupno getKupno() {
        return kupno;
    }

    public void setKupno(Kupno kupno) throws Exception {
        if(kupno==null){
            throw new Exception("kupno nie moze byc nullem");
        }
        this.kupno = kupno;
    }

    public Leasing getLeasing() {
        return leasing;
    }

    public void setLeasing(Leasing leasing) throws Exception {
        if(leasing==null){
            throw new Exception("kupno nie moze byc nullem");
        }
        this.leasing = leasing;
    }

    public Samochod(String marka, String silnik,  Enum<sellType> sellTypeEnum,Double cena) throws Exception {
        this.marka = marka;
        this.silnik = silnik;
        if(sellTypeEnum==sellType.KUPNO){
            setKupno(new Kupno(this,cena));
            this.leasing=null;
        }else if(sellTypeEnum==sellType.LEASING){
            this.kupno=null;
            setLeasing(new Leasing(this,cena));
        }
    }
}
