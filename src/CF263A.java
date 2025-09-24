void main() {
/*
    int i = 0, j = -1, k = 0;
    Scanner sc = new Scanner(System.in);
    while (k != 1) {
        k = sc.nextInt();
        j++;
        if (j == 5) {
            i++;
            j = 0;
        }
        if (i == 5) break;
    }
    if (i != 5) System.out.println(Math.abs(i - 2) + Math.abs(j - 2));
*/
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (sc.nextInt()==1) {
                System.out.println(Math.abs(i - 2) + Math.abs(j - 2));
                return;
            }
        }
    }

}