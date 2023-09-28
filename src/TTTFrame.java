import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTFrame implements ActionListener {
    int[][] mat=new int[3][3];
    int moves_made=0;
    boolean player1turn=true;
    JFrame frame;
    JPanel panel1,panel2;
    JLabel label1;
    JButton[] buttons=new JButton[9];
    public TTTFrame(){


        //INTERFACE DESIGN
        //FRAME
        ImageIcon ic=new ImageIcon("logo.png");
        frame=new JFrame();
        frame.setVisible(true);
        frame.setBounds(0,0,500,540);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setIconImage(ic.getImage());
        frame.setTitle("Tic-Tac-Toe");

        //PANELS
        //Panel1
        panel1=new JPanel();
        panel1.setBounds(0,0,500,60);
        panel1.setPreferredSize(new Dimension(600,100));
        panel1.setBackground(Color.BLACK);

        //Panel2
        panel2=new JPanel();
        panel2.setBounds(0,60,500,440);
        panel2.setPreferredSize(new Dimension(600,400));
        panel2.setBackground(Color.BLACK);
        panel2.setLayout(new GridLayout(3,3,0,0));

        //LABELS
        //Label1
        label1=new JLabel();
        label1.setFont(new Font("INK FREE", Font.BOLD,40));
        label1.setForeground(Color.red);
        label1.setText("X's Turn");


        //BUTTONS
        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(0xFFFFFF));
            panel2.add(buttons[i]);
        }

        //Adding components
        panel1.add(label1);
        frame.add(panel1);
        frame.add(panel2);


        //GAME BACKEND
        //initialize the matrix
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                mat[i][j]=-1;
            }
        }
    }
    boolean checkplayer1(int i,int j){

        //check horizontal
        int count=0;
        for(int x=0;x<3;x++){
            if(mat[i][x]==1) count++;
        }
        //if won, color the buttons green
        if(count==3){
            int row=i*3;
             int p=3;
             while(p>0){
                 p--;
                 buttons[row].setBackground(Color.GREEN);
                 buttons[row].setForeground(Color.BLACK);
                 row++;
             }
            return true;
        }


        count=0;
        //check vertical
        for(int x=0;x<3;x++){
            if(mat[x][j]==1) count++;
        }
        if(count==3){
            int column=j%3; //1
            for(int p=column;column<9;column+=3){
                buttons[column].setBackground(Color.green);
                buttons[column].setForeground(Color.black);
            }
            return true;
        }


        count=0;
        //check left diagonal
        for(int x=0;x<3;x++){
            if(mat[x][x]==1) count++;
        }
        if(count==3) {
            for(int p=0;p<9;p+=4){
                buttons[p].setBackground(Color.GREEN);
                buttons[p].setForeground(Color.BLACK);
            }
            return true;
        }


        count=0;
        //check right diagonal
        int x=0,y=2;
        while(x<3 && y>=0){
            if(mat[x][y]==1) count++;
            x++;
            y--;
        }
        if(count==3){
            for(int p=2;p<9;p+=2){
                buttons[p].setBackground(Color.GREEN);
                buttons[p].setForeground(Color.BLACK);
            }
            return true;
        }
        return false;
    }
    boolean checkplayer2(int i,int j){

        //check horizontal
        int count=0;
        for(int x=0;x<3;x++){
            if(mat[i][x]==2) count++;
        }
        //if won, color the buttons green
        if(count==3){
            int row=i*3;
            int p=3;
            while(p>0){
                p--;
                buttons[row].setBackground(Color.CYAN);
                buttons[row].setForeground(Color.BLACK);
                row++;
            }
            return true;
        }


        count=0;
        //check vertical
        for(int x=0;x<3;x++){
            if(mat[x][j]==2) count++;
        }
        if(count==3){
            int column=j%3; //1
            for(int p=column;column<9;column+=3){
                buttons[column].setBackground(Color.cyan);
                buttons[column].setForeground(Color.black);
            }
            return true;
        }


        count=0;
        //check left diagonal
        for(int x=0;x<3;x++){
            if(mat[x][x]==2) count++;
        }
        if(count==3) {
            for(int p=0;p<9;p+=4){
                buttons[p].setBackground(Color.CYAN);
                buttons[p].setForeground(Color.BLACK);
            }
            return true;
        }


        count=0;
        //check right diagonal
        int x=0,y=2;
        while(x<3 && y>=0){
            if(mat[x][y]==2) count++;
            x++;
            y--;
        }
        if(count==3){
            for(int p=2;p<8;p+=2){
                buttons[p].setBackground(Color.CYAN);
                buttons[p].setForeground(Color.BLACK);
            }
            return true;
        }
        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //check which button was pressed
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                int row=i/3;
                int column=i%3;
                buttons[i].setBackground(Color.black);
                buttons[i].setForeground(Color.green);
                moves_made++;
                if(player1turn==true){
                    label1.setForeground(Color.red);
                    label1.setText("O's turn");
                    buttons[i].setForeground(Color.GREEN);
                    buttons[i].setText("X");
                    buttons[i].setFont(new Font("INK FREE",Font.BOLD,55));
                    buttons[i].setEnabled(false);
                    mat[row][column]=1;
                    if(checkplayer1(row,column)){
                        label1.setForeground(Color.GREEN);
                        label1.setText("X WINS");
                        for(int j=0;j<9;j++){
                            buttons[j].setEnabled(false);
                        }
                    }
                    else{
                        if(moves_made==9){
                            label1.setForeground(Color.PINK);
                            label1.setText("DRAW");
                        }
                    }
                    player1turn=false;
                }
                else{
                    label1.setForeground(Color.red);
                    label1.setText("X's turn");
                    buttons[i].setForeground(Color.CYAN);
                    buttons[i].setText("O");
                    buttons[i].setFont(new Font("INK FREE",Font.BOLD,55));
                    buttons[i].setEnabled(false);
                    mat[row][column]=2;
                    if(checkplayer2(row,column)){
                        label1.setForeground(Color.CYAN);
                        label1.setText("O WINS");
                        for(int j=0;j<9;j++){
                            buttons[j].setEnabled(false);
                        }
                    }
                    else{
                        if(moves_made==9){
                            label1.setForeground(Color.pink);
                            label1.setText("DRAW");
                        }
                    }
                    player1turn=true;
                }
            }
        }


    }
}