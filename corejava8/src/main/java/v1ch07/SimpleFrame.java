package v1ch07;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SimpleFrame extends JFrame {

    public SimpleFrame() {
        setTitle("Simple Frame Test");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new SimpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
    }

}
