class TreeNode {
  constructor(val) {
    this.val = val
    this.isWord = false;
    this.chilrden = {}
  }

}

/**
 * Initialize your data structure here.
 */
var Trie = function () {
  this.root = new TreeNode();
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
  let curNode = this.root;
  let arr = word.split('')
  for (let i = 0; i < arr.length; i++) {
    let isHasChildNode = curNode.chilrden[arr[i]]
    if (!isHasChildNode) {
      curNode.chilrden[arr[i]] = new TreeNode(arr[i])
    }
    curNode = curNode.chilrden[arr[i]]
    if (i === arr.length - 1) {
      curNode.isWord = true;
    }
  }
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
  let curNode = this.root;
  let arr = word.split('')
  for (let i = 0; i < arr.length; i++) {
    if (!curNode.chilrden[arr[i]]) {
      return false;
    }
    curNode = curNode.chilrden[arr[i]]
    if (i === arr.length - 1) {
      return curNode.isWord === true
    }
  }
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
  let curNode = this.root;
  let arr = prefix.split('')
  for (let i = 0; i < arr.length; i++) {
    if (!curNode.chilrden[arr[i]]) {
      return false;
    }
    curNode = curNode.chilrden[arr[i]]
  }
  return true
};