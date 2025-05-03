class Destination{
    int stops,node,dist;
    public Destination(int s, int n, int d)
    {
        this.stops =s;
        this.node = n;
        this.dist = d;
    }
}
class Edge{
    int node, dist;
    public Edge(int node,int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] flight:flights)
        adj.get(flight[0]).add(new Edge(flight[1],flight[2]));

        int[] path = new int[n];
        Arrays.fill(path,Integer.MAX_VALUE);
        path[src] = 0;

        Queue<Destination> q = new LinkedList<>();
        q.offer(new Destination(0,src,0));

        while(!q.isEmpty())
        {
            Destination curr = q.poll();
            int stops = curr.stops, node = curr.node,dist = curr.dist;
            for(Edge Destination:adj.get(node))
            {
                int v = Destination.node, w = Destination.dist;
                if(stops>k) break;
                if(path[v] > dist + w)
                {
                    path[v] = dist + w;
                    q.offer(new Destination(stops+1,v,path[v]));
                }
            }
        }
        return path[dst] == Integer.MAX_VALUE ? -1 : path[dst];
    }
}