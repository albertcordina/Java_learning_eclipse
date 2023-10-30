package polimorphism;
class Bike {

    static int multiply (int a, int b) {
        return a * b;
    }
    static double multiply (double a, double b) {
        return a * b;
    }

    /*
     * COMPILE-TIME (within a class) polymorphism (see above) allows us to use many methods with THE SAME NAME but DIFFERENT SIGNATURES and return types.

     *   RUN-TIME  (between two or more classes) polymorphism allows us to use many methods with THE SAME NAME but DIFFERENT SIGNATURES and return types.
     *              Method 'Overriding' can be used to demonstrate run-time polymorphism (see below).
         
     */

    void run () {
        System.out.println("riding a bike");
    }
}

class Wheels extends Bike {

    @Override                       //  -> example of Run-time polymorphism (affiliated with the 'Overriding');
    void run() {
        System.out.println("spinning wheels");
        super.run();
    }
}
public class Polymorphism_types extends Wheels {

    public static void main(String[] args) {

//       Compile-time polymorphism (printout):   They only have the different signatures (type of variables);
        System.out.println(Bike.multiply(2, 2));
        System.out.println(Bike.multiply(2.0, 3.0));


//       Run-time polymorphism (printout);
        Bike bike1 = new Polymorphism_types(); // -> Run-time polymorphism; Use of the name of the subclass for creating a new object;
        bike1.run(); // the outcome: spinning wheels, riding a bike;

        Wheels wheels1 = new Polymorphism_types();
        wheels1.run(); // gives the same outcome: spinning wheels, riding a bike;

        Bike bike2 = new Wheels();
        bike2.run(); // also gives the same outcome;

        Wheels wheels2 = new Wheels(); // the same outcome;
        wheels2.run();

        Bike bike3 = new Bike(); // NOTE: this time, it prints out the ONLY: riding a bike;
        bike3.run();

    }
}
