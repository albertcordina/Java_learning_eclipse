package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamFromFile {
	
	public static void main(String[] args) throws IOException {
		
	// reading the file (example: a file of the same project)	
	Files.lines(Paths.get("text.txt")).forEach(System.out :: println);	
		
	}
}
