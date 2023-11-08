package lambda_expressions;

//Java program to demonstrate working of predicates 
//on collection. The program finds all admins in an 
//arrayList of users. 
import java.util.function.Predicate;
import java.util.*;

class PredColl {
	
	String name, role;

	PredColl (String a, String b) {
		name = a;
		role = b; }

	String getRole() { return role;}
	String getName() { return name;}

	public String toString() { return "User Name : " + name + ", Role :" + role;}

	public static void main(String args[]) {
		
		List <PredColl> users = new ArrayList <PredColl> ();
		
		users.add(new PredColl("John", "admin"));
		users.add(new PredColl("Peter", "member"));
		
		List admins = process(users, (PredColl u) -> u.getRole().equals("admin"));
		System.out.println(admins);
	}

	public static List <PredColl> process (List<PredColl> users, Predicate<PredColl> predicate) {
		
		List<PredColl> result = new ArrayList<PredColl>();
		
		for (PredColl user : users)
			if (predicate.test(user))
				result.add(user);
		return result;
	}
}
