package ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void TestPut1() {

        //Inserir un element que no col·lisiona dins una taula vuida.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        assertEquals("\n" +
                " bucket[1] = [1, test1]", ht1.toString());
    }

    @Test
    public void TestPut2() {
        //Inserir un element que no col·lisiona dins una taula no vuida.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("2", "test2");
        assertEquals("\n" +
                " bucket[1] = [1, test1]\n" +
                " bucket[2] = [2, test2]", ht1.toString());
    }

    @Test
    public void TestPut3() {
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 2a posició dins el mateix bucket.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("12", "test3");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test3]", ht1.toString());
    }

    @Test
    public void TestPut4() {
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 3a posició dins el mateix bucket.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("12", "test3");
        ht1.put("23", "test4");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test3] -> [23, test4]", ht1.toString());

    }

    @Test
    public void TestPut5() {
        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        assertEquals("\n" +
                " bucket[1] = [1, test1]", ht1.toString());

    }

    @Test
    public void TestPut6() {

        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("1", "test2");
        assertEquals("\n" +
                " bucket[1] = [1, test2]", ht1.toString());

    }

    @Test
    public void TestPut7() {

        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (2a posició) dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("12", "test2");
        ht1.put("12", "test3");

        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test3]", ht1.toString());

    }

    @Test
    public void TestPut8() {

        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (3a posició) dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("12", "test2");
        ht1.put("23", "test3");
        ht1.put("23", "test4");

        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test2] -> [23, test4]", ht1.toString());
    }

    @Test
    public void TestGet1() {

        //Obtenir un element que no col·lisiona dins una taula vuida.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        assertEquals("test1", ht.get("1"));

    }

    @Test
    public void TestGet2() {

        //Obtenir un element que col·lisiona dins una taula (1a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        assertEquals("test1", ht.get("1"));

    }

    @Test
    public void TestGet3() {

        //Obtenir un element que col·lisiona dins una taula (2a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        assertEquals("test2", ht.get("12"));

    }

    @Test
    public void TestGet4() {

        //Obtenir un element que col·lisiona dins una taula (3a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        assertEquals("test3", ht.get("23"));

    }

    @Test
    public void TestGet5() {

        //Obtenir un elements que no existeix perquè la seva posició està buida.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        assertEquals(null, ht.get("3"));

    }

    @Test
    public void TestGet6() {

        //Obtenir un elements que no existeix, tot i que la seva posició està ocupada per un altre que no col·lisiona.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test3");
        assertEquals(null, ht.get("13"));

    }

    @Test
    public void TestGet7() {

        //Obtenir un elements que no existeix, tot i que la seva posició està ocupada per 3 elements col·lisionats.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test3");
        assertEquals(null, ht.get("34"));

    }

    @Test
    public void TestDrop1() {

        //Esborrar un element que no col·lisiona dins una taula.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("2");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test2] -> [23, test3]", ht.toString());

    }

    @Test
    public void TestDrop2() {

        //Esborrar un element que si col·lisiona dins una taula (1a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("1");
        assertEquals("\n" +
                " bucket[1] = [12, test2] -> [23, test3]\n" +
                " bucket[2] = [2, test4]", ht.toString());

    }

    @Test
    public void TestDrop3() {

        //Esborrar un element que si col·lisiona dins una taula (2a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("12");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [23, test3]\n" +
                " bucket[2] = [2, test4]", ht.toString());

    }

    @Test
    public void TestDrop4() {

        //Esborrar un element que si col·lisiona dins una taula (3a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("23");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test2]\n" +
                " bucket[2] = [2, test4]", ht.toString());

    }

    @Test
    public void TestDrop5() {

        //Eliminar un elements que no existeix perquè la seva posició està buida.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("3");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test2] -> [23, test3]\n" +
                " bucket[2] = [2, test4]", ht.toString());

    }

    @Test
    public void TestDrop6() {

        //Eliminar un elements que no existeix, tot i que la seva posició està ocupada per un altre que no col·lisiona.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("13");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test2] -> [23, test3]\n" +
                " bucket[2] = [2, test4]", ht.toString());

    }

    @Test
    public void TestDrop7() {

        //Eliminar un elements que no existeix, tot i que la seva posició està ocupada per 3 elements col·lisionats.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("34");
        assertEquals("\n" +
                " bucket[1] = [1, test1] -> [12, test2] -> [23, test3]\n" +
                " bucket[2] = [2, test4]", ht.toString());

    }


    @Test
    public void TestCount1() {

        //Inserir un element que no col·lisiona dins una taula vuida.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        assertEquals(1, ht1.count());
    }

    @Test
    public void TestCount2() {
        //Inserir un element que no col·lisiona dins una taula no vuida.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("2", "test2");
        assertEquals(2, ht1.count());
    }

    @Test
    public void TestCount3() {
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 2a posició dins el mateix bucket.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("12", "test3");
        assertEquals(2, ht1.count());
    }

    @Test
    public void TestCount4() {
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 3a posició dins el mateix bucket.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("12", "test3");
        ht1.put("23", "test4");
        assertEquals(3, ht1.count());

    }

    @Test
    public void TestCount5() {
        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        assertEquals(1, ht1.count());

    }

    @Test
    public void TestCount6() {

        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("1", "test2");
        assertEquals(1, ht1.count());

    }

    @Test
    public void TestCount7() {

        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (2a posició) dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("12", "test2");
        ht1.put("12", "test3");

        assertEquals(2, ht1.count());

    }

    @Test
    public void TestCount8() {

        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (3a posició) dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("12", "test2");
        ht1.put("23", "test3");
        ht1.put("23", "test4");

        assertEquals(3, ht1.count());
    }


    @Test
    public void TestCount9() {

        //Esborrar un element que no col·lisiona dins una taula.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("2");
        assertEquals(3, ht.count());

    }

    @Test
    public void TestCount10() {

        //Esborrar un element que si col·lisiona dins una taula (1a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("1");
        assertEquals(3, ht.count());

    }

    @Test
    public void TestCount11() {

        //Esborrar un element que si col·lisiona dins una taula (2a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("12");
        assertEquals(3, ht.count());

    }

    @Test
    public void TestCount12() {

        //Esborrar un element que si col·lisiona dins una taula (3a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("23");
        assertEquals(3, ht.count());

    }

    @Test
    public void TestCount13() {

        //Eliminar un elements que no existeix perquè la seva posició està buida.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("3");
        assertEquals(4, ht.count());

    }

    @Test
    public void TestCount14() {

        //Eliminar un elements que no existeix, tot i que la seva posició està ocupada per un altre que no col·lisiona.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("13");
        assertEquals(4, ht.count());

    }

    @Test
    public void TestCount15() {

        //Eliminar un elements que no existeix, tot i que la seva posició està ocupada per 3 elements col·lisionats.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("34");
        assertEquals(4, ht.count());

    }






    @Test
    public void TestSize1() {

        //Inserir un element que no col·lisiona dins una taula vuida.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        assertEquals(16, ht1.size());
    }

    @Test
    public void TestSize2() {
        //Inserir un element que no col·lisiona dins una taula no vuida.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("2", "test2");
        assertEquals(16, ht1.size());
    }

    @Test
    public void TestSize3() {
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 2a posició dins el mateix bucket.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("12", "test3");
        assertEquals(16, ht1.size());
    }

    @Test
    public void TestSize4() {
        //Inserir un element que col·lisiona dins una taula no vuida, que es col·locarà en 3a posició dins el mateix bucket.

        HashTable ht1 = new HashTable();

        ht1.put("1", "test1");
        ht1.put("12", "test3");
        ht1.put("23", "test4");
        assertEquals(16, ht1.size());

    }

    @Test
    public void TestSize5() {
        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        assertEquals(16, ht1.size());

    }

    @Test
    public void TestSize6() {

        //Inserir un elements que ja existeix (update) sobre un element que no col·lisiona dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("1", "test2");
        assertEquals(16, ht1.size());

    }

    @Test
    public void TestSize7() {

        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (2a posició) dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("12", "test2");
        ht1.put("12", "test3");

        assertEquals(16, ht1.size());

    }

    @Test
    public void TestSize8() {

        //Inserir un elements que ja existeix (update) sobre un element que si col·lisiona (3a posició) dins una taula no vuida.

        HashTable ht1 = new HashTable();
        ht1.put("1", "test1");
        ht1.put("12", "test2");
        ht1.put("23", "test3");
        ht1.put("23", "test4");

        assertEquals(16, ht1.size());
    }


    @Test
    public void TestSize9() {

        //Esborrar un element que no col·lisiona dins una taula.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("2");
        assertEquals(16, ht.size());

    }

    @Test
    public void TestSize10() {

        //Esborrar un element que si col·lisiona dins una taula (1a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("1");
        assertEquals(16, ht.size());

    }

    @Test
    public void TestSize11() {

        //Esborrar un element que si col·lisiona dins una taula (2a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("12");
        assertEquals(16, ht.size());

    }

    @Test
    public void TestSize12() {

        //Esborrar un element que si col·lisiona dins una taula (3a posició dins el mateix bucket).

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("23");
        assertEquals(16, ht.size());

    }

    @Test
    public void TestSize13() {

        //Eliminar un elements que no existeix perquè la seva posició està buida.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("3");
        assertEquals(16, ht.size());

    }

    @Test
    public void TestSize14() {

        //Eliminar un elements que no existeix, tot i que la seva posició està ocupada per un altre que no col·lisiona.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("13");
        assertEquals(16, ht.size());

    }

    @Test
    public void TestSize15() {

        //Eliminar un elements que no existeix, tot i que la seva posició està ocupada per 3 elements col·lisionats.

        HashTable ht = new HashTable();
        ht.put("1", "test1");
        ht.put("12", "test2");
        ht.put("23", "test3");
        ht.put("2", "test4");

        ht.drop("34");
        assertEquals(16, ht.size());

    }

}