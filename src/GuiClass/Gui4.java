package GuiClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui4 extends JFrame {
    private final JButton button = new JButton( "Press me");
    private final JLabel infoLabel = new JLabel( "Ready...");
    public Gui4() {
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
        pack();
        setVisible( true);
    }

    private void doButton() {
        new Thread( new Runnable() {
            public void run() {
                for( int i = 0; i < 100; i++) {
                    setInfo( "Ouch " + i + "!");
                    try { Thread.sleep( 500); } catch( InterruptedException x) {}
                }
                setInfo( "Done...");
            }}).start();
    }

    public void setInfo( String info) {
        this.infoLabel.setText( info);
    }

    public static void main( final String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new Gui4();