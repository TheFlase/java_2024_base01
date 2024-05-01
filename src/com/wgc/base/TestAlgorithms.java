package com.wgc.base;

import com.wgc.base.selectionsort.SelectSearch;

import java.util.Random;

/**
 * @Author wgc
 * @Description // 测试算法
 * @Date 2024/5/1
 **/
public class TestAlgorithms {

    public static void main(String[] args) {
        testSort("selectionSort",100000,1000000);
    }

    public static void testSort(String algorithmsName,int numberSizeOne,int numberSizeTwo){
        Random random = new Random();
        Integer[] arrayOne = new Integer[numberSizeOne];
        Integer[] arrayTwo = new Integer[numberSizeTwo];
        for(int i=0;i<numberSizeOne;i++){
            arrayOne[i] = random.nextInt(numberSizeOne);
        }
        for(int i=0;i<numberSizeTwo;i++){
            arrayTwo[i] = random.nextInt(numberSizeTwo);
        }
        if("selectionSort".equals(algorithmsName)){
            System.out.println("********选择排序开始**************");
            long startOne = System.currentTimeMillis();
            SelectSearch.selectTionSort(arrayOne);
            long oneEnd = System.currentTimeMillis()-startOne;
            System.out.println("排序"+numberSizeOne+"个元素，耗时："+oneEnd);

            long startTwo = System.currentTimeMillis();
            SelectSearch.selectTionSort(arrayOne);
            long twoEnd = System.currentTimeMillis()-startOne;
            System.out.println("排序"+numberSizeTwo+"个元素，耗时："+twoEnd);
            System.out.println("********选择排序结束**************");
        }
    }
}
