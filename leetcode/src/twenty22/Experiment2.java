package twenty22;

import java.util.Arrays;
import java.util.Random;

public class Experiment2 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        int[][] x = new int[1024][1024];
        int[][] y = new int[1024][1024];
        t.generate(x, y, 1024); //生成xy矩阵
        t.result1(x, y, 1024);  //经典方法
        t.result(x, y, 1024,4*4); //分块算法
        t.result(x, y, 1024,8*8);
        t.result(x, y, 1024,16*16);
        t.result(x, y, 1024,32*32);
        t.result(x, y, 1024,64*64);
        t.result(x, y, 1024,128*128);

    }
}

class Test1 {

    public void generate(int[][] x, int[][] y, int n) {
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = r.nextInt(10);
                y[i][j] = r.nextInt(10);
            }
        }
    }

    public void result1(int[][] x, int[][] y, int n) {
        int[][] res = new int[n][n];
        long startTime = System.nanoTime();
        classic(x,y,res,n);
        long endTime = System.nanoTime();
        double usedTime = endTime - startTime;
        System.out.println("classic  " + usedTime / 100000 + "ms");

    }

    public void result(int[][] x, int[][] y, int n, int bnum) {

        int[][] res1 = new int[n][n];
        long startTime1 = System.nanoTime();
        block(x,y,res1,n,bnum,4,0,n-1,0,n-1);
        long endTime1 = System.nanoTime();
        double usedTime1 = endTime1 - startTime1;
        System.out.println("block" +  "blocknum" + bnum + "  " + usedTime1 / 100000 + "ms");
    }

    public void classic(int[][] x, int[][] y, int[][] res, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = 0;
                for(int k = 0; k < n; k++) {
                    res[i][j] += x[i][k] * y[k][j];
                }
            }
        }
    }

    public void block(int[][] x, int[][] y, int[][] res, int n, int bnum, int flag, int l, int r, int t, int b) {
        if(flag <= bnum){ //flag为递归标志
            block(x, y, res, n, bnum, flag * 4, l, (l+r)/2, t, (t+b)/2); //分块
            block(x, y, res, n, bnum, flag * 4, (l+r)/2+1, r, t, (t+b)/2);
            block(x, y, res, n, bnum, flag * 4, l, (l+r)/2, (t+b)/2+1, b);
            block(x, y, res, n, bnum, flag * 4, (l+r)/2+1, r, (t+b)/2+1, b);
            calculate(x, y, res, l, (l+r)/2, t, (t+b)/2, l, (l+r)/2, t, (t+b)/2, l, (l+r)/2, t, (t+b)/2);//合并
            calculate(x, y, res, l, (l+r)/2, (t+b)/2+1, b, (l+r)/2+1, r, t, (t+b)/2, l, (l+r)/2, t, (t+b)/2);
            calculate(x, y, res, (l+r)/2+1, r, t, (t+b)/2, l, (l+r)/2, t, (t+b)/2, (l+r)/2+1, r, t, (t+b)/2);
            calculate(x, y, res, (l+r)/2+1, r, (t+b)/2+1, b, (l+r)/2+1, r, t,(t+b)/2, (l+r)/2+1, r, t, (t+b)/2);
            calculate(x, y, res, l, (l+r)/2, t, (t+b)/2, l, (l+r)/2, (t+b)/2+1, b, l, (l+r)/2, (t+b)/2+1, b);
            calculate(x, y, res, l,(l+r)/2, (t+b)/2+1, b, (l+r)/2+1, r, (t+b)/2+1, b, l,(l+r)/2, (t+b)/2+1, b);
            calculate(x, y, res, (l+r)/2+1, r, t, (t+b)/2, l, (l+r)/2, (t+b)/2+1, b, (l+r)/2+1, r, (t+b)/2+1, b);  //
            calculate(x, y, res, (l+r)/2+1, r, (t+b)/2+1, b, (l+r)/2+1, r, (t+b)/2+1, b, (l+r)/2+1, r, (t+b)/2+1, b);//
        }
    }
    //指定矩阵范围的乘法
    public void calculate(int[][] x, int[][] y, int[][] res, int xl, int xr, int xt, int xb, int yl, int yr, int yt, int yb, int rl, int rr, int rt, int rb) {
        for(int i = rl, ix = xl, iy = yl; i <= rr; i++, ix++, iy++) {
            for(int j = rt, jx = xt, jy = yt; j <= rb; j++, jx++, jy++) {
                for(int kx = xt, ky = yl; kx <= xb; kx++, ky++) {
                    int r = x[ix][kx] * y[ky][jy];
                    res[i][j] += r;
                }
            }
        }
    }
}