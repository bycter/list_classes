import org.example.myCollection.LinkedListCustom;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LinkedListCustomTest {

    @Test
    public void getTest1_EmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));

        Assert.assertNull(linkedList.getFirst());
        Assert.assertNull(linkedList.getLast());
    }

    @Test
    public void getTest2_NotEmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("3", linkedList.get(2));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(4));

        Assert.assertEquals("1", linkedList.getFirst());
        Assert.assertEquals("3", linkedList.getLast());
    }

    @Test
    public void addAllWithIndexTest1_ToEmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>();

        linkedList.addAll(0, List.of("A", "B", "C"));

        Assert.assertEquals("A", linkedList.get(0));
        Assert.assertEquals("B", linkedList.get(1));
        Assert.assertEquals("C", linkedList.get(2));
    }

    @Test
    public void addAllWithIndexTest2_ToMiddleOfArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.addAll(2, List.of("A", "B", "C"));

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("A", linkedList.get(2));
        Assert.assertEquals("B", linkedList.get(3));
        Assert.assertEquals("C", linkedList.get(4));
        Assert.assertEquals("3", linkedList.get(5));
    }

    @Test
    public void addAllWithIndexTest3_ToBeginningArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.addAll(0, List.of("A", "B", "C"));

        Assert.assertEquals("A", linkedList.get(0));
        Assert.assertEquals("B", linkedList.get(1));
        Assert.assertEquals("C", linkedList.get(2));
        Assert.assertEquals("1", linkedList.get(3));
        Assert.assertEquals("2", linkedList.get(4));
        Assert.assertEquals("3", linkedList.get(5));
    }

    @Test
    public void addAllWithIndexTest4_ToEndingArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.addAll(3, List.of("A", "B", "C"));

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("3", linkedList.get(2));
        Assert.assertEquals("A", linkedList.get(3));
        Assert.assertEquals("B", linkedList.get(4));
        Assert.assertEquals("C", linkedList.get(5));
    }

    @Test
    public void addAllTest1_ToEmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>();

        linkedList.addAll(List.of("A", "B", "C"));

        Assert.assertEquals("A", linkedList.get(0));
        Assert.assertEquals("B", linkedList.get(1));
        Assert.assertEquals("C", linkedList.get(2));
    }

    @Test
    public void addAllTest2_ToNotEmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.addAll(List.of("A", "B", "C"));

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("3", linkedList.get(2));
        Assert.assertEquals("A", linkedList.get(3));
        Assert.assertEquals("B", linkedList.get(4));
        Assert.assertEquals("C", linkedList.get(5));
    }

    @Test
    public void addTest1_ToEmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>();

        linkedList.add("A");

        Assert.assertEquals("A", linkedList.get(0));
    }

    @Test
    public void addTest2_ToNotEmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.add("A");

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("3", linkedList.get(2));
        Assert.assertEquals("A", linkedList.get(3));
    }

    @Test
    public void addWithIndexTest1_ToEmptyArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>();

        linkedList.add(0, "A");

        Assert.assertEquals("A", linkedList.get(0));
    }

    @Test
    public void addWithIndexTest2_ToMiddleOfArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.add(2, "A");

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("A", linkedList.get(2));
        Assert.assertEquals("3", linkedList.get(3));
    }

    @Test
    public void addWithIndexTest3_ToBeginningArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.add(0, "A");

        Assert.assertEquals("A", linkedList.get(0));
        Assert.assertEquals("1", linkedList.get(1));
        Assert.assertEquals("2", linkedList.get(2));
        Assert.assertEquals("3", linkedList.get(3));
    }

    @Test
    public void addWithIndexTest4_ToEndingArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.add(3, "A");

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("3", linkedList.get(2));
        Assert.assertEquals("A", linkedList.get(3));
    }

    @Test
    public void setTest1_ToBeginningArray() {

        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.set(0, "A");

        Assert.assertEquals("A", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("3", linkedList.get(2));
    }

    @Test
    public void setTest2_ToMiddleArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.set(1, "A");

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("A", linkedList.get(1));
        Assert.assertEquals("3", linkedList.get(2));
    }

    @Test
    public void setTest3_ToEndingArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.set(2, "A");

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
        Assert.assertEquals("A", linkedList.get(2));
    }

    @Test
    public void setTest4_Exceptions() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(-1, "A"));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(3, "A"));
    }

    @Test
    public void removeTest1_ToBeginningArray() {

        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.remove(0);

        Assert.assertEquals("2", linkedList.get(0));
        Assert.assertEquals("3", linkedList.get(1));
    }

    @Test
    public void removeTest2_ToMiddleArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.remove(1);

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("3", linkedList.get(1));
    }

    @Test
    public void removeTest3_ToEndingArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        linkedList.remove(2);

        Assert.assertEquals("1", linkedList.get(0));
        Assert.assertEquals("2", linkedList.get(1));
    }

    @Test
    public void removeTest4_Exceptions() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3"));

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(-1));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(3));
    }

    @Test
    public void subListTest1_FromBeginningArray() {

        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3", "4", "5"));

        List<String> elements = linkedList.subList(0, 3);

        Assert.assertEquals(3, elements.size());
        Assert.assertEquals("1", elements.get(0));
        Assert.assertEquals("2", elements.get(1));
        Assert.assertEquals("3", elements.get(2));
    }

    @Test
    public void subListTest2_FromMiddleArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3", "4", "5"));

        List<String> elements = linkedList.subList(1, 4);

        Assert.assertEquals(3, elements.size());
        Assert.assertEquals("2", elements.get(0));
        Assert.assertEquals("3", elements.get(1));
        Assert.assertEquals("4", elements.get(2));
    }

    @Test
    public void subListTest3_FromEndingArray() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3", "4", "5"));

        List<String> elements = linkedList.subList(2, 5);

        Assert.assertEquals(3, elements.size());
        Assert.assertEquals("3", elements.get(0));
        Assert.assertEquals("4", elements.get(1));
        Assert.assertEquals("5", elements.get(2));
    }

    @Test
    public void subListTest4_Exceptions() {
        LinkedListCustom<String> linkedList = new LinkedListCustom<>(List.of("1", "2", "3", "4", "5"));

        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.subList(-1, 2));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.subList(3, 6));
    }
}
