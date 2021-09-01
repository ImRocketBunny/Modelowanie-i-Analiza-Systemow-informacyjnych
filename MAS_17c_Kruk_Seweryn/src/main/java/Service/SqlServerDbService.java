package Service;

import Models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class SqlServerDbService implements ISklepDbInterface{
    StandardServiceRegistry registry = null;
    SessionFactory sessionFactory = null;

    /*@Override
    public List<PodzespolKomputerowy> getPodzespoly() {
            try {
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                var moviesFromDb = session.createQuery("from PodzespolKomputerowy ").list();
                session.getTransaction().commit();
                session.close();
                return moviesFromDb;
            }
            catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy( registry );
            }

            finally{
                if (sessionFactory != null) {
                    sessionFactory.close();
                    sessionFactory = null;
                }
            }
            return null;
    }*/

    @Override
    public Klient getKlient(String telefonKontaktowy) {
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Klient klienci = (Klient) session.createQuery("from Klient where telefonKontaktowy=:telefonkontaktowy").setParameter("telefonkontaktowy","517786800").getSingleResult();

            //List<Zamowienie> zamowienia = klienci.getZamowienia();
            /*for (Zamowienie zam:zamowienia
                 ) {
                for (PodzespolWzamowieniu pwz:zam.getPodzespoly()
                ) {
                    System.out.println(pwz.getPodzespolKomputerowy().toString());
                }
            }*/




            session.getTransaction().commit();
            session.close();
            return  klienci;
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }

        finally{
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
        return null;
    }

    /*@Override
    public List<Zamowienie> getZamowienie(Klient klient) {
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

           // Klient klienci = (Klient) session.createQuery("from Klient where telefonKontaktowy=:telefonkontaktowy").setParameter("telefonkontaktowy","517786800").getSingleResult();

            //List<Zamowienie> zamowienia = klienci.getZamowienia();

            List<Zamowienie> zamowienia = klient.getZamowienia();

            //var zamowienia = session.createQuery("from Zamowienie where Klient =:klient").setParameter("klient",klienci).list();

//            for (Zamowienie zam :zamowienia
//                 ) {
//                for (PodzespolWzamowieniu pwz:zam.getPodzespoly()
//                     ) {
//                    System.out.println(pwz.getPodzespolKomputerowy().toString());
//                }
//            }

            //System.out.println(klienci);

            //System.out.println(zamowienia);


            session.getTransaction().commit();
            session.close();

           return zamowienia;
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }

        finally{
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
        return null;
    }*/

    @Override//long id
    public List<PodzespolWzamowieniu> getPodzespoly(Zamowienie zamowienie) {
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            var podzespoly = session.createQuery("from PodzespolWzamowieniu where zamowienie.id=:klientid").setParameter("klientid",zamowienie.getId()).list();

            session.getTransaction().commit();
            session.close();
            return podzespoly;
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }

        finally{
            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }
        }
        return null;
    }


    public void open(){
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void close(){

            if (sessionFactory != null) {
                sessionFactory.close();
                sessionFactory = null;
            }

    }





}

