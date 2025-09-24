void main() {
    Scanner scan = new Scanner(System.in);
    int year = scan.nextInt();

    while (true) {
        year++;
        if (helper(year)) {
            System.out.println(year);
            return;
        }
    }
}

private boolean helper(int year) {
    String s = String.valueOf(year);
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
        if (!set.add(s.charAt(i))) {
            return false;
        }
    }
    return true;
}