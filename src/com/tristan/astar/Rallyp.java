package com.tristan.astar;
import java.awt.*;
import java.util.ArrayList;

import android.graphics.Point;
//找到距某点的最大值最小值的方法
class Extreme{
	public int getmax(int[] x){
		int temp=x[0];
		for(int i=0;i<x.length;i=i+1){
			temp=temp>x[i]?temp:x[i];
		}
		return temp;
	}
	public int getmin(int[] x){
		int temp=x[0];
		for(int i=0;i<x.length;i=i+1){
			temp=temp<x[i]?temp:x[i];
		}
		return temp;
	}
}
//判断某元素是否在数组或列表中
class Judgempty{
	public boolean judgempty(int[] x,int y){
	    for(int i=0;i<x.length;i=i+1){
	    	if(y==x[i]){
	    		return true;
	    	}
	    }	    
	    return false;
	}
	public boolean judgempty(ArrayList<Point> a,Point b){
		if(a.contains(b)){
			return true;
		}
		else{
			return false;
		}
	    }
}
class Diffvalue2{
	//比较每一个位置到中心点的路径长度（利用A*获得的）
	public boolean Diffvalue2(Point[] sites,Point mid,Barrier barrier){		
		int[] d=new int[sites.length];
		for(int i=0;i<sites.length;i=i+1){
			GraphForAstar test=new GraphForAstar(500,250,barrier,sites[i],mid);
			test.calculatePath();
			ArrayList<Point> finalPath = test.getFinalPath();
			d[i] = finalPath.size();
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

public class Rallyp {
	private Point mid;
	Diffvalue2 test1=new Diffvalue2();
	//找到一个初始中心的位置，横坐标为最大最小横坐标的平均值，纵坐标为最大最小纵坐标的平均值
	public  Rallyp(Point[] sites){
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
	    while(test1.Diffvalue2(sites,mid,barrier)!=true||barrier3.contains(mid)==true){
		  		mid=traversal(sites,mid,barrier);
	  	}
	    return  mid;
	}
	 //遍历周围邻点，当不属于障碍且到四个点路径差在一定范围内时，符合要求
	public Point traversal(Point[] sites,Point mid,Barrier barrierP){
		Point mid2=new Point(mid.x,mid.y);
        Judgempty test=new Judgempty();
		ArrayList<Point> barrier2=barrierP.getBarrierPoint();
		int flag=0;
		//避免太近难以找到符合要求，5个为一单元
        for(int i=mid2.x-10;i<mid2.x+15;i=i+5){
          	  for(int j=mid2.y-10;j<mid2.y+15;j=j+5){
          		//如果是中间的点就跳过
    				if (i==mid2.x&&j==mid2.y) continue;
    				//如果是障碍中的点则跳过
    				if (test.judgempty(barrier2, new Point(i,j))==true) continue;
    				mid=new Point(i,j);
    				if(test1.Diffvalue2(sites,mid,barrierP)==true){
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


