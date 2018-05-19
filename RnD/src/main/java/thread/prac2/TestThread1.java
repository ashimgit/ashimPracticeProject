package thread.prac2;

public class TestThread1 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("This is Thread 1");
		super.run();
		
		System.out.println("My stacktrace :"+getStackTrace().toString());
	}
}
