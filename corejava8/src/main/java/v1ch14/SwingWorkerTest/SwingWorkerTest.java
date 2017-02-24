package v1ch14.SwingWorkerTest;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.omg.CORBA.PRIVATE_MEMBER;

public class SwingWorkerTest {

}


class SwingWorkerFrame extends JFrame {
	
	private class ProgressData {
		public int number;
		public String line;
	}
	
	private JFileChooser chooser;
	private JTextArea textArea;
	private JLabel statusLine;
	private JMenuItem openItem;
	private JMenuItem cancelItem;
	private SwingWorker<StringBuilder, T> textReader;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 350;
}