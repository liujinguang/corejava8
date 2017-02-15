package v2ch06.ProgressBarTest;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class ProgressBarTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class ProgressBarFrame extends JFrame {
    class SimulateActivity extends SwingWorker<Void, Integer> {

        @Override
        protected Void doInBackground() throws Exception {
            // TODO Auto-generated method stub
            return null;
        }
        
        @Override
        protected void done() {
            // TODO Auto-generated method stub
            super.done();
        }
        
        @Override
        protected void process(List<Integer> chunks) {
            // TODO Auto-generated method stub
            super.process(chunks);
        }
        
        private int current;
        private int target;
    }
}
