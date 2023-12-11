package interface_rules;
/*
 * In Java, an interface is a way to achieve abstraction, 
 * allowing you to define a contract for classes to implement. 
 * An interface declares a set of abstract methods, and any class 
 * that implements the interface must provide concrete implementations for those methods.
 * 
 * Like between Classes, between Interfaces can only be 'extended' one to another.
 * Classes can implement many Interfaces, but Interfaces can't implement anything.
 * 
 * Let's go through a simple example to illustrate the use of interfaces:
 * 
 * In this example, the Animal interface declares a single abstract method makeSound(). 
 * The Dog and Cat classes implement the Animal interface by providing concrete 
 * implementations for the makeSound() method. The AnimalTest class demonstrates 
 * how you can use these classes through the common interface, 
 * calling the makeSound() method on both a Dog and a Cat.
 * 
 */

//Define an interface named Animal
interface Animal {
 void makeSound(); // Abstract method declaration
}

//Implement the Animal interface in a class named Dog
class Dog implements Animal {
 @Override
 public void makeSound() {
     System.out.println("Woof! Woof!");
 }

 public void fetch() {
     System.out.println("Fetching the ball!");
 }
}

//Implement the Animal interface in a class named Cat
class Cat implements Animal {
 @Override
 public void makeSound() {
     System.out.println("Meow!");
 }

 public void climb() {
     System.out.println("Climbing the tree!");
  }
}

//Main class to test the implementations
public class Interface_AnimalTest {
	
 public static void main(String[] args) {
	 
     // Create instances of Dog and Cat
     Dog myDog = new Dog();
     Cat myCat = new Cat();

     // Call makeSound() method on Dog and Cat
     myDog.makeSound(); // Output: Woof! Woof!
     myCat.makeSound(); // Output: Meow!

     /*
      * Uncommenting the lines below will result in a compilation error because 
      *   the fetch() method is not part of the Animal interface.
      *                myDog.fetch();
      *                myCat.climb();
      */
  }
}

