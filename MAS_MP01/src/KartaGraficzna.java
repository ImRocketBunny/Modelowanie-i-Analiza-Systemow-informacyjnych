/*import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class KartaGraficzna extends PodzespolKomputerowy implements Serializable {
    private String producentRdzenia;
    private String kodRdzenia;
    private Integer iloscPamieci;
    private Integer tdp;
    private Integer taktowanieRdzenia;
    private Integer taktowaniePamieci;



    public KartaGraficzna(String nazwaProducenta,
                          String nazwaModelu,
                          String kodProducenta,
                          Double cena,
                          LocalDate dataPremiery,
                          String producentRdzenia,
                          String kodRdzenia,
                          Integer iloscPamieci,
                          Integer tdp,
                          Integer taktowanieRdzenia,
                          Integer taktowaniePamieci) {
        super(nazwaProducenta, kodProducenta, nazwaModelu, cena,dataPremiery);
        this.producentRdzenia=producentRdzenia;
        this.kodRdzenia=kodRdzenia;
        this.iloscPamieci=iloscPamieci;
        this.tdp=tdp;
        this.taktowanieRdzenia=taktowanieRdzenia;
        this.taktowaniePamieci=taktowaniePamieci;
    }

    public String getProducentRdzenia() {
        return producentRdzenia;
    }

    public void setProducentRdzenia(String producentRdzenia) {
        this.producentRdzenia = producentRdzenia;
    }

    public String getKodRdzenia() {
        return kodRdzenia;
    }

    public void setKodRdzenia(String kodRdzenia) {
        this.kodRdzenia = kodRdzenia;
    }

    public Integer getIloscPamieci() {
        return iloscPamieci;
    }

    public void setIloscPamieci(Integer iloscPamieci) {
        this.iloscPamieci = iloscPamieci;
    }

    public Integer getTdp() {
        return tdp;
    }

    public void setTdp(Integer tdp) {
        this.tdp = tdp;
    }

    public Integer getTaktowanieRdzenia() {
        return taktowanieRdzenia;
    }

    public void setTaktowanieRdzenia(Integer taktowanieRdzenia) {
        this.taktowanieRdzenia = taktowanieRdzenia;
    }

    public Integer getTaktowaniePamieci() {
        return taktowaniePamieci;
    }

    public void setTaktowaniePamieci(Integer taktowaniePamieci) {
        this.taktowaniePamieci = taktowaniePamieci;
    }
    @Override
    public void write(DataOutputStream stream) throws IOException {
        //stream.writeUTF(title);
        //stream.writeFloat(price);
        //stream.writeLong(additionDate.toEpochDay());    // count of days where day 0 is 1970-01-01 (ISO)
    }
    @Override
    public void read(DataInputStream stream) throws IOException {
        //title = stream.readUTF();
        //price = stream.readFloat();
        //long epochDay = stream.readLong();
        //dditionDate = LocalDate.ofEpochDay(epochDay);
    }

    @Override
    public String toString(){
        return String.format(getClass().getName()+": "+super.toString()+", Producent rdzenia: %s, Kod rdzenia: %s, Ilosc pamieci: %s, TDP: %s, Taktowanie rdzenia %s, Taktowanie pamieci: %s",
                getProducentRdzenia(),getKodRdzenia(),getIloscPamieci(),getTdp(),getTaktowanieRdzenia(),getTaktowaniePamieci());
    }
}*/
