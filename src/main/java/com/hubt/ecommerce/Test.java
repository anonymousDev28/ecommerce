package com.hubt.ecommerce;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static int[] problem1(int[] arr){
        Set<Integer> hashSet = new HashSet<>();
        int lengthHash = arr.length;
        for (int i = 0; i < lengthHash; i++) {
            hashSet.add(arr[i]);
        }
        for (int i = lengthHash-1; i >=hashSet.size() ; i--) {
            arr[i] = -1;
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(problem1(new int[]{0,0,1,1,1,2,2,3,3,4,5}));
    }
}
