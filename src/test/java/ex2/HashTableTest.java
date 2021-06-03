package ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void TestPut() {

        //Test toString//
        HashTable ht = new HashTable();

        ht.put("1", "test1");

        assertEquals("\n" +
                " bucket[1] = [1, test1]", ht.toString());


        ht.put("2", "test2");

        assertEquals("\n" +
                " bucket[1] = [1, test1]\n" +
                " bucket[2] = [2, test2]", ht.toString());

        ht.put("3", "test3");

        assertEquals("\n" +
                " bucket[1] = [1, test1]\n" +
                " bucket[2] = [2, test2]\n" +
                " bucket[3] = [3, test3]", ht.toString());

        ht = null;

        //Inserir un element que no col·lisiona dins una taula vuida.
        ht = new HashTable();

        ht.put("1", "test1");
        assertEquals("1", ht.toString());


        //Inserir un element que no col·lisiona dins una taula no vuida.
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 2a posició dins el mateix bucket.
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 3a posició dins el mateix bucket.
        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula vuida.
        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula no vuida.
        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (2a posició) dins una taula no vuida.
        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (3a posició) dins una taula no vuida.

    }

    public void TestGet() {

    }

    public void TestDrop() {

    }

    public void TestCount() {

    }

    public void TestSize() {

    }

}