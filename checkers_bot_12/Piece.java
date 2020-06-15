
class Piece{
  private String name;
	public String unicode;

  public Piece(String name){
    this.name = name;
		this.unicode = " ";
  }
  public boolean equals(Piece k){
    return true;
  }
  public String toString(){
    return name;
  }

	public void setUnicode(String uni){
		this.unicode = uni;
	}
	public String getName(){
		return name;
	}
}
