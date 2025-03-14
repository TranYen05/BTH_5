package pj5;

import javax.swing.*;
import java.awt.*;

public class TimSoLonNhat extends JFrame {
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton btnTim, btnXoa, btnThoat;

    public TimSoLonNhat() {
        setTitle("Tìm Số Lớn Nhất");
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

        btnTim = new JButton("Tìm Số Lớn Nhất");
        add(btnTim);

        txtKetQua = new JTextField(10);
        txtKetQua.setEditable(false);
        add(new JLabel("Kết quả:"));
        add(txtKetQua);

        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        add(btnXoa);
        add(btnThoat);

        btnTim.addActionListener(e -> {
            try {
                double a = Double.parseDouble(txtSo1.getText());
                double b = Double.parseDouble(txtSo2.getText());

                double max = Math.max(a, b);
                txtKetQua.setText(String.valueOf(max));
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

    public static void main(String[] args) {
        new TimSoLonNhat();
    }
}
