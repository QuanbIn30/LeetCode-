package lc_20_05.lc_5_5;

/**
 * 数字转化为16进制数
 * @author superquanbin@gmail.com
 * @date 2020-05-05 11:38
 */
public class lc_405_toHex {

    public String toHex(int num){
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4; // 因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }
        return sb.reverse().toString();
    }
}
/**
 *位运算参考资料
 *https://www.cnblogs.com/hongten/p/hongten_java_yiweiyunsuangfu.html
 *https://blog.csdn.net/xmc281141947/article/details/74740061
 *http://c.biancheng.net/cpp/html/1868.html
 *https://www.runoob.com/java/java-operators.html
 */