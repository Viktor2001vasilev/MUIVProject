package Actions;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

public class ButtonActions {

    public static void button1Action() {
        System.out.println("Выполнение действия кнопки 1");
        User32.INSTANCE.SystemParametersInfo(0x0014, 0, "D:\\java\\MUIVProject\\src\\main\\resources\\Picture.jpg", 1);
    }
    public static interface User32 extends Library {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
        boolean SystemParametersInfo(int one, int two, String s, int three);
    }
}
