/*
 * @lc app=leetcode.cn id=874 lang=cpp
 *
 * [874] 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (31.00%)
 * Likes:    63
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 16.5K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 
 * 在网格上有一些格子被视为障碍物。
 * 
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 
 * 返回从原点到机器人的最大欧式距离的平方。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 
 * 
 * 示例 2：
 * 
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int nx[4] = {0,1,0,-1};
    int ny[4] = {1,0,-1,0};
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int curx = 0;
        int cury = 0;
        int drct = 0;
        int max = 0;
        int nxtx, nxty;
        set<pair<int,int>> obstacleSet;//存放障碍物的集合
        for (vector<int> obstacle: obstacles)
            obstacleSet.insert(make_pair(obstacle[0], obstacle[1]));

//        cout<<obstacles.size()<<endl;
        for(int i = 0; i < commands.size(); i++){
            if(commands[i] == -1){
                drct = (drct + 1)%4;
            }
                
            if(commands[i] == -2){
                drct = (drct + 3)%4;
            }
            if(commands[i] > 0){
                for(int j = 1; j <= commands[i]; j++){
//                    cout<<"drct:"<<drct<<" j:"<<j<<" x:"<<curx<<" y:"<<cury<<endl;
//                    if(check(curx, cury, drct, obstacles)){
                    nxtx = curx + nx[drct];
                    nxty = cury + ny[drct];
                    if(obstacleSet.find(make_pair(nxtx, nxty)) == obstacleSet.end()){
                        curx = nxtx;
                        cury = nxty;
                    }
                    else break;
                }
            }
            max = (curx*curx + cury*cury) > max ? (curx*curx + cury*cury) : max;
//            cout<<"command:"<<commands[i]<<" x:"<<curx<<" y:"<<cury;
//            if(drct == 0) cout <<"北 y+";
//            if(drct == 1) cout <<"东 x+";
//            if(drct == 2) cout <<"南 y-";
//            if(drct == 3) cout <<"西 x-";
//            cout<<endl;  
        }
        
        return max;
    }
private:
    bool check(int curx, int cury, int drct, vector<vector<int>>& obstacles){
        int nxt_x = curx + nx[drct];
        int nxt_y = cury + ny[drct];
//        cout << "nxt x:"<<nxt_x<<" y:"<<nxt_y<<endl;
        for(int i = 0; i < obstacles.size(); i++){
            if(nxt_x == obstacles[i][0]){
                if(nxt_y == obstacles[i][1]){
                    return false;
                }
            }  
        }
        return true;
        
    }
};
// @lc code=end

