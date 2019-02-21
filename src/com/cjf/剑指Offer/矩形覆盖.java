package com.cjf.剑指Offer;

/**
 * @Descpription
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 *
 * @Author CJF
 * @Date 2019/2/20 15:46
 **/
public class 矩形覆盖 {
    public int RectCover(int target) {
    if(target<=0)return 0;
    if(target==1)return 1;
    if(target==2)return 2;
    else return RectCover(target-1)+RectCover(target-2);
    }
}
