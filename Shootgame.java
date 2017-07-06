package shootgame;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Shootgame extends JPanel implements KeyListener{
	
	public static final int w_width = 400;
	public static final int w_height= 654;
	public static BufferedImage backgourd;
	public static BufferedImage herofly;
	public static BufferedImage herofly1;
	public static BufferedImage bee;
	public static BufferedImage littlefly;
	public static BufferedImage bullet;
	public  Herofly hero = new Herofly();
	public  Bullet[] bullets = {};
	public FlyingObject[] flyingobject={};

	
	 static{
		 try {
			backgourd = ImageIO.read(Shootgame.class.getResource("background.png"));
			herofly  = ImageIO.read(Shootgame.class.getResource("hero.png"));
			bee       = ImageIO.read(Shootgame.class.getResource("gift.png"));
			littlefly = ImageIO.read(Shootgame.class.getResource("littlefly.png"));
			bullet    = ImageIO.read(Shootgame.class.getResource("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
 public	Shootgame(){
//		bullets = new Bullet[1];
//		bullets[0] = new Bullet(200,300);
//		flyingobject = new FlyingObject[2];
//		flyingobject[0] = new Littlefly();
//		flyingobject[1] = new Bee();
	}
	public static void main(String[] arg){
		JFrame frame = new JFrame("wangyang");
		Shootgame game = new Shootgame();
		frame.add(game);
		frame.setSize(w_width,w_height);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addKeyListener(game);
		game.action();
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(backgourd,0,0,null);
//		g.drawImage(herofly,200,300,null);
		painthero(g);
		paintbullet(g);
		paintflyobject(g);
		
	}
	
	public void painthero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null);
	}
	
	public void paintbullet(Graphics g){
		for(int i=0;i<bullets.length;i++){
		g.drawImage(bullets[i].image,bullets[i].x,bullets[i].y,null);
		}
	}
	
	public void paintflyobject(Graphics g){
		for(int i=0;i<flyingobject.length;i++){
			g.drawImage(flyingobject[i].image,flyingobject[i].x,flyingobject[i].y,null);
		}
	}
	private Timer timer = new Timer();
	private int jiange = 10;
	public void action(){
		timer.schedule(new TimerTask(){
			public void run(){
				enteraction();
				moveaction();
				repaint();
			}
		}, jiange, jiange);
		
	}
	int flyindex =0;
	public void enteraction(){
		int num2 = flyindex++/20;
		if(num2 == 0 ){
			if(flyingobject.length < 1){
				flyingobject = new FlyingObject[1];
			}else{
				Arrays.copyOf(flyingobject, flyingobject.length+1);
			}
		Random rand = new Random();
		int id = rand.nextInt(5);
		if(id ==0){
			flyingobject[flyingobject.length-1] = new Bee();
		}else{
			flyingobject[flyingobject.length-1] = new Littlefly();
		}
//		Arrays.copyOf(bullets, bullets.length+1);
//		bullets[bullets.length-1] = new Bullet();
		}
	}
	public void moveaction(){
		for(int i=0;i<flyingobject.length;i++){
			flyingobject[i].move();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].move();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
