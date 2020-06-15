
//\u265A Black King
//\u2654 White King
import java.util.Scanner;  // Import the Scanner class

class Main {
  public static void main(String[] args) {
    Board mainBoard = new Board(8, 8);
    //mainBoard.print();
    mainBoard.printBoard();
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	//	mainBoard.result(null, mainBoard);
		//System.out.println("Welcome to motherfucking checkers n00b");
		
		System.out.println("You are player o");
		mainBoard.doAction(mainBoard.minimax(mainBoard));
    System.out.println("______________________________");
		mainBoard.printBoard();
		mainBoard.switchPlayer();
		/*
		while (mainBoard.endstate(mainBoard) != true){
			mainBoard.printBoard();
			mainBoard.doAction(mainBoard.minimax(mainBoard));
			mainBoard.switchPlayer();
			System.out.println();
			System.out.println("__________________________");
		}
		*/
		boolean isIn = false;
		
    while(true){
			if(mainBoard.endstate(mainBoard)){
				System.out.println("Its Fucking over noobs");
			}
    System.out.print("Enter xcoordinates of target piece: ");
    String answer = myObj.nextLine();  // Read user input
    int xCo = Integer.parseInt(answer);
    xCo--;
    System.out.print("Enter y coordinates of target piece: ");

    answer = myObj.nextLine();  // Read user input
    int yCo = Integer.parseInt(answer);
    yCo--;
    System.out.print("Direction: ");
    answer = myObj.nextLine();
		if (mainBoard.getNode(xCo, yCo).getValue().getName().equals("o")){
			//for (Action a :mainBoard.getNode(xCo, yCo).getMoves("o")){
				//if (a.equals(new Action(mainBoard.getNode(xCo, yCo), answer))){
					//isIn = true;
				//}
			//}if (isIn){
				mainBoard.doAction(new Action(mainBoard.getNode(xCo, yCo), answer));
			//}
			
			/*
    if (answer.equals("up")){
      mainBoard.getNode(xCo, yCo).moveUp();
    }
    else if (answer.equals("down")){
      mainBoard.getNode(xCo, yCo).moveDown();
    }
    else if (answer.equals("left")){
      mainBoard.getNode(xCo, yCo).moveLeft();
    }
    else if (answer.equals("right")){
      mainBoard.getNode(xCo, yCo).moveRight();
    }
    else if (answer.equals("upright")){
      mainBoard.getNode(xCo, yCo).moveUpRight();
    }
    else if (answer.equals("downright")){
      mainBoard.getNode(xCo, yCo).moveDownRight();
    }
    else if (answer.equals("upleft")){
      mainBoard.getNode(xCo, yCo).moveUpLeft();
    }
    else if (answer.equals("downleft")){
      mainBoard.getNode(xCo, yCo).moveDownLeft();
    }*/
    
    //else{
      //System.out.println("Not a valid answer");
    
		}else{
			System.out.println("Not your piece");
		}
    //clearScreen();
    mainBoard.printBoard();
		mainBoard.switchPlayer();
		mainBoard.doAction(mainBoard.minimax(mainBoard));
		mainBoard.switchPlayer();
		System.out.println();
		System.out.println("______________________________");
		mainBoard.printBoard();
    }

		//public static void clearScreen() {
    //System.out.print("\033[H\033[2J");
    //System.out.flush();
  	//}

  }
}