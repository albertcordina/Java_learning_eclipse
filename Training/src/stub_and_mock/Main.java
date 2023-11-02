package stub_and_mock;

/*
 * A stub interface simulates an actual object by using a few methods. 
 * In other words, a stub can be used as a dummy module to test
 *  an application while the actual module is being developed. 
 * Furthermore, the stub alleviates any issues that may arise during the 
 * implementation of the actual object.
 * 
 * A mock is an interface that we program to compare the outputs from the tests to the expected outcomes.    
 * A mock allows maintaining data configuration within the test. 
 * Additionally, a mock can also count how many times we call a method, function, etc.
 *  Or the sequence of calls to an object. 
 * Moreover, it checks the communications among classes. 
 * We can use the method mock() for mocking purposes.
 * 
 *     Features   |                 stub                 |                         mock
 *--------------------------------------------------------------------------------------------------------------  
 *     Usage      |     We use it if the test data       | We use it if the test data requirements in the suite are
 *                | requirements in the suite are simple.| complex also if all the data configurations happen within the tests.
 *    Scenario    |          
 *                
 *    Advantages  |    Free tools are available, along   | Open-source tools are available, along 
 *                | with plenty of resources online.     | with plenty of resources online.   
 *              
 *  Disadvantages |    Test cases couple tightly due     | Mostly used by developers and not by testers.            
 *                |     to the hard-coding of data.  
 *                  
 *
 * https://toolsqa.com/blogs/differences-between-stubbing-and-mocking/
 */

public class Main {

}
