package kompozycja;

import java.time.LocalDate;

public class Opinia {
    private LocalDate data;
    private String tresc;
    private Integer ocena;

    private ZamowienieKom zamowienie;


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }


    private Opinia(LocalDate data, String tresc, Integer ocena, ZamowienieKom zam) {
        this.data = data;
        this.tresc = tresc;
        this.ocena = ocena;
        this.zamowienie=zam;
    }

    public static Opinia createOpinia(ZamowienieKom zam,LocalDate data, String tresc, Integer ocena) throws Exception{
        if(zam==null){
            throw new Exception("Zamowienie nie istnieje");
        }
        Opinia opinia = new Opinia(data,tresc,ocena,zam);
        zam.addOpinia(opinia);

        return opinia;
    }
    public void removeZamowienie(){
        zamowienie.removeOpinia(this);
        this.zamowienie=null;
    }
}
