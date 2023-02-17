package com.example.demo.study;

/**
 * 归并排序
 */
public class MergeSort {


    static int[] tmp ;
    static void sort(int[]arr,int l,int r){
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        sort(arr,l,mid);
        sort(arr,mid + 1,r);
        //合并
        int i = l;
        int j = mid + 1;
        int tIndex = 0;
        while (i<=mid && j<=r){
            if(arr[i] <= arr[j]){
                tmp[tIndex++] = arr[i];
            }else{
                tmp[tIndex++] = arr[j];
            }
        }
        while (i<=mid){
            tmp[tIndex++] = arr[i];
        }
        while (j<=r){
            tmp[tIndex] = arr[j];
        }
        for (int k = 0; k < r - l + 1; k++) {
            arr[k + l] = tmp[k];
        }
    }

    void mysort(int[] arr,int l,int r){
        if(l >= r)return;
        int mid = (l+r)/2;
        mysort(arr,l,mid);
        mysort(arr,mid+1,r);
        int i = l;
        int j = mid+1;
        int tIndex = 0;
        while (i <= mid && j <= r){
            if(arr[i] <= arr[j]){
                tmp[tIndex++] = arr[i++];
            }else{
                tmp[tIndex++] = arr[j++];
            }
        }
        while (i <= mid){
            tmp[tIndex++] = arr[i++];
        }
        while (j <= r){
            tmp[tIndex++] = arr[j++];
        }
        for (int k = 0; k < r - l + 1; k++) {
            arr[l + k] = tmp[k];
        }


    }


    public static void main(String[] args) {

        int[] arr = new int[4];
        tmp = new int[arr.length];
        sort(arr,0,arr.length-1);
    }
}
