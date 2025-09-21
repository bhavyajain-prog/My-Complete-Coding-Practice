void main() {
    // Initialize the array
    int[] arr = new int[]{3, 4, 1, 2, 5};

    // Answer
    int[] ans = new int[arr.length];
    ans[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
        int j;
        for (j = 0; j < i; j++) {
            if (arr[i] < ans[j]) {
                for (int k = i - 1; k >= j; k--) {
                    ans[k + 1] = ans[k];
                }
                ans[j] = arr[i];
                break;
            }
        }
        if (j == i) {
            ans[j] = arr[i];
        }
    }

    // Print the array
    for (int i :
            ans) {
        IO.println(i);
    }
}
