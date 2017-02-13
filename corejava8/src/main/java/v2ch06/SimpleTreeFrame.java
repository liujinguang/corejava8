package v2ch06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class SimpleTreeFrame extends JFrame {

    public SimpleTreeFrame() {
        setTitle("SimpleTreeTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        //set up tree model data
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
        DefaultMutableTreeNode country = new DefaultMutableTreeNode("USA");
        root.add(country);
        
        DefaultMutableTreeNode state = new DefaultMutableTreeNode("California");
        country.add(state);
        DefaultMutableTreeNode city = new DefaultMutableTreeNode("San Jose");
        state.add(city);
        city = new DefaultMutableTreeNode("Cupertino");
        state.add(city);
        
        state = new DefaultMutableTreeNode("Michigan");
        country.add(state);
        city = new DefaultMutableTreeNode("Ann Arbor");
        state.add(city);
        country = new DefaultMutableTreeNode("Germany");
        root.add(country);
        state = new DefaultMutableTreeNode("Schleswig-Holstein");
        country.add(state);
        city = new DefaultMutableTreeNode("Kiel");
        state.add(city);
        
     // construct tree and put it in a scroll pane
//      tree.putClientProperty("JTree.lineStyle", "None");
//      tree.putClientProperty("JTree.lineStyle", "Angled");
//      tree.setShowsRootHandles(true);
        
        JTree tree= new JTree(root);
        add(new JScrollPane(tree));
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new SimpleTreeFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
}