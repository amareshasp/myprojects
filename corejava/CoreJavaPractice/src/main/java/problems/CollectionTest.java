package problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionTest {
    public static void main(String[] args) {
    Map<Integer,String> studentMap = new HashMap<>();
    studentMap.put(1,"ABC1");
        studentMap.put(2,"PAC134");
        studentMap.put(3,"TAKS1");
        studentMap.put(4,"AYUS2");
        studentMap.put(5,"MIKDJ8");


        for(Map.Entry entry : studentMap.entrySet()){
            System.out.println(entry.getKey()+ "- "+ entry.getValue());
        }

        Iterator<Map.Entry<Integer,String>> itr = studentMap.entrySet().iterator();
        while (itr.hasNext()){
            System.out.println(itr.next().getKey());
        }

        studentMap.forEach((k,v)-> System.out.println(v));

    }


}
