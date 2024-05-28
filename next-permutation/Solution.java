import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        
        int breakPoint = -1;
        int n = nums.length;
        // find the break of the array
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }
        // in case array in the last form of permutation then return first one.
        if(breakPoint == -1) {
            Arrays.sort(nums);
            return ;
        }
        int el = nums[breakPoint];
        int swapIndex = breakPoint;
        // here I need to find the just greater element of break point
        for(int i = breakPoint + 1; i < n; i++) {
            if(nums[i] > el) {
                swapIndex = i;
            }
        }
        // swap both element breakpoint and swapindex element
        int a = nums[breakPoint];
        nums[breakPoint] = nums[swapIndex];
        nums[swapIndex] = a;

        // After swapping just sort all the elements, next to the break point 
        // to get the lexicographically next permutation.
        Arrays.sort(nums, breakPoint + 1, nums.length);
        // return nums;
    }
}
