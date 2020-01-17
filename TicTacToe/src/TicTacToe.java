import java.util.*; 
 
public class TicTacToe {
	
	static ArrayList <Integer> playerPositions = new ArrayList<Integer>() ;  
	static ArrayList <Integer> cpuPositions = new ArrayList<Integer>() ; 
	
	
	public static void main (String args []) {
		
		
		char [][] gameBoard = { {' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '} } ; 
		

		while (true) { 
			
			 
			
			Scanner scan = new Scanner(System.in) ; 
			int playerPos = scan.nextInt() ; 
			// if the position you want to enter "playerPos" is already filled with player positions or cpu positions try again
			while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
				System.out.println("Position Taken! Enter a correct position") ; 
				playerPos = scan.nextInt() ; 
			
			} 
			placePiece(gameBoard, playerPos, "player") ; 
			
			
			// Checks after player move to see if player has won 
			String result = checkWinner() ; 
			if (result.length() > 0) { 
				printGameBoard(gameBoard); 
				System.out.println(result); 
				break; 
			}
			
			
			Random rand = new Random() ; 
			int cpuPos = rand.nextInt(9) +1 ; 
			
			// if the cpu position "cpuPos" is already filled with player positions or cpu positions the cpu will try again 
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				cpuPos = rand.nextInt(9) +1 ; 
			
			}
			placePiece(gameBoard, cpuPos , "cpu") ; 
			
			// checks after cpu move to see if cpu has won 
			if (result.length() > 0) { 
				System.out.println(result); 
				printGameBoard(gameBoard); 
				break;
			}
			
			
			printGameBoard(gameBoard) ; 
		
		}
		
		
	}
	
	public static void placePiece(char [] [] gameBoard, int pos, String user) { 
		
		char symbol = ' ' ; 
		
		if (user.equals("player")) { 
			symbol = 'X' ;
			playerPositions.add(pos); 
		}
		else if (user.equals("cpu")) {
			symbol = 'O' ; 
			cpuPositions.add(pos); 
				
		}
		
		
		switch (pos) { 
			case 1 : 
				gameBoard[0][0]= symbol ; 
				break; 
				
			case 2 : 
				gameBoard[0][2]= symbol ; 
				break; 
				
			case 3 : 
				gameBoard[0][4]= symbol ; 
				break; 
				
			case 4 : 
				gameBoard[2][0]= symbol ; 
				break; 
				
			case 5 : 
				gameBoard[2][2]= symbol ; 
				break; 
				
			case 6 : 
				gameBoard[2][4]= symbol ; 
				break; 
				
			case 7 : 
				gameBoard[4][0]= symbol ; 
				break; 
				
			case 8 : 
				gameBoard[4][2]= symbol ; 
				break; 
				
			case 9 : 
				gameBoard[4][4]= symbol ; 
				break; 
			default: 
				break ; 
		}
		
		
		
	}
	
	public static void printGameBoard (char [][] gameBoard) {
		
		for (char[] row: gameBoard) { 
			for (char col: row) { 
				System.out.print(col); 
			}
			System.out.println(); 
		}
		
	}
	
	public static String checkWinner() { 
		
		//works based off of the cases, if it has case 1,2,3 filled then topRow is filled. 
		// describes the rows, will later be checked to see if you have won
		List topRow = Arrays.asList(1, 2, 3); 
		List midRow = Arrays.asList(4, 5, 6); 
		List botRow = Arrays.asList(7, 8, 9); 
		
		// describes the columns, will later be checked to see if you have won
		List leftCol = Arrays.asList(1, 4, 7) ; 
		List midCol = Arrays.asList(2, 5, 8) ; 
		List rightCol = Arrays.asList(3, 6, 9); 
		// describes the two diagonals, will later be checked to see if you have won 
		List cross1 = Arrays.asList(1, 5, 9) ; 
		List cross2 = Arrays.asList(7, 5, 3) ; 
		
		List<List> winning= new ArrayList<List>() ; 
		winning.add(topRow); 
		winning.add(midRow); 
		winning.add(botRow); 
		winning.add(leftCol); 
		winning.add(midCol); 
		winning.add(rightCol); 
		winning.add(cross1); 
		winning.add(cross2); 
		
		for (List l : winning) { 
			// playerPositions.containsAll(l) all checks if playerPositions contains all the components of l, such as if it contains all the
			// components of top row  
			if (playerPositions.containsAll(l)) {
				return "Congrats" ; 
			}
			// cpuPositions.containsAll(l) all checks if cpuPositions contains all the components of l, such as if it contains all the
			// components of top row  
			else if (cpuPositions.containsAll(l))  { 
				return ("You lost") ; 
			}
			else if (playerPositions.size() + cpuPositions.size() == 9) { 
				return "TIE!" ; 
			}
		}
		
		
		
		
		
		
		
		
		
		return ""; 	
	}
	
}
