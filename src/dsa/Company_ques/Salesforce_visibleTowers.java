package dsa.Company_ques;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Salesforce_visibleTowers {

    public static int[] visibleTowersBruteForce(int[] h) {
        int n = h.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (h[j] > max) {
                    ans[i]++;
                    max = h[j];
                }
            }

            max = 0;
            for (int j = i + 1; j < n; j++) {
                if (h[j] > max) {
                    ans[i]++;
                    max = h[j];
                }
            }
        }

        return ans;
    }

    public static int[] visibleTowers(int[] h) {
        int n = h.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // ── Pass 1 : right → left ─────────────────────────────────────────
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = stack.size();                      // right visible count
            while (!stack.isEmpty() && stack.peek() <= h[i]) {
                stack.pop();
            }
            stack.push(h[i]);
        }

        // ── Pass 2 : left → right ─────────────────────────────────────────
        stack.clear();
        for (int i = 0; i < n; i++) {
            ans[i] += stack.size();                     // add left visible count
            while (!stack.isEmpty() && stack.peek() <= h[i]) {
                stack.pop();
            }
            stack.push(h[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = {3, 6, 2, 4, 5};
        int[] arr2 = {5, 5, 5};

        System.out.println(Arrays.toString(visibleTowers(arr1)));
        System.out.println(Arrays.toString(visibleTowers(arr2)));
    }
}
