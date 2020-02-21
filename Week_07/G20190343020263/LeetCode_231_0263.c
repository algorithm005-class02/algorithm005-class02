bool isPowerOfTwo(int n){
  int sum = 0;
  if (n <= 0)
    return false;
  while (n) {
    n &= n - 1;
    if (++sum > 1)
      return false;
  }
  return sum;
}
