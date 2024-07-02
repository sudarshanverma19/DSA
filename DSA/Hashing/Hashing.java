 import java.util.HashSet;
 import java.util.Iterator;
 import java.util.*;
 public class Hashing{
    public static void main(String[] args){
              
        // hashset

        // creating
        HashSet<Integer> hs = new HashSet<>();

        // add
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(1);

        // size
        System.out.println("size of set is:"+hs.size());

        // print all elements
        System.out.println(hs);

        // search
        if(hs.contains(1)){
            System.out.println("1 is in the set");
        }
        if(!hs.contains(6)){
            System.out.println("6 is not in the set");
        }

        // delete
        hs.remove(1);
        if(!hs.contains(1)){
            System.out.println("1 is removed");
        }
        // Iterator  traversing elements
        Iterator it = hs.iterator();
        //hasNext; next
        while(it.hasNext()){
            System.out.print(it.next()+" ") ; // random order.unordered set
        }
        System.out.println();
        
            // hashmap
            // just like dictionary; key:value pair is there. and key is always unique.
            // creating
            //country(key),population(value)
        HashMap<String,Integer> map = new HashMap<>();

        // insertion
        map.put("India",120);
        map.put("US",30);
        map.put("China",150);

        System.out.println(map); // unordered printing

        // if key exist, value will be updated
        map.put("China",170);
        System.out.println(map);

        // search operation
        if(map.containsKey("India")){
            System.out.println("India is in the map");
        } else{
            System.out.println("India is not in the map");
        }

        // if key exist then value will be printed else print null
        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia"));

        // iteration in HashMap
        for(Map.Entry<String, Integer> e:map.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        // another method
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key+" "+map.get(key));
        }

        // deletion
        map.remove("US");
        System.out.println(map);
    }
 }