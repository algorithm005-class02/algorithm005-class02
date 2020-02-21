int maxProfit(int* prices, int pricesSize){
  
  int total = 0;
  for (int i = 0; i < pricesSize - 1; i++)
  {
     total += prices[i+1] - prices[i] > 0 ? prices[i+1] - prices[i] : 0;
  }
  return total;
}
