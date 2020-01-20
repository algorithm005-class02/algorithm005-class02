/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    var a = [], b = [], c = [];
    var res = 0;
    for(var i = 0; i < board.length; i++){
        if(!(a.length-i)) a.push('');
        for(var j = 0; j < board[i].length; j++){
            var tmps = ''+board[i][j];
            var cindex = parseInt((i)/3)*3+parseInt((j)/3);
            if(!(c.length-cindex)) c.push('');
            if(!(b.length-j)) b.push('');
            if(board[i][j] === '.') continue;
            res = res + a[i].indexOf(tmps) + 1;
            res = res + b[j].indexOf(tmps) + 1;
            res = res + c[cindex].indexOf(tmps) + 1;
            a[i]=a[i].concat(tmps);
            b[j]=b[j].concat(tmps);
            c[cindex]=c[cindex].concat(tmps);
            console.log("index"+ cindex+":"+c[cindex]);
        }
    }
    return !res;
};
