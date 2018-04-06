import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalcGui implements ActionListener {
    static private double a = 0, b = 0, result = 0;
    static private int operator = 0;
    JFrame frame;
    JTextField textfield;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdivide, bmultiply, bsubstract, badd, bdot, bequal, bdelete, bclear, btryg, bcmpx, bsqrt, bparl, bparr;
    private int font_size = 10;
    private String font_type = "Arial";

    public CalcGui() {
        frame = new JFrame("Calculator");
        textfield = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bdivide = new JButton("/");
        bmultiply = new JButton("*");
        bsubstract = new JButton("-");
        badd = new JButton("+");
        bdot = new JButton(".");
        bequal = new JButton(" = ");
        btryg = new JButton("tryg<->norm");
        bcmpx = new JButton("j");
        bdelete = new JButton("DEL");
        bclear = new JButton("AC");
        bsqrt = new JButton("sqrt");
        bparl = new JButton("(");
        bparr = new JButton(")");

        // Frame Layout:
        frame.setVisible(true);
        frame.setSize(510, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textfield.setBounds(40, 40, 430, 40);

        b7.setBounds(40, 100, 70, 40);
        b8.setBounds(130, 100, 70, 40);
        b9.setBounds(220, 100, 70, 40);
        bdelete.setBounds(310, 100, 70, 40);
        bclear.setBounds(400, 100, 70, 40);

        b4.setBounds(40, 170, 70, 40);
        b5.setBounds(130, 170, 70, 40);
        b6.setBounds(220, 170, 70, 40);
        bmultiply.setBounds(310, 170, 70, 40);
        bdivide.setBounds(400, 170, 70, 40);

        b1.setBounds(40, 240, 70, 40);
        b2.setBounds(130, 240, 70, 40);
        b3.setBounds(220, 240, 70, 40);
        badd.setBounds(310, 240, 70, 40);
        bsubstract.setBounds(400, 240, 70, 40);

        b0.setBounds(40, 310, 70, 40);
        bdot.setBounds(130, 310, 70, 40);
        bcmpx.setBounds(220, 310, 70, 40);
        bsqrt.setBounds(310, 310, 70, 40);

        bequal.setBounds(400, 310, 70, 110);
        btryg.setBounds(40, 380, 70, 40);
        bparl.setBounds(130, 380, 70, 40);
        bparr.setBounds(220, 380, 70, 40);


        frame.add(textfield);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(bdivide);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(bmultiply);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(bsubstract);
        frame.add(bdot);
        frame.add(b0);
        frame.add(bequal);
        frame.add(badd);
        frame.add(bdelete);
        frame.add(bclear);
        frame.add(btryg);
        frame.add(bcmpx);
        frame.add(bsqrt);
        frame.add(bparl);
        frame.add(bparr);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdivide.addActionListener(this);
        bmultiply.addActionListener(this);
        bsubstract.addActionListener(this);
        bcmpx.addActionListener(this);
        bdot.addActionListener(this);
        bparl.addActionListener(this);
        bparr.addActionListener(this);
        bsqrt.addActionListener(this);
        bequal.addActionListener(this);
        bdelete.addActionListener(this);
        bclear.addActionListener(this);
        btryg.addActionListener(this);
    }

    public static void main(String... s) {
        new CalcGui();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1)
            textfield.setText(textfield.getText().concat("1"));

        if (e.getSource() == b2)
            textfield.setText(textfield.getText().concat("2"));

        if (e.getSource() == b3)
            textfield.setText(textfield.getText().concat("3"));

        if (e.getSource() == b4)
            textfield.setText(textfield.getText().concat("4"));

        if (e.getSource() == b5)
            textfield.setText(textfield.getText().concat("5"));

        if (e.getSource() == b6)
            textfield.setText(textfield.getText().concat("6"));

        if (e.getSource() == b7)
            textfield.setText(textfield.getText().concat("7"));

        if (e.getSource() == b8)
            textfield.setText(textfield.getText().concat("8"));

        if (e.getSource() == b9)
            textfield.setText(textfield.getText().concat("9"));

        if (e.getSource() == b0)
            textfield.setText(textfield.getText().concat("0"));
        if (e.getSource() == bcmpx)
            textfield.setText(textfield.getText().concat("i"));

        if (e.getSource() == bdot)
            textfield.setText(textfield.getText().concat("."));

        if (e.getSource() == badd) {
            textfield.setText(textfield.getText().concat(" + "));
        }

        if (e.getSource() == bsubstract) {
            textfield.setText(textfield.getText().concat(" - "));
        }

        if (e.getSource() == bmultiply) {
            textfield.setText(textfield.getText().concat(" * "));
        }

        if (e.getSource() == bdivide) {
            textfield.setText(textfield.getText().concat(" / "));
        }

        if (e.getSource() == bsqrt) {
            textfield.setText(textfield.getText().concat(" ^ 0.5"));
        }

        if (e.getSource() == bparl) {
            textfield.setText(textfield.getText().concat("( "));
        }
        if (e.getSource() == bparr) {
            textfield.setText(textfield.getText().concat(" )"));
        }

        if (e.getSource() == bequal) {
            CalcEngine equation = new CalcEngine(textfield.getText());
            System.out.println(textfield.getText().trim());
            textfield.setText("" + equation.evaluateExpression());
            System.out.println(textfield.getText());
        }
        if (e.getSource() == btryg) {
            textfield.setText("");
        }

        if (e.getSource() == bclear)
            textfield.setText("");

        if (e.getSource() == bdelete) {
            String s = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < s.length() - 1; i++)
                textfield.setText(textfield.getText() + s.charAt(i));
        }
    }
}