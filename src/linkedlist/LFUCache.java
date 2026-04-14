package linkedlist;


import java.util.*;

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    int count;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        count=1;
    }
}
class Pair<f,s>{
    f first;
    s second;
    public Pair(f first, s second){
        this.first = first;
        this.second = second;
    }
}
class LFUCache {
    Map<Integer, Pair<Node,Node>> freqmap;
    Map<Integer, Node> cachemap;
    int capacity;
    int freq;
    public LFUCache(int cap) {
        freqmap = new HashMap<>();
        cachemap = new HashMap<>();
        this.capacity=cap;
        this.freq=0;
    }

    public int get(int key) {
        if(!cachemap.containsKey(key)){
            return -1;
        }
        Node node = cachemap.get(key);
        updateFreq(node);
        return node.val;
    }
    public void updateFreq(Node node){
        int key=node.count;
        remove(node);
        if(freqmap.get(key).first.next==freqmap.get(key).second){
            freqmap.remove(key);
            if(freq==node.count){
                freq++;
            }
        }
        node.count++;
        add(node);
    }

    public void remove (Node node){
        node.prev.next=node.next;
        node.next.prev= node.prev;
    }

    public void add(Node node){
        if(!freqmap.containsKey(node.count)){
            Node head = new Node(-1,-1);
            Node tail = new Node(-1,-1);
            head.next =tail;
            tail.prev=head;
            freqmap.put(node.count, new Pair<>(head,tail));
        }
        Node head=freqmap.get(node.count).first;
        Node tmp = head.next;
        head.next= node;
        node.prev=head;
        node.next=tmp;
        node.next.prev= node;
    }

    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(cachemap.containsKey(key)){
            Node node = cachemap.get(key);
            node.val=value;
            updateFreq(node);
        }
        else{
            if(capacity==cachemap.size()){
                Node node = freqmap.get(freq).second.prev;
                cachemap.remove(node.key);
                remove(node);
                if(freqmap.get(freq).first.next==freqmap.get(freq).second){
                    freqmap.remove(freq);
                }

            }
            Node node = new Node(key, value);

            add(node);
            cachemap.put(key,node);
            freq=1;


        }

    }

}