package classes.innerClass;

class StaticOuter {
	static final int i = 10;

	static class StaticIn {
		void f1() {
			System.out.println("This is static inner and i= " + i);
		}
	}
}

public class StaticInnerMain {
	public static void main(String[] args) {
		StaticOuter.StaticIn obj=new StaticOuter.StaticIn();
		obj.f1();
	}
}
