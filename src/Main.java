import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        IntList firstList;

        IntList thirdList = new ArrayIntList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addFront(8);

        //where an iterator gets used:
        for (int value: thirdList) {
            System.out.println(value);
        }

        //alternate way to use an iterator
        Iterator<Integer> itr = thirdList.iterator();
        while (itr.hasNext()){
            int value = itr.next();
            System.out.println(value);
        }

//        arrayIntListTest();
//        singlyLinkedIntListTest();
        doublyLinkedIntListTest();

    }

    public static void arrayIntListTest(){
        ArrayIntList arrayTest = new ArrayIntList();
        System.out.println("Testing ArrayIntList");

        System.out.println("\naddFront()");
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);
        arrayTest.addFront(4);
        arrayTest.addFront(5);
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 5,4,3,2,1
        }

        System.out.println("\naddBack()");
        arrayTest.addBack(20);
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 5,4,3,2,1,20
        }

        System.out.println("\nadd()");
        arrayTest.add(1,13);
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 5,13,4,3,2,1,20
        }

        System.out.println("\nremoveFront()");
        arrayTest.removeFront();
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 13,4,2,1,20
        }

        System.out.println("\nremoveBack()");
        arrayTest.removeBack();
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 13,4,3,2,1
        }

        System.out.println("\nremove()");
        arrayTest.remove(1);
        for (int value : arrayTest){
            System.out.print(value + ", "); //should be: 13,3,2,1
        }

        System.out.println("\nget()");
        arrayTest.get(1); //should be: 3

        System.out.println("contains()");
        System.out.println(arrayTest.contains(1)); //true

        System.out.println("indexOf()");
        System.out.println(arrayTest.indexOf(2)); //2

        System.out.println("isEmpty()");
        System.out.println(arrayTest.isEmpty()); //false

        System.out.println("size()");
        System.out.println(arrayTest.size()); //4

        System.out.println("clear()");
        arrayTest.clear();
        for (int value : arrayTest){
            System.out.print(value + ", "); //empty
        }

    }

    public static void singlyLinkedIntListTest(){
        LinkedIntList linkedListTest = new LinkedIntList();

        linkedListTest.addFront(1);
        linkedListTest.addFront(2);
        linkedListTest.addFront(3);
        linkedListTest.addFront(4);
        System.out.println("Base linked list: ");
        linkedListTest.printList();

        System.out.println("\naddBacK()");
        linkedListTest.addBack(13);
        linkedListTest.printList(); //4,3,2,1,13

        System.out.println("\nadd()");
        linkedListTest.add(3,10);
        linkedListTest.printList(); //4,3,2,10,1,13

        System.out.println("\nremoveFront()");
        linkedListTest.removeFront();
        linkedListTest.printList(); // 3,2,10,1,13

        System.out.println("\nremoveBack()");
        linkedListTest.removeBack();
        linkedListTest.printList(); // 3,2,10,1

        System.out.println("\nremove()");
        linkedListTest.remove(1);
        linkedListTest.printList(); // 3,10,1

        System.out.println("\nget()");
        System.out.println(linkedListTest.get(1)); // 10

        System.out.println("\ncontains()");
        System.out.println(linkedListTest.contains(10)); //true

        System.out.println("\nindexOf()");
        System.out.println(linkedListTest.indexOf(1)); //2

        System.out.println("\nisEmpty()");
        System.out.println(linkedListTest.isEmpty()); //false

        System.out.println("\nsize()");
        System.out.println(linkedListTest.size()); //3

        System.out.println("\nclear");
        linkedListTest.clear();
        linkedListTest.printList();

    }

    public static void doublyLinkedIntListTest(){
        DoublyLinkedIntList test = new DoublyLinkedIntList();
        test.addFront(1);
        test.addFront(2);
        test.addFront(3);
        test.addFront(4);
        test.addFront(5);
        test.addFront(6);
        test.addFront(7);
        test.addBack(8);
        System.out.println("Base doubly linked list"); //7, 6, 5, 4, 3, 2, 1, 8
        test.printList();

        System.out.println("\nindexOf()");
        System.out.println(test.indexOf(6)); //1

        System.out.println("\nget()");
        System.out.println(test.get(0)); //7

        System.out.println("\ncontains()");
        System.out.println(test.contains(3)); //true

        System.out.println("\nremove()");
        test.remove(4);
        test.printList(); //7, 6, 5, 4, 2, 1, 8

        System.out.println("\nremoveFront");
        test.removeFront();
        test.printList(); //6, 5, 4, 2, 1, 8

        System.out.println("\nremoveBack");
        test.removeBack();
        test.printList(); //6, 5, 4, 2, 1

        System.out.println("\nsize()");
        System.out.println(test.size()); //5

        System.out.println("\nclear()");
        test.clear();

        System.out.println("\nisEmpty()");
        System.out.println(test.isEmpty()); //true

    }
}