/* Author : Adikari A.M.I.N.
 * Registration Number :  E/16012
 * CO225 Lab 06 Events
 */

/*Connect data in TicTacToeModel class and GUI in TicTacToeView class */


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class TicTacToeCon implements ActionListener{
	
	private static final int len = 3; /* Length of TicTacToe matrix */
	static String [][] a = new String[len][len]; /*Initialize the matrix for TicTacToe to store JButton text*/
	private TicTacToeModel theModel; /* Create TicTacToeModel object */
	private TicTacToeView theView; /* Create TicTacToeView object */
	
	/* Create empty constructor */
	public TicTacToeCon() {}
	
	/* Create constructor to get TicTacToeModel and TicTacToeView objects */
	public TicTacToeCon(TicTacToeModel theModel, TicTacToeView theView) {
		this.theModel = theModel;
		this.theView = theView;
		
		/* Call actionPerformed method */
		theView.addButtonlisten(this);
		theView.addResetListen(this);		
	}

	/* Set the content of actionPerformed method to perform the correct funtionality of the TicTacToe game */
	@Override
	public void actionPerformed(ActionEvent e) {

		/* Reset the game after the RESET button is pressed */
		if(e.getSource() == theView.getReset()) {
			theView.reset();
			TicTacToeModel.setCount(0);
			theModel.reset(a);			
		}
		/* Continue the game */
		else {
			String letter = "";
			
			/* Get the next Player to action */
			letter = theModel.getPlayer();
						
			/* Set the properties of a button after a button is pressed */
			for(int i = 0;i < theModel.getButtons().length;i++) {
	        	for(int j = 0;j < theModel.getButtons().length;j++) {
	        		if(e.getSource() == theView.getButton(i, j)) {
	        			theView.getButton(i, j).setBackground(Color.red);
	        			theView.getButton(i, j).setForeground(Color.black);
	        			theView.getButton(i, j).setText(letter);
	        			a[i][j] = letter;
	        			theView.getButton(i, j).setEnabled(false);
	        		}
	        	}
	        }
			
			/* Show results in another window */
			int joption = 0;
			
			/* Check if there is a winner */
			if(theModel.getWinner(letter,a) == true) {
				joption = JOptionPane.showConfirmDialog(null,"     PLAYER "+letter+" WON !\n     PLAY AGAIN ?","Winner",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
				/* Check if YES option is selected to Play again */
				if(joption == JOptionPane.YES_OPTION) {
					/* Reset the game */
					theView.reset();
					TicTacToeModel.setCount(0);
					theModel.reset(a);
				}
				/* End the game */
				else {
					System.exit(0);
				}
				
			}
			/* Check if the game is draw */
			else if(TicTacToeModel.getCount() == (len * len) &&  theModel.getWinner(letter,a) == false) {
				joption = JOptionPane.showConfirmDialog(null,"     DRAW !\n     PLAY AGAIN ?","Winner",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
				/* Check if NO option is selected to Play again */
				if(joption == JOptionPane.YES_OPTION) {
					/* Reset the game */
					theView.reset();
					TicTacToeModel.setCount(0);
					theModel.reset(a);
				}
				/* End the game */
				else {
					System.exit(0);
				}
			}
		}	
	}

}
