package interview;

public class SingletonTest {
	public static class Singleton {
		/*
		 * 单利模式，线程安全
		 */
		public static Singleton instance = new Singleton();
		
		private Singleton() {
			
		}
		
		public static Singleton getInstance() {
			return instance;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance() == Singleton.getInstance());
	}
}
