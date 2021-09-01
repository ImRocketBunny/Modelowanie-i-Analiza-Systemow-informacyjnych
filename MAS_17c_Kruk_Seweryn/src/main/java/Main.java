import gui.OkienkoTelefonu;
import gui.WyswietlHistorieZamowien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {
    private JFrame jFrame=new JFrame();
    private JPanel contentPane;
    public Main(){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(100, 100, 837, 426);
        jFrame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new OkienkoTelefonu(new Main().jFrame);
    }
}

