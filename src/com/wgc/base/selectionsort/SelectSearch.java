package com.wgc.base.selectionsort;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description //
 * @Date 2024/4/21
 **/
public class SelectSearch {
    public static void main(String[] args) {
        Integer[] array = {2,4,1,5,7};
        System.out.println("排序前："+ Arrays.toString(array));
//        selectSearch(array);
//        selectTionSort(array);
        selectSort2(array);
        System.out.println("排序后："+ Arrays.toString(array));

        Student A = new Student("张三", 12);
        Student B = new Student("李四", 8);
        Student C = new Student("王五", 15);
        Student D = new Student("赵阳", 11);
        Student[] stuArray = {A,B,C,D};
        System.out.println("排序前："+ Arrays.toString(stuArray));
//        selectSearch(stuArray);
        selectTionSort(stuArray);
        System.out.println("排序后："+ Arrays.toString(stuArray));
    }

    /**
     * 选择排序
     * @param array
     */
    public static <E extends Comparable<E>> void selectSearch(E[] array){
        int minIndex = 0;
        E min ;
        Boolean changeFlag = false;
        for(int i=0;i<array.length;i++){
            changeFlag = false;
            min = array[i];
            for(int j=i+1;j<array.length;j++){
                if(min.compareTo(array[j])>0){
                    min = array[j];
                    minIndex = j;
                    changeFlag = true;
                }
            }
            if(changeFlag){
                System.out.println("第"+(i+1)+"轮排序结束，最小的元素是："+array[minIndex]);
                System.out.println("进行第"+(i+1)+"轮原始数据最小值交换");
                E temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 选择排序方式3：倒序比较
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<E>> void selectSort2(E[] array){
        for(int i=array.length-1;i>=0;i--){
            int index=i;
            for(int j=i;j>=0;j--){
                if(array[index].compareTo(array[j])<0){
                    index = j;
                }
            }
            swap(array,index,i);
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static <E extends Comparable<E>> void selectTionSort(E[] array){
        for(int i=0;i<array.length;i++){
            int minIndex = i;
            for(int j=i;j<array.length;j++){
                if(array[j].compareTo(array[minIndex]) < 0){
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
    private static <E> void swap(E[] array, int i, int minIndex) {
        E temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
