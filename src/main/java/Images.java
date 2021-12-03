import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Images {
    public Images() throws IOException {
        RenderedImage image = null;
        image = ImageIO.read(new URL("https://im0-tub-ru.yandex.net/i?id=8800fa2928e6a8f4bd2f36f3bea18e34-l&n=13"));
        System.out.println("///");
        File outPutImageFile = new File("D:\\java\\MUIVProject\\src\\main\\resources\\Picture2.jpg");
        System.out.println("///");
        ImageIO.write(image, "JPG", outPutImageFile);
        System.out.println("finish");
    }
}
