// Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.
// The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

// Example 1:
// Input: expression = "-1/2+1/2"
// Output: "0/1"

// Example 2:
// Input: expression = "-1/2+1/2+1/3"
// Output: "1/3"

// Example 3:
// Input: expression = "1/3-1/2"
// Output: "-1/6"

// Constraints:
// The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
// Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
// The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
// The number of given fractions will be in the range [1, 10].
// The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

public class Q592 {
    public static String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;

        int i = 0;
        int n = expression.length();
        while (i < n) {
            int sign = 1;
            if (expression.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (expression.charAt(i) == '+')
                i++;
            int start = i;
            while (i < n && Character.isDigit(expression.charAt(i)))
                i++;
            int currentNumerator = sign * Integer.parseInt(expression.substring(start, i));
            i++;
            start = i;
            while (i < n && Character.isDigit(expression.charAt(i)))
                i++;
            int currentDenominator = Integer.parseInt(expression.substring(start, i));
            numerator = numerator * currentDenominator + currentNumerator * denominator;
            denominator = denominator * currentDenominator;
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        return numerator + "/" + denominator;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2")); // Output: "0/1"
        System.out.println(fractionAddition("-1/2+1/2+1/3")); // Output: "1/3"
        System.out.println(fractionAddition("1/3-1/2")); // Output: "-1/6"
    }
}
