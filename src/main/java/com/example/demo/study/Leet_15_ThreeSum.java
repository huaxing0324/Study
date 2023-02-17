package com.example.demo.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_15_ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length <= 2) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if((nums[left] + nums[right]) == target){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right --;
                    while (left < right && nums[left -1] == nums[left]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }else if ((nums[left] + nums[right]) < target){
                    left ++;
                }else{
                    right --;
                }
            }
        }
        return ans;
    }
}
