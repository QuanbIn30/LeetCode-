package lc_5_5;

/**
 * 二进制加法
 * @author superquanbin@gmail.com
 * @date 2020-05-05 16:46
 */
public class lc_67_addBinary {

    public String addBinary(String a, String b){
        // 定义三个int型变量和一个StringBuilder类型的变量
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        while(carry == 1 || i >= 0 || j >= 0){
            if(i >= 0 && a.charAt(i--) == '1'){
                carry++;
            }
            if(j >= 0 && b.charAt(j--) == '1'){
                carry++;
            }
            str.append(carry % 2);
            carry /= 2;
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        lc_67_addBinary tc = new lc_67_addBinary();
        String res = tc.addBinary(a, b);
        System.out.println(res);
    }
}
