package atrybutu;

public class Opinia {

    public final static Integer minimumRating = 0;//min
    public final static Integer maximumRating = 10;//max
    private Integer ocena;
    private String tresc;

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) throws Exception {
        if(ocena<minimumRating){
            throw new Exception(String.format("Podana ocena jest poniżej skali. Minimum to %s",minimumRating));
        }
        if(ocena>maximumRating){
            throw new Exception(String.format("Podana ocena jest powyżej skali. M aksium to %s",maximumRating));
        }
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Opinia(Integer ocena, String tresc) throws Exception {
        if(ocena<minimumRating){
            throw new Exception(String.format("Podana ocena jest poniżej skali. Minimum to %s",minimumRating));
        }
        if(ocena>maximumRating){
            throw new Exception(String.format("Podana ocena jest powyżej skali. M aksium to %s",maximumRating));
        }
        this.ocena = ocena;
        this.tresc = tresc;
    }
}
