class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length < 1 || M.length < 1)
			return 0;
 		int[] flag = new int[M.length];
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if (flag[i] == 0) {
                flag[i] = 1;
                count++;
                DFS(M, flag, i);
            }
		}
		return count;
    }
    public void DFS(int[][] M, int[] flag, int index){
        for(int i = 0; i < flag.length; i++){
            if(flag[i] == 0 && M[index][i] == 1){
                flag[i] = 1;
                DFS(M, flag, i);
            }
        }
    }
}