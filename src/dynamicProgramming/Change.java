package dynamicProgramming;

public class Change {
    /**
     * 找零金额n，面值d1<...<dm，找到用最少硬币的方案
     * @param args
     *
     * n>0 F(n) = min(F(n-dj))+1 n>dj
     * F(0)=0
     */
    public static void main(String[] args) {
        int[] d =new int[]{1,3,4};
        int n = 6;
        int[] f = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int tmp = Integer.MAX_VALUE-1;
            int j = 0;
            while(j<d.length&&i>=d[j]){
                tmp = Math.min(f[i-d[j]],tmp);
                j+=1;
            }
            f[i] = tmp+1;
        }
        System.out.println(f[n]);
    }
}
