package jdbc;

public class JdbcDemo {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
