bool isAnagram(char * s, char * t){
  char a[26] = {0};
  int i;

  if (strlen(s) != strlen(t))
    return false;

  for (i = 0; i < strlen(s); i++) {
    a[*(s+i) - 'a']++;
    a[*(t+i) - 'a']--; 
  }

  for (i = 0; i < 26; i++) {
    if (a[i] != 0)
      return false;
  }

  return true;
}
