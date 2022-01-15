package design;

import java.util.*;
//https://leetcode.com/submissions/detail/618136971/?from=explore&item_id=478
//All testcases passed
public class LRUCacheImplementation {
    public static void main(String args[]){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);
    }
}

class LRUCache {

    private int capacity;
    private int counter;
    private int leastUsed;
    private Map<Integer,Integer> cacheMap = new HashMap<Integer,Integer>();
    private Map<Integer,Integer> accessCounter = new HashMap<Integer,Integer>();
    private Map<Integer,Integer> reverseMap = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.counter = 0;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            updateCounter(key);
            System.out.println(cacheMap.get(key));
            return cacheMap.get(key);
        }else{
            System.out.println(-1);
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            updateCounter(key);
            cacheMap.put(key,value);
        }else if(cacheMap.size() >= this.capacity){
            evictItem();
            cacheMap.put(key,value);
            updateCounter(key);
        }else{
            cacheMap.put(key,value);
            if(counter == 0){
                updateCounter(key);
            }else{
                updateCounter(key);
            }
        }
    }

    private void updateCounter(int key) {
        int itemToRemove=0;
        if(reverseMap.containsKey(key)){
            itemToRemove = reverseMap.get(key);
            accessCounter.remove(itemToRemove);
        }
        int temp = counter;
        reverseMap.put(key,temp);
        accessCounter.put(temp,key);
        counter++;
    }

    private void evictItem(){
        boolean flag = true;
        while(flag){
            if(accessCounter.containsKey(leastUsed)){
                int key = accessCounter.get(leastUsed);
                cacheMap.remove(key);
                reverseMap.remove(key);
                accessCounter.remove(leastUsed);
                leastUsed++;
                flag = false;
            }else{
                leastUsed++;
            }
        }
    }

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

