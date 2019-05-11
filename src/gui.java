import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

public class gui extends JFrame {


    private JTextField textField;
    private double number;
    private Integer calculation;
    private boolean equation;



    public static void main(String[] args){
        gui userInterface = new gui();
        userInterface.run();

    }

    private void run() {

        createView();

        setMinimumSize(new Dimension(320,350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void createView() {


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        getContentPane().add(mainPanel);


        // north part - initializing Text Field where result will be displayed
        JPanel northPanel = new JPanel(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);

        JButton clearButton = new JButton("AC");
        clearButton.addActionListener(new clearButtonReaction());

        northPanel.add(textField,BorderLayout.CENTER);
        northPanel.add(clearButton,BorderLayout.EAST);
        northPanel.setBorder(new EmptyBorder(0,0,10,0));

        mainPanel.add(northPanel,BorderLayout.NORTH);

        //center part
        JPanel centerPanel = new JPanel(new GridLayout(4,4));


        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;


        JButton oneButton = new JButton("1");
        oneButton.addActionListener(new oneButtonReaction());

        JButton twoButton = new JButton("2");
        twoButton.addActionListener(new twoButtonReaction());

        JButton threeButton = new JButton("3");
        threeButton.addActionListener(new threeButtonReaction());

        JButton fourButton = new JButton("4");
        fourButton.addActionListener(new fourButtonReaction());

        JButton fiveButton = new JButton("5");
        fiveButton.addActionListener(new fiveButtonReaction());

        JButton sixButton = new JButton("6");
        sixButton.addActionListener(new sixButtonReaction());

        JButton sevenButton = new JButton("7");
        sevenButton.addActionListener(new sevenButtonReaction());

        JButton eightButton = new JButton("8");
        eightButton.addActionListener(new eightButtonReaction());

        JButton nineButton = new JButton("9");
        nineButton.addActionListener(new nineButtonReaction());

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(new zeroButtonReaction());

        JButton dotButton = new JButton(".");
        dotButton.addActionListener(new dotButtonReaction());

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new equalsButtonReaction());

        JButton additionButton = new JButton("+");
        additionButton.addActionListener(new additionButtonReaction());

        JButton subtractionButton = new JButton("-");
        subtractionButton.addActionListener(new subtractionButtonReaction());

        JButton multiplicationButton = new JButton("*");
        multiplicationButton.addActionListener(new multiplicationButtonReaction());

        JButton divisionButton = new JButton("/");
        divisionButton.addActionListener(new divisionButtonReaction());

        JButton sinButton = new JButton("sin");
        sinButton.addActionListener(new sinButtonReaction());

        JButton cosButton = new JButton("cos");
        cosButton.addActionListener(new cosButtonReaction());

        JButton tgButton = new JButton("tg");
        tgButton.addActionListener(new tgButtonReaction());

        JButton ctgButton = new JButton("ctg");
        ctgButton.addActionListener(new ctgButtonReaction());



        centerPanel.add(sevenButton,c);
        c.gridx++;

        centerPanel.add(eightButton,c);
        c.gridx++;
        centerPanel.add(nineButton,c);
        c.gridx++;
        centerPanel.add(additionButton,c);
        c.gridx++;
        centerPanel.add(sinButton,c);

        c.gridx=0;
        c.gridy++;

        centerPanel.add(fourButton,c);
        c.gridx++;
        centerPanel.add(fiveButton,c);
        c.gridx++;
        centerPanel.add(sixButton,c);
        c.gridx++;
        centerPanel.add(subtractionButton,c);
        c.gridx++;
        centerPanel.add(cosButton,c);

        c.gridx=0;
        c.gridy++;

        centerPanel.add(oneButton,c);
        c.gridx++;
        centerPanel.add(twoButton,c);
        c.gridx++;
        centerPanel.add(threeButton,c);
        c.gridx++;
        centerPanel.add(multiplicationButton,c);
        c.gridx++;
        centerPanel.add(tgButton,c);

        c.gridx=0;
        c.gridy++;

        centerPanel.add(dotButton,c);
        c.gridx++;
        centerPanel.add(zeroButton,c);
        c.gridx++;
        centerPanel.add(equalsButton,c);
        c.gridx++;
        centerPanel.add(divisionButton,c);
        c.gridx++;
        centerPanel.add(ctgButton,c);



        mainPanel.add(centerPanel,BorderLayout.CENTER);
    }

    private void calculate(){

        double result;
        equation=false;

        switch(calculation)
        {
            case 1:
                result = number + Double.parseDouble(textField.getText());
                textField.setText(Double.toString(result));
                equation=true;
                break;
            case 2:
                result = number - Double.parseDouble(textField.getText());
                textField.setText(Double.toString(result));
                equation=true;
                break;
            case 3:
                result = number * Double.parseDouble(textField.getText());
                textField.setText(Double.toString(result));
                equation=true;
                break;
            case 4:
                if(Double.parseDouble(textField.getText())!=0){
                    result = number / Double.parseDouble(textField.getText());
                    textField.setText(Double.toString(result));
                    equation=true;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Nie dzielimy przez zero!");
                    textField.setText("");
                }

                break;
            case 5:
                result = sin(number);
                textField.setText(Double.toString(result));
                equation=true;
                break;
            case 6:
                result = cos(number);
                textField.setText(Double.toString(result));
                equation=true;
                break;
            case 7:
                result = tan(number);
                textField.setText(Double.toString(result));
                equation=true;
                break;
            case 8:
                result = 1/tan(number);
                textField.setText(Double.toString(result));
                equation=true;
                break;
        }
    }



    class oneButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"1");
            else {
                textField.setText(""+"1");
                equation=false;
            }


        }
    }

    class twoButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"2");
            else {
                textField.setText(""+"2");
                equation=false;
            }


        }
    }

    class threeButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"3");
            else {
                textField.setText(""+"3");
                equation=false;
            }


        }
    }

    class fourButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"4");
            else {
                textField.setText(""+"4");
                equation=false;
            }


        }
    }

    class fiveButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"5");
            else {
                textField.setText(""+"5");
                equation=false;
            }


        }
    }

    class sixButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"6");
            else {
                textField.setText(""+"6");
                equation=false;
            }


        }
    }

    class sevenButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"7");
            else {
                textField.setText(""+"7");
                equation=false;
            }


        }
    }

    class eightButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"8");
            else {
                textField.setText(""+"8");
                equation=false;
            }


        }
    }

    class nineButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"9");
            else {
                textField.setText(""+"9");
                equation=false;
            }


        }
    }

    class zeroButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+"0");
            else {
                textField.setText(""+"0");
                equation=false;
            }


        }
    }

    class dotButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!equation) textField.setText(textField.getText()+".");
            else {
                textField.setText(""+".");
                equation=false;
            }


        }
    }

    class equalsButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(calculation!=null){
                calculate();
                calculation=null;
            }

        }
    }

    class additionButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            number = Double.parseDouble(textField.getText());
            calculation=1;
            textField.setText("");

        }
    }

    class subtractionButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            number = Double.parseDouble(textField.getText());
            calculation=2;
            textField.setText("");

        }
    }

    class multiplicationButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            number = Double.parseDouble(textField.getText());
            calculation=3;
            textField.setText("");

        }
    }

    class divisionButtonReaction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            number = Double.parseDouble(textField.getText());
            calculation=4;
            textField.setText("");

        }
    }

    class clearButtonReaction implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText("");
        }
    }

    class sinButtonReaction implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            calculation=5;
            if(textField.getText().length()!=0){
                number= Double.parseDouble(textField.getText());
                calculate();
            }

        }
    }

    class cosButtonReaction implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            calculation=6;
            if(textField.getText().length()!=0){
                number= Double.parseDouble(textField.getText());
                calculate();
            }

        }
    }

    class tgButtonReaction implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            calculation=7;
            if(textField.getText().length()!=0){
                number= Double.parseDouble(textField.getText());
                calculate();
            }

        }
    }

    class ctgButtonReaction implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            calculation=8;

            if(textField.getText().length()!=0){
                number= Double.parseDouble(textField.getText());
                calculate();
            }

        }
    }


}
