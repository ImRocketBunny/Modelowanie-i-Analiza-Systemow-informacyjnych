package Models;


import Service.SqlServerDbService;
import gui.WyswietlHistorieZamowien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Zamowienie {

    @Id
    @GeneratedValue(generator = "increament")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }



    public enum statusZamowienia{ZLOZONE,ANULOWANE,W_TRAKCIE_REALIZACJI,ZREALIZOWANE}

    private final static Integer minimalnaOcena = 0;
    private final static Integer maksymalnaOcena = 10;
    private final static Integer maksymalnaDlugosc = 500;
    @OneToMany
    private List<PodzespolWzamowieniu> podzespoly = new ArrayList<>();
    @ManyToOne
    private Klient klient;
    @ManyToOne
    private Reklamacja reklamacja = null;
    @ManyToOne
    private Magazynier magazynier;

    private LocalDate dataZlozenia;
    private Enum status;
    private Double kwota;
    private Integer ocena = null;
    private String opinia = null;
    private String sposobZaplaty;
    private String adresDostawy;
    private Integer rabat=null;



    @Basic
    public LocalDate getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(LocalDate dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }
    @Enumerated
    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
    @Basic
    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }
    @Basic(optional = true)
    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) throws Exception {
        if(ocena>=minimalnaOcena&&ocena<=maksymalnaOcena) {
            this.ocena = ocena;
        }else {
            throw new Exception("Ocena poza dozwolona skala");
        }
    }
    @Basic(optional = true)
    public String getOpinia() {
        return opinia;
    }

    public void setOpinia(String opinia) throws Exception {
        if(opinia.length()>maksymalnaDlugosc){
            throw new Exception("Tekst za dklugi");
        }
        this.opinia = opinia;
    }
    @Basic
    public String getSposobZaplaty() {
        return sposobZaplaty;
    }

    public void setSposobZaplaty(String sposobZaplaty) {
        this.sposobZaplaty = sposobZaplaty;
    }
    @Basic
    public String getAdresDostawy() {
        return adresDostawy;
    }

    public void setAdresDostawy(String adresDostawy) {
        this.adresDostawy = adresDostawy;
    }
    @Basic
    public Integer getRabat() {
        return rabat;
    }

    public void setRabat(Integer rabat) {
        this.rabat = rabat;
    }

    @OneToMany(mappedBy = "zamowienie",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    public List<PodzespolWzamowieniu> getPodzespoly() {
        return podzespoly;
    }

    public void setPodzespoly(List<PodzespolWzamowieniu> podzespoly) throws Exception {
        if(podzespoly==null){
            throw new Exception("Bledne podzespoly");
        }
        this.podzespoly = podzespoly;
    }
    @ManyToOne
    public Reklamacja getReklamacja() {
        return reklamacja;
    }

    public void setReklamacja(Reklamacja reklamacja) throws Exception {
        if(reklamacja==null){
            throw new Exception("Bledna reklamacja");
        }
        this.reklamacja = reklamacja;
    }

    @ManyToOne
    public Magazynier getMagazynier() {
        return magazynier;
    }

    public void setMagazynier(Magazynier magazynier) throws Exception{
        if(magazynier==null) {
            throw new Exception("Bledny magazynier");
        }
        this.magazynier=magazynier;
    }

    @ManyToOne
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) throws Exception {
        if(klient==null){
            throw new Exception("Bledny klient");
        }
        this.klient = klient;
    }

    public Zamowienie() {

    }


    public Zamowienie(List<PodzespolWzamowieniu> podzespoly, Klient klient, LocalDate dataZlozenia, Enum status, Double kwota, String sposobZaplaty, String adresDostawy) throws Exception {
        setPodzespoly(podzespoly);
        setKlient(klient);
        this.dataZlozenia = dataZlozenia;
        this.status = status;
        this.kwota = kwota;
        this.sposobZaplaty = sposobZaplaty;
        this.adresDostawy = adresDostawy;

        klient.dodajZamowienie(this);
        for (PodzespolWzamowieniu podzespol:podzespoly
             ) {
            podzespol.dodajZamowienie(this);
        }
    }
    public Zamowienie(LocalDate dataZlozenia, Enum status, Double kwota, String sposobZaplaty, String adresDostawy) throws Exception {
        this.dataZlozenia = dataZlozenia;
        this.status = status;
        this.kwota = kwota;
        this.sposobZaplaty = sposobZaplaty;
        this.adresDostawy = adresDostawy;
    }

    public void dodajPodzespolWZamowieniu(PodzespolWzamowieniu podzespolWzamowieniu) throws Exception {
        if(!podzespoly.contains(podzespolWzamowieniu)) {
            podzespoly.add(podzespolWzamowieniu);
            podzespolWzamowieniu.dodajZamowienie(this);
        }
    }

    public void usunPodzesolWZamowieniu(PodzespolWzamowieniu podzespolWzamowieniu){
        if(podzespoly.contains(podzespolWzamowieniu)){
            podzespoly.remove(podzespolWzamowieniu);
            podzespolWzamowieniu.usunZamowienie(this);
        }
    }

    public void dodajKlienta(Klient klient) throws Exception {
        if(this.klient!=null){
            throw new Exception("bledny klient");
        }
            setKlient(klient);
            klient.dodajZamowienie(this);
    }

    public void usunKlienta(Klient klient) throws Exception{
        if(this.klient==klient){
            this.klient=null;
            klient.usunZamowienie(this);
        }
    }

    public void dodajMagazyniera(Magazynier magazynier) throws Exception {
        if(this.magazynier!=null){
            throw new Exception("zamowienie ma przydzielonego magazyniera");
        }
        setMagazynier(magazynier);
        magazynier.dodajZamowienie(this);

    }

    public void usunMagazyniera(Magazynier magazynier) throws Exception{
        if(this.magazynier==magazynier){
            this.magazynier=null;
            magazynier.usunZamowienie(this);
        }
    }

    public void dodajReklamacje(Reklamacja reklamacja) throws Exception {
        if(this.reklamacja!=null){
            throw new Exception("zamowienie ma reklmacje");
        }
        setReklamacja(reklamacja);
    }

    public void usunReklamacje(Reklamacja reklamacja) {
        if(this.reklamacja==reklamacja){
            this.reklamacja=null;
            reklamacja.usunZamowienie(this);
        }
    }



    @Override
    public String toString() {
        return "Zamowienie{" +
                "podzespoly=" + podzespoly.toString() +
                ", dataZlozenia=" + dataZlozenia +
                ", status=" + status +
                ", kwota=" + kwota +
                ", ocena=" + ocena +
                ", opinia='" + opinia + '\'' +
                ", sposobZaplaty='" + sposobZaplaty + '\'' +
                ", adresDostawy='" + adresDostawy + '\'' +
                ", rabat=" + rabat +
                '}';
    }

    public void anulujZamowienie() throws Exception {
        if(this.status==statusZamowienia.ZLOZONE || this.status==statusZamowienia.W_TRAKCIE_REALIZACJI){
            this.status=statusZamowienia.ANULOWANE;
        }else{
            throw new Exception("Nie mozna anulowac zamowienia");
        }
    }

    public static Zamowienie zlozZamowienie(List<PodzespolWzamowieniu> podzespoly, Klient klient, Double kwota, String sposobZaplaty, String adresDostawy) throws Exception {
        Zamowienie zamowienie = new Zamowienie(podzespoly,klient,LocalDate.now(),statusZamowienia.ZLOZONE,kwota,sposobZaplaty,adresDostawy);
        klient.dodajZamowienie(zamowienie);
        for (PodzespolWzamowieniu podzespolWzamowieniu:podzespoly
             ) {
            podzespolWzamowieniu.dodajZamowienie(zamowienie);
        }
        return zamowienie;
    }
    public Reklamacja zlozReklamacje(String powod) throws Exception {
        if(this.reklamacja==null){
            Reklamacja reklamacja = Reklamacja.stworzreklamacje(this,LocalDate.now(),Reklamacja.statusy.ZLOZONA,powod);
            return reklamacja;
        }else {
            throw new Exception("Zamowienie zostalo juz zareklamowane");
        }
    }
    public void realizujZamowienie(Magazynier magazynier) throws Exception {
        if(this.magazynier==magazynier){
            this.status=statusZamowienia.W_TRAKCIE_REALIZACJI;
        }else {
            throw new Exception("Blad");
        }
    }
    public void dodajAdres(String adresDostawy){
        setAdresDostawy(adresDostawy);
    }

    public void finalizujZamowienie(Magazynier magazynier) throws Exception {
        if(this.magazynier==magazynier){
            this.status=statusZamowienia.ZREALIZOWANE;
        }else {
            throw new Exception("Blad");
        }

    }
    public void dodajPodzespol(PodzespolWzamowieniu podzespolWzamowieniu) throws Exception {
        dodajPodzespolWZamowieniu(podzespolWzamowieniu);
        podzespolWzamowieniu.dodajZamowienie(this);
    }
    public void przydzielMagazyniera(Magazynier magazynier) throws Exception {
        if(this.magazynier==null){
            dodajMagazyniera(magazynier);
            magazynier.dodajZamowienie(this);
        }else {
            throw new Exception("Zamowienie ma magazyniera");
        }
    }

    public List<PodzespolWzamowieniu> wyswietlZawartoscZamowienia(){
        return this.getPodzespoly();
    }
    public static void wyswietlListeZamowien(String telefon,JFrame jFrame){

        new WyswietlHistorieZamowien(telefon,jFrame);
        /*StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            Klient klient = (Klient) session.createQuery("from Klient where telefonKontaktowy=:telefonkontaktowy").setParameter("telefonkontaktowy",telefon).getSingleResult();
            jFrame.getContentPane().removeAll();
            jFrame.repaint();

            JList listaZamowien = new JList();
            JList listaPodzespolow = new JList();
            //List<Zamowienie> zamowienia;
            DefaultListModel modelZamowien = new DefaultListModel();
            DefaultListModel modelPodzespolow = new DefaultListModel();
            JLabel labelTytul;
            JLabel labeldolny;
            JLabel labelBottom;
            JButton buttonPowrot;
            JLabel labelBottomPrawa;
            JTextArea tekst = new JTextArea(50, 25);

            //SqlServerDbService sql = new SqlServerDbService();
            //Klient klient = sql.getKlient(telefon);
            List<Zamowienie> zamowieniaKlienta = klient.getZamowienia();

            for (Zamowienie zam : zamowieniaKlienta
            ) {
                modelZamowien.addElement("Zamowienie nr " + (zamowieniaKlienta.indexOf(zam)+1)+" " + zam.getDataZlozenia());
            }
            listaZamowien.setModel(modelZamowien);



            listaZamowien.setBackground(Color.GRAY);
            listaPodzespolow.setBackground(Color.GRAY);
            SwingUtilities.updateComponentTreeUI(jFrame);


            JScrollPane scroll = new JScrollPane();
            scroll.setViewportView(listaZamowien);
            GridBagConstraints gbc_list = new GridBagConstraints();
            gbc_list.fill = GridBagConstraints.BOTH;
            gbc_list.gridwidth = 3;
            gbc_list.insets = new Insets(1, 5, 1, 5);
            gbc_list.gridx = 0;
            gbc_list.gridy = 1;
            jFrame.getContentPane().add(scroll, gbc_list);


            JScrollPane scroll1 = new JScrollPane();
            listaPodzespolow.setPreferredSize(new Dimension(200, 200));
            scroll1.setViewportView(listaPodzespolow);
            GridBagConstraints gbc_list_1 = new GridBagConstraints();
            gbc_list_1.insets = new Insets(1, 0, 1, 5);
            gbc_list_1.gridwidth = 8;
            gbc_list_1.fill = GridBagConstraints.BOTH;
            gbc_list_1.gridx = 8;
            gbc_list_1.gridy = 1;
            jFrame.getContentPane().add(scroll1, gbc_list_1);
            JLabel label = new JLabel();
            //jFrame.removeAll();
            //jFrame.add(listaPodzespolow);
            //jFrame.add(listaZamowien);

            JScrollPane scroll2 = new JScrollPane();
            scroll2.setViewportView(tekst);
            GridBagConstraints gbc_tekst = new GridBagConstraints();
            gbc_tekst.fill = GridBagConstraints.BOTH;
            gbc_tekst.gridwidth = 8;
            gbc_tekst.insets = new Insets(1, 0, 0, 5);
            gbc_tekst.gridx = 16;
            gbc_tekst.gridy = 1;
            jFrame.getContentPane().add(scroll2, gbc_tekst);


            listaZamowien.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    tekst.setText("");
                    listaPodzespolow.removeAll();
                    listaPodzespolow.clearSelection();
                    List<PodzespolWzamowieniu> podzespolyKlienta = zamowieniaKlienta.get(listaZamowien.getSelectedIndex()).getPodzespoly();
                    modelPodzespolow.removeAllElements();
                    for (PodzespolWzamowieniu pd : podzespolyKlienta
                    ) {
                        modelPodzespolow.addElement(pd.getPodzespolKomputerowy().getNazwa()+" sztuk: "+pd.getIlosc());
                    }
                    listaPodzespolow.setModel(modelPodzespolow);
                    for (ListSelectionListener lsl:listaPodzespolow.getListSelectionListeners()
                         ) {
                        listaPodzespolow.removeListSelectionListener(lsl);
                    }
                    //listaPodzespolow.clearSelection();
                    listaPodzespolow.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if(!listaPodzespolow.isSelectionEmpty())
                                tekst.setText(podzespolyKlienta.get(listaPodzespolow.getSelectedIndex()).getPodzespolKomputerowy().toString());
                        }
                    });

                }
            });


        SqlServerDbService sql = new SqlServerDbService();
        Klient osoba = sql.getKlient(telefon);
        List<Zamowienie> zamowienia = sql.getZamowienie(osoba);*/
         /*   //return jFrame;
        }catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy( registry );
        }
        //Session finalSession = session;
        jFrame.addWindowListener(new WindowAdapter() {
            public void WindowClosingg(WindowEvent e){
               /* session.close();
                sessionFactory.close();
                sessionFactory = null;
            }
        });*/

//        finally{
//                if (sessionFactory != null) {
//                    sessionFactory.close();
//                    sessionFactory = null;
//                }
//        }
    }

}
