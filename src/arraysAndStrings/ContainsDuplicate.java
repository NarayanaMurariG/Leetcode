package arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(duplicates.contains(nums[i])){
                return true;
            }else{
                duplicates.add(nums[i]);
            }
        }
        return false;
    }
}
