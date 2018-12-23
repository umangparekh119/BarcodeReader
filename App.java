import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.google.zxing.Reader;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.FileOutputStream;
import java.io.File;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.DecodeHintType;
import java.util.*;
import com.google.zxing.oned.Code128Writer;

/**
 * Hello world!
 *
 */
class App {
 public static void main(String[] args) throws Exception {
  System.out.println("Barcode Generator");

  
  try {
   String text = "98376373783-abc"; // this is the text that we want to encode

   int width = 400;
   int height = 300; // change the height and width as per your requirement

   String imageFormat = "png"; // could be "gif", "tiff", "jpeg" 

   BitMatrix bitMatrix = new Code128Writer().encode(text, BarcodeFormat.CODE_128, width, height);
   MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, new FileOutputStream(new File("qrcode_97802017507991.png")));
   
   System.out.println("Barcode Generated");
  } catch (Exception e) {
   System.out.println(e);
  }



  try {
   InputStream barCodeInputStream = new FileInputStream("qrcode_97802017507991.png");
   BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

   LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
   BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
   Reader reader = new MultiFormatReader();
   System.out.println("testing");

   Result result = reader.decode(bitmap);
   System.out.println("Barcode text is " + result.getText());

  } catch (Exception e) {
   e.printStackTrace();
  }



 }
}