package GuiClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui2 extends JFrame {
    private final JButton button = new JButton( "Press me");
    public Gui2() {
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
        for( int i = 0; i < 100; i++) {
            System.out.println( "Ouch!");
            try { Thread.sleep( 500); } catch( InterruptedException x) {}
        }
        System.out.println();
    }
    public static void main( final String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new Gui2();
            }
        });
    }
}

