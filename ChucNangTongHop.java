package pj5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChucNangTongHop extends JFrame {
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "Giải PT Bậc Nhất", "Tìm Số Lớn Nhất", "Kiểm Tra Số Đối Xứng",
            "Tìm Số Nhỏ Nhất", "Tìm USCLN", "In Tăng Dần",
            "Đảo Ngược Hai Số", "Tìm BSCNN", "In Giảm Dần", "Kiểm Tra SNT"
    };

    public ChucNangTongHop() {
        setTitle("Chương Trình Tổng Hợp");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        txtSo1 = new JTextField(10);
        txtSo2 = new JTextField(10);
        txtKetQua = new JTextField(20);
        txtKetQua.setEditable(false);

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(createActionListener(i));
            add(buttons[i]);
        }

        add(new JLabel("Số 1:"));
        add(txtSo1);
        add(new JLabel("Số 2:"));
        add(txtSo2);
        add(new JLabel("Kết Quả:"));
        add(txtKetQua);
        
        setVisible(true);
    }

    private ActionListener createActionListener(int index) {
        return e -> {
            try {
                int a = Integer.parseInt(txtSo1.getText());
                int b = Integer.parseInt(txtSo2.getText());
                switch (index) {
                    case 0 -> txtKetQua.setText(giaiPTBacNhat(a, b));
                    case 1 -> txtKetQua.setText("Số lớn nhất: " + Math.max(a, b));
                    case 2 -> txtKetQua.setText(kiemTraSoDoiXung(a) ? "Số đối xứng" : "Không phải số đối xứng");
                    case 3 -> txtKetQua.setText("Số nhỏ nhất: " + Math.min(a, b));
                    case 4 -> txtKetQua.setText("USCLN: " + timUSCLN(a, b));
                    case 5 -> txtKetQua.setText("Tăng dần: " + Math.min(a, b) + ", " + Math.max(a, b));
                    case 6 -> txtKetQua.setText("Đảo ngược: " + b + ", " + a);
                    case 7 -> txtKetQua.setText("BSCNN: " + timBSCNN(a, b));
                    case 8 -> txtKetQua.setText("Giảm dần: " + Math.max(a, b) + ", " + Math.min(a, b));
                    case 9 -> txtKetQua.setText(kiemTraSNT(a) ? "Là số nguyên tố" : "Không phải số nguyên tố");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        };
    }

    private String giaiPTBacNhat(int a, int b) {
        if (a == 0) return (b == 0) ? "Vô số nghiệm" : "Vô nghiệm";
        return "Nghiệm x = " + (-b / (double) a);
    }

    private boolean kiemTraSoDoiXung(int n) {
        String s = Integer.toString(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private int timUSCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int timBSCNN(int a, int b) {
        return (a * b) / timUSCLN(a, b);
    }

    private boolean kiemTraSNT(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new ChucNangTongHop();
    }
}
