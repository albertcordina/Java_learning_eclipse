package exceptions;

public class Exceptions_NestedTryBlock {

	public static void main(String[] args) {
//-----------------------------------------  NESTED TRY BLOCK -----------------------------------------------------------------                                        
		// outer try block
		try {
			try {
				int a = 68 / 0;
			} // first inner try block
			catch (NullPointerException e) {
				System.out.println(e);
			} // catch block of the first inner try block

			try {
				int b[] = new int[10]; // second inner try block
				b[11] = 10;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			} // catch block of the second inner try block
		}

		catch (Exception e) {
			System.out.println("Super type Exception in outer catch block");
		} // catch block of outer try block
		// As a result, the system accepts the above two unaccepted actions; with '68/0'
		// and 'b[11]',
		// (when there are only 10 elements in the Array), and will continue run the
		// code;
	}
}
