package lc_5_12;

/**
 * 同构字符串
 * @author superquanbin@gmail.com
 * @date 2020-05-12 22:51
 */
public class lc_205_isIsomorphic {

    public boolean isIsomorphic(String s, String t){
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        // 下面这个遍历就是同时获取到两个字符串相同位置的元素，然后送去判断这两个元素各自上一次出现的位置是不是相等
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            // 这一步就是在判断当前元素的上一个位置是否相等，
            // 例如这个例子中判断两个字符串最后一个元素的上次位置是否相等时，他们得到的当前元素的上一个位置都是2，所以相等
            if(preIndexOfS[sc] != preIndexOfT[tc]){
                return false;
            }

            // 这一步就是把当前遍历到的元素当前出现的位置在数组中记录上
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        lc_205_isIsomorphic tc = new lc_205_isIsomorphic();
        String s = "egg";
        String t = "add";
        boolean res = tc.isIsomorphic(s, t);
        System.out.println(res);
    }
}
