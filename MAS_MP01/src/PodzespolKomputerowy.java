/*import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class PodzespolKomputerowy implements Serializable {

    final static double vatRate = 1.23;
    private static Map<Class, List<PodzespolKomputerowy>> allExtents = new Hashtable<>();


    private String nazwaProducenta;
    private String nazwaModelu;
    private String kodProducenta;
    private Double cenaNetto;
    private Double cenaBrutto;
    private LocalDate dataPremiery;

    public String getNazwaProducenta() {
        return nazwaProducenta;
    }

    public void setNazwaProducenta(String nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }

    public String getNazwaModelu() {
        return nazwaModelu;
    }

    public void setNazwaModelu(String nazwaModelu) {
        this.nazwaModelu = nazwaModelu;
    }

    public String getKodProducenta() {
        return kodProducenta;
    }

    public void setKodProducenta(String kodProducenta) {
        this.kodProducenta = kodProducenta;
    }

    public Double getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(Double cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    public Double getCenaBrutto() {
        return cenaBrutto;
    }

    public void setCenaBrutto(Double cenaBruto) {
        this.cenaBrutto = cenaBruto;
    }

    public LocalDate getDataPremiery() {
        return dataPremiery;
    }

    public void setDataPremiery(LocalDate dataPremiery) {
        this.dataPremiery = dataPremiery;
    }

    public PodzespolKomputerowy(String nazwaProducenta, String nazwaModelu, String kodProducenta, Double cenaNetto, LocalDate dataPremiery){
        this.nazwaProducenta=nazwaProducenta;
        this.kodProducenta=kodProducenta;
        this.nazwaModelu=nazwaModelu;
        this.cenaNetto=cenaNetto;
        this.cenaBrutto=this.cenaNetto*vatRate;
        this.dataPremiery=dataPremiery;

        List extent = null;
        Class theClass = this.getClass();

        if(allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
        }
        else {
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }

        extent.add(this);
    }

    public KartaGraficzna getNajtanszy(){
        PodzespolKomputerowy najtanszy = null;
        List extent=null;
        if(allExtents.containsKey(KartaGraficzna.class)) {
            extent = allExtents.get(KartaGraficzna.class);
            for (Object pod:extent
                 ) {


            }
        }
        else {
            System.out.println("Podzespolu nie ma w ofercie sklepu");
            return
        }
    }

    public void write(DataOutputStream stream) throws IOException {
        //stream.writeUTF(title);
        //stream.writeFloat(price);
        //stream.writeLong(additionDate.toEpochDay());    // count of days where day 0 is 1970-01-01 (ISO)
    }

    public void read(DataInputStream stream) throws IOException {
        //title = stream.readUTF();
        //price = stream.readFloat();
        //long epochDay = stream.readLong();
        //additionDate = LocalDate.ofEpochDay(epochDay);
    }





    @Override
    public String toString(){
        return String.format(" Producent: %s, Model: %s, Kod producenta: %s, Cena Netto: %s, Cena Brutto: %s, Data premiery: %s", getNazwaProducenta(),getNazwaModelu(),getKodProducenta(),getCenaNetto(),getCenaBrutto(),getDataPremiery());
    }

    public static void showExtent(Class theClass) throws Exception {
        List extent = null;

        if(allExtents.containsKey(theClass)) {
            // Extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            throw new Exception("Niepoprawna Nazwa komponentu: " + theClass);
        }

        System.out.println(theClass);

        for(Object obj : extent) {
            System.out.println(obj);
        }
    }


    public static void showExtent() throws Exception{
        List extent=null;
        for ( Class entry : allExtents.keySet()
             ) {
            extent=allExtents.get(entry);
            System.out.println(entry);
            for (Object pk: extent
                 ) {
                System.out.println(pk);
            }

        }

    }






}*/
