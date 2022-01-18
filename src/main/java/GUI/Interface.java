package GUI;

import Actions.ButtonActions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


// отрисовка интерфейса программы, ожидание действий с кнопками
public class Interface extends Thread{

    @Override
    public void run() {
        // Настройки окна
        frame.setDefaultCloseOperation(3);
        frame.setPreferredSize(new Dimension(500, 280));
        frame.setMinimumSize(new Dimension(500, 280));
        frame.setLocationRelativeTo(null);

        // Добавление элементов
        jpanel.setLayout(new FlowLayout());
        jpanel2.setLayout(new FlowLayout());
        jpanel.add(textArea);
        jpanel.add(button3);
        jpanel2.add(new JScrollPane(textArea2));
        jpanel3.add(button1);
        jpanel3.add(button2);
        jpanel3.add(button4);
        frame.getContentPane().add(BorderLayout.NORTH, jpanel);
        frame.getContentPane().add(BorderLayout.CENTER, jpanel2);
        frame.getContentPane().add(BorderLayout.SOUTH, jpanel3);

        frame.setVisible(true);
    }

    private JFrame frame = new JFrame("AutoScreenChanger");
    private JPanel jpanel = new JPanel();
    private JPanel jpanel2 = new JPanel();
    private JPanel jpanel3 = new JPanel();

    // элементы и дейсвтия
    private JButton button1 = new JButton(new AbstractAction("Добавить") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ButtonActions.button1Action(textArea2.getText());
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
            } catch (IOException | InterruptedException ioException) {
                ioException.printStackTrace();
            }
        }
    });

    private JButton button3 = new JButton(new AbstractAction("Задать интервал") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ButtonActions.button3Action(textArea.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });

    private JButton button4 = new JButton(new AbstractAction("Стоп") {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ButtonActions.button4Action();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    });

    private JTextArea textArea = new JTextArea("Интервал в минутах (целое число)", 1, 20);

    private JTextArea textArea2 = new JTextArea("Теги (через запятую и пробел)", 8, 30);
}
