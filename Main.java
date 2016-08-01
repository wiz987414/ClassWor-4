import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CountMapPrototype<String> freeList = new CountMapPrototype<>();
        CountMapPrototype<String> additionList = new CountMapPrototype<>();
        freeList.add("One");
        freeList.add("One");
        freeList.add("Two");
        freeList.valueOut("One");
        freeList.valueOut("Two");

        freeList.showMap();
        System.out.println(freeList.remove("Two") + " - value of removed element");
        System.out.println("\nList after removing element \"One\"");
        freeList.showMap();

        additionList.add("One");
        additionList.add("Two");
        additionList.add("Two");
        additionList.add("Three");
        System.out.println("\nOther list");
        additionList.showMap();

        freeList.addAll(additionList);
        System.out.println("\nExtended list with size: " + freeList.size());
        freeList.showMap();

        Map<String, Integer> listMap = freeList.toMap();

        System.out.println("\nList to map");
        for (Map.Entry element : listMap.entrySet())
            System.out.println(element.getKey() + " - " + element.getValue());
    }
}
