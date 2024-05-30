// package missing-and-repeating;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    int[] findTwoElementMath(int arr[], int n) {
        // code here

        // We can solve this problem using two for loop which will have timecomplexity
        // o(n2)
        // The better approach would be to use hashmap to store the frequency of each
        // element
        // and from the hashmap, we can easily find the repeating element and with the
        // help of
        // repeating element we can also find missing number.

        // This Question has optimal solution using two ways , using maths and by xor;

        // Here is the solution using maths
        long normalArraySum = 0, squareArraySum = 0, sum = 0, squareSum = 0;
        for (int i = 0; i < n; i++) {
            normalArraySum += (long) arr[i];
            squareArraySum += ((long) arr[i] * (long) arr[i]);
            sum += (long) (i + 1);
            squareSum += ((long) (i + 1) * (long) (i + 1));
        }
        // now find out x-y using normarAarraySum - sum;
        long min = normalArraySum - sum;
        // This will be the x+y
        long plus = ((squareArraySum - squareSum) / min);
        // using these two equations, we can find x which is the repeating number
        long x = (min + plus) / 2;
        long y = x - min;
        int[] ans = new int[2];
        ans[0] = (int) x;
        ans[1] = (int) y;
        return ans;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solution().findTwoElementMath(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
