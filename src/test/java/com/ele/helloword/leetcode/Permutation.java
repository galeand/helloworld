package com.ele.helloword.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: Permutation
 * @author: xiangyf
 * @create: 2019-10-05 13:50
 * @description:
 * LeetCode46:全排列
 * 给定一个**没有重复**数字的序列，返回其所有可能的全排列。
 *
 * **示例:**
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutation {

    /**
     * Java中回溯问题的一般方法（子集、排列、组合和、回文排序）
     *     这种结构可能适用于许多其他回溯问题，但在这里我将演示子集、置换和组合求和。
     * @param arr
     * @return
     */
    public static List<List<Integer>> permute(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), arr);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] arr){
        if (tempList.size() == arr.length){
            //这里需要开辟出一块新的内存，然后装进去，不然的话在回溯的时候最终所有的元素都会被删除出去
            res.add(new ArrayList<>(tempList));
        }else{
            for (int i=0; i<arr.length; i++){
                if (tempList.contains(arr[i]))continue;
                tempList.add(arr[i]);
                backtrack(res, tempList, arr);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args){
        int[] test = {1,2,3,4,5,6,7,8,9};
//        int[] test = {1,2,3};
        List<List<Integer>> lists = permute(test);
//        System.out.println(lists);
        lists.forEach(System.out::println);
        System.out.println(lists.size());
    }
}
