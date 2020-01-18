public class MinMutation {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        Queue<String> bfsque = new LinkedList<>();
        Map<String,Boolean> visited = new HashMap<>();
        int res = 0;
        bfsque.offer(start);
         //bfs遍历
        while (!bfsque.isEmpty()){
            Queue<String> childque= new LinkedList<>();
            int tmpsize = bfsque.size();
            //bfs每一层
            for(int i = 0;i < tmpsize;i++){
                String curstr = bfsque.poll();
                //遍历节点
                for(String targetstr:bank){
                    if (visited.containsKey(targetstr)) continue;
                    int notsame = 0;
                    //比较两个字符串
                    for (int j = 0; j < curstr.length(); j++){
                        if(curstr.charAt(j) == targetstr.charAt(j)) continue;
                        notsame++;
                    }
                    //只有一个字母不同,则标为已经访问
                    if(notsame == 1){
                        visited.put(targetstr,true);
                        childque.offer(targetstr);
                        if (targetstr.equals(end)) return res+1;
                    }
                }
            }
            if (!childque.isEmpty()){
                res++;
                bfsque.addAll(childque);
            }
        }
        return -1;
    }
}
