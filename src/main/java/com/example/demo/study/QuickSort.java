package com.example.demo.study;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class QuickSort {

    static void sort(int[] arr,int l,int r){
        if(l>=r){return;}
        int i = l;
        int j = r;
        int temp = arr[l];
        while (i < j){
            //右侧找到小于temp的
            while (i < j && arr[j] >= temp){
                j--;
            }
            //左侧找到大于temp的数
            while (i < j && arr[i] <= temp){
                i++;
            }
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[l] = arr[i];
        arr[i] = temp;
        sort(arr,l,i-1);
        sort(arr,i+1,r);
    }

    void mysort(int[] arr ,int l,int r){

        Semaphore s = new Semaphore(1);
        s.release();

        if(l >= r) return;
        int t = arr[l];
        int lindex = l;
        int rindex = r;
        while (lindex < rindex){
            while (arr[rindex] >= t){
                rindex --;
            }
            while (arr[lindex] <= t){
                lindex ++;
            }
            if(lindex < rindex){
                int tmp = arr[rindex];
                arr[rindex] = arr[lindex];
                arr[lindex] = tmp;
            }
        }
        arr[l] = arr[lindex];
        arr[lindex] = t;
        mysort(arr,l,lindex-1);
        mysort(arr,lindex + 1,r);


    }

    public static void main(String[] args) {
        String s  = "";
    }

}
