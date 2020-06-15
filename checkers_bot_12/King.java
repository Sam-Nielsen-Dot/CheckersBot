class King extends Piece{
	int value;

	public King(String player, boolean white){
		super(player);
		value = 3;
		if (white){
			this.setUnicode("\u2654");
		}else{
			this.setUnicode("\u265A");
		}
	}
}