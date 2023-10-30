package hashMap;
import java.util.*;
public class TreeMap_exercise {

	public static void main(String[] args) {
		
		Map<Integer, Student> students = new TreeMap<>(); // enter the constructor 'Student' to the 'TreeMap' as a value;
		
		students.put(56, new Student (107, "Joe"));
		students.put(72, new Student (102, "Diana"));
		students.put(4, new Student (103, "Elton"));

		System.out.println(students); // the print out is: {4=Student [id=103, name=Elton], 56=Student [id=107, name=Joe], 72=Student [id=102, name=Diana]};
		
		/*Student printOut = new Student();
		printOut.compareTo(o); */

	}

}
class Student {
	
	Integer id;
	String name;
	
	public Student (Integer id, String name) { // we create constructor to implement the two paramertes in the 'TreeMap' above;
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	public int compareTo (Student o) {
	//	return ((Integer)id).compareTo(o.id);  //  -> in 'numerical' or 'alphabetical' order;
		return ((Integer)o.id).compareTo(this.id); // -> the reverce option;
	}
}