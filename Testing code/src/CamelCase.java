public class CamelCase {
    public static void main(String[] args){
        String name = "aNaN";
        int  numberOfWords;
        numberOfWords=1;

        //converting string into character array
        char[] nameArray = name.toCharArray();

        //accessing string elements one by one
        for(int i=0;i<name.length();i++){
            if(check(nameArray[i])){
                numberOfWords++;
            }
        }
        System.out.println(numberOfWords);
    }
    public static boolean check(char character){
        char[] charArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U',
        'W','X','Y','Z'};

        for(int i=0;i<25;i++){
            if(charArray[i] == character){
                return true;
            }
        }
        return false;
    }
}