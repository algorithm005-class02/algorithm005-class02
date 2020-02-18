public boolean isIsomorphic(String s, String t) {
        int m = s.length();
        if (m <= 1) {
            return true;
        }
        int[] sToT = new int[256];
        int[] tToS = new int[256];
        char[] sValue = s.toCharArray();
        char[] tValue = t.toCharArray();
        for (int i = 0; i < m; i++) {
            if (sToT[sValue[i]] == 0 && tToS[tValue[i]] == 0) {
                sToT[sValue[i]] = tValue[i];
                tToS[tValue[i]] = sValue[i];
            } else if (sToT[sValue[i]] != tValue[i] || tToS[tValue[i]] != sValue[i]) {
                return false;
            } 
        }
        return true;
    }