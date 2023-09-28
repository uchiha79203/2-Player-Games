import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SnakeFrame extends JFrame implements ActionListener, WindowListener {
    SnakePanel panel;
    JFrame frame;
    ImageIcon ic;
    JButton start_button;
    int win=0;
    public SnakeFrame(){
        ic=new ImageIcon("snake.png");
        frame=new JFrame();
        frame.setVisible(true);
        frame.setTitle("Snake");
        frame.setResizable(false);
        frame.setIconImage(ic.getImage());
        frame.setBounds(0,0,600,600);

        start_button=new JButton();
        start_button.setText("S T A R T");
        start_button.setSize(100,50);
        start_button.setBackground(Color.black);
        start_button.setForeground(Color.GREEN);
        start_button.setFont(new Font("Arial",Font.BOLD,30));
        start_button.setFocusable(false);
        start_button.addActionListener(this);

        frame.add(start_button);
        frame.addWindowListener(this);
    }
    public int getscore(){
        return win;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start_button){
            start_button.setVisible(false);
            start_button.setEnabled(false);
            panel=new SnakePanel();
            frame.add(panel);
            frame.pack();
            panel.requestFocus();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
