package Basics;

/**
 * Created by matao on 5/26/16.
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(20, 5));
        System.out.println(recursionGcd(20, 5));
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static int recursionGcd(int p, int q) {
        while (q > 0) {
            int r = p % q;
            p = q;
            q = r;
        }
        return p;
    }
}
