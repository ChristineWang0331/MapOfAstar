package com.tristan.astar;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.util.DisplayMetrics;
import android.view.View;

public class TestForAstar extends View{
	private int x,y;
	private Point src;
	private Point dst;
	private ArrayList<Point> path;
	private Barrier barrier;
	private ArrayList<Point> barrierPath;
	
	//我也加了一句注释，测试一下
	
	//获取屏幕的像素点密度
	DisplayMetrics metric = new DisplayMetrics();
	private float density = metric.density;
	
	public TestForAstar(Context context) {
		super(context);
		initialBarrier();
		this.barrierPath = this.barrier.getBarrierPoint();
		this.src = new Point(75,350);
		this.dst = new Point(200,50);
		GraphForAstar test = new GraphForAstar(500, 250, barrier, src, dst);
		test.calculatePath();
		this.path = test.getFinalPath();
	}
	
	public TestForAstar(Context context,Barrier barrier,Point src,Point dst) {
		super(context);
		this.src = src;
		this.dst = dst;
		GraphForAstar test = new GraphForAstar(500, 250, barrier, src, dst);
		test.calculatePath();
		this.path = test.getFinalPath();
	}
	
	private void drawDpPoint(Canvas canvas,Point point,Paint paint){
		int u = 3;
		x=(point.x+20)*u;
		y=(point.y+30)*u;
		canvas.drawPoint(x,y,paint);
	}
	
	
	private void drawDpPoint(Canvas canvas,ArrayList<Point> points,Paint paint){
		int u = 3;
		for(Point p:points){
			x=(p.x+20)*u;
			y=(p.y+30)*u;
			canvas.drawPoint(x,y,paint);
		}
	}
	
	//初始化barrier类
	private void initialBarrier(){
		this.barrier = new Barrier();
		for(int i = 100; i<=300 ; i++){
			this.barrier.addBarrierPoint(new Point(50,i));
		}
		for(int i = 300; i<=400 ; i++){
			this.barrier.addBarrierPoint(new Point(100,i));
		}
		for(int i = 100; i<=400 ; i++){
			this.barrier.addBarrierPoint(new Point(150,i));
		}
		for(int i = 50; i<=150 ; i++){
			this.barrier.addBarrierPoint(new Point(i,100));
		}
		for(int i = 50; i<=100 ; i++){
			this.barrier.addBarrierPoint(new Point(i,300));
		}
		for(int i = 100; i<=150 ; i++){
			this.barrier.addBarrierPoint(new Point(i,400));
		}
	}
	

	
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 设置图层的背景色
		canvas.drawColor(Color.TRANSPARENT);
		// 添加画笔
		Paint paint_Point = new Paint();
		paint_Point.setAntiAlias(true); // 抗锯齿
		paint_Point.setStrokeWidth(20); // 设置画笔宽度
		paint_Point.setStyle(Style.STROKE);
		paint_Point.setColor(Color.RED); // 画笔的颜色
		paint_Point.setStrokeCap(Cap.SQUARE);//圆头的画笔头
		
		Paint paint_Line = new Paint();
		paint_Line.setAntiAlias(true); // 抗锯齿
		paint_Line.setStrokeWidth(8); // 设置画笔宽度
		paint_Line.setStyle(Style.STROKE);
		paint_Line.setColor(Color.RED); // 画笔的颜色
		paint_Line.setStrokeCap(Cap.ROUND);//圆头的画笔头
		
		Paint paintBarrier = new Paint();
		paintBarrier.setAntiAlias(true); // 抗锯齿
		paintBarrier.setStrokeWidth(10); // 设置画笔宽度
		paintBarrier.setStyle(Style.STROKE);
		paintBarrier.setColor(Color.BLACK); // 画笔的颜色
		paintBarrier.setStrokeCap(Cap.ROUND);//圆头的画笔头
		
		//用较粗的点画出起点和终点
		drawDpPoint(canvas, src, paint_Point);
		drawDpPoint(canvas, dst, paint_Point);
		drawDpPoint(canvas, this.barrierPath, paintBarrier);
		//用较细的点画出astar算法给出的轨迹点
		drawDpPoint(canvas, path, paint_Line);
		
	}
	
}
