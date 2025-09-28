package platforms.codeforces;
import java.util.Arrays;
import java.util.Scanner;

void main() {
    int[][] arr = new int[3][3];
    Arrays.fill(arr,1);
    int[][] input = new int[3][3];
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<3;i++) {
        for(int j=0;j<3;j++) {
            input[i][j]=sc.nextInt();
        }
    }
    for(int i=0;i<3;i++) {
        for(int j=0;j<3;j++) {
            arr[i][j]=(arr[i][j]+input[i][j])%2;
            if(i>0) arr[i-1][j]=(arr[i-1][j]+input[i][j])%2;
            if(i<2) arr[i+1][j]=(arr[i+1][j]+input[i][j])%2;
            if(j>0) arr[i][j-1]=(arr[i][j-1]+input[i][j])%2;
            if(j<2) arr[i][j+1]=(arr[i][j+1]+input[i][j])%2;
        }
    }
    for(int i=0;i<3;i++) {
        for(int j=0;j<3;j++) {
            System.out.print(arr[i][j] + ' ');
        }
        System.out.println();
    }
}