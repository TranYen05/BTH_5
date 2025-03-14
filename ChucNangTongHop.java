package pj5;
//sprint 2

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChucNangTongHop extends JFrame {
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton btnGiaiPTBacNhat, btnTimSoLonNhat, btnKiemTraSoDoiXung, btnTimSoNhoNhat,
            btnTimUSCLN, btnInTangDan, btnDaoNguocHaiSo, btnTimBSCNN, btnInGiamDan, btnKiemTraSNT;

    public ChucNangTongHop() {
        setTitle("Chương Trình Tổng Hợp Chức Năng");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        txtSo1 = new JTextField(10);
        txtSo2 = new JTextField(10);
        txtKetQua = new JTextField(20);
        txtKetQua.setEditable(false);

        btnGiaiPTBacNhat = new JButton("Giải PT Bậc Nhất");
        btnTimSoLonNhat = new JButton("Tìm Số Lớn Nhất");
        btnKiemTraSoDoiXung = new JButton("Kiểm Tra Số Đối Xứng");
        btnTimSoNhoNhat = new JButton("Tìm Số Nhỏ Nhất");
        btnTimUSCLN = new JButton("Tìm USCLN");
        btnInTangDan = new JButton("In Tăng Dần");
        btnDaoNguocHaiSo = new JButton("Đảo Ngược Hai Số");
        btnTimBSCNN = new JButton("Tìm BSCNN");
        btnInGiamDan = new JButton("In Giảm Dần");
        btnKiemTraSNT = new JButton("Kiểm Tra Số Nguyên Tố");

        add(new JLabel("Số 1:"));
        add(txtSo1);
        add(new JLabel("Số 2:"));
        add(txtSo2);
        add(btnGiaiPTBacNhat);
        add(btnTimSoLonNhat);
        add(btnKiemTraSoDoiXung);
        add(btnTimSoNhoNhat);
        add(btnTimUSCLN);
        add(btnInTangDan);
        add(btnDaoNguocHaiSo);
        add(btnTimBSCNN);
        add(btnInGiamDan);
        add(btnKiemTraSNT);
        add(new JLabel("Kết Quả:"));
        add(txtKetQua);

        btnGiaiPTBacNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaiPhuongTrinhBacNhat();
            }
        });

        btnTimSoLonNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timSoLonNhat();
            }
        });

        btnKiemTraSoDoiXung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kiemTraSoDoiXung();
            }
        });

        btnTimSoNhoNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timSoNhoNhat();
            }
        });

        btnTimUSCLN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timUSCLN();
            }
        });

        btnInTangDan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inTangDan();
            }
        });

        btnDaoNguocHaiSo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daoNguocHaiSo();
            }
        });

        btnTimBSCNN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timBSCNN();
            }
        });

        btnInGiamDan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inGiamDan();
            }
        });

        btnKiemTraSNT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kiemTraSoNguyenTo();
            }
        });

        setVisible(true);
    }

    private void giaiPhuongTrinhBacNhat() {
        try {
            double a = Double.parseDouble(txtSo1.getText());
            double b = Double.parseDouble(txtSo2.getText());
            if (a == 0) {
                if (b == 0) {
                    txtKetQua.setText("Phương trình vô số nghiệm");
                } else {
                    txtKetQua.setText("Phương trình vô nghiệm");
                }
            } else {
                double x = -b / a;
                txtKetQua.setText("Nghiệm x = " + x);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void timSoLonNhat() {
        try {
            double a = Double.parseDouble(txtSo1.getText());
            double b = Double.parseDouble(txtSo2.getText());
            double max = Math.max(a, b);
            txtKetQua.setText("Số lớn nhất: " + max);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void kiemTraSoDoiXung() {
        try {
            String so = txtSo1.getText().trim();
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
    }

    private boolean laSoDoiXung(String so) {
        int n = so.length();
        for (int i = 0; i < n / 2; i++) {
            if (so.charAt(i) != so.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true
::contentReference[oaicite:0]{index=0}
 
