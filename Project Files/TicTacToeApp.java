/* Author : Adikari A.M.I.N.
 * Registration Number :  E/16012
 * CO225 Lab 06 Events
 */

/* Main class which executes the game */


class TicTacToeApp {

	public static void main(String[] args) {

		/* Instantiate the TicTacToeModel object */
		TicTacToeModel theModel = new TicTacToeModel();
		
		/* Instantiate the TicTacToeView object */
		TicTacToeView theView = new TicTacToeView();
		
		/* Instantiate the TicTacToeCon object */
		new TicTacToeCon(theModel, theView);

	}
}