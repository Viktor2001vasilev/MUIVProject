package GUI;

import Actions.ButtonActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


// отрисовка интерфейса программы, ожидание действий с кнопками
public class Interface {

    private JFrame frame = new JFrame("Title");

    // элементы и дейсвтия
    private JButton button1 = new JButton(new AbstractAction("Установить") {
        @Override
        public void actionPerformed(ActionEvent e) {
            ButtonActions.button1Action();
        }
    });

    public Interface() {
        // Настройки окна
        frame.setDefaultCloseOperation(3);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);

        // Добавление элементов
        frame.getContentPane().add(BorderLayout.CENTER, button1);

        frame.setVisible(true);
    }
}
