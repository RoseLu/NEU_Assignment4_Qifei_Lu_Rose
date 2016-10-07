import java.util.HashSet;
import java.util.Set;

public class Assignment3 {
    // assignments
    /**
     * Write a method to find N numbers which are power of three. e.g. n=4,
     * return {1,3,9,27}
     */
    public int[] findPowerOfThree(int n) {
        if (n <= 0) {
            return null;
        }
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * 3;
        }
        return result;
    }

    /**
     * Given a integer 'n', return n%count, count is the number of digits of n
     * For example, n = 100, return 1
     */
    public int countDigits(int n) {
        int numberOfDigits = 1;
        int number = n;
        while (number / 10 != 0) {
            number = number / 10;
            numberOfDigits++;
        }
        return n % numberOfDigits;
    }

    /**
     * Given a integer 'n', if n is odd, print n odd numbers, if n is even,
     * print n even numbers. For example, n = 3, print 1 3 5 n = 4, print 0 2 4
     * 6
     */
    public int[] printNumbers(int n) {
        if (n <= 0) return null;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n % 2 == 0 ? 2 * i: 2 * i + 1;
        }
        for (int idx: result) {
            System.out.println(idx + " ");
        }
        System.out.println();
        return result;
    }

    /**
     * Given numRows, generate the first numRows of Pascal's triangle. For
     * example, given numRows = 5, return: [1] [1,1] [1,2,1] [1,3,3,1]
     * [1,4,6,4,1]
     */
    public int[][] generatePascalsTriangle(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    result[i][j] = 1;
                    continue;
                }
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }
        return result;
    }

    /**
     * Write a function that takes a string as input and reverse only the vowels
     * of a string. For example: Given s = "hello", return "holle".
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<Character> vowelsDictionary = new HashSet<>();
        vowelsDictionary.add('a');
        vowelsDictionary.add('e');
        vowelsDictionary.add('i');
        vowelsDictionary.add('o');
        vowelsDictionary.add('u');
        vowelsDictionary.add('A');
        vowelsDictionary.add('E');
        vowelsDictionary.add('I');
        vowelsDictionary.add('O');
        vowelsDictionary.add('U');
        int p1 = 0, p2 = s.length() - 1;
        char[] characters = s.toCharArray();
        while (p1 < p2) {
            while (p1 < s.length() && !vowelsDictionary.contains(characters[p1])) {
                p1++;
            }
            if (p1 >= p2) break;
            while (p1 < p2 && !vowelsDictionary.contains(characters[p2])) {
                p2--;
            }
            swap(characters, p1, p2);
            p1++;
            p2--;
        }
        return new String(characters);
    }
    private void swap(char[] characters, int i, int j) {
        char temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;
    }
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space
     * characters ' ', return the length of last word in the string. If the last
     * word does not exist, return 0. Note: A word is defined as a character
     * sequence consists of non-space characters only.
     */
    public int lengthOfLastWord(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        int length = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' '){
                length++;
            } else break;
        }
        return length;
    }

    /**
     * Reverse a string by words. Do not use 'split' function. e.g. "I like
     * soccer" --> "soccer like I"
     */
    public String reverseString2(String str) {
        if (str == null || str.length() == 0) return str;
        str = str.trim();
        char[] letters = str.toCharArray();
        reverseString(letters, 0, str.length() - 1);
        int start = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] ==  ' ') {
                reverseString(letters, start, i - 1);
                start = i + 1;
            }
        }
        reverseString(letters, start, letters.length - 1);
        return new String(letters);
    }
    private void reverseString(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0 || start >= end) return;
        for (int i = 0; i <= (end - start) / 2; i++) {
            swap(chars, start + i, end - i);
        }
    }

    // Bonus
    /**
     * A robot from Mars send a long message to Earth which only contains many
     * "SOS", like "SOSSOS", "SOSSOSSOSSOSSOS" But the radiation from universe
     * changed some characters of the massage. Write a method to count how many
     * characters were changed. For example, "SOSSOSSOS" might be changed to
     * "SOSSUSSOP", then your method should return 2. The message was consisted
     * by "SOS" so its length will be multiple of 3. You could assume the
     * message only contains upper letter.
     */
    public int checkMessage(String message) {
        if (message == null || message.length() % 3 != 0) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if ((i % 3 == 0 || i % 3 == 2) && message.charAt(i) != 'S'){
                count++;
            } else if (i % 3 == 1 && message.charAt(i) != 'O') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Assignment3 assignment = new Assignment3();

        System.out.println("Test: findPowerOfThree");
        int[] result = assignment.findPowerOfThree(8);
        for (int number: result) {
            System.out.print(number + " "); // Output: 1 3 9 27 81 243 729 2187
        }
        System.out.println();

        System.out.println("Test: countDigits");
        System.out.println(assignment.countDigits(-124)); // Output; -1
        System.out.println(assignment.countDigits(1220)); // Output; 0

        System.out.println("Test: PrintNumbers");
        assignment.printNumbers(10); // Output: 0 2 4 6 8 10 12 14 16 18
        assignment.printNumbers(9); // Output: 1 3 5 7 9 11 13 15 17

        System.out.println("Test: generatePascalsTriangle");
        int[][] triangle = assignment.generatePascalsTriangle(8);
        for(int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        } //Output:
//        1
//        1 1
//        1 2 1
//        1 3 3 1
//        1 4 6 4 1
//        1 5 10 10 5 1
//        1 6 15 20 15 6 1
//        1 7 21 35 35 21 7 1

        System.out.println("Test: reverseVowels");
        System.out.println(assignment.reverseVowels("HELLO")); // HOLLE
        System.out.println(assignment.reverseVowels("lintcode")); //Output: lentcodi

        System.out.println("Test: lengthOfLastWord");
        System.out.println(assignment.lengthOfLastWord("the sky is blue ")); // Output: 4

        System.out.println("Test: reverseString2");
        System.out.println(assignment.reverseString2("They like soccer"));//Output: soccer like They

        System.out.println("Test: checkMessage");
        System.out.println(assignment.checkMessage("SOSSUSSOP")); // Output: 2
    }

}
