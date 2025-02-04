package string;

class Palindrome {
    public static boolean isPalindrome(String s1) {
        String s = s1.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char charI = s.charAt(i);
            char charJ = s.charAt(j);

            if (!Character.isLetterOrDigit(charI)) { // Skip if not alphanumeric
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(charJ)) { // Skip if not alphanumeric
                j--;
                continue;
            }
            if (charI != charJ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome("Nayan..||"));
    }
}