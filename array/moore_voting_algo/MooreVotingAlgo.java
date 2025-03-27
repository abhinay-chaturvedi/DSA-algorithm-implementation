package array.moore_voting_algo;

public class MooreVotingAlgo {
    // Simple algo for n/2 majority element
    public int findMajorityElement(int arr[]) {
        int pot = -1, cnt = 0;
        for (int num: arr) {
            if(num == pot) {
                cnt++;
            } else if(cnt > 0) {
                cnt--;
            } else {
                cnt = 1;
                pot = num;
            }
        }
        System.out.println(pot);
        return pot;
    }
    public int[] findMajorityElement2(int arr[]) {
        int first = -1, firstCount = 0, second = -1, secondCount = 0;
        for(int num: arr) {
            if(num == first || firstCount == 0 && second != num) {
                first = num;
                firstCount++;
            } else if(second == num || secondCount == 0) {
                second = num;
                secondCount++;
            } else {
                firstCount--;
                secondCount--;
            }
        }
        System.out.println(first + "---" + second);
        return new int[]{first, second};
    }
}
