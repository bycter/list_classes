import org.example.myCollection.ArrayListCustom;
import org.example.myCollection.ListCustom;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCustomTest {

    @Test
    public void constructorTestWithoutArg() {
        ListCustom<String> listToCheck = new ArrayListCustom<>();

        Assert.assertEquals(0, listToCheck.size());
    }

    @Test
    public void constructorTestStartCapacity() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(5);

        Assert.assertEquals(0, listToCheck.size());
    }

    @Test
    public void constructorTestCollectionOfElements() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        Assert.assertEquals(3, listToCheck.size());

        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void getTest() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        Assert.assertEquals(3, listToCheck.size());

        IndexOutOfBoundsException e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.get(-1));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.get(3));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));
    }

    @Test
    public void addTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>();

        listToCheck.add("G");

        Assert.assertEquals(1, listToCheck.size());
        Assert.assertEquals("G", listToCheck.get(0));
    }

    @Test
    public void addTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.add("G");

        Assert.assertEquals(4, listToCheck.size());
        Assert.assertEquals("G", listToCheck.get(3));
    }

    @Test
    public void addTest3() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.add(null);

        Assert.assertEquals(4, listToCheck.size());
        Assert.assertEquals("C", listToCheck.get(2));
        Assert.assertNull(listToCheck.get(3));
    }

    @Test
    public void addTest4() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.add("");

        Assert.assertEquals(4, listToCheck.size());
        Assert.assertEquals("C", listToCheck.get(2));
        Assert.assertEquals("", listToCheck.get(3));
    }

    @Test
    public void addWithIndexTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        IndexOutOfBoundsException e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.add(-1, "G"));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.add(4, "G"));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void addWithIndexTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.add(0, "G");

        Assert.assertEquals(4, listToCheck.size());
        Assert.assertEquals("G", listToCheck.get(0));
        Assert.assertEquals("A", listToCheck.get(1));
        Assert.assertEquals("B", listToCheck.get(2));
        Assert.assertEquals("C", listToCheck.get(3));
    }

    @Test
    public void addWithIndexTest3() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.add(2, "G");

        Assert.assertEquals(4, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("G", listToCheck.get(2));
        Assert.assertEquals("C", listToCheck.get(3));
    }

    @Test
    public void addWithIndexTest4() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.add(3, "G");

        Assert.assertEquals(4, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
        Assert.assertEquals("G", listToCheck.get(3));
    }

    @Test
    public void addAllTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>();

        listToCheck.addAll(List.of("PP", "KK"));

        Assert.assertEquals(2, listToCheck.size());
        Assert.assertEquals("PP", listToCheck.get(0));
        Assert.assertEquals("KK", listToCheck.get(1));
    }

    @Test
    public void addAllTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.addAll(List.of("PP", "KK"));

        Assert.assertEquals(5, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
        Assert.assertEquals("PP", listToCheck.get(3));
        Assert.assertEquals("KK", listToCheck.get(4));
    }

    @Test
    public void addAllWithIndexTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        IndexOutOfBoundsException e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.addAll(-1, List.of("PP", "KK")));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.addAll(4, List.of("PP", "KK")));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void addAllWithIndexTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.addAll(1, new ArrayList<>());

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void addAllWithIndexTest3() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.addAll(1, List.of());

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void addAllWithIndexTest4() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.addAll(2, List.of("PP", "KK"));

        Assert.assertEquals(5, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("PP", listToCheck.get(2));
        Assert.assertEquals("KK", listToCheck.get(3));
        Assert.assertEquals("C", listToCheck.get(4));
    }

    @Test
    public void addAllWithIndexTest5() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.addAll(3, List.of("PP", "KK"));

        Assert.assertEquals(5, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
        Assert.assertEquals("PP", listToCheck.get(3));
        Assert.assertEquals("KK", listToCheck.get(4));
    }

    @Test
    public void setTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        IndexOutOfBoundsException e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.set(-1, "PP"));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.set(3, "PP"));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void setTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.set(0, "PP");

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("PP", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void setTest3() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.set(2, "PP");

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("PP", listToCheck.get(2));
    }

    @Test
    public void removeWithIndexTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        IndexOutOfBoundsException e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.remove(-1));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.remove(3));
        Assert.assertTrue(e.getMessage().contains("Wrong array index"));

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void removeWithIndexTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.remove(0);

        Assert.assertEquals(2, listToCheck.size());
        Assert.assertEquals("B", listToCheck.get(0));
        Assert.assertEquals("C", listToCheck.get(1));
    }

    @Test
    public void removeWithIndexTest3() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.remove(1);

        Assert.assertEquals(2, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("C", listToCheck.get(1));
    }

    @Test
    public void removeWithIndexTest4() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.remove(2);

        Assert.assertEquals(2, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
    }

    @Test
    public void removeWithObjectTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        Object obj = 1;
        listToCheck.remove(obj);

        listToCheck.remove(new String[0]);
        listToCheck.remove(null);
        listToCheck.remove("");
        listToCheck.remove("b");

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
    }

    @Test
    public void removeWithObjectTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));

        listToCheck.remove("B");

        Assert.assertEquals(2, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("C", listToCheck.get(1));
    }

    @Test
    public void removeWithObjectTest3() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C", "B"));

        listToCheck.remove("B");

        Assert.assertEquals(3, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("C", listToCheck.get(1));
        Assert.assertEquals("B", listToCheck.get(2));
    }

    @Test
    public void removeWithObjectTest4() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C"));
        listToCheck.add(2, null);
        listToCheck.add(4, null);

        listToCheck.remove(null);

        Assert.assertEquals(4, listToCheck.size());
        Assert.assertEquals("A", listToCheck.get(0));
        Assert.assertEquals("B", listToCheck.get(1));
        Assert.assertEquals("C", listToCheck.get(2));
        Assert.assertNull(listToCheck.get(3));
    }

    @Test
    public void subListTest1() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C", "D", "E", "F"));
        Exception e;

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.subList(-1, 0));
        Assert.assertTrue(e.getMessage().contains("should be greater than 0"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.subList(-1, 2));
        Assert.assertTrue(e.getMessage().contains("should be greater than 0"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.subList(0, 10));
        Assert.assertTrue(e.getMessage().contains("should be less than size of array"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.subList(0, 7));
        Assert.assertTrue(e.getMessage().contains("should be less than size of array"));

        e = Assert.assertThrows(IndexOutOfBoundsException.class, () -> listToCheck.subList(7, 8));
        Assert.assertTrue(e.getMessage().contains("should be less than size of array"));

        e = Assert.assertThrows(IllegalArgumentException.class, () -> listToCheck.subList(4, 2));
        Assert.assertTrue(e.getMessage().contains("Incorrect parameter values."));

        e = Assert.assertThrows(IllegalArgumentException.class, () -> listToCheck.subList(7, 5));
        Assert.assertTrue(e.getMessage().contains("Incorrect parameter values."));

        e = Assert.assertThrows(IllegalArgumentException.class, () -> listToCheck.subList(7, -1));
        Assert.assertTrue(e.getMessage().contains("Incorrect parameter values."));
    }

    @Test
    public void subListTest2() {
        ListCustom<String> listToCheck = new ArrayListCustom<>(List.of("A", "B", "C", "D", "E", "F"));

        List<String> subList = listToCheck.subList(2, 4);

        Assert.assertEquals(6, listToCheck.size());

        Assert.assertEquals(2, subList.size());
        Assert.assertEquals("C", subList.get(0));
        Assert.assertEquals("D", subList.get(1));
    }
}
