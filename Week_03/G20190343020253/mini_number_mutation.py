class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        change_map = {
            "A": "CGT",
            "C": "AGT",
            "G": "ACT",
            "T": "ACG"
        }

        # valid params
        if start == end:
            return 1

        if not bank:
            return -1

        result = []
        max_times = len(bank)
        self.mutation(start, end, bank, change_map, 0, result, max_times)
        if result:
            return min(result)
        else:
            return -1

    def mutation(self, start, end, bank, change_map, times, result, max_times):
        # terminator
        if times > max_times:
            return
        if start == end:
            result.append(times)

        # process current level logic
        for i in range(0, len(start)):
            old_char = start[i]
            for new_char in change_map[old_char]:
                new_start = start[:i] + new_char + start[i+1:]
                if new_start in bank:
                    # dill down next level
                    self.mutation(new_start, end, bank, change_map, times+1, result, max_times)

        