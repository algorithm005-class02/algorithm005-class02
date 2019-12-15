class Solution:
    def trap(self, height):
        trap_list = []
        water = 0
        for item in height:
            if len(trap_list) == 0:
                trap_list.append(item)
            elif item > trap_list[0]:
                water_rock = trap_list[0] * len(trap_list)
                trap_list.pop(0)
                if trap_list:
                    for rock in trap_list:
                        water_rock -= rock
                water = water_rock
                trap_list = [item]
            elif item <= trap_list[0]:
                trap_list.append(item)
        return water
