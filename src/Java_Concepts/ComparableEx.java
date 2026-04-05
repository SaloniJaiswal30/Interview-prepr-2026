package Java_Concepts;

import java.util.*;

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int wt;

    public Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
        return this.wt-o.wt;
    }
}

public class ComparableEx{

    public static void main(String[] args) {
        // Example usage
        List<Edge> e = new ArrayList<>();
        e.add(new Edge(23,432,44));
        e.add(new Edge(4,5,4));
        e.add(new Edge(6,7,23));
        e.add(new Edge(1,2,90));
        e.add(new Edge(3,4,1));
        e.add(new Edge(43,7,53));
        e.add(new Edge(90,2,32));
        e.add(new Edge(1,5,5));

        Collections.sort(e);
        e.forEach((edge)->{
            System.out.println("edge " + edge.u+" "+edge.v+" "+edge.wt);
        });

    }
}

