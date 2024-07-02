import java.util.* ;
import java.util.HashMap;
public class PracticeHashing{
    
    
    public static void maxNumbers(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length ;
        for(int i =0 ; i<n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key)>n/3){
                System.out.println(key);
            }
        }
        System.out.println(map);
    }
    public static void unionOfArrays(int arr1[] , int arr2[]){
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length;i++){
            //if(!set.contains(arr2[i])){          // no need to write this bcz vaise bhi hashset unique values hi store karta hai.
                set.add(arr2[i]);
           // }
            
        }
        System.out.println(set);
    }

    public static void intersection(int arr1[],int arr2[]){
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                System.out.print(arr2[i]+" ");
            }
        }
        System.out.println();
    }

    // this question was asked in microsoft.
    public static String getStart(HashMap<String,String> tick){
        HashMap<String,String> rev = new HashMap<>() ;
        for(String key: tick.keySet()){
            rev.put(tick.get(key),key);
        }
        for(String key: tick.keySet()){
            if(!rev.containsKey(key)){
                return key ;
            }
        }
        return null;
    }
    public static void printPath(){         // isko mai function naa banakr directly main function me bhi likh sakta hu.
        // pre defined hachmap
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("New York","Chicago");
        tickets.put("Chicago","Atlanta");
        tickets.put("Atlanta","Dallas");
        tickets.put("Dallas","Houston");
        String start = getStart(tickets);    // idharse starting point mil gaya.
        while(tickets.containsKey(start) ){   //agar start hai apne hashmap me
            System.out.print(start+"->");         // usko print karo
            start = tickets.get(start);        // key ki value ko start bana do ab.
        }
        System.out.println(start);        // last value ko print karo, as destination
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,1,1,1,1,1};
        maxNumbers(arr);
        int arr1[] = {1,2,3,4};
        int arr2[] = {3,4,5,1};
        unionOfArrays(arr1,arr2);
        intersection(arr1, arr2);
        printPath();
    }
}