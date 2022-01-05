package arraysAndStrings;

import java.util.HashMap;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/480/
public class FirstUniqueCharacterInString {

    public static int firstUniqChar(String s) {
        char letters[] = s.toCharArray();
        HashMap<Character,Integer> mapCount = new HashMap<Character, Integer>();
        for(int i=0;i<letters.length;i++){
            if(mapCount.containsKey(letters[i])){
                int val = mapCount.get(letters[i]);
                mapCount.put(letters[i],++val);
            }else{
                mapCount.put(letters[i],1);
            }
        }

        for(int i=0;i<letters.length;i++){
            if(mapCount.get(letters[i]) < 2){
                return i;
            }
        }

        return -1;
    }
    public static void main(String args[]){
        String input = "aabb";
        System.out.println(firstUniqChar(input));
    }
}