import java.util.ArrayList;
import java.util.*; 
import java.util.Collections;

class Board{
  private Node[] list;
  private int length;
  private int width;
  private Node firstNode;
	public String player;

  public Board(int length, int width){
		player = "x";
    this.length = length;
    this.width = width;
    
    list = new Node[length*width];
    for (int k = 0; k< length*width; k++){
      list[k] = new Node(new Piece(" "));
    }
    firstNode = list[0];
    for (int k = 0; k<list.length; k++){
      if (k >= length){
        list[k].setUp(list[k-length]);
      }if (k < list.length-length){
        list[k].setDown(list[k+length]);
      }if ((k+1)%length != 1){
        list[k].setLeft(list[k-1]);
      }if ((k+1)%length != 0){
        list[k].setRight(list[k+1]);
      }
    }

		for(int k = 0; k<length; k+=2){
			 list[k].setValue(new Piece("o"));
			 list[k].getValue().setUnicode("o");
		}for (int k = length+1; k<length*2; k+=2){
			 list[k].setValue(new Piece("o"));
			 list[k].getValue().setUnicode("o");
		}for (int k = (length*(width-1))+1; k<length*width;k+=2){
			 list[k].setValue(new Piece("x"));
			 list[k].getValue().setUnicode("x");
		}for (int k = ((length*(width-1))-length); k<(length*(width-1)); k+=2){
			list[k].setValue(new Piece("x"));
			list[k].getValue().setUnicode("x");
		}for(int k = length*2; k<length*3; k+=2){
			 list[k].setValue(new Piece("o"));
			 list[k].getValue().setUnicode("o");
		}for (int k = ((length*(width-2))-length)+1; k<(length*(width-2)); k+=2){
			list[k].setValue(new Piece("x"));
			list[k].getValue().setUnicode("x");
		}
		/*
		list[(length*3)+length/2].setValue(new King("o", true));
		list[(length*3)+length/2-1].setValue(new King("o", true));
		list[(length*(width-3) + length/2)].setValue(new King("x", false));
		list[(length*(width-3) + length/2)-1].setValue(new King("x", false));
		*/
  }

  public void print(){
    for(Node k:list){
      System.out.println(k.print());
    }
  }

	public Node[] getList(){
		return list;
	}
	public void setList(Node[] list){
		this.list = list;
	}

	public void switchPlayer(){
		if (player.equals("x")){
			player = "y";
		}else{
			player = "x";
		}
	}

  public void printBoard(){
    for (int k = 0; k<width; k++){
      for (int l = 0; l<length; l++){
        if (list[(length*(k))+l].getValue() == null){
          System.out.print("[ ]");
        }else{
          System.out.print("["+list[(length*(k))+l].getValue().unicode+"]");
        }
      }
      System.out.println();
    }
  }
  public Node getNode(int xCo, int yCo){
    return list[yCo*length+xCo];
  }

	public int getX(Node w){
		for(int k = 0; k<list.length;k++){
			if (list[k] == w){
				return k%length;
			}
		}
		return 0;
	}

	public int getY(Node w){
		for(int k = 0; k<list.length;k++){
			if (list[k] == w){
				return (int) k/length;
			}
		}
		return 0;
	}

	public boolean endstate(Board mainBoard){
		int numX = 0;
		int numO = 0;
		for (Node k:mainBoard.getList()){
			if (k.getValue().getName().equals("x")){
				numX += 1;
			}else if(k.getValue().getName().equals("o")){
				numO += 1;
			}
		}
		return (numX==0 || numO == 0);
	}

	public int utility(Board mainBoard){
		int numX = 0;
		int numO = 0;
		for (Node k:mainBoard.getList()){
			if (k.getValue().getName().equals("x")){
				numX += 1;
				if (k.getClass().equals("King")){
				numX+=3;
				}
			}
			else if(k.getValue().getName().equals("o")){
				numO += 1;
				if (k.getClass().equals("King")){
				numO+=3;
				}
			}
		}
		if (numX > numO){
			return numX - numO;
		}else if(numO > numX){
			return 0 - (numO - numX);
		}else{
			return 0;
		}
	}

	public ArrayList<Action> actions(String x, Board mainBoard){
		ArrayList<Action> actions = new ArrayList<Action>();
		for (Node k:mainBoard.list){
			for (Action l:k.getMoves(player)){
				actions.add(l);
			}
		}
		return actions;

	}

	public void doAction(Action a){
		if (a != null){
		if (a.direction.equals("up")){
			a.self.moveUp();
		}else if (a.direction.equals("down")){
			a.self.moveDown();
		}else if (a.direction.equals("left")){
			a.self.moveLeft();
		}else if (a.direction.equals("right")){
			a.self.moveRight();
		}else if (a.direction.equals("upright")){
			a.self.moveUpRight();
		}else if (a.direction.equals("upleft")){
			a.self.moveUpLeft();
		}else if (a.direction.equals("downleft")){
			a.self.moveDownLeft();
		}else if (a.direction.equals("downright")){
			a.self.moveDownRight();
		}else if (a.direction.equals("downdownright")){
			a.self.moveDownRight().moveDownRight();
		}else if (a.direction.equals("downdownleft")){
			a.self.moveDownLeft().moveDownLeft();
		}else if (a.direction.equals("upupright")){
			a.self.moveUpRight().moveUpRight();
		}else{
			a.self.moveUpLeft().moveUpLeft();
		}
		}
	}
	
	
	public Board result(Action a, Board mainBoard){
		Board x = new Board(length, width);
		Node[] newList = new Node[list.length];
		for (int p = 0; p<list.length; p++){
			newList[p] = new Node(list[p].getValue());

		}
		for (int k = 0; k<list.length; k++){
      if (k >= length){
        newList[k].setUp(newList[k-length]);
      }if (k < newList.length-length){
        newList[k].setDown(newList[k+length]);
      }if ((k+1)%length != 1){
        newList[k].setLeft(newList[k-1]);
      }if ((k+1)%length != 0){
        newList[k].setRight(newList[k+1]);
      }
    }

		x.setList(newList);
		Action b = new Action(x.getNode(mainBoard.getX(a.self),mainBoard.getY(a.self)),a.direction);
		x.doAction(b);
		x.switchPlayer();
		return x;
	}

	public Action minimax(Board mainBoard){
		if (endstate(mainBoard)){
			return null;
		}
		ArrayList<Action> listOfActions = new ArrayList<Action>();
		Action po;
		int now;
		int then;
		for (Action a : actions(mainBoard.player, mainBoard)){
			//System.out.println(a.toString());
			if (mainBoard.player.equals("x")){
				po = a;
				po.setWin(Min(mainBoard.result(a, mainBoard), 1));
			}else{
				po = a;
				po.setWin(Max(mainBoard.result(a, mainBoard), 1));
			}
			listOfActions.add(po);
		}
		Collections.sort(listOfActions);
		Collections.reverse(listOfActions);
		for (Action a:listOfActions){
			now = utility(mainBoard);
			then = utility(result(a, mainBoard));
			if ((double) (now-then) > 0.5){
				return a;
			}
		}
		if (listOfActions.size()>0){
			return listOfActions.get(0);
		}else{

			return actions(mainBoard.player, mainBoard).get(0);
			//return null;
		}
	}

	public int Min(Board mainBoard, int count){
		if (endstate(mainBoard) || count > 5){
			return mainBoard.utility(mainBoard);
		}
		int v = 10;
		for (Action a:actions("o", mainBoard)){
			v = Math.min(v, Max(mainBoard.result(a, mainBoard), count+1));
			count +=1;
			
		}
		
		return v;
	}

	public int Max(Board mainBoard, int count){
		if (endstate(mainBoard)  || count > 5){
			return mainBoard.utility(mainBoard);
      
		}
		int v = -10;
		for (Action a:actions("x", mainBoard)){
			v = Math.max(v, Min(mainBoard.result(a, mainBoard), count+1));
			count +=1;
			
		}
		return v;
	}
}