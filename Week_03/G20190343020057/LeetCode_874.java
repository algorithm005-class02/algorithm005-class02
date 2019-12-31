class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for(int[] ob:obstacles){
            obs.add(ob[0]+","+ob[1]);//将障碍物利用哈希保存起来.这里还有个错误，中间必须有东西隔开，不能直接“”
        }
        int dir = 0;//代表方向，0为正北方向，对应配合move数组进行移动判定
        int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0;
        int y = 0;
        int max = 0;
        for(int command:commands){
            if(command==-1){
                dir = (dir==3 ? 0 : dir+1);//顺时针改变方向
                // dir = (dir+1)%4;
            }else if(command==-2){
                dir = (dir==0 ? 3 : dir-1);//逆时针改变方向
                // dir = (dir+3)%4;
            }else{
                int[] move = moves[dir];
                while(command>0 && !obs.contains((x+move[0])+","+(y+move[1]))){
                    //移动前方无障碍物才可以移动过去
                    x += move[0];
                    y += move[1];
                    max = Math.max(max,x*x+y*y);
                    command--;
                }
            }
        }
        return max;
    }
}