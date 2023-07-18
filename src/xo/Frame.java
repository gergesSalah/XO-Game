/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton [] buttons = new JButton[9];
    boolean player1_turn;
    
    JButton replay;
    JPanel replayPanel;
    
    Frame(){
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocation(350, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(50,50,50));
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("X O");
        textfield.setOpaque(true);
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(180,200,180));
        }
        
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        
        firstTurn();
    }
    
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(random.nextInt(2)==0){
            player1_turn =true;
            textfield.setText("X Turn");
        }
        else{
            player1_turn =false;
            textfield.setText("O Turn");
        }
        
    }
    public void check(){
        //check X wins
        if(buttons[0].getText()=="X"&&buttons[1].getText()=="X"&&buttons[2].getText()=="X"){
            xwins(0,1,2);
        }
        if(buttons[3].getText()=="X"&&buttons[4].getText()=="X"&&buttons[5].getText()=="X"){
            xwins(3,4,5);
        }
        if(buttons[6].getText()=="X"&&buttons[7].getText()=="X"&&buttons[8].getText()=="X"){
            xwins(6,7,8);
        }
        if(buttons[0].getText()=="X"&&buttons[3].getText()=="X"&&buttons[6].getText()=="X"){
            xwins(0,3,6);
        }
        if(buttons[1].getText()=="X"&&buttons[4].getText()=="X"&&buttons[7].getText()=="X"){
            xwins(1,4,7);
        }
        if(buttons[2].getText()=="X"&&buttons[5].getText()=="X"&&buttons[8].getText()=="X"){
            xwins(2,5,8);
        }
        if(buttons[0].getText()=="X"&&buttons[4].getText()=="X"&&buttons[8].getText()=="X"){
            xwins(0,4,8);/////////////////////////////////////////
        }
        if(buttons[2].getText()=="X"&&buttons[4].getText()=="X"&&buttons[6].getText()=="X"){
            xwins(2,4,6);////////////////////////////////////////
        }
        
        //check O wins
        if(buttons[0].getText()=="O"&&buttons[1].getText()=="O"&&buttons[2].getText()=="O"){
            owins(0,1,2);
        }
        if(buttons[3].getText()=="O"&&buttons[4].getText()=="O"&&buttons[5].getText()=="O"){
            owins(3,4,5);
        }
        if(buttons[6].getText()=="O"&&buttons[7].getText()=="O"&&buttons[8].getText()=="O"){
            owins(6,7,8);
        }
        if(buttons[0].getText()=="O"&&buttons[3].getText()=="O"&&buttons[6].getText()=="O"){
            owins(0,3,6);
        }
        if(buttons[1].getText()=="O"&&buttons[4].getText()=="O"&&buttons[7].getText()=="O"){
            owins(1,4,7);
        }
        if(buttons[2].getText()=="O"&&buttons[5].getText()=="O"&&buttons[8].getText()=="O"){
            owins(2,5,8);
        }
        if(buttons[0].getText()=="O"&&buttons[4].getText()=="O"&&buttons[8].getText()=="O"){
            owins(0,4,8);/////////////////////////////////////////
        }
        if(buttons[2].getText()=="O"&&buttons[4].getText()=="O"&&buttons[6].getText()=="O"){
            owins(2,4,6);////////////////////////////////////////
        }        
        
        //if 9 buttons played call newGame function
        if (buttons[0].getText()!=""&&buttons[1].getText()!=""&&buttons[2].getText()!=""&&
                buttons[3].getText()!=""&&buttons[4].getText()!=""&&buttons[5].getText()!=""&&
                    buttons[6].getText()!=""&&buttons[7].getText()!=""&&buttons[8].getText()!=""){
            newGame();
        }
    }
    //int A= 0,B=1,C=2;
    public void xwins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0;i<9;i++)
            buttons[i].setEnabled(false);
        
        textfield.setText("X win");
        
        
      //  A = a;B=b;C=c;
        newGame();
    }
    
    public void owins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0;i<9;i++)
            buttons[i].setEnabled(false);
        
        textfield.setText("O win");
        
       // A = a;B=b;C=c;
        newGame();
        
    }
    
    public void newGame(){
        //new Frame();
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setText("");
            //buttons[i].setBackground(new Color(180,200,180));
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < 9; i++) {
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
}
       
