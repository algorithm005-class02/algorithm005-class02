double myPow(double x, int n){
  
  double pow = 1.0;
  int i;
  

  for (i = n; i != 0; i /= 2)
  {
    if (i % 2 != 0)
      pow *= x;
    x *= x ;
  }

  return n < 0 ? 1 / pow : pow;
  
}
