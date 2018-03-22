package dynamicProgramming;

public class MaxSumOfMoney {
    /**
     * 币值最大化问题：
     * n个硬币，c1...cn，整数不一定两两不同，在其原始位置不相邻的情况下，总净额最大。
     *递推方程：F(n)=max{cn+F(n-2),F(n-1)},F(0)=0,F(1)=c1
     */
    public static void main(String[] args) {
        int[] c=new int[]{0,5,1,2,10,6,2};
        int n =c.length;
        int[] f = new int[n];
        f[0]=0;f[1]=c[1];
        for (int i = 2; i < n; i++) {
            f[i]=Math.max(c[i]+f[i-2],f[i-1]);
        }
        System.out.println(f[n-1]);
    }
}
