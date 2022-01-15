package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;


//https://leetcode.com/problems/longest-palindromic-substring/
//Failed in Time Complexity
public class LongestPalindromeString {

    public static void main(String args[]){
        String answer = longestPalindrome("babad");
        System.out.println(answer);
    }

    static String longest = "";
    static int a,b;
    public static String longestPalindrome(String s) {
        longest = "";
        int len = s.length();
//        int dp[len][len];

        Map<String,Boolean> palindromeMap = new HashMap<String,Boolean>();
//        int len = s.length();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                checkForLargerPalindrome(i,j,len,s,palindromeMap);
            }
        }
        return longest;
    }

    public static void checkForLargerPalindrome(int i,int j,int length,String s,Map<String,Boolean> palindromeMap){
        if(i<0 || j>length){
            return;
        }
        else{
            String subString = s.substring(i,j);
            boolean amIPalindrome;
            if(palindromeMap.containsKey(subString)){
                amIPalindrome = palindromeMap.get(subString);
            }else{
                amIPalindrome = isPalindrome(subString);
                palindromeMap.put(subString,amIPalindrome);
            }


            if(amIPalindrome){
                if(longest.length() < subString.length()){
                    longest = subString;
                }
                checkForLargerPalindrome(--i,++j,length,s,palindromeMap);
            }
        }
    }

    public static boolean isPalindrome(String s){
        int len = s.length();
        char array[] = s.toCharArray();
        for(int i=0;i<len/2;i++){
            if(array[i] != array[len-i-1]){
                return false;
            }
        }
        return true;
    }

}
