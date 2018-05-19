package thread.prac2;

public class MyThreadMain{

	public static void main(String[] args) {
		System.out.println("This is to start.");
		new TestThread1().start();
	}
}
