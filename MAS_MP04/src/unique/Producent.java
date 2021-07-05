package unique;

import java.util.*;

public class Producent {
    private String identyfikator; //unikaotwy dla producenta
    private String nazwa;


    private static Set<String> identyfikatory = new HashSet<>(); //set uzywanych identyfikatorow

    public String getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(String identyfikator) throws Exception {
        if(identyfikatory.contains(identyfikator)){
            throw new Exception("Podany identyfikator producenta już istnieje");
        }
        this.identyfikator = identyfikator;
        identyfikatory.add(identyfikator);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Producent(String identyfikator, String nazwa) throws Exception {
        this.setIdentyfikator(identyfikator);
        this.nazwa = nazwa;
        //identyfikatory.add(identyfikator);
    }
}
