package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	private ArrayList<String> vertexList;//存储顶点集合
	private int[][] edges;//存储图对应的邻接矩阵
	private int numOfEdges;//边的个数
	public static void main(String[] args) {
		int n  = 5;//节点个数
		String[] vertexValue = {"A","B","C","D","E"};
		Graph graph = new Graph(n);
		//添加顶点
		for(String value : vertexValue) {
			graph.insertVertex(value);
		}
		
		//添加边
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		graph.show();
	}
	public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else{
            String s = x+"";  
            int i = 0 ;
            int j = s.length()-1;
            while(i < j && i != j) {
            	if(s.charAt(i)==s.charAt(j)) {
            		i--;
            		j--;
            	}else {
            		return false;
            	}
            }
            return true;
        }

    }
	//构造器
	public Graph(int n) {
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
	}
	
	//返回节点的个数
	public  int getNumOfVertex() {
		return vertexList.size();
	}
	
	//得到边的个数
	public int getNumOfEdges() {
		return numOfEdges;
	}
	
	//返回节点i（下标） 对应的值  
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	
	//返回v1和v2的权值
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}
	
	//显示图对应的矩阵
	public void show() {
		for(int[] link:edges ) {
			System.out.println(Arrays.toString(link));
		}
	}
	//插入节点
	public  void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//添加边
	/**
	 * 
	 * @param v1 第一个顶点对应的下标
	 * @param v2 第二个顶点对应的下标
	 * @param weight 
	 */
	public void insertEdge(int v1 ,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

}
