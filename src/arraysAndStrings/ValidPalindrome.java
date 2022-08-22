package arraysAndStrings;


//https://leetcode.com/problems/valid-palindrome
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = cleanedString.length();
        for(int i=0;i<length/2;i++){
            if(cleanedString.charAt(i) != cleanedString.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
