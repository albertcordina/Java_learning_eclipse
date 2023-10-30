package abstract_class;

abstract class Shape { 
	abstract void shape();   // we use the abstract method 'shape' for the children classes below; 
}                            // NOTE: do not create abstract method if you do not use it;

class Rectangle extends Shape {

	@Override
	void shape() {                   //        we override the parent abstract method 'shape' for 'Rectangle';
		System.out.println("Rectangle shape");
	}

}

class Circle extends Shape {

	@Override
	void shape() {                   //        we override the parent abstract method 'shape' for 'Cirlce';
		System.out.println("Circle shape");
	}

}

public class Abstract_shape {

	public static void main(String[] args) {
		Shape s1 = new Rectangle();  //       the subtype 'Rectangle' can be used for the superclass 'Shape'; 
		Shape s2 = new Circle();     //       the subtype 'Circle' can also be used for the superclass 'Shape';
		s1.shape();                  //       to print out;
		s2.shape();

	}
}
