package shootgame;

import javax.imageio.*;
import java.util.Random;
import javax.swing.*;

/*
 * ������
 */
public class Bee extends FlyingObject implements Gift{
	private int xspeed = 1;
	private int yspeed = 2;	
	private int gift;
	public Bee(){
		image = Shootgame.bee;
		width = image.getWidth(null);
		height = image.getHeight(null);
		Random ran = new Random();
//		System.out.println(Shootgame.w_width-width);
		x=ran.nextInt(Shootgame.w_width-width);
		y = height;
		gift = ran.nextInt(2);
	}
	public void move(){
		if(x >= Shootgame.w_width-width){
			x -= xspeed;
		}else{
			x += xspeed;
		}
		y += yspeed;
	}
	
	public int gifttohero(){
		return gift; //GIFT ֻ��0 ���� 1 0��ʱ��˫��������1��ʱ�� ��һ����.
	}
	
	public int socretohero(){//�����littlefly�õġ�
		return 0;
	}
}
