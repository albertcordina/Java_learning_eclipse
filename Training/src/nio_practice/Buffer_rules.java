package nio_practice;

import java.io.*;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.*;

public class Buffer_rules { 
	/*
	 * The Java Buffer is USED to hold the sequence of INTEGER values that can be used for input/output operations: 
	 *  https://www.baeldung.com/java-bytebuffer
	 *  https://www.youtube.com/watch?v=zeHiINPExns
	 *  ----------------------------------------------------------------------------------------
	 *  
	 *  Channels always read from or write to a Buffer;
	 *  The channels are: 
	 *  
	 *     FileChannel     <--- data comes from or to a file;
	 *     DatagramChannel <--- UDP connection;
	 *     SocketChannel   <--- sending or reciving data via a socket to or from the server;
	 *     ServerSocketChannel <--- when a server is using Java NIO;
	 *     
	 * First, we create a channel and then we read the channel via Buffer;
	 * 
	 * 1. Allocate Buffer;
	 * 2. Write data to the Buffer from a channel;
	 * 3. Flip the Buffer;
	 * 4. Read the data from the Buffer;
	 * ------------------------------------------------------------------------------------------
	 * Buffer stores the data to be read by a channel or to store the data that comes from a channel;
	 * Buffer has POSITION, LIMIT, CAPACITY; 
	 * Types of the Buffers (in JDK):
	 * 
	 *     ByteBuffer;
	 *     CharBuffer;
	 *     DoubleBuffer;
	 *     FloatBuffer;
	 *     IntBuffer;
	 *     LongBuffer;
	 *     ShortBuffer;
	 * -------------------------------------------------------------------------------------------
	 * The method 'flip' prepares the Buffer from write to read mode;   
	 *    
	 * ------------------------------------------------------------------------------------------- 
	 * The ByteBuffer class has two allocation methods:
	 *     the 'allocate' method is a non-direct buffer – that is, a buffer instance with an underlying byte array;
	 *     the 'allocateDirect' method generates a direct buffer;
	 * -------------------------------------------------------------------------------------------    
	 * The method 'wrap' allows an instance to reuse an existing byte array;  
	 * 
	 * --------------------------------------------------------------------------------------------  
	 *  Scattering and Gathering:
	 *     
	 *     write data from a channel to a Buffer array;
	 *     write data from Buffer array to channel;
	 * --------------------------------------------------------------------------------------------    
	 *  Transfer from Channel to Channel:
	 *  
	 *     transfer data directly between channels;
	 *     there is no need to code Buffer hanling if we just read from one and write to the other;
	 *----------------------------------------------------------------------------------------------     
	 *  Selectors are effective when the application has to handle many low volume connections:
	 *    
	 *     register a channel to a selctor;
	 *     call selec() to wait an event on any of the channels registered; 
	 */

	public static void main(String[] args) {
		
//----------------------------------------  PLACING TEXT TO A BUFFER AND READING IT -----------------------------------------------
		
				ByteBuffer buffer1 = ByteBuffer.allocate(1024); // create a Buffer and allocate the capacity in 'bytes'; 
				String text = "i like thriller movies";    // create a String with the text;
				buffer1.put(text.getBytes());  // 'getBytes' converts the text of the String into bytes and 'put' puts it into the Buffer;
				
				buffer1.flip(); // The method 'flip' sets the Buffer from 'write' to 'read' mode; 
				
				while (buffer1.hasRemaining()) {System.out.print((char) buffer1.get());}  // print out the readable content of the Buffer;
				
	
//-------------------------------------- PLACING TEXT FROM FILE TO BUFFER AND READING IT --------------------------------------------------------------	
		

		try {
			FileInputStream file = new FileInputStream ("//home//dci-student//Desktop//NIOFiles//example.txt"); // we create the link 'file' to the file;
			FileChannel channel = file.getChannel();                      // we create the object 'channel' and get the 'file' into it;
			
			ByteBuffer buffer = ByteBuffer.allocate (1024);           //  we create the object 'buffer' with the capacity; 
			
			int bytesRead = channel.read(buffer);                 // 'buffer' reads the content of the 'channel'(file) and places it into int 'bytesRead';
		   
		    while (bytesRead != -1) {buffer.flip();            // 'flip' switchs 'buffer' to read mode;
		            while (buffer.hasRemaining()) { System.out.print((char) buffer.get());} // printing out the content of the 'buffer';
		             
		    buffer.clear(); // switch to write mode;
		    bytesRead = channel.read(buffer); 
		    } 
		    
		    file.close();
		    System.out.println("completed");
		} 
		
		catch (FileNotFoundException e) { throw new RuntimeException (e);} // throw Exceptions;
	    catch(IOException e) { throw new RuntimeException(e);}	    
	}
}
