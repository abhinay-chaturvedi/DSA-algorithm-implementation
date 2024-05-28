public class Solution {

    // Simple function that returns
    // count of subarrays of arr with
    // XOR value equals to m
    static long subarrayXorBruteApproach(int arr[],
            int n, int m) {

        // Initialize ans
        long ans = 0;

        // Pick starting point i of
        // subarrays
        for (int i = 0; i < n; i++) {

            // Store XOR of current
            // subarray
            int xorSum = 0;

            // Pick ending point j of
            // subarray for each i
            for (int j = i; j < n; j++) {

                // calculate xorSum
                xorSum = xorSum ^ arr[j];

                // If xorSum is equal to
                // given value, increase
                // ans by 1.
                if (xorSum == m)
                    ans++;
            }
        }

        return ans;
    }

    // Driver code
    public static void main(String args[]) {

        int[] arr = { 4, 2, 2, 6, 4 };
        int n = arr.length;
        int m = 6;

        System.out.println("Number of subarrays"
                + " having given XOR is "
                + subarrayXorBruteApproach(arr, n, m));
    }
}