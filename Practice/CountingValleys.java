package Practice;

public class CountingValleys {
    public static void main(String[] args){

        System.out.println(countingValleys(100,"DDUDUDDUDDUDDUUUUDUDDDUUDDUUDDDUUDDUUUUUUDUDDDDUDDUUDUUDUDUUUDUUUUUDDUDDDDUDDUDDDDUUUUDUUDUUDUUDUDDD"));
    }
    public static int countingValleys(int steps, String path) {
        int numberOfValleys, i, flag;
        char[] charArr = path.toCharArray();
        numberOfValleys=0;
        i=0;
        flag=0;

        while (i<steps){
            if(charArr[i] == 'U'){
                flag++;
            } else if(charArr[i] == 'D') {
                flag--;
            }
            if(flag == -1 && charArr[i+1] == 'U'){
                numberOfValleys++;
            }
            //System.out.print(flag+", ");
            i++;
        }
        return numberOfValleys;
    }
}