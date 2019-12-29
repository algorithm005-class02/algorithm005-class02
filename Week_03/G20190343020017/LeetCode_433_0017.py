class Solution: 
    # 验证当前基因是否能够通过一次变化成为目标基因
    def _oneStep(self, gene, target):
        count = 0
        for i in range(len(gene)):
            if gene[i] != target[i]:
                count += 1
                if count > 1:
                    return False
        return True
        
    # 在基因库中寻找能通过对当前基因进行一次变化得到的基因
    def _findOneStep(self, gene, bank, visited):
        result = []
        for target in bank:
            if target not in visited and self._oneStep(gene, target):
                result.append(target)
                visited.add(target)
        return result

    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if start == end:
            return 0
        # BFS
        step, visited = 0, set()
        level = self._findOneStep(start, bank, visited)
        while level:
            step, nextLevel = step + 1, []
            for gene in level:
                if gene == end:
                    return step
                nextLevel += self._findOneStep(gene, bank, visited)
            level = nextLevel
        return -1