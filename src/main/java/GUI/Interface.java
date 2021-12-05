package GUI;

import Actions.ButtonActions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


// отрисовка интерфейса программы, ожидание действий с кнопками
public class Interface {

    private JFrame frame = new JFrame("Title");

    // элементы и дейсвтия
    private JButton button1 = new JButton(new AbstractAction("Добавить") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ButtonActions.button1Action(textArea.getText());
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });

    private JButton button2 = new JButton(new AbstractAction("Запустить") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ButtonActions.button2Action();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });

    private JTextArea textArea = new JTextArea();

    public Interface() {
        // Настройки окна
        frame.setDefaultCloseOperation(3);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);

        // Добавление элементов
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.getContentPane().add(BorderLayout.EAST, button1);
        frame.getContentPane().add(BorderLayout.SOUTH, button2);


        frame.setVisible(true);
    }
}
