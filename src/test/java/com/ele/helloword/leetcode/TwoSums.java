package com.ele.helloword.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @name: TwoSums
 * @author: xiangyf
 * @create: 2019-10-06 14:50
 * @description:
 * ## LeetCode1:两数之和
 *
 * 给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * **示例:**
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSums {

    public static void main(String[] args) {
        int[] nums = {1,3,2,9,0,1,4,7,3};
        int[] res = twoSum(nums, 50);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }

    //这一道题再次让我体会到了hashmap的快，但是如何用好它其实是一个很大的问题
    public static int[] twoSum(int[] arr, int target){
        if (arr.length<=2){
            return new int[]{0,1};
        }
        int[] res = new int[2];
        Map<Integer,Integer> tempMap = new HashMap<>(arr.length + 1);
        for (int i=0; i<arr.length; i++){
            if (tempMap.containsKey(target - arr[i])){
                res[0] = tempMap.get(target-arr[i]);
                res[1] = i;
                break;
            }
            tempMap.put(arr[i], i);
        }

        return res;
    }
}
