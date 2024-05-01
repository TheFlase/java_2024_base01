package com.wgc.base.insertsort;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description // 插入排序
 * @Date 2024/5/1
 **/
public class InsertSort {
    public static void main(String[] args) {
        Integer[] array = {2,4,1,8,7,5};
        System.out.println("排序前："+ Arrays.toString(array));
        insertSort(array);
        System.out.println("排序后："+ Arrays.toString(array));
    }

    public static <E extends Comparable> E[] insertSort(E[] array){
        for(int i=0;i<=array.length-1;i++){
            for(int j=i;j>0;j--){
                if(j==0){
                    continue;
                }else {
                    if(array[j].compareTo(array[j-1])<0){
                        swap(array,j,j-1);
                    }
                }
            }
        }
        return array;
    }

    /**
     * 交换数组指定下标的元素
     * @param array
     * @param one
     * @param two
     */
    private static <E> void swap(E[] array, int one, int two) {
        E temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}
