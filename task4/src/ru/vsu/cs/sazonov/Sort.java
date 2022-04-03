package ru.vsu.cs.sazonov;

import java.util.Arrays;
import java.util.List;

public class Sort {

    public static <Integer> void sort(List<Integer> list){
        java.lang.Integer[] arr=list.toArray(new java.lang.Integer[0]);
       int[]arr1= ArrayUtils.toPrimitive(arr);
       sort(arr1);
    }

    public static void sort(int[] data) {
        int[][] arr=new int[3][data.length];
        for(int i=0; i<arr[0].length;i++){
            arr[0][i]=data[i];
            arr[1][i]=i;
        }
        QuickSort.sort(arr, 0);//O(n*log(n))
        for(int i=0; i<arr[0].length;i++){
            arr[2][i]=i;
        }
        QuickSort.sort(arr, 1);//O(n*log(n))
        toString(arr);
        reverse(arr);
    }

    public static void reverse(int[][]arr){
        for (int i = 0; i < arr[0].length; i++) {//O(n)
            int left=0;
            int right=arr[0].length;
            while(left<right){//бинарный поиск O(log(n))
                int index=(left+right+1)/2;
                if(arr[1][index]==arr[2][i])
                {
                    left=index;
                    break;
                }
                if(arr[1][index]<=arr[2][i]){
                    left=index;
                }
                else{
                    right=index-1;
                }
            }

            for (int g=0; g<3;g++){
                if(g==1) continue;
                int tmp=arr[g][i];
                arr[g][i]=arr[g][left];
                arr[g][left]=tmp;
            }
            System.out.println("----------");
            toString(arr);

        }
    }

    public static void toString(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
