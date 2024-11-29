package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    private static List<Integer> topologicalSort(List<List<Integer>> adj) {
        int v = adj.size();
        int[] deg = new int[v];
        for (int i = 0; i < v; i++) {
            for (var x : adj.get(i))
                deg[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (deg[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int k = q.poll();
            result.add(k);
            for (var x : adj.get(k)) {
                deg[x]--;
                if (deg[x] == 0) q.offer(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topologicalSort(List.of(List.of(), List.of(3), List.of(3), List.of(), List.of(0, 1), List.of(0, 2))));
    }
}
