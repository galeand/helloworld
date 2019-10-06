package com.ele.helloword.leetcode;

import java.util.LinkedList;

/**
 * @name: TheKthPermutation
 * @author: xiangyf
 * @create: 2019-10-02 09:53
 * @description:
 * 给出集合 `[1,2,3,…,n]`，其所有元素共有 *n*! 种排列。
 *
 *
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 *n* = 3 时, 所有排列如下：
 *
 *
 *
 * 1. `"123"`
 *
 * 2. `"132"`
 *
 * 3. `"213"`
 *
 * 4. `"231"`
 *
 * 5. `"312"`
 *
 * 6. `"321"`
 *
 *
 *
 * 给定 *n* 和 *k*，返回第 *k* 个排列。
 */
public class TheKthPermutation {

    /**
     * 这道题的思路其实我没有太懂，但是我恍惚觉得这道题貌似是像数学题一样，先找出规律，然后具化到写法上面
     * @param n
     * @param k
     * @return
     */
    public static String theKthPermHandler(int n, int k){
        System.out.println("i:\t\tweight:");
        LinkedList<Integer> notUsedList = new LinkedList<>();
        int weight = 1;
        for(int i=1; i<=n; i++){
            notUsedList.add(i);
            if (i == n){
                break;
            }
            weight = weight * i;
            System.out.println(i + "\t\t" + weight);
        }
        System.out.println("此时list：" + notUsedList);
        String res = "";
        k = k - 1;
        System.out.println("res:");
        System.out.println("res:\tk:\tweight:\t");
        while (true){
            res = res + notUsedList.remove(k / weight);
            k = k % weight;
            if (notUsedList.isEmpty()){
                break;
            }
            weight = weight / notUsedList.size();
            System.out.println(res+"\t\t"+k+"\t"+weight);
        }

        return res;
    }

    public static void main(String[] args){
        String res = TheKthPermutation.theKthPermHandler(4, 17);
        System.out.println("最终的结果：" + res);
    }

}
