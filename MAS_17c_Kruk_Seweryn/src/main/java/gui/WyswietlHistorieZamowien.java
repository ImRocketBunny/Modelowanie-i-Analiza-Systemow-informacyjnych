package gui;

import Models.Klient;
import Models.Osoba;
import Models.PodzespolWzamowieniu;
import Models.Zamowienie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class WyswietlHistorieZamowien {
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel tytulZamowienia;
    private javax.swing.JLabel tytulPodzespoly;
    private javax.swing.JLabel tytulSzczegoly;
    private javax.swing.JLabel daneKlienta;
    private javax.swing.JList listaZamowien;
    private javax.swing.JList listaPodzespolow;
    private javax.swing.JScrollPane jScrollZamowienia;
    private javax.swing.JScrollPane jScrollPodzespoly;
    private javax.swing.JTextArea szczegolyPodzespolu;
    private javax.swing.DefaultListModel modelZamowien;
    private javax.swing.DefaultListModel modelPodzespolow;
    private javax.swing.JScrollPane jScrollSzczegoly;

    private Klient klient;
    private JPanel contentPane;

    StandardServiceRegistry registry = null;
    SessionFactory sessionFactory = null;
    Session session = null;

    //private SqlServerDbService sql;

    public WyswietlHistorieZamowien(String telefon,JFrame frame){
        frame.getContentPane().removeAll();
        frame.repaint();
        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            klient = (Klient) session.createQuery("from Klient where telefonKontaktowy=:telefonkontaktowy").setParameter("telefonkontaktowy", telefon).getSingleResult();
            initilizeComponents(frame);
        }catch (Exception e) {
        e.printStackTrace();
        StandardServiceRegistryBuilder.destroy( registry );
        }


    }
    private void initilizeComponents(JFrame frame){
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.setTitle("Sklep z podzespolami komputerowymi online");
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        frame.getContentPane().setLayout(gbl_contentPane);
        jScrollZamowienia = new javax.swing.JScrollPane();
        listaZamowien = new javax.swing.JList<>();
        jScrollPodzespoly = new javax.swing.JScrollPane();
        listaPodzespolow = new javax.swing.JList<>();
        szczegolyPodzespolu = new javax.swing.JTextArea();
        tytulPodzespoly = new javax.swing.JLabel();
        tytulSzczegoly = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        daneKlienta = new javax.swing.JLabel();
        tytulZamowienia = new javax.swing.JLabel();
        modelZamowien = new DefaultListModel();
        modelPodzespolow = new DefaultListModel();
        jScrollSzczegoly = new javax.swing.JScrollPane();


        for (Zamowienie zam:klient.getZamowienia()
        ) {
            modelZamowien.addElement("Zamowienie numer "+(klient.getZamowienia().indexOf(zam)+1)+" dokonane "+zam.getDataZlozenia());
        }
        listaZamowien.setModel(modelZamowien);
        jScrollZamowienia.setViewportView(listaZamowien);
        jScrollPodzespoly.setViewportView(listaPodzespolow);

        listaZamowien.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                szczegolyPodzespolu.setText("");
                listaPodzespolow.removeAll();
                listaPodzespolow.clearSelection();
                List<PodzespolWzamowieniu> podzespolyKlienta = klient.getZamowienia().get(listaZamowien.getSelectedIndex()).getPodzespoly();
                modelPodzespolow.removeAllElements();
                for (PodzespolWzamowieniu pd : podzespolyKlienta
                ) {
                    modelPodzespolow.addElement(pd.getPodzespolKomputerowy().getNazwa()+" - sztuk: "+pd.getIlosc());
                }
                listaPodzespolow.setModel(modelPodzespolow);
                for (ListSelectionListener lsl:listaPodzespolow.getListSelectionListeners()
                ) {
                    listaPodzespolow.removeListSelectionListener(lsl);
                }
                listaPodzespolow.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if(!listaPodzespolow.isSelectionEmpty())
                            szczegolyPodzespolu.setText(podzespolyKlienta.get(listaPodzespolow.getSelectedIndex()).getPodzespolKomputerowy().toString());
                    }
                });

            }
        });

        tytulZamowienia.setText("Zamowienia Klienta: "+klient.getTelefonKontaktowy());
        tytulPodzespoly.setText("Podzespoly w Zamowieniu");
        tytulPodzespoly.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tytulSzczegoly.setText("Szczegóły podzespołu");
        tytulSzczegoly.setFont(new Font("Times New Roman", Font.BOLD, 24));
        //daneKlienta.setText("Klient: ");
        daneKlienta.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tytulZamowienia.setFont(new Font("Times New Roman", Font.BOLD, 24));

        jButton1.setText("Wyjście");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(frame, "Napewno chcesz wyjść?", "Potwierdzenie.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
                    return;
                }
                if (sessionFactory != null) {
                    sessionFactory.close();
                    sessionFactory = null;
                }
                System.exit(0);
            }
        });

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;

        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        frame.getContentPane().add(jScrollZamowienia,gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;

        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;

        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        frame.getContentPane().add(jScrollPodzespoly,gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        frame.getContentPane().add(tytulZamowienia, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;

        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        frame.getContentPane().add(tytulPodzespoly, gridBagConstraints);


        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;

        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        frame.getContentPane().add(tytulSzczegoly, gridBagConstraints);


        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        frame.getContentPane().add(jButton1, gridBagConstraints);


        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        frame.getContentPane().add(daneKlienta, gridBagConstraints);

        szczegolyPodzespolu.setEditable(false);
        jScrollSzczegoly.setViewportView(szczegolyPodzespolu);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;

        gridBagConstraints.ipadx = 395;
        gridBagConstraints.ipady = 313;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        frame.getContentPane().add(jScrollSzczegoly, gridBagConstraints);

        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(frame, "Napewno chcesz wyjść?", "Potwierdzenie.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
                    return;
                }
                if (sessionFactory != null) {
                    sessionFactory.close();
                    sessionFactory = null;
                }
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

        });
        frame.pack();
        frame.setBounds(200, 200, 1366, 360);



    }

}
