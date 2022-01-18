package Actions;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class ImageActions {
    private static File theDir = new File("D:\\java\\MUIVProject\\src\\main\\resources\\pictures");

    public ImageActions() {
        System.out.println("Создаю папку");
        theDir.mkdir();
    }

    // Поиск фотографии по src и сохранение в папку resources
    public void download(String src, int index) throws IOException {
        RenderedImage image = ImageIO.read(new URL(src));
        File outPutImageFile = new File("D:\\java\\MUIVProject\\src\\main\\resources\\pictures\\Picture" + index + ".jpg");
        ImageIO.write(image, "JPG", outPutImageFile);
    }

    // Удаление файлов из директории и самой директории
    public static void deleteFolder() throws IOException {
        if (theDir.exists()) {
            System.out.println("Удаляю папку");
            Files.walk(theDir.toPath())
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
            theDir.delete();
        }
    }

}
