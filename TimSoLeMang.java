package pj5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TimSoLeMang extends JFrame {
    private JTextField txtInput, txtResult;
    private JButton btnFindOdd;

    public TimSoLeMang() {
        setTitle("Tìm Số Lẻ Trong Mảng");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        txtInput = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);
        btnFindOdd = new JButton("Tìm Số Lẻ");

        btnFindOdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] input = txtInput.getText().split(",");
                    int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                    String oddNumbers = Arrays.stream(numbers)
                                             .filter(n -> n % 2 != 0)
                                             .mapToObj(String::valueOf)
                                             .collect(Collectors.joining(", "));
                    txtResult.setText("Số lẻ: " + (oddNumbers.isEmpty() ? "Không có số lẻ" : oddNumbers));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số, cách nhau bởi dấu phẩy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(new JLabel("Nhập mảng (các số cách nhau bởi dấu phẩy):"));
        add(txtInput);
        add(btnFindOdd);
        add(txtResult);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TimSoLeMang();
    }
}
