package arraysAndStrings;
//https://leetcode.com/problems/two-sum/
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int output[] = {-1,-1};
        for(int i=0;i<list.size();i++){
            if(list.contains(target - list.get(i)) && (i != list.indexOf(target - list.get(i)))){
                output[0] = i;
                output[1] = list.indexOf(target - list.get(i));
                System.out.println(output[0]);
                System.out.println(output[1]);
                break;
            }
        }

        return output;
    }

    public static void main(String args[]){
        int list[] = {3,2,4};
        twoSum(list,6);
    }
}
