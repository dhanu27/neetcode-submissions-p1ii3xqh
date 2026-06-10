class Solution {
    public int leastInterval(char[] tasks, int n) {
        Comparator<Pair<Character, Integer>> c = (a, b) -> b.getValue() - a.getValue();
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(c);

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int ct = map.getOrDefault(tasks[i],0);
            map.put(tasks[i], ct + 1);
        }

        for (Character ch : map.keySet()) {
            pq.add(new Pair(ch, map.get(ch)));
        }

        String result = "";
        int ans = 0;

        while (pq.size() > 0) {
            ArrayList<Pair<Character, Integer>> tmp = new ArrayList<>();
            int h = n + 1;
            while (h > 0 && pq.size() > 0) {
                Pair<Character, Integer> node = pq.remove();
                node = new Pair<Character, Integer>(node.getKey(), node.getValue() - 1);
                result = result + node.getKey() + "->";
                if (node.getValue() > 0) {
                    tmp.add(node);
                }

                ans++;
                h = h -1;
            }
            if (h > 0 && !tmp.isEmpty()) {
                ans = ans + h;
                result = result + h + ":- IDLE"
                    + "->";
            }

            for (int l = 0; l < tmp.size(); l++) {
                pq.add(tmp.get(l));
            }
        }
        System.out.println(result);
        return ans;
    }
}
