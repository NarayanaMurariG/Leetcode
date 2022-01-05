package recursion;

import java.util.*;
//https://leetcode.com/explore/interview/card/amazon/84/recursion/521/
public class LetterCombinationOfPhoneNumbers {
    public static void main(String args[]){
        System.out.println(letterCombinations("").toString());
    }

    public static List<String> letterCombinations(String letters) {
        Map<String,List<String>> digit_letters = new HashMap<String,List<String>>();

        for(char key : data.keySet()){
            String value = data.get(key);
            List<String> valueStrings = new ArrayList<String>();
            for(char val : value.toCharArray()){
                valueStrings.add(String.valueOf(val));
            }
            digit_letters.put(String.valueOf(key),valueStrings);
        }
        List<String> output = recursion(letters,digit_letters);
        return output;
    }

    private static List<String> recursion(String value, Map<String, List<String>> digit_letters){
        List<String> cominations = new ArrayList<String>();
        if(value.length() == 0){
            return cominations;
        }
        if(value.length() == 1){
            cominations.addAll(digit_letters.get(value));
        }else{
            //List of current over recursion of substring
            List<String> values = digit_letters.get(value.substring(0,1));
            List<String> previousCombinations = recursion(value.substring(1), digit_letters);
            for(String val : values){
                for(String temp : previousCombinations){
                    cominations.add(val+temp);
                }
            }

        }
        return cominations;
    }

    public static Map<Character,String> data = new HashMap<Character,String>();

    static {
        data.put('2',"abc");
        data.put('3',"def");
        data.put('4',"ghi");
        data.put('5',"jkl");
        data.put('6',"mno");
        data.put('7',"pqrs");
        data.put('8',"tuv");
        data.put('9',"wxyz");
    }
}
