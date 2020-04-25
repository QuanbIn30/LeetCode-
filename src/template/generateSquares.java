package template;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成小于n的平方数序列
 * @author superquanbin@gmail.com
 * @date 2020-04-20 22:38
 */
public class generateSquares {
    public static List<Integer> generateSquares(int n){
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while(square <= n){
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
