package thread.prac1;

public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		Th1 t1=new Th1();
		System.out.println("************************************ 1");
		t1.start();
		System.out.println("************************************ 2");
		for(int j=0;j<10;j++){
			System.out.println("j= "+j);
			Thread.sleep(100);
		}
		System.out.println("************************************ 3");
		
	}

}
