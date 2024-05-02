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
        InsertSort insertSort = new InsertSort();
        Integer[] intArray = insertSort.generateArray(10, 5);
        System.out.println("排序前："+ Arrays.toString(intArray));
//        insertSort(intArray);
        insertSortByMoveElement(intArray);
        System.out.println("排序后："+ Arrays.toString(intArray));
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

    /**
     * 常规：第一次操作
     * @param array
     * @param <E>
     * @return
     */
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
     * 常规：第二次操作，利用平移特性
     * @param array
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] insertSortByMoveElement(E[] array){
        for(int i=0;i<=array.length-1;i++){
            E temp = null;
            int index = 0;
            for(int j=i;j>0;j--){
                if(array[j].compareTo(array[j-1])<0){
                    temp = array[j];
                    array[j] = array[--j];
                }else {
                    index = j;
                }
            }
            if(null != temp){
                array[index] = temp;
            }
            System.out.println("第"+(i+1)+"次排序后，结果是："+Arrays.toString(array));
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
