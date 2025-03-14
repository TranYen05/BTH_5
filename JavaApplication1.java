package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaApplication1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cộng Hai Số");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));
        
        JLabel label1 = new JLabel("Nhập số thứ nhất: ");
        JTextField text1 = new JTextField();
        JLabel label2 = new JLabel("Nhập số thứ hai: ");
        JTextField text2 = new JTextField();
        JButton button = new JButton("Tính tổng");
        JLabel resultLabel = new JLabel("Tổng: ");
        JLabel result = new JLabel();
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(text1.getText());
                    double num2 = Double.parseDouble(text2.getText());
                    double sum = num1 + num2;
                    result.setText(String.valueOf(sum));
                } catch (NumberFormatException ex) {
                    result.setText("Lỗi nhập liệu!");
                }
            }
        });
        
        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);
        frame.add(button);
        frame.add(resultLabel);
        frame.add(result);
        
        frame.setVisible(true);
    }
}

