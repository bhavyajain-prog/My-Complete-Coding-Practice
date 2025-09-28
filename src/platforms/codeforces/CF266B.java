package platforms.codeforces;
import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    char[] q = sc.next().toCharArray();
    for (int t = 0; t < k; t++) {
        for (int i = 0; i < n - 1; i++) {
            if (q[i] == 'B' && q[i + 1] == 'G') {
                char ch = q[i];
                q[i] = q[i + 1];
                q[i + 1] = ch;
                i++;
            }
        }
    }
    System.out.println(new String(q));
}