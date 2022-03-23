package arraysAndStrings;

import java.util.*;
//https://leetcode.com/problems/insert-delete-getrandom-o1/
//All testcases passed
public class RandomizedSet {

    public static void main(String[] args){
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.remove(0));
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
        System.out.println(set.getRandom());
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
    }
    private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    private List<Integer> list = new ArrayList<Integer>();
    private Random rand = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val,list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int pos = map.get(val);
            int lastItem = list.get(list.size()-1);
            list.remove(pos);
            list.add(pos,lastItem);
            list.remove(list.size()-1);

            map.put(lastItem,pos);
            map.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
