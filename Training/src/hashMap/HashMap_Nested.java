package hashMap;
import java.util.*;
public class HashMap_Nested {

	public static void main(String[] args) {

		UndergraduateStudent nonGrad = new UndergraduateStudent();
		GraduateStudent grad = new GraduateStudent();
		
		nonGrad.setName("John");
		nonGrad.setStudentID(25);
		nonGrad.setYear(2002);
		
		grad.setName("Marta");
		grad.setStudentID(30);
		grad.setResearchTopic("Life");
			
		//Map<Integer, String> data = new HashMap<> ();		
		//data.put(nonGrad.getStudentID(), nonGrad.getName()); // -> an ordinary HashMap;
		//                                                                                          THE NESTED HASH MAP:
		Map<Integer, HashMap <String, Integer>> dataNonGrad = new HashMap<> ();  
		dataNonGrad.put(nonGrad.getStudentID(), new HashMap() {{ put (nonGrad.getName() , nonGrad.getYear());}});  // -> the student's ID is the 'key';
		
		Map<Integer, HashMap <String, String>> dataGrad = new HashMap<> ();  
		dataGrad.put(grad.getStudentID(), new HashMap() {{ put (grad.getName() , grad.getResearchTopic());}});     // -> the student's ID is the 'key';
		
		System.out.println(dataNonGrad);
		System.out.println(dataGrad);
	}
}

class Students {

	String name;
	int studentID;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getStudentID() {
		return studentID;
	}
}

class UndergraduateStudent extends Students {
	
	int year;
	
	public void setYear (int year) {
		this.year = year;
	}
	public int getYear () {
		return year;
	}
}

class GraduateStudent extends Students {
	
	String researchTopic;

	public void setResearchTopic (String researchTopic) {
		this.researchTopic = researchTopic;
	}
	public String getResearchTopic () {
		return researchTopic;
	}
}
