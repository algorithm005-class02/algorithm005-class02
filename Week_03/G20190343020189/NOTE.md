学习笔记

## Divide and conquer & backtracking

- are all basically → recursions
- key: repetition (of sub-problems)
- flow: identify repetition → divide to min-sub-problem → conquer → combine
- DnC template:

        def divide_conquer(problem, param1, param2, ...):
        	# terminator
        	if problem is None:
        		harvest_result
        		return
        	
        	# prepare data
        	data = prepare_data(problem)
        	subproblems = split_problem(problem, data)
        	# conquer subproblems
        	subresult1 = self.divide_conquer(subproblems[0], p1, ...)
        	subresult2 = self.divide_conquer(subproblems[1], p1, ...)
        	subresult3 = self.divide_conquer(subproblems[2], p1, ...)
        	...
        	# process and generate the final result
        	result = process_result(subresult1, subresult2, subresult3, ...)
        	
        	# revert the current level states, if necessary

- backtracking: trail and error at each layer of the recursion