package com.jack.tree;

import java.util.Scanner;

public class Dijstarl {

	public static void main(String[] args) {
		int n , m , x;		//n表示n个点，m表示m条边。x表示要求最短路径的点

		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		x = cin.nextInt();

		//距离为了方便我就用数组了
		int value[][] = new int[n+1][n+1];		//表示n个点之间的权重  地图用的是邻接表 因为点太多了
		int dis[] = new int[n+1];		//表示存从x点到每个点的最短路径的

		//先初始化图。最开始都认为没有可以走的边
		for(int i=1;i<=n; i++) {
			dis[i] = Integer.MAX_VALUE;		//最开始没有最短距离 都是无穷大 也可以用-1表示
			for(int j =1; j<=n ;j++) {
				if(i == j) value[i][j] = 0 ;	//表示是自己
				else value[i][j] = -1;		//表示从i到j最开始是没有路的
			}
		}
		//接下来输入这个图上面的所有边
		for(int i=1;i<=m;i++) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			int weight = cin.nextInt();		//表示 a点到b点的距离为weight
			value[a][b] = weight;
			//在这里的时候就可以计算出要求最短路径的第一个点，因为第一个点进来就是直达就行了
			if(a == x) {		//表示是我们要求的那个点
				dis[b] = weight;
			}
		}
		dijkstra(x, dis, value, n);
	}

	public static void dijkstra(int x,int dis[],int value[][],int n) {
		boolean mark[] = new boolean[n+1];		//标记是不是已经加入过了
		for(int i = 1;i<=n;i++) {
			mark[i] = false;		//最开始是没有加的
		}
		dis[x] = 0;
		mark[x] = true;
		while(true) {	//如果每次都有点加进来 不是O（N） Nlogn
			//找离最近的那个点
			int min = Integer.MAX_VALUE;
			int loc = -1;		//存储最小的那个点
			for(int i =1; i<= n;i++) { //O(n)
				if(!mark[i] && dis[i] < min) {
					min = dis[i];
					loc = i;
				}
			}
			if(loc == -1)break;
			mark[loc] = true;
			for(int i = 1; i <= n;i++) {
				if(value[loc][i] != -1) {		//判断我们加进来的这个点能不能到i
					if(dis[loc] + value[loc][i] < dis[i]) {	//通过中转点能不能减少距离
						dis[i] = dis[loc] + value[loc][i];
					}
				}
			}
		}

		System.out.println(x + "点到每个点的最短距离如下所示：");
		for(int i = 1 ; i <= n;i++) {
			if(dis[i] != Integer.MAX_VALUE) {
				System.out.println("到" + i + "点的最短距离为：" +dis[i]);
			}else{
				System.out.println("不能到达" + i);
			}
		}
	}
}
