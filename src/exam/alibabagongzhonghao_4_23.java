package exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author superquanbin@gmail.com
 * @date 2020-04-23 08:32
 */
public class alibabagongzhonghao_4_23 {
    Map<String, String> map = new HashMap<>();

    public static <String, T, Alibaba> String Aliget(String string, T t)
    {return string;}

    /*
    public static void main(String[] args) {
        String s = null;
        switch (s){
            case "null" :
                System.out.println("匹配\"null\"");
                break;

            case "bbb" :
                System.out.println("bbb");
                break;
            default:{
                System.out.println("default");
                break;
            }
        }
    }
    */


    public static void f(String s){
        System.out.println("调用f(String s)");
    }

    public static void f(Integer i){
        System.out.println("调用f(Integer i)");
    }



    /*
    public static void main(String[] args) {
        f(null);
    }
     */

    // F 0.10000000000000009
    // G 0.09999999999999998

    /*
    public static void main(String[] args) {
        double c = 0.8;
        double d = 0.7;
        double e = 0.6;
        double f = c - d;
        double g = d - e;
        String F = String.valueOf(f);
        String G = String.valueOf(g);
        System.out.println(G);
    }
     */

    /*
    public static void main(String[] args) {
        float a = 0.125f;
        double b = 0.125d;
        System.out.println((a - b) == 0.0);
    }

     */

}
