package package1;

import package2.ClassB;

public class ClassA {

	private static final ClassB CLASS_B = new ClassB();

	public static void main(String[] args) {
		String message = CLASS_B.printColors(Colors.Red.name(), Colors.Blue.name());
		System.out.println(message);
	}
}
