import java.util.Scanner;

void main() {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '.') sb.append('0');
        else {
            sb.append(s.charAt(i + 1) == '.' ? '1' : '2');
            i++;
        }
    }
    System.out.println(sb);
}