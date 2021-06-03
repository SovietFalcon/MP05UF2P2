package ex2;

public class Main {

    public static void main(String[] args) {

        HashTable ht = new HashTable();

        ht.put("1", "lol");
        ht.put("2", "lol2");

        System.out.println(ht.getCollisionsForKey("1", 5));
        System.out.println(ht.getCollisionsForKey("2", 5));
    }

}
