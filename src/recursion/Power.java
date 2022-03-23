package recursion;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/powx-n/
//All test cases passed
public class Power {

    public static void main(String[] args){
        Power pow = new Power();
//        System.out.println(pow.myPow(2,11));
        System.out.println(pow.myPow(2,-2147483648));
    }


    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
}
