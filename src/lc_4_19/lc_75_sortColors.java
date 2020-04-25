package lc_4_19;

/**
 * 荷兰国旗问题
 *
 * 使用整数 0、 1 和 2 分别表示红色、白色和蓝色
 * @author superquanbin@gmail.com
 * @date 2020-04-19 10:34
 */
public class lc_75_sortColors {

    public static void sortColors (int[] arr){
        int less = -1;
        int more = arr.length;
        int index = 0;
        while(index < more){
            if(arr[index] == 0){
                swap(arr, ++less, index++);
            }else if(arr[index] == 2){
                swap(arr, --more, index);
            }else{
                index++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
