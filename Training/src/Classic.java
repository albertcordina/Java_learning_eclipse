class Classic1 {
	int x = 1;

	class Classic2 {
		int y = 2;
	}

}

public class Classic {

	public static void main(String[] args) {

		Classic1 ref1 = new Classic1();
		Classic1.Classic2 ref2 = ref1.new Classic2();

		System.out.println(ref1.x + ref2.y);

	}

}
