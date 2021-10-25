public class Main {
    public static void main(String[] args){
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList<>();
        circleLinkedList.insert(4);
        circleLinkedList.insert(6);
        circleLinkedList.insert(1);
        circleLinkedList.delete(2);
        circleLinkedList.insert(9);
        circleLinkedList.insert(22);
        circleLinkedList.delete(28);
        System.out.println(circleLinkedList.toString());
    }
}
