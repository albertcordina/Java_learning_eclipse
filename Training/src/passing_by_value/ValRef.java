package passing_by_value;

public class ValRef {
 //                                                                                                             CALLED - BY - VALUE :
   int a = 10;                   // the original value of 'a' belongs to the class and not to a method;
   void call(int a) {            // (int a) of the 'call' method doesn't link to the 'main' method;
      a = a + 10;               // this local variable 'a' is subject to change in its value;
  
   }   
     
    public static void main(String[] args) {
 
        ValRef eg = new ValRef();  
        System.out.println("Before call-by-value: " + eg.a); // the value of 'a' is according to the original 'a';
         
        eg.call(50510);                                      // the value '50510' doesn't pass since the passing parameter is a primitive, 
        System.out.println("After call-by-value: " + eg.a);  // therefore, the value of 'a' will still remain unchanged in case of 'CALL-BY-VALUE'.
    }
}
 //                                                                                                             CALLED - BY - REFERENCE : 
 /*   int a = 10;               
      void call(ValRef eg) {  // (ValRef eg) links to the 'main' method;
        eg.a = eg.a + 10;   // the original value of 'a' will be changed as we are passing the objects by reference.
    }
     
    public static void main(String[] args) {
 
        ValRef eg = new ValRef();
        System.out.println("Before call-by-reference: " + eg.a);
          
        eg.call(eg);         // passing the object as a value using 'PASS-BY-REFERENCE';
        System.out.println("After call-by-reference: " + eg.a);
           
    }
}
	*/