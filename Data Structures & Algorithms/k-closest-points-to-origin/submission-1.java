class Node {
    int x, y;
    double distance;
    Node(int x, int y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<Node> c = (a, b) -> {
            if (a.distance > b.distance)
                return 1;
            else if (a.distance == b.distance)
                return 0;
            else
                return -1;
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(k, c);

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt((x * x) + (y * y));
            System.out.println("Distance:- " + distance + " x:- " + x + " y:- " + y);
            pq.add(new Node(x, y, distance));
        }

        int[][] result = new int[k][2];
        int h = 0;
        while (pq.size() > 0 && k > 0) {
            Node tmp = pq.remove();
            System.out.println(
                "Removing Distance:- " + tmp.distance + " x:- " + tmp.x + " y:- " + tmp.y);

            result[h][0] = tmp.x;
            result[h][1] = tmp.y;
            h++;
            k--;
        }
        return result;
    }
}
