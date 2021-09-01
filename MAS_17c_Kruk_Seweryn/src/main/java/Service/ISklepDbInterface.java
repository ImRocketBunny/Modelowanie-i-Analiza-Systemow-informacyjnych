package Service;

import Models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public interface ISklepDbInterface {
   // public List<PodzespolKomputerowy> getPodzespoly();

    public Klient getKlient(String telefonKontaktowy);

    //public List<Zamowienie> getZamowienie(Klient klient);

   // public List<PodzespolWzamowieniu> getPodzespoly(Long id);
   public List<PodzespolWzamowieniu> getPodzespoly(Zamowienie zamowienie);


}
