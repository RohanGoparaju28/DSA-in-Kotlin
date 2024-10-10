fun binarySearch(nums:IntArray,l:Int,h:Int,target:Int):Int {
if(l>h) return -1
  val mid = (l+h)/2
  if(a[mid] == target) return mid
  if(a[mid]> target) return binarySearch(a,l,mid-1,target)
  else return binarySearch(a,mid+1,h,target)
}
fun main() {
val n  = readln().toInt()
val arr = IntArray(n) {0};
  for(i in 0 until n) {
    arr[i] = readln().toInt()
  }
  val target = readln().toInt();
  val idx = binarySearch(a,0,n-1,target)
  if(idx == -1) println("Element is not present in the array")
  else println("Element found t $idx");
}
