package other;

import java.util.*;


//https://leetcode.com/discuss/interview-question/1014660/samsara-oa-codesignal-summer-internship
public class BrokenKeyboard {
    public static void main(String[] args ){
        String input = "3 + 2 = 5";
        List<Character> list = new ArrayList<Character>();
        list.add('a');
        char[] letters = {};
        Set<Character> letterSet = new HashSet<Character>();
        //For text = "Hello, this is CodeSignal!" and letters = ['e', 'i', 'h', 'l', 'o', 's']

        for (char c : letters ) {
            letterSet.add(c);
        }

        System.out.println(brokenKeyboard(input,letterSet));

    }

    public static int brokenKeyboard(String text,Set<Character> letterSet){
        int noOfWords = 0;
        String[] words = text.toLowerCase().split(" ");
        for(int i=0;i<words.length;i++){
            if(checkCharInWord(words[i],letterSet)){
                noOfWords++;
            }
        }
        return noOfWords;
    }

    private static boolean checkCharInWord(String word, Set<Character> letterSet) {

        for (char c : word.toCharArray()) {

            if( c >= 'a' && c<= 'z'){
                if(letterSet.contains(c)){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

}
