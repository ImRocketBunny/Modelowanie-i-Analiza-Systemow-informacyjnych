package gui;

import Models.Zamowienie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkienkoTelefonu {
    private TextField textField;
    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private JButton btnNewButton_1;

    public OkienkoTelefonu(JFrame frame){
        initizlizeComponents(frame);
    }

    public void initizlizeComponents(JFrame frame){
        frame.getContentPane().removeAll();
        //frame.removeAll();
        frame.repaint();
        frame.setTitle("Sklep z podzespolami komputerowymi online");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        //frame.setContentPane(contentPane);

        lblNewLabel = new JLabel("Podaj numer klienta");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 5;
        gbc_lblNewLabel.gridy = 2;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);


        textField=new TextField();
        textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
        textField.setColumns(9);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.gridx = 5;
        gbc_textField.gridy = 3;
        contentPane.add(textField, gbc_textField);

        panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 5;
        gbc_panel.gridy = 4;
        contentPane.add(panel, gbc_panel);

        btnNewButton = new JButton("Wyjście");
        panel.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(frame, "Napewno chcesz wyjść?", "Potwierdzenie.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {
                    return;
                }
                System.exit(0);
            }
        });

        btnNewButton_1 = new JButton("Wyświetl zamówienia klienta");
        panel.add(btnNewButton_1);

        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().length()!=9){
                    JOptionPane.showMessageDialog(frame, "numer telefonu ma 9 znaków");
                    return;
                }
               Zamowienie.wyswietlListeZamowien(textField.getText(),frame);


            }
        });
        frame.pack();
        frame.setBounds(200, 200, 1366, 360);
    }

}
