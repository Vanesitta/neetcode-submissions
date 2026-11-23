
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        java.util.Map<Integer, Integer> count = new java.util.HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        java.util.List<Integer>[] buckets =
                new java.util.List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }

        for (int num : count.keySet()) {
            int frequency = count.get(num);
            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1;
             frequency >= 1 && index < k;
             frequency--) {

            for (int num : buckets[frequency]) {
                result[index] = num;
                index++;

                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}
