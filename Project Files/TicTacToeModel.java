/* Author : Adikari A.M.I.N.
 * Registration Number :  E/16012
 * CO225 Lab 06 Events
 */

/* Model class which stores data needed for TicTacToe game */


class TicTacToeModel {

	private static final int len = 3; /* Length of TicTacToe matrix */
	private String [][] buttons = new String [len][len]; /*Initialize the matrix for TicTacToe */
	private static int count = 0; /* To count number of moves */
	private String letter = ""; /* Indicate whether it is Player 1 or Player 2*/
	
	/* Method to determine the winner of TicTacToe */
    public boolean getWinner(String symbol,String [][]buttons) {
    	
		int  countRow, countCol, countPDia = 0, countSDia = 0;
		for(int i = 0;i < buttons.length;i++) {
			countRow = 0;
			countCol = 0;
			/* Count number of instances where horizontal or vertical cells are identical */
			for(int j = 0;j < buttons[0].length - 1;j++) {
				if(symbol.equals(buttons[i][j]) && symbol.equals(buttons[i][j+1] )) {
					countRow++;
				}
				if(symbol.equals(buttons[j][i])  && symbol.equals(buttons[j+1][i]) ) {
					countCol++;
				}
			}
			 /* To check horizontal winner */
			if(countRow == buttons.length - 1) {
				return true;
			}
			/* To check vertical winner */
			else if(countCol == buttons.length - 1) {
				return true;
			}			
		}
		/* Count number of instances where diagonal cells are identical */
		for(int i = 0;i < buttons.length - 1;i++) {
			if(symbol.equals(buttons[i][i])  && symbol.equals(buttons[i+1][i+1]) ) {
				countPDia++;
			}
			if(symbol.equals(buttons[i][buttons.length - 1 - i])  && symbol.equals(buttons[i+1][buttons.length - 2 - i]) ) {
				countSDia++;
			}
		}
		 /* To check primary diagonal winner */
		if(countPDia == buttons.length - 1) {
			return true;
		}
		 /* To check secondary diagonal winner */
		else if(countSDia == buttons.length - 1) {
			return true;
		}	
		return false;
    }

    /* Method to reset the cells of the matrix */
    public void reset(String [][] buttons) {
    	for(int i = 0;i < buttons.length;i++) {
    		for(int j = 0;j < buttons[0].length;j++) {
    			buttons[i][j] = "";
    		}
    	}
    }
    
    /*Method to determine next player */
    public String getPlayer() {
    	if(count%2 == 0) {
			letter = "1";
		}
		else if(count%2 != 0) {
			letter = "2";
		}
		count++; /* Go to next move */
		return letter;
    }

    /* Method to return TicTacToe matrix */
	public String[][] getButtons() {
		return buttons;
	}	
	
	/* Method to get number of moves */
	public static int getCount() {
		return count;
	}

    /* Method to set the number of moves to a given value */
	public static void setCount(int count) {
		TicTacToeModel.count = count;
	}


}
