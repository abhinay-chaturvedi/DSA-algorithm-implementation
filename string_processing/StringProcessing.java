package string_processing;

// import string_processing.kmp.KMP;
// import string_processing.hashing.Hashing;
// import string_processing.rabin_karp.RabinKarp;
import string_processing.z_function.ZFunction;

public class StringProcessing {
    
    public static void main(String[] args) {
        // Hashing hashing = new Hashing("ab");
        // System.out.println(hashing.getHash());
        // RabinKarp rabinKarp = new RabinKarp();
        // System.out.println(rabinKarp.getOccurrences("abbccdddessbbcksjfbbcc", "bbccc"));
        // KMP kmp = new KMP();
        // kmp.buildKmpArray("aaaaaabcaaabfssccdaaaaaajfskjlsaaalsjfsaaa");
        ZFunction zFunction = new ZFunction();
        zFunction.optimizedZArray("abacaba");
    }
}
