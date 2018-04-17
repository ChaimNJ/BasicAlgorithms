package graph;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
//        Deep();
        DFS2(0);
    }

    //DFS递归
    static int[] flag;
    public static void Deep() {
        int[][] graph = new int[][]{{0,0,1,0,0},{0,1,0,0,0},{0,0,0,1,0},{0,0,0,0,1},{0,0,0,0,0}};
        flag = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(flag[i]==0){
                Dfs(graph,i);
            }
        }
    }

    public static void Dfs(int[][] graph, int start){
        System.out.println(start);
        flag[start]=1;
        for (int i = 0; i < graph.length; i++) {
            if(graph[start][i]==1&&flag[i]==0){
                Dfs(graph,i);
            }
        }
    }

    //非递归

    public static void DFS2(int start){
        Stack<Integer> stack = new Stack<>();
        int[][] graph = new int[][]{{0,1,1,0,0},{0,0,0,1,0},{0,0,0,1,1},{0,0,0,0,0},{0,0,0,0,0}};
        boolean[] flag = new boolean[graph.length];
        stack.push(start);
        System.out.println(start);
        flag[start]=true;
        while(!stack.isEmpty()){
            int i =  stack.peek();
            int j =0;
            for (; j < graph.length; j++) {
                if(graph[i][j]==1&&flag[j]==false){
                    System.out.println(j);
                    flag[j]=true;
                    stack.push(j);
                    break;
                }
            }
            if(j>=graph.length){
                stack.pop();
            }
        }
    }



}
