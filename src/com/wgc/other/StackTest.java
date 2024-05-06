package com.wgc.other;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description // 栈结构
 * @Date 2024/5/6
 **/
public class StackTest {

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
}
