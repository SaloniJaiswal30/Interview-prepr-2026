package Company_ques;

import java.util.*;

public class Main {
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

        Map<String, Set<String>> adj = new HashMap<>();
        for (List<String> users : attrToUsers.values()) {
            for (int i = 0; i < users.size(); i++) {
                for (int j = i + 1; j < users.size(); j++) {
                    String u1 = users.get(i);
                    String u2 = users.get(j);
                    adj.computeIfAbsent(u1, k -> new HashSet<>()).add(u2);
                    adj.computeIfAbsent(u2, k -> new HashSet<>()).add(u1);
                }
            }
        }

        adj.forEach((user, neighbors) -> {
            System.out.println(user + " -> " + neighbors);
        });

        getNumofConnectedIslands(adj);

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
        System.out.println(count);
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
}
//input:-
//5
//user1 email1 phone1
//user2 phone1
//user3 email2 ip1
//user4 ip1
//user5 email2 ip2