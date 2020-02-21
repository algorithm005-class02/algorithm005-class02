var ladderLength = function(beginWord, endWord, wordList) {
    let queue = [beginWord];
    let visitedMap  = {};
    let count = 0;
    while(queue.length != 0){
        count ++;
        const length = queue.length;
        for(let i = 0; i < length; i ++){
            let node = queue.pop();
            if(node == endWord){
                return count;
            }
            const nextList = findNext(node, wordList, visitedMap);
            for(let j = 0; j < nextList.length; j ++){
                if(nextList[j] == endWord){
                    return count + 1;
                }
                visitedMap[nextList[j]] = true;
                queue.unshift(nextList[j]);
            }
        }
    }
    return 0;
};
function findNext(word, arr, visitedMap){
    let result = [];
    for(let i = 0;i < arr.length; i ++){
        let ele = arr[i];
        if(visitedMap[ele]){
            continue;
        }
        let diff = 0;
        for(let j = 0;j < word.length; j ++){
            if(word.charAt(j) != ele.charAt(j)){
                diff ++;
            }
        }
        if(diff == 1){
            result.push(ele);
        }
    }
    return result;
}