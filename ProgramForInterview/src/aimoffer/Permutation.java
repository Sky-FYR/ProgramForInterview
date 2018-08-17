package aimoffer;/*
 * ------------------------------------------------------------------
 * Copyright  2017 Hangzhou DtDream Technology Co.,Ltd. All rights reserved.
 * ------------------------------------------------------------------
 *   Product: ProgramForInterview
 *   Module Name: aimoffer
 *   Date Created: 2018/8/4
 *   Description:
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Description
 * ------------------------------------------------------------------
 * 2018/8/4      FYR
 * ------------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if((str == null) || (str.length() == 0)){
            return result;
        }
        char[] chars = str.toCharArray();
        Set<String> tmp = new TreeSet<String>();
        Permutation(chars, 0, tmp);
        result.addAll(tmp);
        Collections.sort(result);
        return result;
    }

    public void Permutation(char[] chars, int begin, Set<String> result) {
        if(begin == chars.length-1){
            result.add(String.valueOf(chars));
        }else {
            for(int i=begin;i<=chars.length-1;i++){
                swap(chars,begin,i);
                Permutation(chars, begin + 1, result);
                swap(chars, begin, i);
            }
        }
    }

    public void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
