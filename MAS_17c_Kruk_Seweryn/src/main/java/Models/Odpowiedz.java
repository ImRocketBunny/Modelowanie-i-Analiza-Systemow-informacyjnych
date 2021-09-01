package Models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Odpowiedz {
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    private Pytanie pytanie;
    private LocalDate data;
    private String tresc;
    private Long id;

    @Basic
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    @Basic
    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
    @OneToOne
    public Pytanie getPytanie() {
        return pytanie;
    }

    public void setPytanie(Pytanie pytanie) throws Exception {
        if(pytanie==null){
            throw new Exception("Bledne pytanie");
        }
        this.pytanie = pytanie;
    }


    public Odpowiedz() {

    }

    private Odpowiedz(LocalDate data, String tresc, Pytanie pytanie) throws Exception {
        this.data = data;
        this.tresc = tresc;
        setPytanie(pytanie);

    }



    public static Odpowiedz stworzOdpowiedz(String tresc,Pytanie pytanie) throws Exception {
        Odpowiedz odpowiedz = new Odpowiedz(LocalDate.now(),tresc,pytanie);
        pytanie.dodajOdpowiedz(odpowiedz);

        return odpowiedz;
    }

    public void usunPytanie(){
        pytanie.usunOdpowiedz(this);
        this.pytanie=null;
    }

    @Override
    public String toString() {
        return "Odpowiedz{" +
                "data=" + data +
                ", tresc='" + tresc + '\'' +
                '}';
    }


}
