class Solution {
    private int searchElement(int k, int start, int end, int[] nums) {
        int searchIndex = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == k) return mid;
            if(nums[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return searchIndex;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(i!= 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < n; j++) {
                if(j != (i + 1) && nums[j] == nums[j-1]) continue;
                // here one opimization i can do that why removing this for
                // loop and using binary search
                // for this method time complexity would be o(n2 logn(n))
                int searchNumber = -(nums[i] + nums[j]);
                int searchIndex = searchElement(searchNumber, j + 1, n-1, nums);
                if(searchIndex != -1) {
                    List<Integer> li = new ArrayList<Integer>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[searchIndex]);
                        ans.add(li);
                }
                // for this method time complexity would be o(n3)
                // for(int k = j + 1; k < n; k++) {
                //     if(k != (j + 1) && nums[k] == nums[k-1]) continue;
                //     int sum = nums[i] + nums[j] + nums[k];
                //     if(sum == 0) {
                //         List<Integer> li = new ArrayList<Integer>();
                //         li.add(nums[i]);
                //         li.add(nums[j]);
                //         li.add(nums[k]);
                //         ans.add(li);
                //         break;
                //     }
                // }
            }
        }
        return ans;
    }
}