package string_processing.hashing;

public class Hashing {
    private long hash;
    private long pow[];
    int size;
    private final long p = 31;
    private final int mod = (int) (1e9 + 7);

    public Hashing(String s) {
        this.size = s.length();
        pow = new long[size];
        fillPow();
        calculateHash(s);
    }

    private void calculateHash(String s) {
        this.hash = 0;
        for (int i = 0; i < size; i++) {
            this.hash += (((s.charAt(i) - '0') + 1) * pow[i] % mod);
        }
    }

    private void fillPow() {
        pow[0] = 1;
        for (int i = 1; i < size; i++) {
            pow[i] = (pow[i - 1] * p) % mod;
        }
    }

    public long getHash() {
        return this.hash;
    }

}
