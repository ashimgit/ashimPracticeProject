package classes.innerClass;

class MemberInnerTest {
	int i = 10;

	class Inner1 {
		String s1 = "This is s1 from Inner1 ";

		void f1() {
			System.out.println("This is f1 from Inner1 and i= "+i);
		}
	}

	void methodOfOuter(){System.out.println("This is methodOfOuter");}
}

public class MemberInnerClass {
	public static void main(String[] args) {
		new MemberInnerTest().methodOfOuter();
		new MemberInnerTest().new Inner1().f1();
	}

}
