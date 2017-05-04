package com.tristan.astar;
import java.awt.*;
import java.util.ArrayList;

import android.graphics.Point;
class Diffvalue{
	public boolean Diffvalue(Point[] sites,Point mid){
		
		int[] d=new int[sites.length];
		for(int i=0;i<sites.length;i=i+1){
			d[i]=Math.abs(sites[i].x-mid.x)+Math.abs(sites[i].y-mid.y);
		}
        Extreme getex=new Extreme();
        int dmax=getex.getmax(d);
        int dmin=getex.getmin(d);
		if(Math.abs(dmax-dmin)>80){
			return false;
		}
		else{
			return true;
		}
	}
}
public class RallyP2 {
	private Point mid;
	Diffvalue test1=new Diffvalue();
	//接收四个人间的位置信息，找到一个初始的中点，横纵坐标分别是最小横坐标与最大横坐标的中间值
	public  RallyP2(Point[] sites){
		  int[] x=new int[4];
		  int[] y=new int[4];
		  for(int i=0;i<4;i=i+1){
			  x[i]=sites[i].x;
			  y[i]=sites[i].y;
		  }
    	  Extreme xsite=new Extreme();
	      int xmin=xsite.getmin(x);
	      int xmax=xsite.getmax(x);
	      int ymin=xsite.getmin(y);
	      int ymax=xsite.getmax(y);
	      int xmid=(int)((xmin+xmax)/2);
	      int ymid=(int)((ymin+ymax)/2);
	      mid=new Point(xmid,ymid);
	  }
	//当初始中点不满足汇聚点，找其周围的点判断是否满足
	public Point getmid(Point[]sites,Barrier barrier){
		ArrayList<Point> barrier3=barrier.getBarrierPoint();
	    while(test1.Diffvalue(sites,mid)!=true||barrier3.contains(mid)==true){
		  		mid=traversal(sites,mid,barrier);
	  	}
	    return  mid;
	}
	
	  //遍历周围邻点，当不属于障碍且到四个点曼哈顿距离差在一定范围内时，符合要求
	  public Point traversal(Point[] sites,Point mid,Barrier barrierP){
		  Point mid2=new Point(mid.x,mid.y);
          Judgempty test=new Judgempty();
		  ArrayList<Point> barrier2=barrierP.getBarrierPoint();
		  int flag=0;
              for(int i=mid2.x-10;i<mid2.x+15;i=i+5){
            	  for(int j=mid2.y-10;j<mid2.y+15;j=j+5){
            		//如果是中间的点就跳过
      				if (i==mid2.x&&j==mid2.y) continue;
      				//如果是障碍中的点则跳过
      				if (test.judgempty(barrier2, new Point(i,j))==true) continue;
      				mid=new Point(i,j);
      				if(test1.Diffvalue(sites,mid)==true){
		                 flag=1;
		                 break;
      				}
            	  }
            	  if(flag==1){
            		  break;
            	  }
              }
           return mid;
          
	  }
}