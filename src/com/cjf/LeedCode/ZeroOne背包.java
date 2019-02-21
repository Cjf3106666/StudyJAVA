package com.cjf.LeedCode;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/1/4 15:32
 **/
public class ZeroOne背包 {
    static final int MAX_WEIGHT = 20;
    static final int[] VALIES = {0, 3, 4, 5, 8, 10};
    static final int[] WEIGHT = {0, 2, 3, 4, 5, 9};
    static int[][] BW = new int[VALIES.length][MAX_WEIGHT + 1];

    public static void main(String[] args) {
        System.out.println(ZeroOnePacket());
    }

    static public int ZeroOnePacket() {
        for (int i = 1; i < VALIES.length; i++) {
            for (int j = 1; j < MAX_WEIGHT + 1; j++) {
                if (WEIGHT[i] > j) {
                    BW[i][j] = BW[i - 1][j];
                } else {
                    int newValue = BW[i - 1][j - WEIGHT[i]] + VALIES[i];
                    int oldValue = BW[i - 1][j];
                    BW[i][j] = Math.max(newValue, oldValue);
                }
            }
        }
        return BW[5][20];
    }

}
