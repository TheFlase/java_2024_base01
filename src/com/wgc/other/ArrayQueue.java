package com.wgc.other;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description // 队列:基于数组实现
 * @Date 2024/5/6
 **/
public class ArrayQueue {
    private Integer[] items;
    // 数组元素个数(下标)
    private Integer index;
    // 数组大小
    private Integer arrayLength;
    // 取值索引标志
    private Integer popIndex;

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        System.out.println("插入值后："+arrayQueue.toString());
        arrayQueue.pop();
        arrayQueue.pop();
        System.out.println("取值后："+arrayQueue.toString());
    }

    public ArrayQueue(Integer arrayLength) {
        if(arrayLength<1){
            System.out.println("数组大小非法，已自动设置数组默认大小！");
            arrayLength = 1;
        }
        this.arrayLength = arrayLength;
        this.index = 0;
        this.popIndex = 0;
        items = new Integer[arrayLength];
    }

    public boolean push(Integer element){
        if(index.equals(arrayLength)){
            return false;
        }
        items[index] = element;
        ++index;
        return true;
    }

    public Integer pop(){
        if(arrayLength == 0 || popIndex>index-1){
            return null;
        }
        Integer popValue = items[popIndex];
        items[popIndex] = null;
        ++popIndex;
        System.out.println("当前取值下标："+(popIndex-1)+",值为："+popValue);
        return popValue;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", index=" + index +
                ", arrayLength=" + arrayLength +
                ", popIndex=" + popIndex +
                '}';
    }
}
