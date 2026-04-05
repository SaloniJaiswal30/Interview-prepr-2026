package Java_Concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EdgeClass{
    int u;
    int v;
    int wt;

    public EdgeClass(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}
class ComparatorEdge implements Comparator<EdgeClass> {

    @Override
    public int compare(EdgeClass o1, EdgeClass o2) {
        return o1.u-o2.u;
    }
}

public class ComparatorEx {
    public static void main(String[] args) {
        // Example usage
        List<EdgeClass> e = new ArrayList<>();
        e.add(new EdgeClass(23,432,44));
        e.add(new EdgeClass(4,5,4));
        e.add(new EdgeClass(6,7,23));
        e.add(new EdgeClass(1,2,90));
        e.add(new EdgeClass(3,4,1));
        e.add(new EdgeClass(43,7,53));
        e.add(new EdgeClass(90,2,32));
        e.add(new EdgeClass(1,5,5));

        Collections.sort(e,new ComparatorEdge());
        e.forEach((edge)->{
            System.out.println("edge " + edge.u+" "+edge.v+" "+edge.wt);
        });
    }
}
