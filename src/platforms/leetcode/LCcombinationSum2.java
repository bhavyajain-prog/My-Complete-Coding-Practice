package platforms.leetcode;

void main() {
    System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
}

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    helper(result, new ArrayList<>(), candidates, target, 0);
    return result;
}

private void helper(List<List<Integer>> result, List<Integer> list, int[] arr, int target, int i) {
    if (target == 0) {
        result.add(new ArrayList<>(list));
        return;
    }

    for (int j = i; j < arr.length; j++) {
        if (j > i && arr[j] == arr[j - 1]) continue;

        if (arr[i] > target) break;

        list.add(arr[j]);
        helper(result, new ArrayList<>(list), arr, target - arr[j], j + 1);
        list.removeLast();
    }
}