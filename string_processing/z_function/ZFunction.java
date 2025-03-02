package string_processing.z_function;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZFunction {
    // So basically ZFunction is used to get the array for string s, which stores the length of longest prefix
    // at index i,  which is also the prefix of suffix of s starting at index i
    // So this can be done in 2 ways 
    // Easy way - We can run 2 for loop and can get the array filled. TC - o(N^2)
    // Optimized Way - Using ZFunction - which can fill the array in one pass, means o(n)
    

    // o(N^2)
    public int[] buildZArray(String s) {
        int n = s.length();
        int z[] = new int[n];
        for(int i = 1; i < n; i++) {
            int l = 0, r = i;
            while(r < n && s.charAt(l) == s.charAt(r)) {
                l++;
                r++;
            }

            z[i] = l;
        }
        System.out.println(Arrays.stream(z).boxed().collect(Collectors.toList()));
        return z;
    }
    // So here is the optimized implementation of the z-algo
    public int[] optimizedZArray(String s) {
        int n = s.length();
        int z[] = new int[n];
        int l = 0, r = 0;
        for(int i = 1; i < n; i++) {
           
            if(i < r) {
                z[i] = Math.min(r - i, z[i - l]);
            }
            while(i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if(i + z[i] > r) {
                r = i + z[i];
                l = i;
            }
        }
        System.out.println(Arrays.stream(z).boxed().collect(Collectors.toList()));
        return z;
    }
}
