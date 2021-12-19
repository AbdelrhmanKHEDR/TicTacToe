/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoegame;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Abdelrhman mohamed
 */
public class TicTacToe extends Applet implements ActionListener {
    //Buttons.
     JButton []cells = new JButton[9]; //array that enter the 9 buttons of the game.
     JButton B1 = new JButton("Reset");
     
     
     
     JPanel boardpanel = new JPanel(new GridLayout(3,3));
     
     TextField txt = new TextField(50); //l3b
     
     JLabel l= new JLabel("Lets play TicTacToe"); // label of the game.
     Font f = new Font("chiller",Font.ITALIC,60);
     Font f1 = new Font("Elephant",Font.ITALIC,20);
     
     ImageIcon O = new ImageIcon("E:\\java programs\\TicTacToeGame\\src\\tictactoegame\\newpackage\\letterr o.png");
     ImageIcon X = new ImageIcon("E:\\java programs\\TicTacToeGame\\src\\tictactoegame\\newpackage\\letterr x.png");
     
     private boolean flag=false;
     int count=0;
 //`    public boolean draw=false;
     public  boolean win = false;
 
     
     JPanel panelFrame = new JPanel();
 
     
     
     public TicTacToe()
     {
         for(int i=0;i<cells.length;i++) //loop to show the board of the game.
       {
         cells[i]=new JButton();
         cells[i].setPreferredSize(new Dimension (133,133)); // thats change the dimension and size of the buttons.
         add(cells[i]);
         cells[i].setBackground(Color.BLACK);
         boardpanel.add(cells[i]);
         
         boardpanel.setBorder(new LineBorder(Color.RED,4));
         
         
         
       }
         
         
       
     }
     

      
     
    public void init() //method that we enter all the butt
    {
      
      add(boardpanel);
      add(B1);
      add(txt);

      l.setFont(f);
      add(l);
      
      txt.setFont(f1);
      
     
      
      
      for(int i=0;i<cells.length;i++)
      {
      cells[i].addActionListener(this);
      }
      
     
     B1.addActionListener(this);
    
     txt.setEnabled(false);
    }
    
   

    
     @Override
    public void paint(Graphics g) // method paint to change the sizes and dimensions of all thing in the project.
    {
     super.paint(g);
     
     boardpanel.setBounds(200,250,407,407);
  
     B1.setBounds(800,400,100,100);
     txt.setBounds(300,100,200,50);
     l.setBounds(500,100, 400,200);
    }
    

    
    public void CheckForWin() //function for checking the winner.
    {
      //Horizontal
        for(int i=0;i<cells.length;i++)
        {
          if(cells[0].getIcon()==cells[1].getIcon() 
                  && cells[1].getIcon()==cells[2].getIcon() 
                    && cells[0].getIcon() !=null)
          {      
           win=true;
           txt.setText("You won the game");
           
           for(int j=0;j<cells.length;j++)
           {
           cells[i].setEnabled(false);
           }
          }
          else if(cells[3].getIcon()==cells[4].getIcon() 
                  && cells[4].getIcon()==cells[5].getIcon() 
                     && cells[3].getIcon() !=null)
          {
           win=true;
           txt.setText("You won the game");
           for(int j=0;j<cells.length;j++)
           {
           cells[i].setEnabled(false);
           }
           
          }
          else if(cells[6].getIcon()==cells[7].getIcon() 
                  && cells[7].getIcon()==cells[8].getIcon() 
                    && cells[6].getIcon() !=null)
          {
            win=true;
             txt.setText("You won the game");
           for(int j=0;j<cells.length;j++)
           {
           cells[i].setEnabled(false);
           }
          }
          
          // Verticaly.
          else if(cells[0].getIcon()==cells[3].getIcon() 
                  && cells[3].getIcon()==cells[6].getIcon() 
                    && cells[0].getIcon() !=null)
          {
           win=true;
            txt.setText("You won the game");
           for(int j=0;j<cells.length;j++)
           {
           cells[i].setEnabled(false);
           }
          }
          else if(cells[1].getIcon()==cells[4].getIcon() 
                  && cells[4].getIcon()==cells[7].getIcon() 
                    && cells[1].getIcon() !=null)
          {
           win=true;
            txt.setText("You won the game");
            for(int j=0;j<cells.length;j++)
           {
           cells[i].setEnabled(false);
           }
          }
          else if(cells[2].getIcon()==cells[5].getIcon() 
                  && cells[5].getIcon()==cells[8].getIcon() 
                    && cells[2].getIcon() !=null)
          {
           win=true;
           txt.setText("You won the game");
           for(int j=0;j<cells.length;j++)
            {
              cells[i].setEnabled(false);
            }
          }
          
          //Diagonaly
          else if(cells[0].getIcon()==cells[4].getIcon() 
                  && cells[4].getIcon()==cells[8].getIcon() 
                    && cells[0].getIcon() !=null)
          {
           win=true;
            txt.setText("You won the game");
            for(int j=0;j<cells.length;j++)
           {
           cells[i].setEnabled(false);
           }
          }
          else if(cells[2].getIcon()==cells[4].getIcon() 
                  && cells[4].getIcon()==cells[6].getIcon() 
                    && cells[2].getIcon() !=null)
          {
           win=true; 
            txt.setText("You won the game");
            for(int j=0;j<cells.length;j++)
           {
           cells[i].setEnabled(false);
           }
          }
          
          
    }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        for(int i=0;i<cells.length;i++)  //Enter the letters.
        {
          if(e.getSource()==cells[i])
          {
            if(flag)  
            {
           cells[i].setIcon(X);
           cells[i].setEnabled(false);
           txt.setText("O'Turn should play");
            flag = false ;
           
            }
            else if(flag=true)
            { 
            cells[i].setIcon(O);
            cells[i].setEnabled(false);
            txt.setText("X'Turn should play");
            flag = true ;
            }
                
          }
         
      }
        
        count++;
        
        if(count==9) //if condition that if they are no win and they draw
        {
    
          txt.setText("Tie Game! try again");          
        }
      
      for(int i=0;i<cells.length;i++) //Reset button that clear all the images from any button in the game.
      {
        if(e.getSource()==B1)
        {
         cells[i].setIcon(null);     
         txt.setText(" ");
        cells[i].setEnabled(true);
        }
      } 
          
      CheckForWin(); //calling this method.
      
    }

}
    
    
    
        
        
    

    

