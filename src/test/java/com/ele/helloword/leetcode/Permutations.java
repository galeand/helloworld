package com.ele.helloword.leetcode;

//46. Permutations
//给定一个没有重复数字的序列，返回其所有可能的全排列。

import java.util.*;

/**
 * A general approach to backtracking questions in Java
 * (Subsets, Permutations, Combination Sum, Palindrome Partioning)
 * 这道题可以引申出下面这几种通用的情况：子集，全排列，全组合，回文排列
 */
public class Permutations {
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
//        printf("nums为：");

        printf("\n全排列：");
        toPrint(nums);
        permutation(nums);
        printf("组合之和为target："+5);
        toPrint(nums);
        combinationSum(nums, 5);
        printf("所有子集："+nums);
        toPrint(nums);
        subsets(nums);

        int nums2[] = {1, 1, 2};
        printf("全排列2："+nums2);
        toPrint(nums2);
        permutation2(nums2);

        int nums3[] = {10, 1, 2, 7, 6, 1, 5};
        printf("组合2："+nums3);
        toPrint(nums3);
        combinationSum2(nums3, 8);


        int nums4[] = {1, 2, 2};
        printf("子集2："+nums4);
        toPrint(nums4);
        subSet2(nums4);

    }

    public static void toPrint(int[] nums) {
        for (int k : nums) {
            System.out.print(k + "\t");
        }
    }

    private static void printf(String s) {
        System.out.println(s);
    }

    //46. Permutations ，全排列
    private static void permutation(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums);
        printList(list);
        //return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 47. Permutations II ;全排列2 （这个重点应该就是需要查重一下）
    // Given a collection of numbers that might contain duplicates,
    // return all possible unique permutations.
    public static void permutation2(int nums[]) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        printList(list);
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length && !list.contains(tempList)) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void printList(List<?> list) {
        System.out.println(list.toString());
    }

    //39. Combination Sum；找出所有数组中所有可能的组合数之和等于target的情况

    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and
     * a target number (target),
     * find all unique combinations in candidates
     * where the candidate numbers sums to target.
     * The same repeated number may be chosen from candidates unlimited number of times.
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     *
     * @param nums
     * @param target
     */
    public static void combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        printList(list);
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //40. Combination Sum II （重点是nums里面的每个元素只能用一次,而且nums里面可能有重复的元素）
    public static void combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0, target, 2);
        printList(list);
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start, int remain, int distinct) {
        if (remain < 0) {
            return;
        } else if (remain == 0 && !list.contains(tempList)) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                //想想为啥不可以是backtrack(list, tempList, nums, start + 1, remain - nums[i], distinct);
                backtrack(list, tempList, nums, i + 1, remain - nums[i], distinct);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //78. Subsets ;所有子集
    //Given a set of distinct integers, nums, return all possible subsets (the power set).
    //Note: The solution set must not contain duplicate subsets.
    public static void subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        printList(list);
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }

    // 90. Subsets II(给的nums里面可能包含有重复的元素)
    public static void subSet2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, 0);
        printList(list);
    }

    private static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        if (!list.contains(tempList)) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack2(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
