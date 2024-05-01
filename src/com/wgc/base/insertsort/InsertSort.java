package com.wgc.base.insertsort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author wgc
 * @Description // 插入排序
 * @Date 2024/5/1
 **/
public class InsertSort {
    public static void main(String[] args) {
//        Integer[] array = {2,4,1,8,7,5};
        InsertSort insertSort = new InsertSort();
        Integer[] longArray = insertSort.generateArray(100, 100);
        System.out.println("排序前："+ Arrays.toString(longArray));
        insertSort(longArray);
        System.out.println("排序后："+ Arrays.toString(longArray));
    }

    public Integer[] generateArray(int endRange,int sizeOfElement){
        Random random = new Random(endRange);
        Integer[] result = new Integer[sizeOfElement];
        for(int i=0;i<sizeOfElement;i++){
            result[i] = random.nextInt(endRange);
        }
        return result;
    }

    public InsertSort() {
    }

    public static <E extends Comparable<E>> E[] insertSort(E[] array){
        for(int i=0;i<=array.length-1;i++){
            for(int j=i;j>0;j--){
                if(array[j].compareTo(array[j-1])<0){
                    swap(array,j,j-1);
                }else {
                    break;
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
