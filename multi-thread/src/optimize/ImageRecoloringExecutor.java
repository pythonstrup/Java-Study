package optimize;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageRecoloringExecutor {

  // 400ms~450ms 정도의 시간 소요
  public static void singleThread() throws IOException {
    BufferedImage originalImage = ImageIO.read(new File(ImageRecoloring.SOURCE_FILE));
    BufferedImage resultImage =
        new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

    long startTime = System.currentTimeMillis();
    ImageRecoloring.recolorSingleThreaded(originalImage, resultImage);
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;

    File outputFile = new File(ImageRecoloring.DESTINATION_FILE);
    ImageIO.write(resultImage, "jpg", outputFile);

    System.out.println("singleThread: " + duration);
  }

  public static void multiThread() throws IOException {
    BufferedImage originalImage = ImageIO.read(new File(ImageRecoloring.SOURCE_FILE));
    BufferedImage resultImage =
        new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

    long startTime = System.currentTimeMillis();
//    ImageRecoloring.recolorMultiThreaded(originalImage, resultImage, 1); // 400ms~500ms
//    ImageRecoloring.recolorMultiThreaded(originalImage, resultImage, 2); // 320ms~340ms
//    ImageRecoloring.recolorMultiThreaded(originalImage, resultImage, 4); // 340ms~370ms
//    ImageRecoloring.recolorMultiThreaded(originalImage, resultImage, 6); // 400ms
    ImageRecoloring.recolorMultiThreaded(originalImage, resultImage, 8); // 400ms
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;

    File outputFile = new File(ImageRecoloring.DESTINATION_FILE);
    ImageIO.write(resultImage, "jpg", outputFile);
    System.out.println("multiThread: " + duration);
  }
}
