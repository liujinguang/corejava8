package v1ch14.FutureTest;

import java.io.File;
import java.util.concurrent.Callable;

public class FutureTest {

}

/**
 * This task counts the files in a directory and its subdirectories that contain
 * a keyword
 * 
 * @author jliu
 *
 */
class MatchCounter implements Callable<Integer> {

	public MatchCounter(File directory, String keyword) {
		super();
		this.directory = directory;
		this.keyword = keyword;
	}

	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private File directory;
	private String keyword;
	private int count;
}