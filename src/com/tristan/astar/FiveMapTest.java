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

public class FiveMapTest extends View{
	private int x,y;
	private Point[] src;
	private Point dst;
	private ArrayList<Point>[] path;
	private Barrier barrier;
	private ArrayList<Point> barrierPath;
	
	//��ȡ��Ļ�����ص��ܶ�
	DisplayMetrics metric = new DisplayMetrics();
	private float density = metric.density;
	
	public FiveMapTest(Context context) {
		super(context);
		initialBarrier();
		this.barrierPath = this.barrier.getBarrierPoint();
		this.path=new ArrayList[4];
		for(int i=0;i<4;i=i+1){
			path[i]=new ArrayList<Point>(4);
		}
	    this.src=new Point[4];
	    this.src[0]=new Point(130,180);
	    this.src[1]=new Point(200,300);
	    this.src[2]=new Point(200,200);
	    this.src[3]=new Point(140,270);		
	    Rallyp smid=new Rallyp(src);
	    dst=smid.getmid(src, barrier);
	
		for(int i=0;i<4;i=i+1){
		GraphForAstar test = new GraphForAstar(500, 250, barrier, src[i], dst);
		test.calculatePath();
		this.path[i] = test.getFinalPath();
		}
	    
	}
	
	public FiveMapTest(Context context,Barrier barrier,Point[] src,Point dst) {
		super(context);
		this.src = src;
		this.dst = dst;
		for(int i=0;i<4;i=i+1){
		GraphForAstar test = new GraphForAstar(500, 250, barrier, src[i], dst);
		test.calculatePath();
		this.path[i] = test.getFinalPath();
		}
	    
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
	
	//��ʼ��barrier��
	private void initialBarrier(){
		this.barrier = new Barrier();
		//5¥¥��
		//����һ��

		for(int i = 140; i<=166 ; i++){
			this.barrier.addBarrierPoint(new Point(i,4));
		}
		//5¥�����Ҽ���̨
		//�����õ�ע��
		for(int i = 5; i<=72 ; i++){
			this.barrier.addBarrierPoint(new Point(140,i));
		}
		for(int i = 22; i<=139 ; i++){
			this.barrier.addBarrierPoint(new Point(i,29));
		}
		for(int i = 30; i<=72 ; i++){
			this.barrier.addBarrierPoint(new Point(22,i));
		}
		for(int i = 23; i<=34 ; i++){
			this.barrier.addBarrierPoint(new Point(i,72));
		}
		for(int i = 73; i<=129 ; i++){
			this.barrier.addBarrierPoint(new Point(34,i));
		}
		for(int i = 72; i<=128 ; i++){
			this.barrier.addBarrierPoint(new Point(121,i));
		}
		for(int i = 35; i<=121 ; i++){
			this.barrier.addBarrierPoint(new Point(i,129));
		}
		for(int i = 122; i<=140 ; i++){
			this.barrier.addBarrierPoint(new Point(i,104));
		}
		for(int i = 122; i<=140 ; i++){
			this.barrier.addBarrierPoint(new Point(i,120));
		}
		for(int i = 105; i<=166 ; i++){
			this.barrier.addBarrierPoint(new Point(140,i));
		}
		//501����
		for(int i = 167; i<=241 ; i++){
			this.barrier.addBarrierPoint(new Point(i,37));
		}
		for(int i = 4; i<=114 ; i++){
			this.barrier.addBarrierPoint(new Point(166,i));
		}
		
		for(int i = 38; i<=120 ; i++){
			this.barrier.addBarrierPoint(new Point(241,i));
		}
		for(int i = 167; i<=240 ; i++){
			this.barrier.addBarrierPoint(new Point(i,120));
		}
		//504�칫��
		for(int i = 121; i<=167 ; i++){
			this.barrier.addBarrierPoint(new Point(i,167));
		}
		for(int i = 168; i<=192 ; i++){
			this.barrier.addBarrierPoint(new Point(121,i));
		}
		for(int i = 122; i<=166 ; i++){
			this.barrier.addBarrierPoint(new Point(i,192));
		}
		for(int i = 177; i<=192 ; i++){
			this.barrier.addBarrierPoint(new Point(167,i));
		}
		//506�칫��
		for(int i = 193; i<=217 ; i++){
			this.barrier.addBarrierPoint(new Point(121,i));
		}
		for(int i = 122; i<=166 ; i++){
			this.barrier.addBarrierPoint(new Point(i,217));
		}
		for(int i = 193; i<=209 ; i++){
			this.barrier.addBarrierPoint(new Point(167,i));
		}
		for(int i = 215; i<=219 ; i++){
			this.barrier.addBarrierPoint(new Point(167,i));
		}
		//508�칫��
		for(int i = 218; i<=241 ; i++){
			this.barrier.addBarrierPoint(new Point(121,i));
		}
		for(int i = 225; i<=258 ; i++){
			this.barrier.addBarrierPoint(new Point(167,i));
		}
        for(int i = 122; i<=166 ; i++){			
			this.barrier.addBarrierPoint(new Point(i,241));
		}
        //510�칫��
        for(int i = 242; i<=266 ; i++){
			this.barrier.addBarrierPoint(new Point(121,i));
		}
        for(int i = 122; i<=166 ; i++){
			this.barrier.addBarrierPoint(new Point(i,266));
		}
		for(int i = 264; i<=266 ; i++){
			this.barrier.addBarrierPoint(new Point(167,i));
		}
		//5¥ϴ�ּ�
		for(int i = 267; i<=318 ; i++){
			this.barrier.addBarrierPoint(new Point(121,i));
		}
		for(int i = 280; i<=304 ; i++){
			this.barrier.addBarrierPoint(new Point(150,i));
		}
		for(int i = 304; i<=318 ; i++){
			this.barrier.addBarrierPoint(new Point(167,i));
		}
		for(int i = 122; i<=149 ; i++){
			this.barrier.addBarrierPoint(new Point(i,291));
		}
		for(int i = 156; i<=166 ; i++){
			this.barrier.addBarrierPoint(new Point(i,280));
			this.barrier.addBarrierPoint(new Point(i,304));
		}
		for(int i = 267; i<=280 ; i++){
			this.barrier.addBarrierPoint(new Point(167,i));
		}	
		for(int i = 103; i<=167 ; i++){
			this.barrier.addBarrierPoint(new Point(i,319));
		}
		//5¥��¥��
		for(int i = 320; i<=344 ; i++){
			this.barrier.addBarrierPoint(new Point(103,i));
		}
		for(int i = 104; i<=149 ; i++){
			this.barrier.addBarrierPoint(new Point(i,344));
		}
		for(int i = 345; i<=385 ; i++){
			this.barrier.addBarrierPoint(new Point(149,i));
		}
		//517ʵ����
		for(int i = 103; i<=152 ; i++){
			this.barrier.addBarrierPoint(new Point(i,385));
		}
		for(int i = 167; i<=198 ; i++){
			this.barrier.addBarrierPoint(new Point(i,385));
		}
		for(int i = 213; i<=223 ; i++){
			this.barrier.addBarrierPoint(new Point(i,385));
		}
		for(int i = 386; i<=485 ; i++){
			this.barrier.addBarrierPoint(new Point(103,i));
		}
		for(int i = 104; i<=223 ; i++){
			this.barrier.addBarrierPoint(new Point(i,485));
		}
		for(int i = 104; i<=169 ; i++){
			this.barrier.addBarrierPoint(new Point(i,475));
		}
		for(int i = 476; i<=484 ; i++){
			this.barrier.addBarrierPoint(new Point(149,i));
		}
		for(int i = 476; i<=484 ; i++){
			this.barrier.addBarrierPoint(new Point(169,i));
		}
		for(int i = 369; i<=485 ; i++){
			this.barrier.addBarrierPoint(new Point(223,i));
		}
		//505ʵ����
		for(int i = 121; i<=146 ; i++){
			this.barrier.addBarrierPoint(new Point(241,i));
		}
		for(int i = 188; i<=240 ; i++){
			this.barrier.addBarrierPoint(new Point(i,146));
		}
		for(int i = 126; i<=169 ; i++){
			this.barrier.addBarrierPoint(new Point(187,i));
		}
		//507ʵ����
		for(int i = 167; i<=217 ; i++){
			this.barrier.addBarrierPoint(new Point(241,i));
		}
		for(int i = 177; i<=219 ; i++){
			this.barrier.addBarrierPoint(new Point(187,i));
		}
		for(int i = 188; i<=240 ; i++){
			this.barrier.addBarrierPoint(new Point(i,167));
		}
		for(int i = 188; i<=240 ; i++){
			this.barrier.addBarrierPoint(new Point(i,217));
		}
		//509ʵ����
		for(int i = 227; i<=268 ; i++){
			this.barrier.addBarrierPoint(new Point(187,i));
		}
		for(int i = 218; i<=266 ; i++){
			this.barrier.addBarrierPoint(new Point(241,i));
		}
		for(int i = 188; i<=240 ; i++){
			this.barrier.addBarrierPoint(new Point(i,266));
		}
		//511ʵ����
		for(int i = 276; i<=360 ; i++){
			this.barrier.addBarrierPoint(new Point(187,i));
		}
		for(int i = 267; i<=319 ; i++){
			this.barrier.addBarrierPoint(new Point(241,i));
		}
		for(int i = 188; i<=240 ; i++){
			this.barrier.addBarrierPoint(new Point(i,319));
		}		
		//513ʵ����
		for(int i = 320; i<=368 ; i++){
			this.barrier.addBarrierPoint(new Point(241,i));
		}
		for(int i = 187; i<=240 ; i++){
			this.barrier.addBarrierPoint(new Point(i,368));
		}
	}
	

	
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// ����ͼ��ı���ɫ
		canvas.drawColor(Color.TRANSPARENT);
		// ��ӻ���
		Paint paint_Pointsrc = new Paint();
		paint_Pointsrc.setAntiAlias(true); // �����
		paint_Pointsrc.setStrokeWidth(20); // ���û��ʿ��
		paint_Pointsrc.setStyle(Style.STROKE);
		paint_Pointsrc.setColor(Color.RED); // ���ʵ���ɫ
		paint_Pointsrc.setStrokeCap(Cap.SQUARE);//Բͷ�Ļ���ͷ
		
		Paint paint_Pointdst = new Paint();
		paint_Pointdst.setAntiAlias(true); // �����
		paint_Pointdst.setStrokeWidth(20); // ���û��ʿ��
		paint_Pointdst.setStyle(Style.STROKE);
		paint_Pointdst.setColor(Color.BLUE); // ���ʵ���ɫ
		paint_Pointdst.setStrokeCap(Cap.SQUARE);//Բͷ�Ļ���ͷ
		
		Paint paint_Line = new Paint();
		paint_Line.setAntiAlias(true); // �����
		paint_Line.setStrokeWidth(4); // ���û��ʿ��
		paint_Line.setStyle(Style.STROKE);
		paint_Line.setColor(Color.RED); // ���ʵ���ɫ
		paint_Line.setStrokeCap(Cap.ROUND);//Բͷ�Ļ���ͷ
		
		Paint paintBarrier = new Paint();
		paintBarrier.setAntiAlias(true); // �����
		paintBarrier.setStrokeWidth(4); // ���û��ʿ��
		paintBarrier.setStyle(Style.STROKE);
		paintBarrier.setColor(Color.BLACK); // ���ʵ���ɫ
		paintBarrier.setStrokeCap(Cap.ROUND);//Բͷ�Ļ���ͷ
		
		//�ýϴֵĵ㻭�������յ�
		
		drawDpPoint(canvas, dst, paint_Pointdst);
		drawDpPoint(canvas, this.barrierPath, paintBarrier);
		//�ý�ϸ�ĵ㻭��astar�㷨�����Ĺ켣��
		for(int i=0;i<4;i=i+1){
		drawDpPoint(canvas, src[i], paint_Pointsrc);
		drawDpPoint(canvas, path[i], paint_Line);
		}
		
	}
	
}