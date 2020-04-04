var LinkedListNode = function(value, next) {
  this.value = value;
  this.next = next;
}

var LinkedList = function() {
  this.head = undefined;
  this.tail = undefined;
}

LinkedList.prototype.append = function(value) {
  let node = new LinkedListNode(value);
  if (this.head === undefined) {
      this.head = this.tail = node;
  } else {
      this.tail.next = node;
      this.tail = node;
  }
}

LinkedList.prototype.find = function(value) {
  let currentNode = this.head;
  while (currentNode !== undefined) {
      if (currentNode.value === value) {
          break;
      }
      currentNode = currentNode.next;
  }
  return currentNode;
}

LinkedList.prototype.remove = function(value) {
  let currentNode = this.head;
  let previousNode = undefined;
  while (currentNode !== undefined) {
      if (currentNode.value === value) {
          if (currentNode === this.head) {
              this.head = this.head.next;
          } else {
              previousNode.next = currentNode.next;
              if (this.tail === currentNode) {
                  this.tail = previousNode;
              }
          }
          break;
      }
      previousNode = currentNode;
      currentNode = currentNode.next;
  }
}

/**
* Initialize your data structure here.
*/
var MyHashSet = function() {
  this.bucketSize = 32;
  this.bucket = new Array(this.bucketSize).fill(null).map(() => new LinkedList());
};

MyHashSet.prototype.hash = function(key) {
  return key % this.bucketSize;
}

/** 
* @param {number} key
* @return {void}
*/
MyHashSet.prototype.add = function(key) {
  if (!this.contains(key)) {
      let hash = this.hash(key);
      this.bucket[hash].append(key);
  }
};

/** 
* @param {number} key
* @return {void}
*/
MyHashSet.prototype.remove = function(key) {
  let hash = this.hash(key);
  this.bucket[hash].remove(key);
};

/**
* Returns true if this set contains the specified element 
* @param {number} key
* @return {boolean}
*/
MyHashSet.prototype.contains = function(key) {
  let hash = this.hash(key);
  return this.bucket[hash].find(key) !== undefined;
};

/** 
* Your MyHashSet object will be instantiated and called as such:
* var obj = new MyHashSet()
* obj.add(key)
* obj.remove(key)
* var param_3 = obj.contains(key)
*/