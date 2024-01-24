import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import optimize.Rgb;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
    BufferedImage originalImage = ImageIO.read(new File(Rgb.SOURCE_FILE));
    BufferedImage resultImage =
        new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

    Rgb.recolorSingleThread(originalImage, resultImage);

    File outputFile = new File(Rgb.DESTINATION_FILE);
    ImageIO.write(resultImage, "jpg", outputFile);

  }

}