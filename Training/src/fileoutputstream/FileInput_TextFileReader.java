package fileoutputstream;
import java.io.*;
public class FileInput_TextFileReader {
  
	public static void readAndDisplayFile(String fileName) throws IOException {
		
       FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("//home//dci-student//Desktop//student_records.csv"); // new object to link to the file;
        int currentByte;
        while ((currentByte = fileInputStream.read()) != -1) { System.out.print((char) currentByte);} // iterate and read the whole file;
        } 
    finally {
         if (fileInputStream != null) { fileInputStream.close();} // close the method 'read';
    }
 }
    public static void main(String[] args) {
    	
       String fileName = "sample.txt";
       
     try {
          readAndDisplayFile(fileName);  // call the method obove;
          System.out.println("\nOperation was successful.");}  //  report a successfull reading;
     catch (IOException e) { System.err.println("An error occurred during the operation: " + e.getMessage());} // if Error;
    }
 }