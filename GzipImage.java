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
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

// Main class
// GZIPInputStreamDemo
public class GzipImage {

	// Main driver method
	public static void main(String[] args)
		throws DataFormatException, IOException
	{
		BufferedImage bImage = ImageIO.read(new File("sample.jpg"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos );
		byte [] input = bos.toByteArray();

		// Print and display the message
		System.out.println("Original Message length : "
						+ input.length);
	

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
		byte [] result = bos.toByteArray();
		
		System.out.println("Original Message length : "
						+ result.length);
		ByteArrayInputStream inStreambj = new ByteArrayInputStream(result);
		
		BufferedImage newImage = ImageIO.read(inStreambj);
		ImageIO.write(newImage, "jpg", new File("sampleoutput.jpg"));

	}
}
