/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoegame;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Abdelrhman mohamed
 */
public class TicTacToeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("TicTacToe Game");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
        
        TicTacToe T = new TicTacToe();
        frame.getContentPane().add(T);
        T.setVisible(true);
        T.init();
        T.start();
        T.setBackground(new Color(80,80,80));

        
    }
    
}
