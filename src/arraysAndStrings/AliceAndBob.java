package arraysAndStrings;


//https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
//All testcases passed
public class AliceAndBob {
    public static void main(String[] args){

    }

    public static boolean winnerOfGame(String colors) {

        int alice = 0,bob = 0;

        for(int i=0;i<colors.length()-2;i++){
            String subString = colors.substring(i,i+3);
            if(subString.equals("AAA")){
                alice++;
            }
            if(subString.equals("BBB")){
                bob++;
            }
        }

        if(alice > bob){
            return true;
        }else{
            return false;
        }

    }
}
