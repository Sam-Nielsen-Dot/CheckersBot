import java.util.ArrayList;
class Node{
  private Node up;
  private Node down;
  private Node left;
  private Node right;

  private Piece value;

  public Node(Piece e){
    value = e;
  }

  public boolean equals(Node k){
    if (k.getValue().equals(value)){
      return true;
    }else{
      return false;
    }
  }

  public String toString(){
    if (value == null){
      return "null";
    }else{
      return value.toString();
    }
  }

  public String print(){
    return "Value: " + value + "\nUp: " + up + "\nDown: " + down  +"\nLeft: " + left + "\nRight: " + right;
  }

  public void setUp(Node up){
    this.up = up;
  }

  public void setValue(Piece e){
    value = e;
  }

  public Piece getValue(){
    return value;
  }

  public void setDown(Node down){
    this.down = down;
  }

  public void setLeft(Node left){
    this.left = left;
  }

  public void setRight(Node right){
    this.right = right;
  }

  public Node getUp(){
    return up;
  }

  public Node getDown(){
    return down;
  }

  public Node getLeft(){
    return left;
  }

  public Node getRight(){
    return right;
  }

  public Node moveUp(){
    this.getUp().setValue(value);
    this.setValue(new Piece(" "));
    return getUp();
  }

  public Node moveDown(){
    this.getDown().setValue(value);
    this.setValue(new Piece(" "));
    return getDown();
  }

	public Node moveUpRight(){
		this.moveRight();
		this.right.moveUp();
		return this.right.getUp();
	}

	public Node moveUpLeft(){
		this.moveLeft();
		this.left.moveUp();
		return this.left.getUp();
	}

	public Node moveDownLeft(){
		this.moveLeft();
		this.left.moveDown();
		return this.left.getDown();
	}

	public Node moveDownRight(){
		this.moveRight();
		this.right.moveDown();
		return this.right.getDown();
	}

  public Node moveLeft(){
    this.getLeft().setValue(value);
    this.setValue(new Piece(" "));
    return getLeft();
  }

  public Node moveRight(){
    this.getRight().setValue(value);
    this.setValue(new Piece(" "));
    return getRight();
  }

	public ArrayList<Action> getMoves(String x){
		ArrayList<Action> returnArr = new ArrayList<Action>();
		Node downright = null;
		Node downleft = null;
		Node upleft = null;
		Node upright = null;
		if (value.getName().equals(x)){
			/*
			if (left != null && !(left.getValue().getName().equals(x)) && left.getValue() != null){
				returnArr.add(new Action(this, "left"));
			}
			if (right != null && !(right.getValue().getName().equals(x)) && right.getValue() != null){
				returnArr.add(new Action(this, "right"));
			}*/
			if (up != null && !(up.getValue().getName().equals(x)) && up.getValue() != null){
				//returnArr.add(new Action(this, "up"));
				if (up.getRight() != null && !(up.getRight().getValue().getName().equals(x)) && up.getRight().getValue().getName().equals(" ")){
						returnArr.add(new Action(this, "upright"));
						//System.out.println("yo");
				}if (up.getLeft() != null && !(up.getLeft().getValue().getName().equals(x)) && up.getLeft().getValue().getName().equals(" ")){
					returnArr.add(new Action(this, "upleft"));
				}
			}
			if (down != null && !(down.getValue().getName().equals(x)) && down.getValue() != null){
				//returnArr.add(new Action(this, "down"));
				if (down.getRight() != null && !(down.getRight().getValue().getName().equals(x)) && down.getRight().getValue().getName().equals(" ")){
						returnArr.add(new Action(this, "downright"));
				}if (down.getLeft() != null && !(down.getLeft().getValue().getName().equals(x)) && down.getLeft().getValue().getName().equals(" ")){
					returnArr.add(new Action(this, "downleft"));
				}
			}
///*
			//Stuff for checkers
			String playerK;
			if (x.equals("x")){
				playerK = "o";
			}else{
				playerK = "x";
			}
			if (up != null && !(up.getValue().getName().equals(x)) && up.getValue() != null){
				//returnArr.add(new Action(this, "up"));
				if (up.getRight() != null && !(up.getRight().getValue().getName().equals(x)) && up.getRight().getValue().equals(playerK)){
						returnArr.add(new Action(this, "upright"));
						upright = up.getRight();
				}if (up.getLeft() != null && !(up.getLeft().getValue().getName().equals(x)) && up.getLeft().getValue().equals(playerK)){
					returnArr.add(new Action(this, "upleft"));
					upleft = up.getRight();
				}
			}
			if (down != null && !(down.getValue().getName().equals(x)) && down.getValue() != null){
				//returnArr.add(new Action(this, "down"));
				if (down.getRight() != null && !(down.getRight().getValue().getName().equals(x)) && down.getRight().getValue().equals(playerK)){
						returnArr.add(new Action(this, "downright"));
						downright = down.getRight();
				}if (down.getLeft() != null && !(down.getLeft().getValue().getName().equals(x)) && down.getLeft().getValue().equals(playerK)){
					returnArr.add(new Action(this, "downleft"));
					downleft = down.getLeft();
				}
			}
			if (upright != null && upright.getDiagonal("upright")!= null && upright.getDiagonal("upright").getValue().equals(" ")){
				returnArr.add(new Action(this, "upupright"));
			}else if (upleft != null && upleft.getDiagonal("upleft")!= null && upleft.getDiagonal("upleft").getValue().equals(" ")){
				returnArr.add(new Action(this, "upupleft"));
			}else if (downright != null && downright.getDiagonal("downright")!= null && downright.getDiagonal("downright").getValue().equals(" ")){
				returnArr.add(new Action(this, "downdownright"));
			}else if (downleft != null && downleft.getDiagonal("downleft")!= null && downleft.getDiagonal("downleft").getValue().equals(" ")){
				returnArr.add(new Action(this, "downdownleft"));
			}//*/
		}
		for (Action a : returnArr){
			//System.out.println(a.toString());
		}
		//end of stuff for checkers
		return returnArr;
	}

	public Node getDiagonal(String direction){
		if (direction.equals("upright") && this.getRight() != null && this.getRight().getUp() != null){
			return this.getRight().getUp();
		}else if (direction.equals("upleft") && this.getUp() != null && this.getUp().getLeft() != null){
			return this.getUp().getLeft();
		}else if (direction.equals("downleft") && this.getDown() != null && this.getDown().getLeft() != null){
			return this.getDown().getLeft();
		}else if (direction.equals("downright") && this.getRight() != null && this.getRight().getDown() != null){
			return this.getRight().getDown();
		}else{
			return null;
		}
	}


}