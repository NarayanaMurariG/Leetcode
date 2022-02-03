package arraysAndStrings;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2971/
//All testcases passed
public class MissingNumber {
    public static void main(String[] args){

    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int size = nums.length;
        int actualSum = (size+1)*size/2;
        for(int i=0;i<size;i++){
            sum = sum + nums[i];
        }
        return actualSum-sum;
    }
}
