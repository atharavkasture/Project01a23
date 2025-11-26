import java.util.*;

class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

public class Djiskstras {
    static List<List<Pair>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges");
        int m = sc.nextInt();
        for(int i = 0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        System.out.println("Enter the edge in format src dest weight");
        for(int i = 0;i<m;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            list.get(src).add(new Pair(dest,weight));
            list.get(dest).add(new Pair(src,weight));
        }
        System.out.println("Graph: ");
        for(int i = 1;i<=list.size()-1;i++){
            System.out.print(i+": ");
            for(Pair p:list.get(i)){
                System.out.print("("+p.node+","+p.weight+") ");
            }
            System.out.println();
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair a, Pair b) {
                        return Integer.compare(a.weight,b.weight);
                    }
                }
        );
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
        System.out.println("Enter the source");
        int source = sc.nextInt();
        dist[source] = 0;
        pq.offer(new Pair(source,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int c = curr.node;
            int d = curr.weight;
            for(Pair it:list.get(c)){
                int ne = it.node;
                int nd = it.weight;
                if(dist[ne]>d+nd){
                    dist[ne] = d+nd;
                    parent[ne] = c;
                    pq.offer(new Pair(ne, dist[ne]));
                }
            }
        }
        System.out.println("Enter the goal node");
        int goal = sc.nextInt();
        List<Integer> path = new ArrayList<>();
        while(parent[goal]!=-1){
            path.add(goal);
            goal = parent[goal];
        }
        path.add(goal);
        for(int i = path.size()-1;i>=0;i--){
            System.out.print(path.get(i)+" ");
        }
    }
}
