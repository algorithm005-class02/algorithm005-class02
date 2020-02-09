class Leaderboard {
    private Map<Integer, Integer> board;
    public Leaderboard() {
        board = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if(board.containsKey(playerId)){
            board.put(playerId, board.get(playerId)+score);
        }else {
            board.put(playerId, score);
        }
    }

    public int top(int K) {
        //这里使用堆排序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            //需要对比value
            @Override
            public int compare(Map.Entry<Integer, Integer> integerIntegerEntry, Map.Entry<Integer, Integer> t1) {
                return integerIntegerEntry.getValue() - t1.getValue();
            }
        });
        for(Map.Entry<Integer, Integer> entry: board.entrySet()){
            if(queue.size()<K){
                queue.add(entry);
            }else {
                if(entry.getValue()>queue.peek().getValue()){
                    queue.poll();
                    queue.add(entry);
                }
            }
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry:queue){
            res+=entry.getValue();
        }
        return res;
    }

    public void reset(int playerId) {
        board.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */