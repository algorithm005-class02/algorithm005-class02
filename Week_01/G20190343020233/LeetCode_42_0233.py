
class Solution:
    def trap(self, height):
        trap_list = []
        water = 0
        for item in height:
            if len(trap_list) == 0:
                trap_list.append(item)
            elif item >= trap_list[0]:
                water += self.calculate_water(trap_list)
                trap_list = [item]
            elif item < trap_list[0]:
                trap_list.append(item)
        if len(trap_list) > 1:
            if trap_list[0] == trap_list[-1]:
                trap_list.pop()
                water += self.calculate_water(trap_list)
            else:
                trap_again = []
                for item in trap_list[::-1]:
                    if len(trap_again) == 0:
                        trap_again.append(item)
                    elif item >= trap_again[0]:
                        water += self.calculate_water(trap_again)
                        trap_again = [item]
                    elif item < trap_again[0]:
                        trap_again.append(item)
        return water

    def calculate_water(self, container):
        water_rock = container[0] * (len(container))
        if container:
            for rock in container:
                water_rock -= rock
        return water_rock

if __name__ == "__main__":
    test = Solution()
    print(test.trap([2,0,2]))
    print(test.trap([0,1,0,2,1,0,1,3,2,1,2,1]))
