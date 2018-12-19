package com.cjf.LeedCode;

/**
 * @Descpription 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * @Author CJF
 * @Date 2018/12/19 14:41
 **/
public class 最长公共前缀 {
    public static void main(String[] args) {
        String strs[] = {};
        System.out.println(longestCommonPrefix(strs));
    }

    static public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min_length = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            min_length = min_length < strs[i].length() ? min_length : strs[i].length();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min_length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
