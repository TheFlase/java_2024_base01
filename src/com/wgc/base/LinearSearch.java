package com.wgc.base;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description //
 * @Date 2024/1/13
 **/
public class LinearSearch {
    public static <T>  int search(T[] array, T obj){
        int i = 0;
        for(T item:array){
            if(obj.equals(item)){
                return i;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Integer[] array = {2,54,1,55,5,756};
        int needToFindNum = 1;
        int searchResult = LinearSearch.search(array, needToFindNum);
        System.out.println("输出的数组是："+ Arrays.toString(array)+"查找的数字是："+needToFindNum+",搜索结果是："+searchResult);
    }
}
