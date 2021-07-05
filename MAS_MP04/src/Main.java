import atrybutu.Opinia;
import bag.Danie;
import bag.Klient;
import bag.Zamowienie;
import ordered.KontoBankowe;
import ordered.Osoba;
import ordered.Transakcja;
import subset.GrupaOpercyjna;
import subset.Zolnierz;
import unique.Producent;
import wlasne.Item;
import xor.Samochod;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {
        xor();
    }
    public static void atrybutu() throws Exception {
        Opinia op2 = new Opinia(5,"średnie");
        try {
            Opinia op1 = new Opinia(11,"Dobry produkt, polecam");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void ordered() throws Exception {
        Osoba os = new Osoba("1234567890","Seweryn", "Kruk");
        KontoBankowe kn = new KontoBankowe("261111111111111111",os);
        Transakcja tr1 = new Transakcja("trMNOP","12345678998878","12.0","za naprwe");

        Transakcja tr2 = new Transakcja("trKNWD","5557777888548844","240.0","Podzial zysku");
        kn.makeTransfer(tr2);
        kn.makeTransfer(tr1);

        kn.showHistory();
    }
    public static void subset() throws Exception {
        Zolnierz z1 = new Zolnierz("Seweryn", "Kruk", "Sierzant");
        Zolnierz z2 = new Zolnierz("Adam", "B", "Szeregowy");
        Zolnierz z3 = new Zolnierz("Haggard", "B", "Szeregowy");
        Zolnierz z4 = new Zolnierz("Sweat", "B", "Szeregowy");
        Zolnierz z5 = new Zolnierz("Sweat", "B", "Szeregowy");

        GrupaOpercyjna go = new GrupaOpercyjna(12212,"Delta");
        go.addZolnierz(z1);
        go.addZolnierz(z2);
        go.addZolnierz(z3);
        go.addZolnierz(z4);
        go.setDowodca(z1);
        try {
            go.setDowodca(z5);
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void unique() throws Exception {
        Producent pr = new Producent("012345","Intel");
        Producent pr2 = new Producent("67890","AMD");

        try {
            pr2.setIdentyfikator("012345");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void wlasny() throws Exception {
        Item item1 = new Item("ABCD123456","Koszyk");
        try {
            Item item2 = new Item("ABC12345","Koszyk maly");
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void xor() throws Exception {
        Samochod sam1 = new Samochod("Audi","V6 1.6", Samochod.sellType.KUPNO,50000.0);
        Samochod sam2 = new Samochod("Toyota","2JZ", Samochod.sellType.LEASING,1200.0);
    }
    public static void bag() throws Exception{
        Danie danie1 = new Danie("Spagetti", new String[]{"makaron", "mieso mielone","sos pomoidorowy"});
        Klient k1 = new Klient("98022504556","Kruk","Seweryn");
        k1.addZamowienie(new Zamowienie(LocalDate.now(),k1,danie1));
        k1.addZamowienie(new Zamowienie(LocalDate.now(),k1,danie1));
        k1.addZamowienie(new Zamowienie(LocalDate.now(),k1,danie1));

        System.out.println(k1);
    }

}
