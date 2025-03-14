package pj5;

import javax.swing.*;
import java.awt.*;

public class TinhTienDien extends JFrame {
    private JTextField txtSoDau, txtSoCuoi, txtThanhTien;
    private JButton btnTinh, btnXoa, btnThoat;

    public TinhTienDien() {
        setTitle("Tính Tiền Điện");
        setSize(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Số đầu:"));
        txtSoDau = new JTextField(5);
        add(txtSoDau);

        add(new JLabel("Số cuối:"));
        txtSoCuoi = new JTextField(5);
        add(txtSoCuoi);

        btnTinh = new JButton("Tính");
        add(btnTinh);

        txtThanhTien = new JTextField(10);
        txtThanhTien.setEditable(false);
        add(new JLabel("Thành tiền:"));
        add(txtThanhTien);

        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        add(btnXoa);
        add(btnThoat);

        btnTinh.addActionListener(e -> {
            try {
                int soDau = Integer.parseInt(txtSoDau.getText());
                int soCuoi = Integer.parseInt(txtSoCuoi.getText());

                if (soCuoi < soDau) {
                    JOptionPane.showMessageDialog(this, "Số cuối phải lớn hơn số đầu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int thanhTien = (soCuoi - soDau) * 2000;
                txtThanhTien.setText(String.valueOf(thanhTien));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnXoa.addActionListener(e -> {
            txtSoDau.setText("");
            txtSoCuoi.setText("");
            txtThanhTien.setText("");
        });

        btnThoat.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new TinhTienDien();
    }
}
