class SingleLinkedList<T> {
    inner class Node<T>(data:T,next:Node<T>?) {
        val data = data
        var next:Node<T>? = null
    }
    var head:Node<T>? = null
    var temp:Node<T>? = null
    fun insertBeg(data:T) {
        val node:Node<T> = Node(data,null)
        if(head == null) {
            head = node
            temp = node
        } else {
            node.next  = head
            head = node
        }
    }
    fun insertLast(data: T) {
        val node:Node<T> = Node(data,null)
        if(head== null) {
            insertBeg(data)
        } else {
            temp?.next = node
            temp = node
        }
    }
    fun insertPos(data: T,pos:Int) {
        if(head == null || pos == 0) {
            insertBeg(data)
        }
        else {
            val node = Node(data,null)
            var curr = head
            var prev:Node<T>? = null
            var i = 0
            while(i<pos && curr != null) {
                prev = curr
                curr = curr.next
                i++
            }
            if(curr == null) {
                insertLast(data)
            } else {
                prev?.next  = node
                node.next = curr
            }
        }
    }
    fun deleteBeg() {
        if(head == null) {
            println("Empty LinkedList")
        }else {
            head = head?.next
        }
    }
    fun deleteLast() {
        if(head == null) return
        var curr = head
        var prev:Node<T>?= null
        while(curr?.next != null) {
            prev = curr
            curr = curr?.next
        }
        prev?.next = null;
        temp = prev
    }
    fun deletePos(pos:Int) {
        if(head == null) return
        if(pos == 0) {
            deleteBeg()
        } else {
            var curr = head
            var prev:Node<T>? = null
            var i = 0
            while(i<pos && curr!= null) {
                prev = curr
                curr = curr.next
                i++
            }
            if(curr == null) deleteLast()
            else {
                prev?.next = curr.next
            }
        }

    }
    fun display() {
        var curr = head
        while(curr!= null) {
            print("${curr.data} ")
            curr = curr.next
        }
        println()
    }
}
fun main() {
    val i = SingleLinkedList<Int>()
    i.insertBeg(5)
    i.insertBeg(15)
    i.display()
    i.insertLast(67)
    i.insertPos(45,2)
    i.display()
    i.deletePos(1)
    i.display()
    val str = SingleLinkedList<String>()
    str.insertLast("J")
    str.insertPos("t",2)
    str.insertBeg("Micheal")
    str.display()
    str.deleteBeg()
    str.display()
}