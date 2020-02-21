/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
  this.capacity = capacity;
  this.cache = {};
  this.head = new Node();
  this.last = new Node();
  this.head.next = this.last;
  this.last.pre = this.head;
};

function Node(key, val) {
  return {pre: null, val, key, next: null}
}

LRUCache.prototype.add = function (node) {
  node.pre = this.head;
  node.next = this.head.next;
  this.head.next.pre = node;
  this.head.next = node;
}

LRUCache.prototype.remove = function(node) {
  let pre = node.pre;
  let next = node.next;
  pre.next = next;
  next.pre = pre;
}

LRUCache.prototype.removeLast = function () {
  let node = this.last.pre;
  node.val !== null && this.remove(node);
  return node;
}

LRUCache.prototype.popToHead = function(node) {
  this.remove(node);
  this.add(node);
}

/**
* @param {number} key
* @return {number}
*/
LRUCache.prototype.get = function(key) {
  if (!this.cache[key]) return -1;
  let node = this.cache[key];
  this.popToHead(node);
  return node.val;
};

/**
* @param {number} key
* @param {number} value
* @return {void}
*/
LRUCache.prototype.put = function(key, value) {
  if (this.cache[key]) {
      let node = this.cache[key];
      node.val = value;
      this.popToHead(node);
  } else {
      let node = new Node(key, value);
      this.add(node);
      this.cache[key] = node;
  }
  if (Object.keys(this.cache).length > this.capacity) {
      let node = this.removeLast();
      delete this.cache[node.key];
  }
};

/**
* Your LRUCache object will be instantiated and called as such:
* var obj = new LRUCache(capacity)
* var param_1 = obj.get(key)
* obj.put(key,value)
*/