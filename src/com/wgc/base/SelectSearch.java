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
        int minIndex = 0;
        int min = 0;
        Boolean changeFlag = false;
        System.out.println("排序前："+ Arrays.toString(array));
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
        System.out.println("排序后："+ Arrays.toString(array));
    }
}
