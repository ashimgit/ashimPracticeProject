package thread.prac1;

public class Th1 extends Thread {

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("i= " + i);

				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
