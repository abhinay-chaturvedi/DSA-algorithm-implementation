package string_processing.kmp;


// import java.util.Arrays;
// import java.util.List;

// import java.util.stream.Collectors;

public class KMP {
    

    public int[] buildKmpArray(String s) {
        int n = s.length();
        int arr[] = new int[n];
        int i = 1, j = 0;
        // int cnt = 0;
        while(i < n) {
            // System.out.println(cnt++);
            if(s.charAt(i) == s.charAt(j)) {
                arr[i]  = j + 1;
                i++;
                j++;
            } else if(j == 0) {
                i++;
            } else {
                j = arr[j - 1];
            }
        }
        // List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // System.out.println(list);
        return arr;
    }
}
