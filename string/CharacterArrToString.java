package string;

public class CharacterArrToString {
    public static void main(String[] args){

        //character array to string
        char[] charArr = {'a','b','c'};
        String combined = String.valueOf(charArr);
        System.out.println(combined);

        //string to character array
        char[] stringArr = "Nayan".toCharArray();
        for (char c : stringArr){
            System.out.print(c+", ");
        }
    }
}
