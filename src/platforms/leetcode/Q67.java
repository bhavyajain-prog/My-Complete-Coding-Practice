// Given two binary strings a and b, return their sum as a binary string.

// Example 1:
// Input: a = "11", b = "1"
// Output: "100"

// Example 2:
// Input: a = "1010", b = "1011"
// Output: "10101"

public class Q67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            char c = a.charAt(i);
            char d = b.charAt(j);
            int sum = c - '0' + d - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }
        while (i >= 0 && carry >= 0) {
            char c = a.charAt(i);
            int sum = c - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            i--;
        }
        while (j >= 0 && carry >= 0) {
            char c = b.charAt(j);
            int sum = c - '0' + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
