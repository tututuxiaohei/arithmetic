package date;

/**
 * @author mazhenxing
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);

        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(first,second);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始化头结点
        ListNode result = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        //定义变量循环添加next 该值节点 每次循环都会改变
        ListNode cur = result;
        int pos = 0;
        while (p1 != null || p2 != null){
            int i = p1 == null ? 0 : p1.val;
            int j = p2 == null ? 0 : p2.val;
            int sum = i + j + pos;
            pos = sum / 10;
            //创建余数节点
            cur.next = new ListNode(sum % 10);
            //修改当前节点
            cur = cur.next;
            if(null != p1){
                p1 = p1.next;
            }
            if(null != p2){
                p2 = p2.next;
            }
        }
        if(pos > 0){
            cur.next = new ListNode(pos);
        }
        //返回头结点的next
        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
