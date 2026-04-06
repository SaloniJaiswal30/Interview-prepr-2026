package graph;
import java.util.*;
public class DSUMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,String> map =new HashMap<>();
        HashMap<String,String> emailParent =new HashMap<>();
        for(List<String> account:accounts){
            String name = account.get(0);
            for(int i=1;i<account.size();i++){
                map.put(account.get(i),name);
                union(emailParent,account.get(1),account.get(i));
            }
        }
        HashMap<String,List<String>> emaillist =new HashMap<>();
        for(String email:map.keySet()){
            String parent = getParent(emailParent,email);
            emaillist.computeIfAbsent(parent, k->new ArrayList<>()).add(email);
        }

        List<List<String>> resultlist =new ArrayList<>();
        for(String e:emaillist.keySet()){
            List<String> result=new  ArrayList<>();
            result.add(map.get(e));
            List<String> list = emaillist.get(e);
            Collections.sort(list);
            result.addAll(list);
            resultlist.add(result);

        }
        return resultlist;

    }

    String getParent(HashMap<String,String> emailParent, String email){
        if (!emailParent.containsKey(email)) {
            emailParent.put(email, email);
        }
        if(emailParent.get(email)==email){
            return email;
        }
        emailParent.put(email,getParent(emailParent,emailParent.get(email)));
        return emailParent.get(email);
    }

    void union(HashMap<String,String> emailParent,String email1,String email2){
        String x = getParent(emailParent,email1);
        String y = getParent(emailParent,email2);
        if(!x.equals(y)){
            emailParent.put(x,y);
        }
    }
}
