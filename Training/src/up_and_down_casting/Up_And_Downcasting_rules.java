package up_and_down_casting;

class ParentClass {
    int ai = 1;

    public void a() { System.out.println("Parent a");} // 'a' and 'b' are the OVERRIDDEN methods in the Parent and Child classes.
    public void b() { System.out.println("Parent b");}

    public void g() { System.out.println("Parent-SINGLE-g");}
}
//---------------------------------------------------------------------------
class ChildClass extends ParentClass {

    int bi = 2;

    public void a() { System.out.println("Child a");} // 'a' and 'b' are the OVERRIDDEN methods in the Parent and Child classes.
    public void b() { System.out.println("Child b");}

    public void c() { System.out.println("Child-single-c");}
}
//---------------------------------------------------------------------------------------------------------------------
public class Up_And_Downcasting_rules {

    public static void main(String[] args) {

//         -  Up and Down Casting is used to level up a child class to its parent class  -
//
//         Up - Casting gives us the convenience to use only one 'keyword' to access
//             the same named method(s) of the child class and also all other methods of its parent class;
//                NOTE: It excludes of use all the same named method(s) of the parent class!

        System.out.println("\nWith 'up-casting':");
        ParentClass a1 = new ChildClass();
        a1.a();
        a1.b();
        a1.g();  // <- another method of the parent class;
        System.out.println(a1.ai); // and only the variables of the parent class can be accessed;
        //      System.out.println(a1.bi);


//         Down - Casting is addition to Up - Casting, and it gives us also the additional access to
//                                                     all other method(s) of the child class;
        System.out.println("\nWith 'down-casting':");
        ChildClass b1 = (ChildClass) a1;
        b1.a();
        b1.b();
        b1.g();
        b1.c();          // <- another method of the child class;
        System.out.println(b1.ai); // and use the variables of
        System.out.println(b1.bi); // parent and child classes;
    }
}
