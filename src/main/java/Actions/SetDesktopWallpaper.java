package Actions;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;


public class SetDesktopWallpaper {

    private interface User32 extends Library {
        SetDesktopWallpaper.User32 INSTANCE = (SetDesktopWallpaper.User32) Native.loadLibrary("user32", SetDesktopWallpaper.User32.class, W32APIOptions.DEFAULT_OPTIONS);
        boolean SystemParametersInfo(int one, int two, String s, int three);
    }

    public static void setWallpaper(int photoId) {
        System.out.println("Установка обоев...");
        SetDesktopWallpaper.User32.INSTANCE.SystemParametersInfo(0x0014, 0, "D:\\java\\MUIVProject\\src\\main\\resources\\pictures\\Picture" + photoId + ".jpg", 1);
        System.out.println("Обои установлены.");
    }
}
