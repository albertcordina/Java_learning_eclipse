package nio_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferManipulationChallengeExercise {
	
    public static void main(String[] args) {
    	
        try {
            FileInputStream inputStream = new FileInputStream("//home//dci-student//Desktop//NIOFiles//student_records.csv"); // 1. link to the file; 
            FileOutputStream outputStream = new FileOutputStream("//home//dci-student//Desktop//NIOFiles//student_recordsnew.csv");
            
            FileChannel inputChannel = inputStream.getChannel(); // 2. create the channel to the link;
            FileChannel outputChannel = outputStream.getChannel();
            
            ByteBuffer buffer = ByteBuffer.allocate(1024); // 3. create Buffer and allocate the capacity;
            
            while (inputChannel.read(buffer) != -1) { buffer.flip(); // 4. Switch to read mode and flip;
            
                // Perform custom transformation (XOR encryption in this example)
                byte xorKey = 0x0F;
                
                   while (buffer.hasRemaining()) {
                    byte originalByte = buffer.get();
                    byte encryptedByte = (byte) (originalByte ^ xorKey);
                    buffer.put(encryptedByte);
                }
                buffer.flip(); // Switch to read mode
                outputChannel.write(buffer);
                buffer.clear(); // Switch to write mode
            }
            inputChannel.close();
            outputChannel.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) { e.printStackTrace();}
    }
}
