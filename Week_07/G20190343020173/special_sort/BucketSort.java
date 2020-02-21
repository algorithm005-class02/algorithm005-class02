package org.crayzer.leetcode.editor.en.sort.special_sort;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    public static void bucketSort(int[] a, int bucketSize) {
        if (a.length == 0) return;
        int i;
        int len = a.length;
        int minValue = a[0];
        int maxValue = a[0];

        for (i = 1; i < len; i++) {
            if (a[i] < minValue) minValue = a[i];
            else if (a[i] > maxValue) maxValue = a[i];
        }

        int DEFAULT_BUCKET_SIZE = 5;            // 设置桶的默认数量为5
        bucketSize = bucketSize | DEFAULT_BUCKET_SIZE;
        int bucketCount = (int) (Math.floor((maxValue - minValue) / bucketSize) + 1);
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for(i = 0; i < buckets.size(); i++) {
            buckets.set(i, new ArrayList<>());
        }

        for(i = 0; i < len; i++) {
            // buckets.get((int)[Math.floor((a[i] - minValue) / bucketSize)]);
        }
    }
}
