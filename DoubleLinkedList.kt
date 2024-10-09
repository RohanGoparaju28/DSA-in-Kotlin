class DoubleLinkedList<T> {
    inner  class Node<T>(data:T) {
        val data = data
        var next:Node<T>? = null
        var prev:Node<T>? = null
    }
    var head:Node<T>? = null
    var temp:Node<T>? = null
    fun insertBeg(data:T) {
        val node = Node(data)
        if(head == null) {
            head = node
            temp = node
        }else {
            head?.next = node
            node?.prev = head
        }
    }
    fun insertLast(data: T) {
        val node = Node(data)
        if(head == null) {
            insertBeg(data)
        } else {
            temp?.next  = node
            node.prev = temp
            temp = node
        }
    }
    fun insertPos(data:T,pos:Int) {
        if(head == null || pos == 0) insertBeg(data)
        else {
            var node = Node(data)
            var curr = head
            var prev:Node<T>? = null
            for(i in 0 until pos ) {
                if(curr == null) {
                    break
                } else{
                    prev = curr;
                }
                curr = curr.next
            }
            if(curr == null) insertLast(data)
            else {
                prev?.next =  node
                node.prev = prev
                node.next = curr
                curr.prev = node
                node = curr
            }
        }
    }
    fun deleteBeg() {
        if(head == null) return
        else{
            head = head?.next
            head?.prev = null
        }
    }
    fun deleteLast() {
        if(head == null) return
        else{
            var curr = head
            var prev:Node<T>? = null
            while(curr?.next != null) {
                prev = curr
                curr = curr.next
            }
            prev?.next  = null
            curr?.next = null;
            temp = prev
        }
    }
    fun deletePos(pos:Int) {
        if(head != null && pos == 0) {
            deleteBeg()
        } else{
            var curr = head
            var prev:Node<T>? = null
            var i = 0
            while(i<pos && curr != null) {
                prev = curr
                curr = curr.next
                i++
            }
            if(curr == null) deleteLast()
            else{
                prev?.next = curr.next
                curr.prev = null;
            }
        }
    }
    fun display() {
        if(head == null) return
        else{
            var curr = head
            while(curr != null) {
                print("${curr.data} ")
                curr = curr.next
            }
            println()
        }
    }
}
fun main() {
    val int = DoubleLinkedList<Int>()
    int.insertBeg(45)
    int.insertLast(345)
    int.insertLast(348)
    int.insertPos(3,1)
    int.display()
    int.deleteLast()
    int.deletePos(1)
    int.display()
    val bool = DoubleLinkedList<Boolean>()
    bool.insertBeg(true)
    bool.insertLast(false)
    bool.display()
    bool.insertPos(true,0)
    bool.display()
    bool.deleteLast()
    bool.display()

}