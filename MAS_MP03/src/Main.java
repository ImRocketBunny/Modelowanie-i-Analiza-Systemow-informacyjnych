import dynamiczne.KierownikDzialuObslugi;
import dynamiczne.Osoba;
import dynamiczne.PracownikDzialuObslugi;
import klasaAbstrakcyjna.KartaGraficzna;
import klasaAbstrakcyjna.PlytaGlowna;
import klasaAbstrakcyjna.PodzespolKomputerowy;
import klasaAbstrakcyjna.Porcesor;
import wieloaspektowe.Osobowy;
import wieloaspektowe.Samochod;
import wielodziedziczenie.UrzadzenieWielofunkcyjne;
import wielodziedziczenie.UrządzenieElektryczne;


import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //klasaAbstrPolim();
        //dynamiczna();
        //overlapping();
        wieloosapektowe();
    }
    public static void klasaAbstrPolim(){
        PodzespolKomputerowy pc1 = new PlytaGlowna("01","AsRock","Gaming K6", "Z170 GAMING K6","Z170","LGA1151",3,11,"DDR4");
        PodzespolKomputerowy pc2 = new Porcesor("02","Intel","I7-7700K","BX80677I77700K",4,8,"DDR4", List.of("Single-channel","Dual-channel"),8);
        PodzespolKomputerowy pc3 = new KartaGraficzna("03","ZOTAC","GTX 1080 AMP! Edition","ZT-P10800C-10P","Nvidia",8192,"GDDR5X");
        System.out.println(pc1.getPamiec());
        System.out.println("+++++");
        System.out.println(pc2.getPamiec());
        System.out.println("++++++");
        System.out.println(pc3.getPamiec());
    }
    public static void dynamiczna(){
        Osoba o1 = new PracownikDzialuObslugi("Seweryn","Kruk","M","seweryn@gmail.com",2200.0,"Karty Graficzne");
        System.out.println(o1);
        o1 = new KierownikDzialuObslugi(o1,5000.0,"Procesory");
        System.out.println(o1);
    }
    public static void overlapping(){
        overlapping.Osoba o1 =new overlapping.Osoba("Seweryn","Kruk","M","@xkom.pl",5000.0,2200.0,"Latarki","Procesory");
        try {
            System.out.println(o1.getNazwaDzialu());
            System.out.println(o1.getPensjaPracownikaObslugi());
            System.out.println(o1.getKierowanyDzial());
            System.out.println(o1.getPensjaKierownicza());
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void wieloosapektowe(){
        Samochod osobowy1 = new Osobowy("Koenigsegg","Jesko","JESKO-TEST", Samochod.samochodUzytkowanie.LEASING,2);
        try {
            osobowy1.setRataLeasigowa(Optional.of(1200.0));
            osobowy1.getRataLeasigowa();
            osobowy1.setCenaZakupu(Optional.of(5000000.0));

        }catch (Exception e){
            System.out.println(e);

        }
    }

    public static void wielodziedziczenie(){

        UrządzenieElektryczne urzadel = new UrzadzenieWielofunkcyjne(200,230,"GB","4800 x 4800","210 x 297 mm","kolorowy","18 w czerni , 4 w kolorze");
    }

}
