package Practice;

public class CountingValleys {
    public static void main(String[] args){

        //System.out.println(countingValleys(100,"DDUDUUDUDDD"));
        System.out.println(getInteger(124,2));
    }
    public static int getInteger(int x, int idx){
        String str = Integer.toString(x);
        char[] strArr = str.toCharArray();
        char[] charArr = {'1','2','3','4','5','6','7','8','9'};
        int j;
        j=0;
        String s = "Nayan";
        System.out.println(s.length());
        while (charArr.length > j){
            if (strArr[idx] == charArr[j]){
                return charArr[j]-'0';
            }
            j++;
        }
        return -1;
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