class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:      
        for i in range(9):
            nums1,nums2,nums3 = {},{},{}
            for x in board[i]:
                if x not in nums1 or x == ".":
                    nums1[x] = True
                else:return False

            for y in board:
                if y[i] not in nums2 or y[i] == ".":
                    nums2[y[i]] = True
                else:return False

            for y in board[3*(i//3):3*(i//3)+3]:
                for x in y[3*(i%3):3*(i%3)+3]:
                    if x not in nums3 or x == ".":
                        nums3[x] = True
                    else:return False
        
        return True