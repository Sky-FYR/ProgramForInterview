package aimoffer;

import java.math.BigInteger;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public int Add(int num1, int num2) {
//        while (num2!=0) {
//            int temp = num1^num2;//相加异或，计算各位，不算进位
//            num2 = (num1&num2)<<1;//计算进位，与操作并左移
//            num1 = temp;
//        }
//        return num1;

        BigInteger n1 = BigInteger.valueOf(num1);
        BigInteger n2 = BigInteger.valueOf(num2);
        return n1.add(n2).intValue();
    }
}
