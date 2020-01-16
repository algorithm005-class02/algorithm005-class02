// 26. Remove Duplicates from Sorted Array
var removeDuplicates = function(nums) {
  if (!nums || !nums.length) return 0;

  let j = 1;
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] !== nums[j]) nums[++j] = nums[i];
  }

  return j + 1;
};

// 80. Remove Duplicates from Sorted Array II
var removeDuplicates = function(nums) {
  if (!nums) return 0;
  if (nums.length < 3) return nums.length;

  let writer = 0;
  let reader = 0;
  while (reader < nums.length) {
    let [newReader, count, curNum] = read(nums, reader);
    let newWriter = write(nums, writer, curNum, Math.min(count, 2));
    reader = newReader;
    writer = newWriter;
  }

  return writer;

  function read(nums, reader) {
    let count = 0;
    let curNum = nums[reader];
    while (reader < nums.length) {
      if (nums[reader] !== curNum) break;
      reader++;
      count++;
    }
    return [reader, count, curNum];
  }

  function write(nums, writer, num, count) {
    while (count--) {
      nums[writer++] = num;
    }
    return writer;
  }
};
