package lc_20_04.lc_4_20;

/**
 * 第一个错误版本
 * @author superquanbin@gmail.com
 * @date 2020-04-20 10:24
 */
public class lc_278_firstBadVersion {

    public static int firstBadVersion(int n){
        int l = 1;
        int h = n;
        while(l < h){
            int mid = l + (h - l) / 2;
            if(isBadVersion(mid)){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    // 这个函数在leetcode中是由leetcode提供的
    // 所以此处判断算法是错误的，只是为了让主函数不报错
    private static boolean isBadVersion(int index){
        return false;
    }
}
