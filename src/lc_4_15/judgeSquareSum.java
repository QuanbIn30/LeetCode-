package lc_4_15;

/**
 *
 * 判断一个数是不是平方和数
 * @author superquanbin@gmail.com
 * @date 2020-04-15 10:22
 */
public class judgeSquareSum {

    public static boolean judgeSquareSum(int c){

        int i = 0;
        int j = (int)Math.sqrt(c);
        while(i <= j){
            int powsum = i * i + j * j;
            if (powsum == c){
                return true;
            }if(powsum < c){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
