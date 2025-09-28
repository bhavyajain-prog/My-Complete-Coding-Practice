package platforms.codeforces;
import java.util.Scanner;

void main() {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int dx = 0, dy = 0, dz = 0;
    for (int i = 0; i < n; i++) {
        dx += scan.nextInt();
        dy += scan.nextInt();
        dz += scan.nextInt();
    }
    if (dx == 0 && dy == 0 && dz == 0) System.out.println("YES");
    else System.out.println("NO");
}