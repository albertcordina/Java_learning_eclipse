package fileoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class FileInOutPutStream_rules {

	/*
	 * I/O Streams java.io package Java streams are composed of bytes.
	 * FileOutputStream extends OutputStream FileInputStream extends InputStream The
	 * read() method returns -1 at the end of its execution.
	 */

	public static void main(String[] args) throws Exception { // <--- important: for merging the files (see below) use to 'throws Exception';

		try {
			FileOutputStream file = new FileOutputStream("//home//dci-student//Desktop//test.txt");
			file.write(120); // writes the letter 'x' into the file;
			file.write(65); // writes the letter 'A' into the file;
			// we do not use this method due to the complexity (no possibility to know all
			// the numbers of bytes corresponding to the letters);
			file.close(); // <-- we need to always close the method 'write' in order to avoid any errors further;
			
			System.out.println("Success!");
		   } catch (Exception e) { System.out.println(e);}
		

		try {
			FileOutputStream file = new FileOutputStream("//home//dci-student//Desktop//test.txt");
			String text = "Java Course e01";
			byte b[] = text.getBytes(); // converting the String text into the b Array;
			file.write(b); // writes the whole text;
			file.close();
			
			System.out.println("Success!");
		   } catch (Exception e) { System.out.println(e);}
//-------------------------------------------

		try {
			FileInputStream file = new FileInputStream("//home//dci-student//Desktop//test.txt");
			int b = file.read(); // reads the first letter/character of the text in the file 'J' (not commonly used);
			
			System.out.println((char) b);
			file.close();
		   } catch (Exception e) { System.out.println(e);}

		try {
			FileInputStream file = new FileInputStream("//home//dci-student//Desktop//test.txt");
			int n = 0;
			while ((n = file.read()) != -1) { System.out.println(n);} // prints out the all letters of the text as the numbers;
			
			file.close();
		   } catch (Exception e) { System.out.println(e);}
//-------------------------------------- FILE INPUT STREAM (READ THE FILE) ---------------------------------------------------

		FileInputStream file1 = new FileInputStream("//home//dci-student//Desktop//test1.txt");
		FileInputStream file2 = new FileInputStream("//home//dci-student//Desktop//test2.txt");
		FileOutputStream fileOutput = new FileOutputStream("//home//dci-student//Desktop//test3.txt");

		SequenceInputStream sis = new SequenceInputStream(file1, file2); // merging the two files into one;
		int n = 0;

		while ((n = sis.read()) != -1) { System.out.print((char) n);}
		sis.close();
		file1.close();
		file2.close();
	}
}
