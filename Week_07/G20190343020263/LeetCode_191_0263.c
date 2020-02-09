int hammingWeight(uint32_t n) {
  int sum = 0;
  while (n) {
    n &= n - 1;
    ++sum;
  }

  return sum;
}
