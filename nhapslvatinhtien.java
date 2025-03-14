package pj5;

import javax.swing.*;
import java.awt.*;

public class nhapslvatinhtien extends JFrame {
    private JTextField txtQuantity, txtPrice, txtTotal;
    private JButton btnCalculate, btnClear, btnExit;

    public nhapslvatinhtien() {
        setTitle("Tính Thành Tiền");
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        txtQuantity = new JTextField(5);
        txtPrice = new JTextField(5);
        txtTotal = new JTextField(10);
        txtTotal.setEditable(false);

        btnCalculate = new JButton("Tính");
        btnClear = new JButton("Xóa");
        btnExit = new JButton("Thoát");

        btnCalculate.addActionListener(e -> {
            try {
                int quantity = Integer.parseInt(txtQuantity.getText());
                double price = Double.parseDouble(txtPrice.getText());
                double total = quantity * price;
                txtTotal.setText(String.format("%.2f", total));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnClear.addActionListener(e -> {
            txtQuantity.setText("");
            txtPrice.setText("");
            txtTotal.setText("");
        });

        btnExit.addActionListener(e -> System.exit(0));

        add(new JLabel("Số lượng:")); add(txtQuantity);
        add(new JLabel("Đơn giá:")); add(txtPrice);
        add(new JLabel("Thành tiền:")); add(txtTotal);
        add(btnCalculate); add(btnClear); add(btnExit);

        setVisible(true);
    }

    public static void main(String[] args) {
        new nhapslvatinhtien();
    }
}
