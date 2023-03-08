class ListNode {
    private static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    public void add(int data){
        Node newNode = new Node(data);
        
        if(head == null){ // if the list is empty, set the new node as the head
            head = newNode;
            return;
        }
        // otherwise, find the last node in the list and set its "next" reference to the new node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void print(){
        Node curr = head;

        while (curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public static void twoSum(ListNode list1, ListNode list2){
        ListNode list3 = new ListNode();

        Node curr1 = list1.head;
        Node curr2 = list2.head;
        

        while(curr1 != null || curr2 != null){
            int num = curr1.val + curr2.val;
            list3.add(num);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while(curr1 != null){
            list3.add(curr1.val);
            curr1 = curr1.next;
        }

        while(curr2 != null){
            list3.add(curr2.val);
            curr2 = curr2.next;
        }
        
        Node curr3 = list3.head;

        while(curr3 != null){
            if (curr3.val >= 10){
                if(curr3.next == null){
                    list3.add(0);
                }
                curr3.val = curr3.val % 10;
                curr3.next.val += 1;
            }
            curr3 = curr3.next;
        }

        list3.print();
    }

    public static void main(String[] args){
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();

        list1.add(2); 
        list1.add(4); 
        list1.add(3);
        
        list2.add(5); 
        list2.add(6); 
        list2.add(4);  
        
        twoSum(list1, list2);
    }
}