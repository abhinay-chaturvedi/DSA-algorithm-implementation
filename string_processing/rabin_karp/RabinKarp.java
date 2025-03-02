package string_processing.rabin_karp;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    // This is the class for Rabin karp algorithm 
    // So this call provide the funciton which takes string s, and pattern p
    // and will return the occurrences of p in s;
    // Also all the utils methods are public So that we can use this alogrithm based on 
    // custom need
    // Also u can choose p and mod based on your choice by providing in the constructor
    private long p = 31;
    private int mod =  (int) (1e9 + 7);
    public RabinKarp() {
    }
    public RabinKarp(long p, int mod){
        this.p = p;
        this.mod = mod;
    };
    public long[] buildPowArray(int size) {
        long p_pow[] = new long[size];
        p_pow[0] = 1;
        for(int i = 1; i < size; i++) {
            p_pow[i] = (p_pow[i - 1] * p) % mod;
        }
        return p_pow;
    }
    public long[] buldHashArray(String s, long p_pow[]) {
        int n = s.length();
        long hash[] = new long[n + 1];
        for(int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] + (s.charAt(i) - 'a' + 1) * p_pow[i]) % mod;
        }
        return hash;
    }
    public long buildStringHash(String s, long p_pow[]) {
        int n = s.length();
        long hs = 0;
        for(int i = 0; i < n; i++) {
            hs += ((s.charAt(i) - 'a' + 1) * p_pow[i]) % mod; 
        }
        return hs;
    }
    public List<Integer> getOccurrences(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;
        long[] p_pow = this.buildPowArray(s.length());
        long hash[] = this.buldHashArray(s, p_pow);
        long hs = this.buildStringHash(p, p_pow);

        int N = s.length(), P = p.length();
        for(int i = 0; i < N - P + 1; i++ ) {
            long curr_hash = (hash[i + P] - hash[i] + mod) %  mod;
            long p_hash = hs * p_pow[i] % mod;
            if(p_hash == curr_hash) {
                ans.add(i);
            }

        }
        return ans;
    }
}
