package com.leetcode.javacode;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * 1、两数之和
 */
public class OneAndTwoSum {

    /**
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param traget
     * @return
     * @throws Exception
     */
    public int[] TwoSun(int[] nums, int traget) throws Exception {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == traget) {
                    return new int[]{i, j};
                }
            }
        }
        throw new Exception("No two Sum solution");
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{2, 7, 11, 15};
        int traget = 9;
        OneAndTwoSum oneAndTwoSum = new OneAndTwoSum();
        int[] retrunResult = oneAndTwoSum.TwoSun2(nums, traget);
        System.out.println("两数之和等于" + traget + "的数组下标为【" +
                retrunResult[0] + "," + retrunResult[1] + "】");

    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)·
     * @param nums
     * @param traget
     * @return
     * @throws Exception
     */
    public int[] TwoSun2(int[] nums, int traget) throws Exception {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = traget - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        throw new Exception("No two Sum solution");

    }


}
