// Java Program to Usage of GZIPInputStream
// via Showcasing Reading Data

// Importing required classes
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Main class
// GZIPInputStreamDemo
public class GFG {

	// Main driver method
	public static void main(String[] args)
		throws DataFormatException, IOException
	{
		// Custom input string
		String message = "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;"
						+ "Welcome to Geeksforgeeks;";

		// Print and display the message
		System.out.println("Original Message length : "
						+ message.length());
	
		byte[] input = message.getBytes("UTF-8");

		// Compress the bytes
		ByteArrayOutputStream arrayOutputStream
			= new ByteArrayOutputStream();
		GZIPOutputStream outputStream
			= new GZIPOutputStream(arrayOutputStream);
		outputStream.write(input);
		outputStream.close();

		// Read and decompress the data
		byte[] readBuffer = new byte[5000];
		ByteArrayInputStream arrayInputStream
			= new ByteArrayInputStream(
				arrayOutputStream.toByteArray());
		GZIPInputStream inputStream
			= new GZIPInputStream(arrayInputStream);
		int read = inputStream.read(readBuffer, 0,
									readBuffer.length);
		inputStream.close();
		// Should hold the original (reconstructed) data
		byte[] result = Arrays.copyOf(readBuffer, read);

		// Decode the bytes into a String
		message = new String(result, "UTF-8");

		System.out.println("UnCompressed Message length : "
						+ message.length());
	}
}
