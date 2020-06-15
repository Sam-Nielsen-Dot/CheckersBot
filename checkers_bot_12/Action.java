import java.util.ArrayList;
import java.util.*; 
import java.util.Collections;

class Action implements Comparable<Action>{
	public String direction;
	public Node self;
	public int win;

	public Action(Node k, String direction) {
		self = k;
		this.direction = direction;
		win = 0;
	}

	public void setWin(int k) {
		win = k;
	}

	public int compareTo(Action e) {
		if (e.win == win){
			//if (e.direction.equals("up") || e.direction.equals("upright")|| e.direction.equals("upleft")){
				//return -1;
			//}else{
				//return 0;
			//}
			return 0;
		}else if (win <= e.win){
			return -1;
		}else{
			return 1;
		}
	}

	public String toString(){
		return direction + ", " + win;
	}

	public boolean equals(Action a){
		if (this.direction == a.direction && this.self.equals(a.self)){
			return true;
		}else{
			return false;
		}
	}
}