import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

public class Procesor  implements Serializable {

    final static double vat = 1.23;

    private String nazwaProducenta;
    private String nazwaModelu;
    private String kodProducenta;
    private Double cenaNetto;
    private LocalDate dataPremiery;
    private Double czestotliwoscZegara;
    private Integer iloscRdzeni;
    private Integer iloscWatkow;
    private String iGpu = null;
    private String trybPracyPamieci;
    private Integer iloscCache;
    private List<String> zestawInstrukcji;

    private static List<Procesor> ekstensjaProcesora = new ArrayList<>();
    public Procesor(){
        addProcesor(this);
    }

    public Procesor(String nazwaProducenta,
                    String kodProducenta,
                    String nazwaModelu,
                    Double cenaNetto,
                    LocalDate dataPremiery,
                    Double czestotliwoscZegara,
                    Integer iloscRdzeni,
                    Integer iloscWatkow,
                    String iGpu,
                    String trybPracyPamieci,
                    Integer iloscCache,
                    List<String> zestawInstrukcji) {
        this.nazwaProducenta=nazwaProducenta;
        this.kodProducenta=kodProducenta;
        this.nazwaModelu=nazwaModelu;
        this.cenaNetto=cenaNetto;
        this.dataPremiery=dataPremiery;
        this.czestotliwoscZegara=czestotliwoscZegara;
        this.iloscRdzeni=iloscRdzeni;
        this.iloscWatkow=iloscWatkow;
        this.iGpu=iGpu;
        this.trybPracyPamieci=trybPracyPamieci;
        this.iloscCache=iloscCache;
        this.zestawInstrukcji=zestawInstrukcji;
        addProcesor(this);
    }
    public Procesor(String nazwaProducenta,
                    String kodProducenta,
                    String nazwaModelu,
                    Double cenaNetto,
                    LocalDate dataPremiery,
                    Double czestotliwoscZegara,
                    Integer iloscRdzeni,
                    Integer iloscWatkow,
                    String trybPracyPamieci,
                    Integer iloscCache,
                    List<String> zestawInstrukcji) {
        this.nazwaProducenta=nazwaProducenta;
        this.kodProducenta=kodProducenta;
        this.nazwaModelu=nazwaModelu;
        this.cenaNetto=cenaNetto;
        this.dataPremiery=dataPremiery;
        this.czestotliwoscZegara=czestotliwoscZegara;
        this.iloscRdzeni=iloscRdzeni;
        this.iloscWatkow=iloscWatkow;
        this.trybPracyPamieci=trybPracyPamieci;
        this.iloscCache=iloscCache;
        this.zestawInstrukcji=zestawInstrukcji;
        addProcesor(this);
    }

    public Double getCzestotliwoscZegara() {
        return czestotliwoscZegara;
    }

    public void setCzestotliwoscZegara(Double czestotliwoscZegara) {
        this.czestotliwoscZegara = czestotliwoscZegara;
    }

    public Integer getIloscRdzeni() {
        return iloscRdzeni;
    }

    public void setIloscRdzeni(Integer iloscRdzeni) {
        this.iloscRdzeni = iloscRdzeni;
    }

    public Integer getIloscWatkow() {
        return iloscWatkow;
    }

    public void setIloscWatkow(Integer iloscWatkow) {
        this.iloscWatkow = iloscWatkow;
    }

    public String getiGpu() {
        if(iGpu==null){
            return "(brak igpu)";
        }
        return iGpu;
    }


    public void setiGpu(String iGpu) {
        this.iGpu = iGpu;
    }

    public String getTrybPracyPamieci() {
        return trybPracyPamieci;
    }

    public void setTrybPracyPamieci(String trybPracyPamieci) {
        this.trybPracyPamieci = trybPracyPamieci;
    }

    public Integer getIloscCache() {
        return iloscCache;
    }

    public void setIloscCache(Integer iloscCache) {
        this.iloscCache = iloscCache;
    }

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

    public Double getCenaBrutto(){
        return getCenaNetto()*vat;
    }


    public LocalDate getDataPremiery() {
        return dataPremiery;
    }

    public void setDataPremiery(LocalDate dataPremiery) {
        this.dataPremiery = dataPremiery;
    }

    public List<String> getZestawInstrukcji() {
        return zestawInstrukcji;
    }

    public void setZestawInstrukcji(List<String> zestawInstrukcji) {
        this.zestawInstrukcji = zestawInstrukcji;
    }


    private static void addProcesor(Procesor procesor) {
        ekstensjaProcesora.add(procesor);
    }


    private static void removeProcesor(Procesor procesor) {
        ekstensjaProcesora.remove(procesor);
    }


    @Override
    public   String toString(){
        return String.format(this.getClass().getName()+": Producent: %s, Model: %s, Kod producenta: %s, Cena Netto: %s, Cena Brutto: %s, Data premiery: %s, Czestotliwosc zegara: %s, Ilosc rdzeni: %s, Ilosc watkow: %s, iGpu: %s, Tryb pracy pameci %s, Ilosc cache: %s, Zestaw instrukcji: %s",
                getNazwaProducenta(),getNazwaModelu(),getKodProducenta(),getCenaNetto(),getCenaBrutto(),getDataPremiery(),getCzestotliwoscZegara(),getIloscRdzeni(),getIloscWatkow(),getiGpu()!=null ? getiGpu(): "(no iGpu)",getTrybPracyPamieci(),getIloscCache(),getZestawInstrukcji());
    }



    public static void showExtent() throws Exception{

        for (Procesor pk: ekstensjaProcesora) {
            System.out.println(pk);
        }
    }
    public static void showExtent(String name, Object value) throws Exception{
            var result = switch (name){
                case "nazwaProducenta" ->ekstensjaProcesora.stream().filter(p2 -> p2.getNazwaProducenta().contains((CharSequence) value)).collect(Collectors.toList());
                case "nazwaModelu"->ekstensjaProcesora.stream().filter(p2 -> p2.getNazwaModelu().contains((CharSequence) value)).collect(Collectors.toList());
                case "kodProducenta"->ekstensjaProcesora.stream().filter(p2 -> p2.getKodProducenta().equals(value)).collect(Collectors.toList());
                case "cenaNetto"->ekstensjaProcesora.stream().filter(p2 -> p2.getCenaNetto().equals(value)).collect(Collectors.toList());
                case "czestotliwoscZegara"->ekstensjaProcesora.stream().filter(p2 -> p2.getCzestotliwoscZegara().equals(value)).collect(Collectors.toList());
                case "iloscRdzeni"->ekstensjaProcesora.stream().filter(p2 -> p2.getIloscRdzeni().equals(value)).collect(Collectors.toList());
                case "iloscWatkow"->ekstensjaProcesora.stream().filter(p2 -> p2.getIloscWatkow().equals(value)).collect(Collectors.toList());
                case "iGpu"->ekstensjaProcesora.stream().filter(p2 -> p2.getiGpu().equals(value)).collect(Collectors.toList());
                case "trybPracyPamieci"->ekstensjaProcesora.stream().filter(p2 -> p2.getTrybPracyPamieci().equals(value)).collect(Collectors.toList());
                case "iloscCache"->ekstensjaProcesora.stream().filter(p2 -> p2.getIloscCache().equals(value)).collect(Collectors.toList());
                case "zestawInstrukcji"->ekstensjaProcesora.stream().filter(p2 -> p2.getZestawInstrukcji().contains(value)).collect(Collectors.toList());
                default -> null;
            };
            if(result.isEmpty()) {
                System.out.println("Brak wynikow");
                return;
            }else if(result==null){
                System.out.println("błędny filtr");
                return;
            }
            for (Procesor p3:result
                 ) {
                System.out.println(p3);
            }
    }
    public static Procesor najtanszy() throws Exception{
        if(ekstensjaProcesora.isEmpty())
            throw new Exception("List empty");

        Procesor p = ekstensjaProcesora.get(0);
        for (Procesor proc:ekstensjaProcesora
             ) {
            if(proc.getCenaBrutto()<p.getCenaBrutto()){
                p=proc;
            }
        }
        return p;
    }

    public boolean czymMaHT(){
        return this.iloscWatkow==(this.iloscRdzeni*2);
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(ekstensjaProcesora);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ekstensjaProcesora = (ArrayList<Procesor>) stream.readObject();
    }

}
