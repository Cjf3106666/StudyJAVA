package com.cjf.剑指Offer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Descpription. 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1    2    3    4
 * 5    6    7    8
 * 9    10   11   12
 * 13   14   15   16
 * <p>
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author CJF
 * @Date 2019/2/21 17:34
 **/
public class A19_顺时针打印矩阵 {
    static public ArrayList<Integer> printMatrix(int[][] matrix) {
        if(matrix.length==0) {
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>(16);
        int row = matrix.length;
        int column = matrix[0].length;
        int cycleNum=((row<column?row:column)-1)/2+1;
        row--;
        column--;

        for(int i=0;i<cycleNum;i++){
            for(int j=0;j<=column;j++){
                if(map.get(i+","+j)==null) {
                    list.add(matrix[i][j]);
                    map.put(i+","+j,matrix[i][j]);
                }
            }
            for (int k=0;k<=row;k++){
                if(map.get(k+","+column)==null) {
                    list.add(matrix[k][column]);
                    map.put(k+","+column,matrix[k][column]);
                }
            }
            for (int l=column;l>=0;l--){
                if(map.get(row+","+l)==null) {
                    list.add(matrix[row][l]);
                    map.put(row+","+l,matrix[row][l]);
                }
            }
            for (int m=row;m>=0;m--){
                if(map.get(m+","+i)==null) {
                    list.add(matrix[m][i]);
                    map.put(m+","+i,matrix[m][i]);
                }
            }
            row--;
            column--;
        }
        return list;
    }

    public static void main(String[] args) {

        int nums[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> list = printMatrix(nums);
        System.out.println(list);
    }
}
