package string;

public class StringToCharArr {
    public static void main(String[] args){
        String name= "Nayan";
        char[] nameArr = name.toCharArray();
        for (char c : nameArr) {
            System.out.print(c + ", ");
        }
    }
}
