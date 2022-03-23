package arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/gas-station/
//All testcases passed
//Greedy Algorithm
public class GasStation {

    public static void main(String[] args){

        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int maxGas = Integer.MIN_VALUE;
        List<Integer> startPos = new ArrayList<>();
        int gasSum = 0;
        int costSum = 0;
        for(int i=0;i<gas.length;i++){
            gasSum = gasSum + gas[i];
            costSum = costSum + cost[i];
            if(gas[i] > cost[i]){
                startPos.add(i);
            }
        }


        if(gasSum < costSum){
            return -1;
        }

        Collections.sort(startPos,Collections.reverseOrder());

        for(Integer start : startPos){
            boolean flag = checkCircuit(gas,cost,0,start,0);
            if(flag){
                return start;
            }
        }

        return -1;
        /*for(int i=0;i< gas.length;i++){
            if(gas[i] >= cost[i]){
                boolean flag = checkCircuit(gas,cost,0,i,0);
                if(flag){
                    return i;
                }
            }else{
                continue;
            }
        }*/

    }

    private static boolean checkCircuit(int[] gas, int[] cost, int count,int current, int fuelCapacity) {
        int length = gas.length;
        int currentFuel = fuelCapacity;
        int requiredFuel = 0;
        int index = -1;
        if(length == count){
            return true;
        }
        for(int i=0;i< length;i++){
            index = (i+current)%length;
            currentFuel = currentFuel + gas[index];
            requiredFuel = cost[index];
            if(currentFuel < requiredFuel){
                return false;
            }else{
                return checkCircuit(gas,cost,++count,(index+1)%length,currentFuel-requiredFuel);
            }
        }

        return false;
    }
}
