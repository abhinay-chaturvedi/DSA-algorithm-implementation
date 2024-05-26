class Solution {
    public int maxSubArray(int[] nums) {
        // Since We are only asked for the sum, so we can use kadane's
        // algorithm to find out the largest subarray sum
        int sum = 0;
        int n = nums.length;
        int ans = -10000;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}