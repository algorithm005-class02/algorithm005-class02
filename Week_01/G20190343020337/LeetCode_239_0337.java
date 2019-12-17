class Solution {
    public void clearDeque(Deque<Integer> deque,int i,int k,int[] nums){

        if(!deque.isEmpty() && deque.getFirst() == i-k){
            deque.removeFirst();
        }
        while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]){
            deque.removeLast();
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k)
    {
        Deque<Integer> deque = new LinkedList<>();
        int [] output = new int[nums.length - k + 1];
        if (k<=1){
            return nums;
        }
        if (nums.length * k == 0) return new int[0];
        int max_idx = 0;
        for(int i=0;i<k;i++){
            clearDeque(deque,i,k,nums);
            deque.addLast(i);
            if(nums[i]>nums[max_idx])
                max_idx=i;
        }
        output[0]=nums[max_idx];
        for(int i=k;i<nums.length;i++){

            clearDeque(deque,i,k,nums);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }

        return output;

    }
}