package com.example.abhishekyadav.autodrow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class first extends AppCompatActivity {
Paint paint;
    Point point1,point2;
    Path path;
    List<Path> paths =new ArrayList<Path>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Panel(this));

    }
    class Panel extends View implements View.OnTouchListener
    {
public Panel(Context context)
{
    super(context);
    paint=new Paint();
    paint.setColor(Color.RED);
    paint.setStrokeWidth(10);
    paint.setStyle(Paint.Style.STROKE);
    this.setOnTouchListener(this);

}
        @Override
        public void onDraw(Canvas canvas)
        {
            canvas.drawColor(Color.WHITE);
            for(Path path:paths)
            {
                canvas.drawPath(path,paint);
            }

        }
        @Override
public  boolean onTouch(View view,MotionEvent event)
{
 if (event.getAction()==MotionEvent.ACTION_DOWN)
 {
     point1=new Point();
     point1.x=(int)event.getX();
     point1.y=(int)event.getY();
     path=new Path();
     path.moveTo(point1.x,point1.y);
 }
    else if(event.getAction()==MotionEvent.ACTION_MOVE)
 {
     point2=new Point();
     point2.x=(int)event.getX();
     point2.y=(int)event.getY();
     path.lineTo(point2.x,point2.y);
     paths.add(path);
     invalidate();


 }
    return  true;
        }
    }
}
