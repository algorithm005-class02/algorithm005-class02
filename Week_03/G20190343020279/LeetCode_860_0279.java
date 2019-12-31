 boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(5, 0);
        map.put(10, 0);        
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            }
            if (bills[i] == 10) {
                map.put(10, map.getOrDefault(10, 0) + 1);
                map.put(5, map.getOrDefault(5, 0) - 1);
                if (map.get(5) < 0) {
                    return false;
                }
            }
            if (bills[i] == 20) {
                if (map.get(10) >= 1 && map.get(5) >= 1) {
                    map.put(10, map.getOrDefault(10, 0) - 1);
                    map.put(5, map.getOrDefault(5, 0) - 1);
                    if (map.get(10) < 0 || map.get(5) < 0) {
                        return false;
                    }
                } else if (map.get(5) >= 3) {
                    map.put(5, map.getOrDefault(5, 0) - 3);
                    if (map.get(5) < 0) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
