
// class Node{
//     int vertex;
//     int edges;
//     Node(int v, int e){
//         vertex = v;
//         edges = e
//     }
// }
class Solution {

    public int getZeroInComingEdgeVertex(HashMap<Integer, Integer> inComing){
        for(Integer i : inComing.keySet()){
            //  System.out.println("i:- "+ inComing.get(i));
            if(inComing.get(i) == 0){
                return i;
            }
        }
        return -1;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Integer> inComingEdges = new HashMap<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
            inComingEdges.put(i,0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            inComingEdges.put(u,inComingEdges.getOrDefault(u,0) + 1);
            adjList.get(v).add(u);
        }
        // PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
        //     int compare(Node n1, Node n2){
        //         return n1.edges - n2.edges;
        //     }
        // });
        // for(int i =0; i<inComingEdges.length; i++){
        //     pq.add(new Node(i, inComingEdges[i]));
        // }


        // ArrayList<Integer> ans = new ArrayList<>();
        
        while (getZeroInComingEdgeVertex(inComingEdges)!=-1) {
              int v = getZeroInComingEdgeVertex(inComingEdges);
              System.out.println("v:- "+ v);
              for(int i=0; i<adjList.get(v).size(); i++){
                   inComingEdges.put(adjList.get(v).get(i), inComingEdges.get(adjList.get(v).get(i)) - 1);
              }
              inComingEdges.remove(v);
            //   ans.add(v);
        }
       
        return inComingEdges.size() == 0 ? true : false;
    }
}
