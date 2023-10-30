package fileoutputstream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileOutput_Writer {

	public static void writeNamesToFile(String [] names, String fileName) throws IOException {
		
		FileOutputStream fileOutputStream = null; 
		
	    try {
		   fileOutputStream = new FileOutputStream ("//home//dci-student//Desktop//NIOFiles//names.txt"); // link the output file;
		
		for (String name : names) {  // iterate the whole Array for the names;
				
				byte [] nameBytes = (name + "\n").getBytes(); // converting the String text into the bytes;
				fileOutputStream.write(nameBytes); }         // writes the whole Array list below into the file as a text;
	    } 
	  finally {if (fileOutputStream != null) {fileOutputStream.close();} // close the method 'write' if the writing has been done;
	}
}

	public static void main(String[] args) {
		
		String [] names = {"Nicole ", "Casie ", "Charlie ", "David ", "Raven "}; // create an Array list;	
		String fileName = "names.txt";  // create a 'String' with the name of the file as a text;
		
		 try {
			writeNamesToFile(names, fileName); // call the method above;
		    System.out.println("Names have been successfully written to " + fileName);}                         //  report: a successful written info;
		 catch (IOException e) {System.err.println("An error occurred while writing to the file: " + e.getMessage()); // if not successful written info;
		}
	}
}
