
package pj5;

import javax.swing.*;
import java.awt.*;

public class KiemTraSoDoiXung extends JFrame {
    private JTextField txtSo, txtKetQua;
    private JButton btnKiemTra, btnXoa, btnThoat;

    public KiemTraSoDoiXung() {
        setTitle("Kiểm tra số đối xứng");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(new JLabel("Nhập số:"));
        txtSo = new JTextField(10);
        add(txtSo);

        btnKiemTra = new JButton("Kiểm tra");
        add(btnKiemTra);

        txtKetQua = new JTextField(15);
        txtKetQua.setEditable(false);
        add(new JLabel("Kết quả:"));
        add(txtKetQua);

        btnXoa = new JButton("Xóa");
        btnThoat = new JButton("Thoát");
        add(btnXoa);
        add(btnThoat);

        btnKiemTra.addActionListener(e -> {
            try {
                String so = txtSo.getText().trim();
                if (so.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập một số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (laSoDoiXung(so)) {
                    txtKetQua.setText("Là số đối xứng");
                } else {
                    txtKetQua.setText("Không phải số đối xứng");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnXoa.addActionListener(e -> {
            txtSo.setText("");
            txtKetQua.setText("");
        });

        btnThoat.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private boolean laSoDoiXung(String so) {
        int n = so.length();
        for (int i = 0; i < n / 2; i++) {
            if (so.charAt(i) != so.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new KiemTraSoDoiXung();
    }
}
