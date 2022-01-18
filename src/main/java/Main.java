import Actions.ImageActions;
import GUI.Interface;

import java.io.File;
import java.io.IOException;

// запуск программы
public class Main {
    public static void main(String[] args) throws IOException {
        ImageActions.deleteFolder();
        Interface mainInterface = new Interface();
        mainInterface.run();
    }
}
