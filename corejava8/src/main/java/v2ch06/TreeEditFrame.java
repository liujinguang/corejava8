package v2ch06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeEditFrame extends JFrame {

    public TreeEditFrame() {
        // TODO Auto-generated constructor stub
    }

    public TreeNode makeSampleTree() {
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

        return root;
    }

    public void makeButtons() {
        JPanel panel = new JPanel();
        JButton addSliblingButton = new JButton("Add Slibling");
        addSliblingButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();

                if (selectNode == null) {
                    return;
                }

                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectNode
                        .getParent();
                if (parent == null) {
                    return;
                }

                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
                        "New");

                int selectedIndex = parent.getIndex(selectNode);
                model.insertNodeInto(newNode, parent, selectedIndex + 1);

                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);
            }
        });
        panel.add(addSliblingButton);

        JButton addChildButton = new JButton("Add Child");
        addChildButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();
                if (selectedNode == null) {
                    return;
                }
                
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New"  );
                model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                
                //display new node now
                TreeNode[] nodes = model.getPathToRoot(newNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);
            }
        });
        panel.add(addChildButton);
    }

    public static void main(String[] args) {

    }

    private DefaultTreeModel model;
    private JTree tree;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 200;
}
