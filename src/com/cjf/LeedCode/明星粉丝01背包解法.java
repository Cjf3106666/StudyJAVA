package com.cjf.LeedCode;

import java.net.Socket;
import java.util.*;

/**
 * @Descpription 有10个明星，他们都有各自的粉丝，现在要求分成两组 要求两方粉丝数量基本相同，如何划分。
 * 提示：01背包
 * @Author CJF
 * @Date 2019/1/4 16:02
 **/
public class 明星粉丝01背包解法 {
    static final int[] SUPERSTAR = {0, 15, 23, 45, 16, 21, 28, 45, 11, 39, 75};
    static final int[] FANSNUM = {0, 15, 23, 45, 16, 21, 28, 45, 11, 39, 75};

    public static void main(String[] args) {
        System.out.println(Solution());
    }

    static public int Solution() {
        double MAXSIZE = 0;
        for (int i = 0; i < FANSNUM.length; i++
                ) {
            MAXSIZE += FANSNUM[i];
        }
        MAXSIZE /= 2;
        int[][] BW = new int[FANSNUM.length][(int) MAXSIZE + 1];
        for (int i = 1; i < SUPERSTAR.length; i++) {
            for (int j = 1; j < (int) MAXSIZE + 1; j++) {
                if (FANSNUM[i] > j) {
                    BW[i][j] = BW[i - 1][j];
                } else {
                    int newValue = BW[i - 1][j - FANSNUM[i]] + SUPERSTAR[i];
                    int oldValue = BW[i - 1][j];
                    BW[i][j] = Math.max(newValue, oldValue);
                }
            }
        }

        /**
         * 回溯 找出选择了哪几位明星
         */

        int c = (int) MAXSIZE;
        int[] x = new int[SUPERSTAR.length];
        for (int i = SUPERSTAR.length - 1; i > 1; i--) {
            if (BW[i][c] == BW[i - 1][c]) {
                x[i] = 0;
            } else {
                x[i] = 1;
                c -= FANSNUM[i];
            }
        }
        x[1] = (BW[1][c] > 0) ? 1 : 0;

        System.out.println(Arrays.toString(x));
        return BW[SUPERSTAR.length - 1][(int) MAXSIZE];
    }


}
