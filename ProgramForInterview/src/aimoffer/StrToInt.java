package aimoffer;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(StrToInt("+126"));
    }
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int size = str.length();
        boolean negative = false;
        int num = 0;
        for (int i = 0; i < size; i++) {
            if (i == 0){
                if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    if (size > 1) {
                        negative = str.charAt(i) == '-' ? true:false;
                        continue;
                    } else {
                        return 0;
                    }
                }
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num = 10*num + (str.charAt(i)-'0');
            } else {
                return 0;
            }
        }

        if (negative) {
            num = -num;
        }

        return num;
    }
}
