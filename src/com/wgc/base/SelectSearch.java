package com.wgc.base;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description //
 * @Date 2024/4/21
 **/
public class SelectSearch {
    public static void main(String[] args) {
        int[] array = {2,4,1,5,7};
        System.out.println("排序前："+ Arrays.toString(array));
//        selectSearch(array);
        selectTionSort(array);
        System.out.println("排序后："+ Arrays.toString(array));
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectSearch(int[] array){
        int minIndex = 0;
        int min = 0;
        Boolean changeFlag = false;
        for(int i=0;i<array.length;i++){
            changeFlag = false;
            min = array[i];
            for(int j=i+1;j<array.length;j++){
                if(min>array[j]){
                    min = array[j];
                    minIndex = j;
                    changeFlag = true;
                }
            }
            if(changeFlag){
                System.out.println("第"+(i+1)+"轮排序结束，最小的元素是："+array[minIndex]);
                System.out.println("进行第"+(i+1)+"轮原始数据最小值交换");
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectTionSort(int[] array){
        for(int i=0;i<array.length;i++){
            int minIndex = i;
            for(int j=i;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    /**
     * 交换数组的指定元素
     * @param array
     * @param i
     * @param minIndex
     */
    private static void swap(int[] array, int i, int minIndex) {
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
