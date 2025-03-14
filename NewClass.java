package javaapplication1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Giải Phương Trình Bậc Nhất");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(4, 2));
        
        JLabel label1 = new JLabel("Nhập hệ số a: ");
        JTextField text1 = new JTextField();
        JLabel label2 = new JLabel("Nhập hệ số b: ");
        JTextField text2 = new JTextField();
        JButton button = new JButton("Giải phương trình");
        JLabel resultLabel = new JLabel("Nghiệm: ");
        JLabel result = new JLabel();
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(text1.getText());
                    double b = Double.parseDouble(text2.getText());
                    
                    if (a == 0) {
                        if (b == 0) {
                            result.setText("Vô số nghiệm");
                        } else {
                            result.setText("Vô nghiệm");
                        }
                    } else {
                        double x = -b / a;
                        result.setText(String.valueOf(x));
                    }
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
