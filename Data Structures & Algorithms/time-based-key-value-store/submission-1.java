class TimeMap {
    HashMap<String, ArrayList<ArrayList<String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<ArrayList<String>> res =
            map.getOrDefault(key, new ArrayList<ArrayList<String>>());
        ArrayList<String> values;
        ArrayList<String> timeStamps;
        if (res.size() == 0) {
            values = new ArrayList<String>();
            timeStamps = new ArrayList<String>();
            res.add(values);
            res.add(timeStamps);
        } else {
            values = res.get(0);
            timeStamps = res.get(1);
        }
        values.add(value);
        timeStamps.add(Integer.toString(timestamp));
        map.put(key, res);
    }

    public String get(String key, int timestamp) {
        ArrayList<ArrayList<String>> res = map.get(key);
        if (res == null)
            return "";

        ArrayList<String> values = res.get(0);
        ArrayList<String> timeStamps = res.get(1);
        int start = 0;
        int end = timeStamps.size() - 1;
        int maxClosetIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = Integer.parseInt(timeStamps.get(mid));
            if (midValue == timestamp) {
                return values.get(mid);
            } else if (midValue < timestamp) {
                if (maxClosetIndex == -1) {
                    maxClosetIndex = mid;
                } else if (midValue > Integer.parseInt(timeStamps.get(maxClosetIndex))) {
                    maxClosetIndex = mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return maxClosetIndex == -1 ? "" : values.get(maxClosetIndex);
    }
}
