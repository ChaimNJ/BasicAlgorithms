package dynamicProgramming;

public class BeiBaoQuestion {
    public static void main(String[] args) {
        int n = 4;
        int weight = 5;
        int[][] f = new int[][]{
                {0,0,0,0,0,0},
                {0,-1,-1,-1,-1,-1},
                {0,-1,-1,-1,-1,-1},
                {0,-1,-1,-1,-1,-1},
                {0,-1,-1,-1,-1,-1},
        };
        int[] w =new int[]{0,2,1,3,2};
        int[] v = new int[]{0,12,10,20,15};
        System.out.println(MFKnapscak(n,weight,f,w,v));;
    }
    public static int MFKnapscak(int i,int j,int[][] f,int[] w,int[] v){
        int value = 0;
        if(f[i][j]<0){
            if(j<w[i]){
                value = MFKnapscak(i-1,j,f,w,v);
            }else{
                value = Math.max(MFKnapscak(i-1,j,f,w,v),v[i]+MFKnapscak(i-1,j-w[i],f,w,v));
            }
            f[i][j] = value;
        }
        return f[i][j];
    }
}
