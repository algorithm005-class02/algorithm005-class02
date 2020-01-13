class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        obstacleMap, result = set(map(tuple, obstacles)), 0
        # 初始移动向量和位置坐标
        step, position = (0, 1), (0, 0)
        # 处理命令
        for cmd in commands:
            # 右转90度
            if cmd == -1:
                step = (step[1], -step[0])
            # 左转90度
            elif cmd == -2:
                step = (-step[1], step[0])
            else:
                # cmd > 0 就尝试往前走一步
                while cmd:
                    cmd, nextPosition = cmd - 1, (position[0] + step[0], position[1] + step[1])
                    # 判断下一坐标是否为障碍物，不是障碍物则移动到下一个坐标
                    if (nextPosition[0], nextPosition[1]) not in obstacleMap:
                        position = nextPosition
                        result = max(result, position[0] * position[0] + position[1] * position[1])
        return result