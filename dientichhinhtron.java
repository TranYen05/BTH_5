package pj5;

import javax.swing.*;
import java.awt.*;

public class dientichhinhtron extends JFrame {
    private JTextField txtBanKinh;
    private JLabel lblKetQua;

    public dientichhinhtron() {
        setTitle("Tính Diện Tích Hình Tròn");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Bán kính:"));
        txtBanKinh = new JTextField(5);
        add(txtBanKinh);

        JButton btnTinh = new JButton("Tính");
        add(btnTinh);

        lblKetQua = new JLabel("Diện tích: ");
        add(lblKetQua);

        btnTinh.addActionListener(e -> {
            try {
                double banKinh = Double.parseDouble(txtBanKinh.getText());
                double dienTich = Math.PI * Math.pow(banKinh, 2);
                lblKetQua.setText(String.format("Diện tích: %.2f", dienTich));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new dientichhinhtron();
    }
}
