package v2ch06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PlanetTableFrame extends JFrame {

    public PlanetTableFrame() {
        setTitle("PlanetTable");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        final JTable table = new JTable(cells, columnNames);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    // TODO: handle exception
                }
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(printButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new PlanetTableFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    private Object[][] cells = { { "Mercury", 2440.0, 0, false, Color.yellow },
            { "Venus", 6052.0, 0, false, Color.yellow },
            { "Earth", 6378.0, 1, false, Color.blue },
            { "Mars", 3397.0, 2, false, Color.red },
            { "Junipter", 71492.0, 16, true, Color.orange },
            { "Saturn", 60268.0, 18, true, Color.orange }, 
            {"Uranus", 25559.0, 17, true, Color.blue},
            {"Neptune", 24766.0, 8, true, Color.blue},
            {"Pluto", 1137.0, 1, false, Color.black}};

    private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous",
            "Color" };

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;
}
