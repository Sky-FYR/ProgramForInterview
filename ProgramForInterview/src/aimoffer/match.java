package aimoffer;

import java.util.Stack;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class match {
    public boolean match(char[] str, char[] pattern) {

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

//        for (int i = 0; i < str.length; i++) {
//            if (pattern[i+1] != '*') {
//                if (str[i] != pattern[i]) {
//                    return false;
//                }
//            } else {
//
//            }
//            if (str[i] != pattern[i]) {
//                if (pattern[i+1] == '*')
//                     pattern[i] == '.') {
//                    s1.push(str[i]);
//                    s2.push(pattern[i]);
//                    s2.push(pattern[i]);
//                } else {
//                    return false;
//                }
//            }
//        }

        for (int i = 0; i < str.length; i++) {
            if (str[i] != pattern[i]) {
                if (pattern[i] == '.') {
                    continue;
                } else if (pattern[i] == '*') {
                    if (i == 0) {
                        return false;
                    } else {
                        if (str[i] != pattern[i-1]) {
                            return false;
                        }
                    }

                } else if (pattern[i+1] == '*') {
                            continue;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
