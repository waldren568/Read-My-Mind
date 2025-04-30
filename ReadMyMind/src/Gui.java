import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{

    JFrame progressBarFrame = new JFrame("Please Wait");

    JTextField numberTf = new JTextField();

    JProgressBar pB = new JProgressBar();

    JLabel decifratingThoughtsLbl = new JLabel("deciphering thoughts...");

    public Gui(){
        super("Read Minds 2.0");

        setVisible(false);
        progressBarFrame.setVisible(false);

        setSize(300, 200);
        progressBarFrame.setSize(300, 200);

        setResizable(false);
        progressBarFrame.setResizable(false);

        setLayout(null);
        progressBarFrame.setLayout(null);

        setLocationRelativeTo(null);
        progressBarFrame.setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        progressBarFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        addGuiComponents();
    }

    private void addGuiComponents(){

        // Main label
        JLabel mainLbl = new JLabel("Think a number and i will try to guess it:");
        mainLbl.setBounds(10, 10, 300, 20);
        mainLbl.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(mainLbl);

        // Textfield number
        numberTf.setBounds(10, 40, 140, 30);
        numberTf.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(numberTf);

        // Progress bar
        pB.setBounds(30, 70, 210, 20);
        pB.setValue(0);
        pB.setStringPainted(true);
        pB.setFont(new Font("Dialog", Font.PLAIN, 16));
        progressBarFrame.add(pB);

        // Done button
        JButton doneBtn = new JButton("Done thinking");
        doneBtn.setBounds(10, 80, 210, 45);
        doneBtn.setFont(new Font("Dialog", Font.PLAIN, 16));
        doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(doneBtn)){
                    if(numberTf.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please fill the field or else you can't continue", "Fill the field", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        progressBarFrame.setVisible(true);
                        setVisible(false);
                        fill();

                         ThinkingOf();
                    }
                }
            }
        });
        add(doneBtn);

        // Adding decifrating thoughts label
        decifratingThoughtsLbl.setBounds(40, 30, 210, 45);
        decifratingThoughtsLbl.setFont(new Font("Dialog", Font.PLAIN, 16));
        progressBarFrame.add(decifratingThoughtsLbl);
    }

    private void fill(){

        int counter = 0;

        while(counter <= 100){
            pB.setValue(counter);
            try{
                Thread.sleep(100);
            } catch(InterruptedException ex){
                ex.printStackTrace();
            }
            counter += 5;
        }
    }

    private void ThinkingOf(){
        int i = 0;

        while (i <= 100){
            i++;
            if(i == 100){
                JOptionPane.showMessageDialog(null, "You are thinking of: " + numberTf.getText(), "You are thinking of:", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
