package arraysAndStrings;

import java.util.*;


//https://leetcode.com/problems/top-k-frequent-elements/submissions/
//All test cases passed
public class TopKFrequentElements {

    public static void main(String[] args){
        int[] nums = {1};
        print(topKFrequent(nums,1));
    }

    private static void print(int[] productExceptSelf) {
        for(int i=0;i<productExceptSelf.length;i++){
            System.out.println(productExceptSelf[i]);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        ElementFrequencyComparator comparator = new ElementFrequencyComparator();
        Queue<ElementFrequency> priorityQueue = new PriorityQueue(nums.length,comparator);
        Map<Integer,ElementFrequency> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ElementFrequency(nums[i],1));
            int prevCount = map.get(nums[i]).getFrequency();
            map.get(nums[i]).setFrequency(prevCount + 1);
        }

        for(Integer key : map.keySet()){
            priorityQueue.add(map.get(key));
        }

        for(int i=0;i<k;i++){
            result[i] = priorityQueue.poll().getValue();
        }

        return result;
    }

}

class ElementFrequency {
    private int value;
    private int frequency;

    public ElementFrequency(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}

class ElementFrequencyComparator implements Comparator<ElementFrequency> {

    @Override
    public int compare(ElementFrequency e1, ElementFrequency e2) {
        return e2.getFrequency() - e1.getFrequency();
    }

}
