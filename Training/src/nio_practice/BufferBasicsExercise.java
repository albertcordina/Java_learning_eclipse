package nio_practice;

import java.nio.ByteBuffer;

public class BufferBasicsExercise {

	public static void main(String[] args) {

//------------------------------------  PLACING TEXT TO A BUFFER AND READING IT -----------------------------------------------
		
		ByteBuffer buffer = ByteBuffer.allocate(1024); // create a Buffer and allocate the capacity in 'bytes'; 
		String text = "i like thriller movies";    // create a String with the text;
		buffer.put(text.getBytes());  // 'getBytes' converts the text of the String into bytes and 'put' puts it into the Buffer;
		
		buffer.flip(); // The method 'flip' sets the Buffer from 'write' to 'read' mode; 
		
		while (buffer.hasRemaining()) {System.out.print((char) buffer.get());}  // print out the readable content of the Buffer;
		
	}
}
