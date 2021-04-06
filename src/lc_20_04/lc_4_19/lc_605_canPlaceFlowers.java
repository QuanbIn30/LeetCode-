package lc_20_04.lc_4_19;

/**
 * 种花问题
 * @author superquanbin@gmail.com
 * @date 2020-04-19 17:06
 */
public class lc_605_canPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        // 首先获取数组的长度
        int len = flowerbed.length;
        int cnt = 0;

        // 遍历数组判断哪些位置可以种花
        for(int i = 0; i < len && cnt < n; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if(pre == 0 && next == 0){
                cnt++;
                flowerbed[i] = 1;
            }
        }
        // 如果可以种花的位置的个数大于等于n的话则表示可以种下n朵花，否则不可以
        return cnt >= n;
    }
}
