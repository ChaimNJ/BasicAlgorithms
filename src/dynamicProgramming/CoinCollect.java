package dynamicProgramming;

/**
 * n*m的木板放硬币，每格硬币最多一个，左上方的机器人需要尽可能收集硬币，并带到右下方
 * ，机器人只能向右或者向下移动一格。设计一个算法找出机器人能找出的最大硬币数，并给出相应的路径
 * <p>
 * F(i,j)=max{F(i-1,j),F(i,j-1)}+Cij
 * F(0,j)=0,1<=j<=m  F(i,0)=0 1<=i<=n
 */
public class CoinCollect {
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] c = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1, 0}
        };
        System.out.println(RobotCoinCollection(c, n, m));
    }

    public static int RobotCoinCollection(int[][] c, int n, int m) {
        int[][] f = new int[n + 1][m + 1];
        f[1][1] = c[1][1];
        for (int i = 2; i <= m; i++) {
            f[1][i] = f[1][i - 1] + c[1][i];
        }
        for (int i = 2; i <= n; i++) {
            f[i][1] = f[i - 1][1] + c[i][1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + c[i][j];
            }
        }
        //回溯找路径，如果f[i-1][j]>f[i][j-1]则必然来自上方

        int i = n, j = m;
        while (i >= 1 && j >= 1) {
            System.out.println(i + " " + j);
            if (i == 1) {
                j = j - 1;
            } else if (j == 1) {
                i = i - 1;
            } else {
                if (f[i - 1][j] >= f[i][j - 1]) {
                    i = i - 1;
                    j = j;
                } else {
                    i = i;
                    j = j - 1;
                }
            }
        }
        return f[n][m];
    }


}
