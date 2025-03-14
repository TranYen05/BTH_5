package pj5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TimSoChanMang extends JFrame {
    private JTextField txtInput, txtResult;
    private JButton btnFindEven;

    public TimSoChanMang() {
        setTitle("Tìm Số Chẵn Trong Mảng");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        txtInput = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);
        btnFindEven = new JButton("Tìm Số Chẵn");

        btnFindEven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] input = txtInput.getText().split(",");
                    int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                    String evenNumbers = Arrays.stream(numbers)
                                             .filter(n -> n % 2 == 0)
                                             .mapToObj(String::valueOf)
                                             .collect(Collectors.joining(", "));
                    txtResult.setText("Số chẵn: " + (evenNumbers.isEmpty() ? "Không có số chẵn" : evenNumbers));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số, cách nhau bởi dấu phẩy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(new JLabel("Nhập mảng (các số cách nhau bởi dấu phẩy):"));
        add(txtInput);
        add(btnFindEven);
        add(txtResult);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TimSoChanMang();
    }
}
