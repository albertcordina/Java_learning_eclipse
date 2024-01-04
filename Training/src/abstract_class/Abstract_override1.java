package abstract_class;

abstract class Machine {
	
	abstract void on ();

}

public class Abstract_override1 extends Machine {

	@Override
	void on() {

		System.out.println("Turn the machine on");
	}
	
	public static void main(String args[]) {
		Abstract_override1 machine = new Abstract_override1(); // the subtype 'Tesla' can be used for the supertype 'Machine';
		machine.on();
	}
}
