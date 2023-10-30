package fileoutputstream;
import java.io.*;
public class FileOutput_CSVFileWriter {

	public static void writeStudentRecordsToFile(String [][] studentRecords, String fileName) throws IOException {
		
        FileOutputStream fileOutputStream = null;
        
        try {
            fileOutputStream = new FileOutputStream("//home//dci-student//Desktop//test.csv");
            for (String[] record : studentRecords) {                 // iterate the whole Array;
                String csvLine = String.join (",", record) + "\n";  // join the 'comma' and the next line '\n' to the new String 'csvLine';
                byte[] lineBytes = csvLine.getBytes();             // convert the whole updated text/list of the 'csvLine' to bytes 'lineBytes';
                fileOutputStream.write(lineBytes);}               // write the converted 'lineBytes' into the file;
            } 
        finally {
            if (fileOutputStream != null) {fileOutputStream.close();}
    }
}

	public static void main(String[] args) {

		String [][] studentRecords = {
                {"101", "Alice", "3.8"}, // the 3 different attributes (ID, Name, GPA);
                {"102", "Bob", "3.5"},
                {"103", "Charlie", "3.2"},
                {"104", "David", "3.9"},
                {"105", "Eve", "3.7"}
             };
        String fileName = "student_records.csv";
        
        try { 
        	writeStudentRecordsToFile(studentRecords, fileName); // call the method above;
            System.out.println("Student records have been successfully written to " + fileName);} // report the successfull writing into the file;
        catch (IOException e) { System.err.println("An error occurred while writing to the file: " + e.getMessage());} // if Error;
    }
}
 