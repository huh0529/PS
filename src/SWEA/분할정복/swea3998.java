package SWEA.분할정복;

import java.util.Scanner;

public class swea3998 {
    static int N;
    static int[] arr;
    static int[] tmp;
    static long cnt;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            N = sc.nextInt();
            arr = new int[N];
            tmp = new int[N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            mergeSort(0, N - 1);

            System.out.println("#" + test_case + " " + cnt);
        }
    }

    static void mergeSort(int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];
                cnt += mid - i + 1;
            }else
                tmp[k++] = arr[i++];
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int l = left; l <= right; l++) {
            arr[l] = tmp[l];
        }
    }
}
