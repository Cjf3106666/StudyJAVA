package com.cjf.LeedCode;

import java.util.*;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/1/3 9:09
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 **/
public class 全排列 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("prosperity", "properties"));
    }

    static public boolean checkInclusion(String s1, String s2) {
         List<String> list = new LinkedList<>();
        fullSort(list,s1.toCharArray(), 0);
        for (String s : list
                ) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }

    public static void fullSort(List list,char[] ss, int i) {
        if (i < 0 || ss == null || i >= ss.length) {
            return;
        }
        if (i == ss.length - 1) {
            list.add(new String(ss));
        } else {
            for (int j = i; j < ss.length; j++) {
                char temp = ss[i];
                ss[i] = ss[j];
                ss[j] = temp;
                fullSort(list,ss, i + 1);
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }
}
