package lc_4_9;

import java.util.ArrayList;

public class BFPRTSort {

    // 递归寻找中位数的中位数
    int findMid(int[] R, int low, int high) {
        if (low == high)
            return R[low];
        int i, k = 0;
        //将序列划分为每5个数一组，找到每组的中位数
        for (i = low; i + 4 <= high; i += 5) {
            insertSort(R, i, i + 4);
            k = i - low; //每组的首元素下标
            swap(R[low + (k / 5)], R[i + 2]); //将每组中位数交换到最前面
        }
        int n = high - i + 1;
        if (n > 0) {
            insertSort(R, i, high);
            k = i - low;
            swap(R[low + (k / 5)], R[i + n / 2]);
        }
        k = k / 5;//得到组数
        if (k == 0)
            return R[low];
        return findMid(R, low, low + k);
    }

    // 插入排序
    void insertSort(int[] R, int low, int high) {
        int temp;
        int j;
        for (int i = low + 1; i <= high; i++) {
            temp = R[i];
            j = i - 1;
            while (j >= low && R[j] > temp)
                R[j + 1] = R[j--];
            R[j + 1] = temp;
        }
    }

    //寻找中位数的下标
    int findMidId(int[] R, int low, int high, int mid) {
        for (int i = 0; i <= high; i++) {
            if (mid == R[i])
                return i;
        }
        return -1;
    }

    //进行划分过程
    int partion(int[] R, int low, int high, int index) {
        if (low <= high) {
            //将中位数和首元素交换
            swap(R[index], R[low]);
            int temp = R[low];
            int i = low, j = high;
            while (i != j) {
                while (i < j && temp < R[j])
                    j--;
                R[i] = R[j];
                while (i < j && temp > R[i])
                    i++;
                R[j] = R[i];
            }
            R[i] = temp;
            return i;
        }
        return -1;
    }

    int BFPRT(int[] R, int low, int high, int k) {
        // 中位数
        int median = findMid(R, low, high);
        // 中位数的下标
        int index = findMidId(R, low, high, median);
        int newIndex = partion(R, low, high, index);
        int rank = newIndex - low + 1;
        if (rank == k)
            return R[newIndex];
        else if (rank > k)
            return BFPRT(R, low, newIndex - 1, k);
        else return BFPRT(R, newIndex + 1, high, k - rank);
    }

    private void swap(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;
    }

    public static void main(String[] args) {
        BFPRTSort bfprt = new BFPRTSort();
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        int result = bfprt.BFPRT(array, 0, array.length - 1, 3);
        System.out.println(array[2]);//找到第三小的元素
        //找出前三小的元素
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            res.add(array[i]);
        }
        System.out.println(res);
    }
}

