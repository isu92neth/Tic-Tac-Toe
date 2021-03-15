/* Author : Adikari A.M.I.N.
 * Registration Number :  E/16012
 * CO225 Lab 06 Events
 */

/* Design GUI needed for TicTacToe game*/


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class TicTacToeView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final int len = 3; /* Length of TicTacToe matrix */
	private JFrame gui = new JFrame(); /* Main frame to display TicTacToe game */
	private JButton [][] buttons = new JButton[len][len]; /*Initialize the JButton matrix for TicTacToe */
	private JButton reset ; /* Button to reset the TicTacToe game */
	
	public TicTacToeView() {
		
		/* Panel 1 to display TicTacToe grid */
		JPanel p1 = new JPanel(); 
		p1.setSize(400, 300);
		p1.setLayout(new GridLayout(len, len));
		
		/* Panel 2 to display RESET button */
		JPanel p2 = new JPanel(); 
		p2.setLayout(new FlowLayout()); 
		
		/* Set properties of the main frame */
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Tic Tac Toe");
		gui.setSize(400, 400);
		gui.setLocationRelativeTo(null);
		
		/* Initialize the buttons */
       for(int i = 0;i < buttons.length;i++) {
    	   for(int j = 0;j < buttons[0].length;j++) {
          		buttons[i][j] = new JButton("");
          		buttons[i][j].setOpaque(true);
          		buttons[i][j].setFont(new Font("Arial",Font.BOLD,50));
          		buttons[i][j].setForeground(Color.black);
          		buttons[i][j].setBackground(Color.gray);
          	}
       }
       
       /* Add buttons to Panel 1 */
       for(int i = 0;i < buttons.length;i++) {
       	for(int j = 0;j < buttons[0].length;j++) {
       		p1.add(buttons[i][j]);
       	}
       }	
       
       /* Set properties of the RESET button */
       reset = new JButton("RESET");
       reset.setBackground(Color.yellow);
       reset.setForeground(Color.black);
       reset.setFont(new Font("Arial",Font.BOLD,20));
       
       /* Set properties of Panel 2*/
       p2.setBackground(Color.darkGray);
       
       /* Add RESET button to Panel 2 */
       p2.add(reset);
       
       /* Add Panel 1 and Panel 2 to the Main frame */
       gui.add(p1,BorderLayout.CENTER);
       gui.add(p2,BorderLayout.PAGE_END);
     
       /* Set the visibility of the Main frame */
       gui.setVisible(true);
       		
	}

	/* Method to get the specific button in the button matrix */
	public JButton getButton(int i,int j) {
		return buttons[i][j];
	}

	/* Method to get the RESET button */
	public JButton getReset() {
		return reset;
	}
	
	/* Method to set the buttons to perform action when any button is pressed in TicTacToe button matrix */
	public void addButtonlisten(ActionListener buttonListen) {
		for(int i = 0;i < buttons.length;i++) {
        	for(int j = 0;j < buttons[0].length;j++) {
        		buttons[i][j].addActionListener(buttonListen);
        	}      	
        }
	}
	
	/* Method to set the reset button to perform action when the reset button is pressed */
	public void addResetListen(ActionListener resetListen) {
		reset.addActionListener(resetListen);
	}
	
	/* Method to reset the buttons */
	public void reset() {
		for(int i = 0;i < buttons.length;i++) {
        	for(int j = 0;j < buttons[0].length;j++) {
        		buttons[i][j].setText("");
        		buttons[i][j].setFont(new Font("Arial",Font.BOLD,50));
           		buttons[i][j].setBackground(Color.gray);
        		buttons[i][j].setEnabled(true);
        	}
        	
        }
	}
	
}

