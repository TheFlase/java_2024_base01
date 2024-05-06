package com.wgc.other;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description // 栈结构：基于数组实现
 * @Date 2024/5/6
 **/
public class ArrayStack {

    public static void main(String[] args) {
        StackByArray stackByArray = new StackByArray();
        stackByArray.put(1);
        stackByArray.put(2);
        stackByArray.put(3);
        stackByArray.put(4);
        System.out.println("插入值后："+stackByArray.toString());
        stackByArray.pop();
        stackByArray.pop();
        stackByArray.pop();
        System.out.println("取值后："+stackByArray.toString());
    }

    public static class StackByArray{
        private Integer arrayLength = 2;
        private Integer[] array;
        private ThreadLocal<Integer> currIndex = new ThreadLocal<>();

        public StackByArray(Integer arrayLength) {
            this.arrayLength = arrayLength;
            array = new Integer[arrayLength];
        }

        public StackByArray() {
            array = new Integer[arrayLength];
        }

        public  Boolean put(Integer element){
            Integer curr = currIndex.get();
            if(null == curr){
                curr = 0;
            }else if(curr > array.length-1){
                // 扩容
                Integer[] arrayNew = expansionArray(array);
                arrayLength = arrayNew.length;
                array = arrayNew;
            }

            if(curr<= arrayLength){
                array[curr] = element;
                curr ++;
                currIndex.set(curr);
                return Boolean.TRUE;
            }else {
                System.out.println("数组容量已耗尽，请扩容后再插入新元素！");
                return Boolean.FALSE;
            }
        }

        private Integer[] expansionArray(Integer[] array) {
            int size = array.length * 2;
            Integer[] arrayNew = Arrays.copyOf(array, size);
            return arrayNew;
        }

        public  Integer pop(){
            Integer curr= currIndex.get();
            --curr;
            Integer currValue = array[curr];
            System.out.println("从栈（下标为:"+curr+"）取值：" + currValue);
            array[curr] = null;
            currIndex.set(curr);
            return currValue;
        }

        @Override
        public String toString() {
            return "StackByArray{" +
                    "arrayLength=" + arrayLength +
                    ", array=" + Arrays.toString(array) +
                    ", curr's already uses Index=" + (currIndex.get()-1) +
                    '}';
        }
    }

    class ArrayStackDemo{
        private String[] items;
        // 栈的元素个数(下标)
        private volatile int count;
        // 栈的大小
        private int n;

        public ArrayStackDemo(int n) {
            this.items = new String[n];
            this.n = n;
            // 初始化时设置栈的元素个数为0
            this.count = 0;
        }

        public boolean push(String item){
            if(count == n){
                return false;
            }
            // 入栈，元素个数加1
            items[count] = item;
            ++ count;
            return true;
        }

        public String pop(){
            if(count == 0){
                return null;
            }
            // 出栈，元素个数减1
            String item = items[count - 1];
            -- count;
            return item;
        }
    }
}
