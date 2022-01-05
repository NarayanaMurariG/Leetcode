package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/481/
public class IntegerToEnglishWords {

    public static void main(String args[]){
        System.out.println(numberToWords(1000000));
    }

    public static String numberToWords(int num) {
        List<Integer> digits = new ArrayList<Integer>();

        if(num == 0){
            return "Zero";
        }
        else{
            int temp = num;
            while(temp > 0){
                digits.add(temp%10);
                temp = temp / 10;
            }

        }
        //0,000,000,000
        //3<x<7 ->Thousand
        //6<x<10 ->Million
        //9 < x ->Billion
        StringBuilder output = new StringBuilder();
        int len = digits.size();
        if(len >= 10){ //Hundreds
            int billion = digits.get(9);
            int million = number(digits.subList(6,9));
            int thousand = number(digits.subList(3,6));
            int hundred = number(digits.subList(0,3));
            output.append(zeroToThousand(billion));
            output.append("Billion ");
            if(million !=0) {
                output.append(zeroToThousand(million));
                output.append("Million ");
            }
            if(thousand !=0) {
                output.append(zeroToThousand(thousand));
                output.append("Thousand ");
            }
            if(hundred !=0) {
                output.append(zeroToThousand(hundred));
            }
        }else if(len >=7 && len <10){ //Millions
//            int million = number(digits.subList(6,9));
            int million = num/1000000;
            int thousand = number(digits.subList(3,6));
            int hundred = number(digits.subList(0,3));
            output.append(zeroToThousand(million));
            output.append("Million ");
            if(thousand !=0) {
                output.append(zeroToThousand(thousand));
                output.append("Thousand ");
            }
            if(hundred !=0) {
                output.append(zeroToThousand(hundred));
            }
        }else if(len >= 4 && len <7){ //Thousands
//            int thousand = number(digits.subList(3,6));
            int thousand = num/1000;
            int hundred = number(digits.subList(0,3));
            output.append(zeroToThousand(thousand));
            output.append("Thousand ");
            output.append(zeroToThousand(hundred));
        }else{ //Hundreds
            output.append(zeroToThousand(num));
        }

        return output.toString().trim();
    }

    private static int number(List<Integer> digits){
        return digits.get(2) * 100 + digits.get(1) * 10 + digits.get(0);
    }

    private static String zeroToThousand(int num){
        List<Integer> digits = new ArrayList<Integer>();

        int temp = num;
        while(temp > 0){
            digits.add(temp%10);
            temp = temp / 10;
        }

        int len = digits.size();
        //two billion one hundred forty-seven million four hundred eighty-three thousand six hundred forty-eight
        //123 99,999 9,999,999 9,999,999,999
        //Hundreds
        if(num == 0){
            return "";
        }

        StringBuilder output = new StringBuilder();
        if(len == 1){
            return getOnesPlace(digits.get(0));
        }
        if(len == 2){
            if(digits.get(1) == 1){
                output.append(tenToTwentyPlace(digits.get(0)));
            }else{
                output.append(tensPlace(digits.get(1)));
                output.append(getOnesPlace(digits.get(0)));
            }
        }
        //112
        if(len == 3){
            output.append(getOnesPlace(digits.get(2)));
            output.append("Hundred ");
            if(digits.get(1) == 1){
                output.append(tenToTwentyPlace(digits.get(0)));
            }else{
                output.append(tensPlace(digits.get(1)));
                output.append(getOnesPlace(digits.get(0)));
            }
        }
        return output.toString();
    }

    private static String tenToTwentyPlace(int num) {
        if(num == 1){
            return "Eleven ";
        }
        if(num == 2){
            return "Twelve ";
        }
        if(num == 3){
            return "Thirteen ";
        }
        if(num == 4){
            return "Fourteen ";
        }
        if(num == 5){
            return "Fifteen ";
        }
        if(num == 6){
            return "Sixteen ";
        }
        if(num == 7){
            return "Seventeen ";
        }
        if(num == 8){
            return "Eighteen ";
        }
        if(num == 9){
            return "Nineteen ";
        }
        else return "Ten ";
    }

    private static String tensPlace(int num) {
        if(num == 1){
            return "Ten";
        }
        if(num == 2){
            return "Twenty ";
        }
        if(num == 3){
            return "Thirty ";
        }
        if(num == 4){
            return "Forty ";
        }
        if(num == 5){
            return "Fifty ";
        }
        if(num == 6){
            return "Sixty ";
        }
        if(num == 7){
            return "Seventy ";
        }
        if(num == 8){
            return "Eighty ";
        }
        if(num == 9){
            return "Ninety ";
        }
        else return "";
    }

    public static String getOnesPlace(int num){
        if(num == 1){
            return "One ";
        }else if(num == 2){
            return "Two ";
        }else if(num == 3){
            return "Three ";
        }else if(num == 4){
            return "Four ";
        }else if(num == 5){
            return "Five ";
        }else if(num == 6){
            return "Six ";
        }else if(num == 7){
            return "Seven ";
        }else if(num == 8){
            return "Eight ";
        }else if(num == 9){
            return "Nine ";
        }else{
            return "";
        }
    }



}
