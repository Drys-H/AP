package GuiClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui1 extends JFrame {
    private final JButton button = new JButton( "Press me");
    public Gui1() {
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE);
        add( this.button);
        this.button.addActionListener( new ActionListener() {
            public void actionPerformed( final ActionEvent ev) {
                doButton();
            }
        });
        pack();
        setVisible( true);
    }

    private void doButton() {
        System.out.println( "Ouch!");
    }
    public static void main( final String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new Gui1();
            }
        });
    }
}

