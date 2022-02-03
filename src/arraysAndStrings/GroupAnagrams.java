package arraysAndStrings;

import java.util.*;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2970/
//All test cases passed
public class GroupAnagrams {
    public static void main(String[] args){
        String[] list = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = groupAnagrams(list);
        System.out.println(output);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int index=0;
        for(String str : strs){
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String key = String.valueOf(characters);
            if(map.containsKey(key)){
                List<String> list = output.get(map.get(key));
                list.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                output.add(index,list);
                map.put(key,index);
                index++;
            }
        }
        return output;
    }
}
