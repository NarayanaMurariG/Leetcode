package arraysAndStrings;

import java.util.Arrays;
//https://leetcode.com/problems/product-of-array-except-self/
//All test cases passed
public class ProductOfArrayExceptSelf {


    public static void main(String[] args){
        int[] array = {-1,1,0,-3,3};
        print(productExceptSelf(array));
    }

    private static void print(int[] productExceptSelf) {
        for(int i=0;i<productExceptSelf.length;i++){
            System.out.println(productExceptSelf[i]);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[nums.length];
        int[] left = Arrays.copyOf(nums,length);
        int[] right = Arrays.copyOf(nums,length);

        for(int i=0;i<length;i++){
            if(i == 0){
                left[i] = nums[0];
            }else{
                left[i] = left[i] * left[i-1];
            }

            if(i == 0){
                right[length - i - 1] = nums[length - i -1];
            }else{
                right[length - i - 1] = right[length - i - 1] * right[length - i];
            }
        }
        result[0] = right[1];
        result[length-1] = left[length-2];
        for(int i = 1;i<length-1;i++){
            result[i] = left[i-1] * right[i+1];
        }
        return result;
    }

}
