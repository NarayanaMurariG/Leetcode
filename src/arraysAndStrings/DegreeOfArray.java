package arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://leetcode.com/problems/degree-of-an-array/
//All testcases passed
public class DegreeOfArray {

    public static void main(String[] args){
        int[] array = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(array));
    }

    public static int findShortestSubArray(int[] nums) {
        int maxCount = 0;
        Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                if(list.size() > maxCount){
                    maxCount = list.size();
                }
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i],list);
                if(list.size() > maxCount){
                    maxCount = list.size();
                }
            }
        }
        int least = Integer.MAX_VALUE;
        for(Integer key : map.keySet()){
            if(map.get(key).size() == maxCount){
                List<Integer> list = map.get(key);
                int length = list.get(list.size()-1) - list.get(0) +1;
                if(length < least){
                    least = length;
                }
            }
        }

        return least;
    }

}
