package GuiClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui2 extends JFrame {
    private final JButton button = new JButton( "Press me");
    private final JLabel infoLabel = new JLabel( "Ready...");
    public Gui2() {
        setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel( new GridLayout(2,0));
        panel.add( this.button);
        panel.add( this.infoLabel);
        add( panel);
        this.button.addActionListener( new ActionListener() {
            public void actionPerformed( final ActionEvent ev) {
                doButton();
            }
        });
        pack(); setVisible( true);
    }

    private void doButton() {
        new Thread( new Runnable() {
            public void run() {
                for( int i = 0; i < 10000000; i++) {
                    queueInfo( "Ouch " + i + "!");
                    //try { Thread.sleep(500);} catch( InterruptedException x) {}
                }
                queueInfo( "Done...");
            }}).start();
    }

    public void queueInfo( final String info) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() { setInfo( info); }
        });
    }
    public void setInfo( String info) {
        this.infoLabel.setText( info);
    }