package fr.dubois.space.invader;
import android.graphics.Bitmap;
import fr.dubois.space.invader.Sprite;


public class Alien extends Sprite {

	public Alien(Bitmap bitmap, float x, float y) {
		super(bitmap, x, y);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void act() {
		x = x+2;
		// TODO Auto-generated method stub
		
	}

}
