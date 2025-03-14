package pj5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TimSoNguyenToMang extends JFrame {
    private JTextField txtInput, txtResult;
    private JButton btnFindPrime;

    public TimSoNguyenToMang() {
        setTitle("Tìm Số Nguyên Tố Trong Mảng");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        txtInput = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);
        btnFindPrime = new JButton("Tìm Số Nguyên Tố");

        btnFindPrime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] input = txtInput.getText().split(",");
                    int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                    String primeNumbers = Arrays.stream(numbers)
                                                .filter(TimSoNguyenToMang::isPrime)
                                                .mapToObj(String::valueOf)
                                                .collect(Collectors.joining(", "));
                    txtResult.setText("Số nguyên tố: " + (primeNumbers.isEmpty() ? "Không có số nguyên tố" : primeNumbers));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số, cách nhau bởi dấu phẩy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(new JLabel("Nhập mảng (các số cách nhau bởi dấu phẩy):"));
        add(txtInput);
        add(btnFindPrime);
        add(txtResult);

        setVisible(true);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new TimSoNguyenToMang();
    }
}
