class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> storeArray = new HashMap<>();
        for (int n: nums) {
            if (storeArray.containsKey(n)) {
                storeArray.replace(n, storeArray.get(n)+1);
            } else {
                storeArray.put(n, 1);
            }
        }

        for (Map.Entry mapElement : storeArray.entrySet()) {
            if ((int)mapElement.getValue() > (nums.length / 2)) {
                return (int)mapElement.getKey();
            }
        }
        return -1;
    }
}