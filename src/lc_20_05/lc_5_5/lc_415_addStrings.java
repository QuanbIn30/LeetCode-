package lc_20_05.lc_5_5;

/**
 * 字符串加法
 * @author superquanbin@gmail.com
 * @date 2020-05-05 20:00
 */
public class lc_415_addStrings {

    // 方法1：双指针法
    public String addStrings(String num1, String num2){
        // 定义三个int型的变量，和一个StringBuilder类型的变量
        StringBuilder str = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 这个while里的判断条件就是最绝的，很精妙，
        // 其中carry独立起作用的时候就是我输入的参数已经走完了，但是走的过程中有进位的情况，我要把这个进位安排进答案里去
        // 其中 i >= 0 || j >= 0 我输入的参数还有数，还有数的情况下那当然必须的继续走
        while(carry == 1 || i >= 0 || j >= 0){
            // 下面这两步给x、y赋值的操作，也到了将长短不一的两个数字用0补齐的效果
            // 这个x就是从输入的参数num1中从后往前取数，记得一定要 - '0', 因为字符型的'0'等于int型的48
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            // 同理，这个y的作用就是从输入的参数num2中从后往前取数，记得一定要 - '0', 因为字符型的'0'等于int型的48
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            // 下面这个((x + y + carry) % 10)的作用是将当前这个位的数安排好，
            // 进位的我不管，我只管安排好当前这一位的
            str.append((x + y + carry) % 10);
            // 下面这个carry变量就是控制进位的，作用是发挥的下一轮，
            // 因为这一轮当他这已经走完了相当于，
            // 而carry这个变量他把这个数带着去了下一轮参与((x + y + carry) % 10)的计算了
            carry = (x + y + carry) / 10;
        }
        // 记得返回记过之前要反转str
        return str.reverse().toString();
    }

    public static void main(String[] args) {
//        lc_415_addStrings tc = new lc_415_addStrings();
//        String num1 = "0";
//        String num2 = "0";
//        String res = tc.addStrings(num1, num2);
//        System.out.println(res);
        char a = '0';
        char b = '0';
        System.out.println('0' + 0);
    }
}
