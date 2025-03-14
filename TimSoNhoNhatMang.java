package pj5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TimSoNhoNhatMang extends JFrame {
    private JTextField txtInput, txtResult;
    private JButton btnFindMin;

    public TimSoNhoNhatMang() {
        setTitle("Tìm Số Nhỏ Nhất Trong Mảng");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        txtInput = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);
        btnFindMin = new JButton("Tìm Số Nhỏ Nhất");

        btnFindMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] input = txtInput.getText().split(",");
                    int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                    int min = Arrays.stream(numbers).min().orElseThrow();
                    txtResult.setText("Số nhỏ nhất: " + min);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số, cách nhau bởi dấu phẩy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(new JLabel("Nhập mảng (các số cách nhau bởi dấu phẩy):"));
        add(txtInput);
        add(btnFindMin);
        add(txtResult);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TimSoNhoNhatMang();
    }
}
