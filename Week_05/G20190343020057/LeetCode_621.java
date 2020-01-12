class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskNum = new int[26];
        for(char task:tasks){
            taskNum[task-'A']++;
        }
        Arrays.sort(taskNum);
        int time1 = (n+1)*(taskNum[25]-1)+1; //按照最多任务来进行分布，留下空隙, 每个空隙为n+1的大小,其中n是任务间隔时间
        for(int i=24;i>=0;i--){
            if(taskNum[i]==taskNum[25]){
                time1++;
            }else{
                break;
            }
        }
        int time2 = tasks.length;
        //time1是假设任务数偏少，或者间隔偏大
        //time2是假设任务数偏多，或者间隔偏小，预留的空隙还不够摆放剩余任务，这样其实可以将任务继续强制插入这些空隙，因为间隔肯定是满足规律的。都至少有n个空隙。此时的最短时间就是任务数。
        return Math.max(time1,time2);
    }
}