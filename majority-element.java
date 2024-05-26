class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        int k = n/3;
        List ans = new ArrayList();

        // Here i am going to implement the brute force approach
        
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i = 0; i < n; i++) {
        //     if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
        //     else map.put(nums[i], 1);
        // }
        // List ans = new ArrayList();
        
        // for(Map.Entry<Integer, Integer> m: map.entrySet()) {
        //     if(m.getValue() > k) ans.add(m.getKey());
        // }
        // return ans;
        

        // Here is the efficient approach
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        int firstCount = 0, secondCount = 0;
        for(int i = 0; i < n; i++) {
            if(firstCount == 0 && second != nums[i]) {
                first = nums[i];
                firstCount =1;
            } else if(secondCount == 0 && first != nums[i]) {
                second = nums[i];
                secondCount = 1;
            } else if(first == nums[i]) {
                firstCount++;
            } else if(second == nums[i]) {
                secondCount++;
            } else {
                firstCount--;
                secondCount--;
                   
            }
        }
        firstCount = 0;
        secondCount = 0;
        System.out.println(first);
        System.out.println(second);
        for(int i = 0; i < n; i++) {
            if(nums[i] == first) firstCount++;
            if(nums[i] == second) secondCount++;
        }
        if(firstCount > k) ans.add(first);
        if(secondCount > k) ans.add(second);
        return ans;
    }
}