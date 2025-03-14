package pj5;

import javax.swing.*;
import java.awt.*;

public class DaoNguocHaiSo extends JFrame {
    private JTextField txtSo1, txtSo2;
    private JButton btnSwap, btnThoat;

    public DaoNguocHaiSo() {
        setTitle("Hoán Đổi Hai Số");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Số 1:"));
        txtSo1 = new JTextField(5);
        add(txtSo1);

        add(new JLabel("Số 2:"));
        txtSo2 = new JTextField(5);
        add(txtSo2);

        btnSwap = new JButton("Hoán Đổi");
        add(btnSwap);

        btnThoat = new JButton("Thoát");
        add(btnThoat);

        btnSwap.addActionListener(e -> {
            String temp = txtSo1.getText();
            txtSo1.setText(txtSo2.getText());
            txtSo2.setText(temp);
        });

        btnThoat.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new DaoNguocHaiSo();
    }
}
