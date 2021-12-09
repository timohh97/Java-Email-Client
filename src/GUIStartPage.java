import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUIStartPage extends JFrame{

    private JLabel label1;
    private JTextField fromMail;
    private JLabel label2;
    private JTextField toMail;
    private JLabel label3;
    private JTextField message;
    private JButton button;


    public GUIStartPage(String titel) {

        setTitle(titel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout mainLayout = new GridLayout(7,1);
        mainLayout.setVgap(10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,100,60,100));
        panel.setLayout(mainLayout);
        panel.setBackground(Color.RED);

        add(panel,BorderLayout.CENTER);

        initComponents();
        addComponentsToPanel(panel);

        setColorOfComponents();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }


    private void addComponentsToPanel(JPanel panel)
    {
        panel.add(label1);
        panel.add(fromMail);
        panel.add(label2);
        panel.add(toMail);
        panel.add(label3);
        panel.add(message);
        panel.add(button);

    }

    private void setColorOfComponents()
    {
        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        fromMail.setBackground(Color.BLACK);
        fromMail.setForeground(Color.WHITE);
        fromMail.setCaretColor(Color.WHITE);
        toMail.setBackground(Color.BLACK);
        toMail.setForeground(Color.WHITE);
        toMail.setCaretColor(Color.WHITE);
        message.setBackground(Color.BLACK);
        message.setForeground(Color.WHITE);
        message.setCaretColor(Color.WHITE);
        label1.setFont(label1.getFont().deriveFont(32.0f));
        label2.setFont(label2.getFont().deriveFont(32.0f));
        label3.setFont(label3.getFont().deriveFont(32.0f));
        button.setFont(button.getFont().deriveFont(32.0f));
        fromMail.setFont(fromMail.getFont().deriveFont(32.0f));
        toMail.setFont(toMail.getFont().deriveFont(32.0f));
        message.setFont(message.getFont().deriveFont(32.0f));
    }


    private void initComponents() {

        fromMail = new JTextField(20);
        toMail = new JTextField(20);
        label1 = new JLabel("From:");
        label2 = new JLabel("To:");
        label3 = new JLabel("Message:");
        message = new JTextField(30);
        button = new JButton("Send email");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromMailEingabe = fromMail.getText();
                String toMailEingabe = toMail.getText();
                String messageEingabe = message.getText();

                if(MailValidator.validateMail(fromMailEingabe))
                {
                    if(MailValidator.validateMail(toMailEingabe))
                    {
                        if(messageEingabe.length()>4)
                        {
                            try {
                                MailClient.sendMail(fromMailEingabe,toMailEingabe,messageEingabe);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(GUIStartPage.this,
                                    "<html><h1 style='font-family: Calibri; font-size: 36pt;'>Please type in at least 5 characters for your message!");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(GUIStartPage.this,
                                "<html><h1 style='font-family: Calibri; font-size: 36pt;'>The second email is not valid!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(GUIStartPage.this,
                            "<html><h1 style='font-family: Calibri; font-size: 36pt;'>The first email is not valid!");
                }
            }
        });

    }
}
