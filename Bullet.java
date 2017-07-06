package shootgame;

public class Bullet extends FlyingObject{
	
	private int speed = 3;
	
	Bullet(){
		image = Shootgame.bullet;
		width = image.getWidth(null);
		height= image.getHeight(null);
		this.x= x;
		this.y= y;
		
	}
	public void move(){
		y -= speed;
	}
	public void move(int x1,int y1){
		
	}
}
