package abstract_class;

class Motorcycle {
    final int SPEEDLIMIT = 90; // -> the name of the 'final' variable should have the capital letters;
                              //   NOTE: all the modifies (i.e. the public, private, e.t.c. can also be used in combination the 'final' key word);

    void run () {
//		SPEEDLIMIT = 200;      // -> it won't work;
    }

    final void drive () {      // -> the 'final' method can not be changed for its override methods;              
        System.out.println("driving ... ");
    }
}

public class Final_keyword {

    public static void main(String[] args) {

        /*
         * We can use the final keyword in:
         *
         * 1. variables -> it prevents the value from changing.
         * 2. methods -> it prevents changing the overriden methods.
         * 3. classes -> it does not allow inheritance.
         *
         * NOTE: constructors do not and can not use the 'final' keyword,
         *       because, constructor has already final values;
         *
         */
    }
}
