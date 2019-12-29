class Solution:
    def minMutation(self, start, end, bank):
        process = [[start]]
        result = []
        visited = []

        if not bank or not start or not end:
            return -1

        while process:
            one_level = []
            for item in process.pop(0):
                if item not in visited:
                    for gens in bank:
                        visited.append(item)
                        if self._next_gen(item, gens):
                            if gens == end:
                                return len(result) + 1
                            one_level.append(gens)
            if one_level:
                result.append(one_level)
                process.append(one_level)
        return -1

    def _next_gen(self, one, two):
        result = 0
        for i in range(len(one)):
            if one[i] != two[i]:
                result += 1
        return result == 1

    def minMutation_dfs(self, start, end, bank):
        res_list = []
        visited = []
        def _dfs(res, current):
            if current == end:
                res_list.append(res)
                return
            for item in bank:
                if self._next_gen(current, item) and item not in visited:
                    visited.append(current)
                    _dfs(res + 1, item)
                    visited.remove(current)
        _dfs(0, start)
        return min(res_list) if res_list else -1


if __name__ == '__main__':
    test = Solution()
    print(test.minMutation_dfs("AACCGGTT", "AACCGGTA", ["AACCGGTA"]))
    print(test.minMutation_dfs("AACCGGTT", "AACCGGTA", []))
    print(test.minMutation_dfs("AACCGGTT", "AAACGGTA", ["AACCGGTA", "AACCGCTA", "AAACGGTA"]))
    print(test.minMutation_dfs("AAAAACCC", "AACCCCCC", ["AAAACCCC", "AAACCCCC", "AACCCCCC"]))
    print(test.minMutation_dfs("AACCGGTT", "AAACGGTA", ["AACCGATT","AACCGATA","AAACGATA","AAACGGTA"]))
    print(test.minMutation_dfs("AACCTTGG", "AATTCCGG", ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]))
    print(test.minMutation_dfs("AAAAAAAA", "CCCCCCCC", ["AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"]))
    print(test.minMutation_dfs("AAAACCCC", "CCCCCCCC", ["AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"]))


