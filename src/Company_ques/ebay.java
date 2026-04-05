package Company_ques;

import java.util.*;

class Edge implements Comparable<Edge> {
    String u;
    String v;
    int wt;
    public Edge(String u, String v,int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

     @Override
     public int compareTo(Edge o) {
         return this.wt-o.wt;
     }
 };
public class ebay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.nextLine();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String[] users = sc.nextLine().split(" ");
            ArrayList<String> userDetails = new ArrayList<>(Arrays.asList(users).subList(1,users.length));
            map.putIfAbsent(users[0], userDetails);
        }

        Map<String, List<String>> attrToUsers = new HashMap<>();
        for (String user : map.keySet()) {
            for (String attr : map.get(user)) {
                attrToUsers
                        .computeIfAbsent(attr, k -> new ArrayList<>())
                        .add(user);
            }
        }

        attrToUsers.forEach((attr,user) ->{
            System.out.println(attr+"->"+user);
        });

        Map<String, Map<String, Integer>> edgeWeights = new HashMap<>();

        Map<String, Set<String>> adj = new HashMap<>();
        for (List<String> users : attrToUsers.values()) {
            for (int i = 0; i < users.size(); i++) {
                for (int j = i + 1; j < users.size(); j++) {
                    String u1 = users.get(i);
                    String u2 = users.get(j);
                    adj.computeIfAbsent(u1, k -> new HashSet<>()).add(u2);
                    adj.computeIfAbsent(u2, k -> new HashSet<>()).add(u1);

                    //for MST
                    Map<String, Integer> mu1= edgeWeights.computeIfAbsent(u1,k->new HashMap<>());
                    mu1.put(u2, mu1.getOrDefault(u2, 0) + 1);

                }
            }
        }

        adj.forEach((user, neighbors) -> {
            System.out.println(user + " -> " + neighbors);
        });

        getNumofConnectedIslands(adj);
        //set edges for MST
        List<Edge> edgeList= new ArrayList<>();
        for(String vertex1:edgeWeights.keySet()){
            for(String vertex2 :edgeWeights.get(vertex1).keySet()){
                edgeList.add(new Edge(vertex1,vertex2,edgeWeights.get(vertex1).get(vertex2)));
            }
        }

        edgeList.forEach((edge)->{
            System.out.println(edge.u + " -> " + edge.v+" "+edge.wt);
        });

        Collections.sort(edgeList);

        findMST(edgeList);

    }


    static int getNumofConnectedIslands(Map<String, Set<String>> adj) {
        Set<String> visited =new HashSet<>();
        int count=0;
        for(String user : adj.keySet()){
            if(!visited.contains(user)) {
                visited.add(user);
                count++;
                dfs(adj, visited, user);
            }
        }
        System.out.println("Total islands:"+count);
        return count;
    }

    static void dfs(Map<String, Set<String>> adj,Set<String> visited,String u){
        for(String user: adj.get(u)){
            if(!visited.contains(user)){
                visited.add(user);
                dfs(adj,visited,user);
            }
        }
    }

    static void findMST(List<Edge> edgeList){
        List<Edge> mst = new ArrayList<>();
        Map<String, String> parent = new HashMap<>();
        for(Edge e:edgeList){
            if(union(e.u,e.v,parent)){
                mst.add(e);
            }
        }
        System.out.println("MST");
        mst.forEach((mstEdge)->{
            System.out.println(mstEdge.u+" "+mstEdge.v);
        });

    }

    static String parent(Map<String, String> parent, String user ){
        if (!parent.containsKey(user)) {
            parent.put(user, user);
        }
        if(Objects.equals(parent.get(user), user)){
            return user;
        }
        parent.put(user, parent(parent, parent.get(user)));
        return parent.get(user);
    }

    static boolean union(String u, String v,Map<String, String> parent){
        String x= parent(parent, u);
        String y= parent(parent, v);
        if(Objects.equals(x, y))
            return false;
        parent.put(y,x);
        return true;
    }
}

//input:-
//5
//user1 email1 phone1
//user2 phone1
//user3 email2 ip1
//user4 ip1
//user5 email2 ip2