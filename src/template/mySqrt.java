package template;

/**
 *
 * 求开方
 * 计算并返回非负整数x的平方根，返回结果只保留整数部分
 * @author superquanbin@gmail.com
 * @date 2020-04-21 07:33
 */
public class mySqrt {
    public int mySqrt(int x){
        if(x <= 1){
            return x;
        }

        int l = 1;
        int h = x;
        while(l <= h){
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if(sqrt == mid){
                return mid;
            }else if(mid > sqrt){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return h;
    }
}
