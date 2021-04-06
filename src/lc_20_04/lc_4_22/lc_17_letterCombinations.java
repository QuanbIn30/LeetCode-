package lc_20_04.lc_4_22;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @author superquanbin@gmail.com
 * @date 2020-04-22 20:46
 */
public class lc_17_letterCombinations {

    private static final String[] KEYS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static List<String> letterCombinations(String digits){
        // 定义一个存放String类型数据的list链表，用来存放返回结果
        List<String> combinations = new ArrayList<>();
        // 国际惯例，先判断下输入数据的欺骗性
        if(digits == null || digits.length() == 0){
            return combinations;
        }

        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private static void doCombination(StringBuilder prefix, List<String> combinations, final String digits){
        // 如果digits的长度与prefix的长度一样说明prefix中已经有了与按下的按键数相同数量的字符了，
        // 此时可以将prefix中的元素存进结果集中了，然后return
        if(prefix.length() == digits.length()){
            combinations.add(prefix.toString());
            return;
        }
        // 定位输入的数字字符
        int curDigits = digits.charAt(prefix.length()) - '0';
        // 获取当前定位到的数字对应的键盘上的字符串
        String letters = KEYS[curDigits];
        // 遍历获取到的字符串
        for(char c : letters.toCharArray()){
            prefix.append(c);
            // 调用doCombination的主要作用是当prefix中有与输入的字符相同数量的字符时，
            // 会将其作为结果存进结果集
            doCombination(prefix, combinations, digits);
            // prefix中的字符串作为结果存进结果集之后，删除掉最后一个元素，
            // 因为要重新添加下一个可遍历的字符组成新的结果字符串
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static void main(String[] args) {
        String input = "23";
        List<String> res = letterCombinations(input);
        System.out.println(res);
    }
}
