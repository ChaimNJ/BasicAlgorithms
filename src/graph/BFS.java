package graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{0,0,1,0,1},{0,0,0,0,0},{0,1,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
        bfs(graph,0);
    }

    public static void bfs(int[][] graph,int start){
        boolean[] flag = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        visit(start);
        flag[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int tmp = q.remove();
            for (int i = 0; i < graph.length; i++) {
                if(graph[tmp][i]==1&&!flag[i]){
                    visit(i);
                    flag[i]=true;
                    q.add(i);
                }
            }
        }
    }

    private static void visit(int i) {
        System.out.println(i);
    }
}
