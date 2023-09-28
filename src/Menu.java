import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Menu extends JFrame implements MouseListener, WindowListener {
    ImageIcon snake=new ImageIcon("snake.png");
    ImageIcon pong=new ImageIcon("ping-pong.png");
    ImageIcon tictactoe=new ImageIcon("logo.png");
    JLabel snakelabel,ponglabel,tttlabel;
    SnakeFrame s2;
    int Score, score1=0,score2=0;

    public Menu(){
        this.setTitle("2-Player-Games");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,600,650);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(new GridLayout(2,2,50,5));
        this.setResizable(false);
        this.addWindowListener(this);

        snakelabel=new JLabel("SNAKE");
        snakelabel.setForeground(Color.white);
        snakelabel.setFont(new Font("INK FREE",Font.BOLD,25));
        snakelabel.setIcon(snake);
        snakelabel.setPreferredSize(new Dimension(300,300));
        snakelabel.addMouseListener(this);
        snakelabel.setVerticalTextPosition(JLabel.BOTTOM);
        snakelabel.setHorizontalTextPosition(JLabel.CENTER);
        snakelabel.setHorizontalAlignment(JLabel.CENTER);

        ponglabel=new JLabel("PING-PONG");
        ponglabel.setForeground(Color.white);
        ponglabel.setFont(new Font("INK FREE",Font.BOLD,25));
        ponglabel.setIcon(pong);
        ponglabel.setPreferredSize(new Dimension(100,100));
        ponglabel.addMouseListener(this);
        ponglabel.setVerticalTextPosition(JLabel.BOTTOM);
        ponglabel.setHorizontalTextPosition(JLabel.CENTER);
        ponglabel.setHorizontalAlignment(JLabel.CENTER);

        tttlabel=new JLabel("TIC-TAC-TOE");
        tttlabel.setForeground(Color.white);
        tttlabel.setFont(new Font("INK FREE",Font.BOLD,25));
        tttlabel.setIcon(tictactoe);
        tttlabel.setHorizontalAlignment(JLabel.CENTER);
        tttlabel.setPreferredSize(new Dimension(100,100));
        tttlabel.addMouseListener(this);
        tttlabel.setVerticalTextPosition(JLabel.BOTTOM);
        tttlabel.setHorizontalTextPosition(JLabel.CENTER);
        tttlabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(snakelabel);
        this.add(ponglabel);
        this.add(tttlabel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==snakelabel){
            s2=new SnakeFrame();
        }
        if(e.getSource()==ponglabel){
            new PongFrame();
        }
        if(e.getSource()==tttlabel){
            new TTTFrame();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
