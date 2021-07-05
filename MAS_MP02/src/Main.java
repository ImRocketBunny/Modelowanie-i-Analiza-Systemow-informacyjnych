import atrybut.Klient;
import atrybut.ObslugaKlienta;
import atrybut.Pytanie;
import kompozycja.Opinia;
import kompozycja.ZamowienieKom;
import kwalifikowana.Pracownik;
import kwalifikowana.Sklep;
import zwykła.PodzesolKomputerowy;
import zwykła.Zamowienie;
import kompozycja.ZamowienieKom;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Zwykła");
        //zwyklaTest();
        System.out.println("Kompozycja");
        //kompozycjaTest();
        System.out.println("z Atrybutem");
        //atrybutTest();
        System.out.println("Kwlifikowana");
        kwalifikowanaTest();
    }

    public static void zwyklaTest(){
        PodzesolKomputerowy pd1 = new PodzesolKomputerowy("ZAQ1234","Intel");
        PodzesolKomputerowy pd2 = new PodzesolKomputerowy("ZAQ!@#$","Intel");
        PodzesolKomputerowy pd3 = new PodzesolKomputerowy("NVGP104","Nvidia");

        Zamowienie zam1 = new Zamowienie("1", LocalDate.now(),"W trakcie przygotowywania");

        zam1.addPodzesolKomputerowy(pd1);
        zam1.addPodzesolKomputerowy(pd2);
        zam1.addPodzesolKomputerowy(pd3);

        System.out.println(zam1);

        System.out.println(pd1);


    }

    public static void atrybutTest(){
        Klient kl = new Klient("Seweryn", "Kruk", "s18371@pjwstk.edu.pl",LocalDate.parse("1998-02-25"),"Poland");
        ObslugaKlienta ob = new ObslugaKlienta("Al","Bundy", "AB@x-kom.pl","Podzespoły PC");
        kl.addPytanie(new Pytanie(LocalDate.now(),"Czy i7 yo najlepsze cpu",ob,kl));

        System.out.println(kl);
        System.out.println("=========================================================");
        System.out.println(ob);
    }

    public static void kompozycjaTest() throws Exception {
        ZamowienieKom zam1 = new ZamowienieKom("1", LocalDate.now(),"Zrealizowane");
        Opinia.createOpinia(zam1,LocalDate.now(),"Dostawa dlugo trwa",2);
        Opinia.createOpinia(zam1,LocalDate.now(),"Zabezpieczenie przesylki strasznie slabe",3);
        System.out.println(zam1);

    }

    public static void kwalifikowanaTest() throws Exception {
        Pracownik pr = new Pracownik("S","K","sk@email.com","12345678901");
        Sklep sk = new Sklep("X-kom","Warszawa");

        sk.addPracownikQ(pr);

        Pracownik szukany = sk.findPracownikQualif("12345678901");

        System.out.println(szukany);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(sk);

    }

}
