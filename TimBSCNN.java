package pj5;

import javax.swing.*;
import java.awt.*;

public class TimBSCNN extends JFrame {
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton btnTinh, btnXoa, btnThoat;

    public TimBSCNN() {
        setTitle("Tìm BSCNN");
        setSize(450, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Số 1:"));
        txtSo1 = new JTextField(5);
        add(txtSo1);

        add(new JLabel("Số 2:"));
        txtSo2 = new JTextField(5);
        add(txtSo2);

        btnTinh = new JButton("Tìm BSCNN");
        add(btnTinh);

        txtKetQua = new JTextField(10);
        txtKetQua.setEditable(false);
        add(new JLabel("BSCNN:"));
        add(txtKetQua);

        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        add(btnXoa);
        add(btnThoat);

        btnTinh.addActionListener(e -> {
            try {
                int a = Integer.parseInt(txtSo1.getText());
                int b = Integer.parseInt(txtSo2.getText());

                if (a <= 0 || b <= 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int bscnn = (a * b) / UCLN(a, b);
                txtKetQua.setText(String.valueOf(bscnn));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnXoa.addActionListener(e -> {
            txtSo1.setText("");
            txtSo2.setText("");
            txtKetQua.setText("");
        });

        btnThoat.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private int UCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        new TimBSCNN();
    }
}
