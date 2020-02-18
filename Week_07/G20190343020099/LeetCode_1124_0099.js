var Leaderboard = function() {
  this.board = {};
};

/**
* @param {number} playerId
* @param {number} score
* @return {void}
*/
Leaderboard.prototype.addScore = function(playerId, score) {
  this.board[playerId] = (this.board[playerId] || 0) + score;
};

/**
* @param {number} K
* @return {number}
*/
Leaderboard.prototype.top = function(K) {
  return Object.values(this.board).sort((a, b) => b - a).slice(0, K).reduce((acc, curr) => acc + curr);
};

/**
* @param {number} playerId
* @return {void}
*/
Leaderboard.prototype.reset = function(playerId) {
  delete this.board[playerId]
};

/**
* Your Leaderboard object will be instantiated and called as such:
* var obj = new Leaderboard()
* obj.addScore(playerId,score)
* var param_2 = obj.top(K)
* obj.reset(playerId)
*/