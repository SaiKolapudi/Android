import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class ImageToByteArray {
   public static void main(String args[]) throws Exception{
      BufferedImage bImage = ImageIO.read(new File("sample.jpg"));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(bImage, "jpg", bos );
      byte [] data = bos.toByteArray();
	  System.out.println("Original Message length : "
						+ data.length);
   }
}