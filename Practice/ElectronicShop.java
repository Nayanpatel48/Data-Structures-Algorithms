package Practice;
import java.util.Arrays;

public class ElectronicShop {
    public static void main(String[] args){
        int[] keyboards = {40,50,60};
        int[] drives = {5,8,12};
        int b;
        b=60;
        System.out.println(getMoneySpent(keyboards,drives,b));
    }
    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int[] possibities = new int[drives.length*keyboards.length];
        int k=0;
        for (int i=0;i<keyboards.length;i++) {
            for (int j=0;j< drives.length;j++) {
                //System.out.print(k+++",");
                possibities[k++] = keyboards[i] + drives[j];
                //k++;
            }
        }
        Arrays.sort(possibities);
        System.out.println(possibities[0]);
        for(int i=possibities.length-1;i>=0;i--){
            if (possibities[i] <=b){
                return possibities[i];
            }
        }
        return -1;
    }
}