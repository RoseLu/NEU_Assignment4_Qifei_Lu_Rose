import org.junit.Assert;

/**
 * Created by qiqi on 2016/10/6.
 */
public class Assignment3Test {

    @org.junit.Test
    public void findPowerOfThreeTest() {
        Assignment3 assignment3 = new Assignment3();
        int n = 4;
        int[] output = assignment3.findPowerOfThree(n);
        int[] expectedResult = {1, 3, 9, 27};
        Assert.assertArrayEquals(expectedResult, output);
    }

    @org.junit.Test
    public void countDigitsTest() {
        Assignment3 assignment3 = new Assignment3();
        int n = -124;
        int output = assignment3.countDigits(n);
        int expectedResult = -1;
        Assert.assertEquals(expectedResult, output);

    }

    @org.junit.Test
    public void printNumbersTest() {
        Assignment3 assignment3 = new Assignment3();
        int n = 5;
        int[] output = assignment3.printNumbers(n);
        int[] expectedResult = {1, 3, 5, 7, 9};
        Assert.assertArrayEquals(expectedResult, output);
    }

    @org.junit.Test
    public void generatePascalsTriangleTest() {
        Assignment3 assignment3 = new Assignment3();
        int n = 7;
        int[][] output = assignment3.generatePascalsTriangle(n);
        int[][] expectedResult = {{1, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0},
                {1, 2, 1, 0, 0, 0, 0}, {1, 3, 3, 1, 0, 0, 0},
                {1, 4, 6, 4, 1, 0, 0}, {1, 5, 10, 10, 5, 1, 0},
                {1, 6, 15, 20, 15, 6, 1}};
        Assert.assertArrayEquals(expectedResult, output);
    }

    @org.junit.Test
    public void reverseVowelsTest() {
        Assignment3 assignment3 = new Assignment3();
        String s = "lintcode";
        String output = assignment3.reverseVowels(s);
        String expectedResult = "lentcodi";
        Assert.assertEquals(expectedResult, output);
    }

    @org.junit.Test
    public void lengthOfLastWordTest() {
        Assignment3 assignment3 = new Assignment3();
        String s = "the sky is blue ";
        int output = assignment3.lengthOfLastWord(s);
        int expectedResult = 4;
        Assert.assertEquals(expectedResult, output);
    }

    @org.junit.Test
    public void reverseString2() throws Exception {
        Assignment3 assignment3 = new Assignment3();
        String s = "They like soccer";
        String output = assignment3.reverseString2(s);
        String expectedResult = "soccer like They";
        Assert.assertEquals(expectedResult, output);
    }

    @org.junit.Test
    public void checkMessage() throws Exception {
        Assignment3 assignment3 = new Assignment3();
        String s = "SOSSUSSOP";
        int output = assignment3.checkMessage(s);
        int expectedResult = 2;
        Assert.assertEquals(expectedResult, output);
    }

}