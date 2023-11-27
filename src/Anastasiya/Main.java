package Anastasiya;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel contentPanel;

    public Main(){
        super("Zadanie 1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setLayout(null);

        DrawingPanel drawingPanel = new DrawingPanel();
        contentPanel.add(drawingPanel);

        setContentPane(contentPanel);
        setSize(500,350);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Main test = new Main();
                    test.setVisible(true);

                }catch (Exception e){
                    e.printStackTrace(System.err);
                }
            }
        });
    }
}


