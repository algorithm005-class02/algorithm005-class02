/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
  let dirs = [ [0, 1], [1, 0], [0, -1], [-1, 0] ];
  let result = 0;
  let x = 0;
  let y = 0;
  let di = 0;
  let s = new Set();
  for (let i = 0; i < obstacles.length; i += 1) {
    let obstacle = obstacles[i];
    s.add('' + obstacle[0] + '_' + obstacle[1]);
  }
  for (let i = 0; i < commands.length; i += 1) {
    let command = commands[i];
    if (command === -1) {
      di = (di + 1) % 4;
    } else if (command === -2) {
      di = (di + 3) % 4;
    } else {
      for (let j = 0; j < command; j += 1) {
        const newX = x + dirs[di][0];
        const newY = y + dirs[di][1];
        if (!s.has('' + newX + '_' + newY)) {
          x = newX;
          y = newY;
          result = Math.max(result, x*x + y*y);
        }
      }
    }
  }
  return result;
};

