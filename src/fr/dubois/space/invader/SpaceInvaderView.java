package fr.dubois.space.invader;




import com.example.android.snake.SnakeView.RefreshHandler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;

import android.graphics.drawable.Drawable;

import android.util.AttributeSet;
import android.view.View;

public class SpaceInvaderView extends View {
	
	// Dimensions souhaitées
	private static final int TARGET_HEIGHT = 800;
	private static final int TARGET_WIDTH = 600;

	private Bitmap alienbitmap;
	

	private Paint paint; // Style pour le texte	

	private String text; // texte a afficher

	Alien alien;


	public SpaceInvaderView(Context context) {
		super(context);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SpaceInvaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	void init(){

		paint = new Paint();
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.YELLOW);
		paint.setTypeface(Typeface.SANS_SERIF);
		paint.setTextSize(36);
		paint.setTextAlign(Paint.Align.CENTER);
		text = "Texte";
		alienbitmap = loadImage(R.drawable.alien1);
		alien = new Alien (alienbitmap, 0,0);
	}

	
	
	

	
	
	/*
	 M�thode loadImage()
	 Obtention du drawable � partir de l'identifiant
	 D�finition de la taille intrins�que du drawable dans les variables x et y
	 Cr�ation d'un bitmap aux dimensions intrins�ques, et du caneva associ�
	 D�finition de la taille du trac�, et trac�, et trac� de l'image
	 Retour de l'image cr��e
	 */
	public Bitmap loadImage(int id) {
		
		Drawable tmp = this.getContext().getResources().getDrawable(id);
        int x=tmp.getIntrinsicWidth();
		int y=tmp.getIntrinsicHeight();
		
		Bitmap bitmap = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        
        //Drawable image = null;
		tmp.setBounds(0, 0, x, y);
        tmp.draw(canvas);
        
        return bitmap;
    }
	
	
	

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawRGB(0, 0, 0);
		canvas.drawRect(0, 0, TARGET_WIDTH-1, TARGET_HEIGHT-1, paint);
		alien.draw(canvas);
		if (text != null){
			canvas.drawText(text, canvas.getWidth()/2,canvas.getHeight()/2, paint);
		}
		alien.draw(canvas);
		
	}


	private int computeSize(int spec,int def){
		int mode = View.MeasureSpec.getMode(spec);
		if (mode == View.MeasureSpec.UNSPECIFIED) return def;
		int size = View.MeasureSpec.getSize(spec);
		if (mode == View.MeasureSpec.EXACTLY) {
			return size;
		}
		//		MeasureSpec.AT_MOST
		if (size < def ) return size;
		return def;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int x = computeSize(widthMeasureSpec, TARGET_WIDTH);
		int y = computeSize(heightMeasureSpec, TARGET_HEIGHT);
		this.setMeasuredDimension(x,y);
		

	}
	private RefreshHandler mRedrawHandler = new RefreshHandler();
	
	
	
}








