import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Images {
    // Поиск фотографии по src и сохранение в папку resourses
    public Images() throws IOException {
        RenderedImage image = ImageIO.read(new URL("https://im0-tub-ru.yandex.net/i?id=8800fa2928e6a8f4bd2f36f3bea18e34-l&n=13"));
        File outPutImageFile = new File("D:\\java\\MUIVProject\\src\\main\\resources\\Picture2.jpg");
        ImageIO.write(image, "JPG", outPutImageFile);
    }
}
