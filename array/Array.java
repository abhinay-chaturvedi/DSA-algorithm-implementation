package array;

import array.moore_voting_algo.MooreVotingAlgo;

public class Array {
    public void runMooresVotingAlgo(int cnt) {
        int arr[] = new int[]{1, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2};
        MooreVotingAlgo mooreVotingAlgo = new MooreVotingAlgo();
        if(cnt == 1) mooreVotingAlgo.findMajorityElement(arr);
        else mooreVotingAlgo.findMajorityElement2(arr);
    }
    public static void main(String[] args) {
        // System.out.println("hi");
        Array array = new Array();
        array.runMooresVotingAlgo(2);
    }
}