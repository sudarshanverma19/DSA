import java.util.ArrayList;
import java.util.Collections ;
class ArrayLis{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();     // we are using collections framework here.
        //add elements
        list.add(0);
        list.add(2);
        list.add(3);

        System.out.println(list);

        //get elements
        int element  = list.get(0);
        System.out.println("Element at index 0: " + element);

        // adding element in between
        list.add(1, 1);
        System.out.println(list);

        //set element
        list.set(0,5);
        System.out.println(list);

        // delete element
        list.remove(0);
        System.out.println(list);
        
        //size
        int size = list.size();      // array me length use hota and arraylist me size.
        System.out.println(size);

        // loops
        for(int i=0; i<list.size() ;i++){
            System.out.print(list.get(i));
        }
        System.out.println();
        

        // sorting
        Collections.sort(list);
        System.out.println(list);
    }
}