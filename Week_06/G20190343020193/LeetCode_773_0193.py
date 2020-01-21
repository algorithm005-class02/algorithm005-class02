moves = {
    0: [1, 3],    
    1: [0, 2, 4], 
    2: [1, 5],
    3: [0, 4],
    4: [1, 3, 5],
    5: [2, 4]
}
class Solution(object):
    def slidingPuzzle(self, board):
	
        used = set() 
        cnt = 0
        s = "".join(str(c) for row in board for c in row) 

        q = [s] 
		while q:
				new = [] 
				for s in q:
					used.add(s)
					if s == "123450": 
						return cnt 
					arr = [c for c in s] 

		zero_index = s.index('0')
                for move in moves[zero_index]:
                    new_arr = arr[:] 
                    new_arr[zero_index], new_arr[move] = new_arr[move], new_arr[zero_index] 
                    new_s = "".join(new_arr)
                    if new_s not in used:
                        new.append(new_s)	
            cnt += 1
            q = new
	return -1