package package2;

import package3.ClassC;

public class ClassB {
	public String printColors(String... values) {
		return "These are the colors we have: "
				+ String.join(new ClassC().separation(), values);
	}

}
