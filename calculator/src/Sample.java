import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample {
    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("This program requires a graphical environment.");
            System.exit(1); 
        }

        SwingUtilities.invokeLater(Sample::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel l1 = new JLabel("Number 1:");
        l1.setBounds(100, 100, 100, 25);
        frame.add(l1);

        JTextField t1 = new JTextField(10);
        t1.setBounds(201, 100, 100, 25);
        frame.add(t1);

        JLabel l2 = new JLabel("Number 2:");
        l2.setBounds(100, 150, 100, 25);
        frame.add(l2);

        JTextField t2 = new JTextField(10);
        t2.setBounds(201, 150, 100, 25);
        frame.add(t2);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(100, 200, 100, 25);
        frame.add(addButton);

        JButton subtractButton = new JButton("SUBTRACT");
        subtractButton.setBounds(201, 200, 100, 25);
        frame.add(subtractButton);

        JButton multiplyButton = new JButton("MULTIPLY");
        multiplyButton.setBounds(302, 200, 100, 25);
        frame.add(multiplyButton);

        JButton divideButton = new JButton("DIVIDE");
        divideButton.setBounds(403, 200, 100, 25);
        frame.add(divideButton);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(100, 250, 100, 25);
        frame.add(submitButton);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setBounds(201, 250, 100, 25);
        frame.add(clearButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(302, 250, 100, 25);
        frame.add(exitButton);

        JLabel result = new JLabel("               ");
        result.setBounds(201, 300, 200, 25);
        result.setForeground(Color.blue);
        result.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(result);

        ActionListener operationListener = (ActionEvent ae) -> {
            try {
                int n1 = Integer.parseInt(t1.getText());
                int n2 = Integer.parseInt(t2.getText());
                JButton source = (JButton) ae.getSource();
                String operation = source.getText();
                switch (operation) {
                    case "ADD":
                        result.setText("Sum: " + (n1 + n2));
                        break;
                    case "SUBTRACT":
                        result.setText("Difference: " + (n1 - n2));
                        break;
                    case "MULTIPLY":
                        result.setText("Product: " + (n1 * n2));
                        break;
                    case "DIVIDE":
                        if (n2 != 0) {
                            result.setText("Quotient: " + ((double) n1 / n2));
                        } else {
                            result.setText("Cannot divide by 0!");
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                result.setText("Invalid Input!");
            }
        };

        addButton.addActionListener(operationListener);
        subtractButton.addActionListener(operationListener);
        multiplyButton.addActionListener(operationListener);
        divideButton.addActionListener(operationListener);

        submitButton.addActionListener((ActionEvent ae) -> {
            try {
                int n1 = Integer.parseInt(t1.getText());
                int n2 = Integer.parseInt(t2.getText());
                result.setText("Submitted: " + n1 + " and " + n2);
            } catch (NumberFormatException e) {
                result.setText("Invalid Input!");
            }
        });

        clearButton.addActionListener((ActionEvent ae) -> {
            t1.setText("");
            t2.setText("");
            result.setText("               ");
        });

        exitButton.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

        frame.setVisible(true);
    }
}
