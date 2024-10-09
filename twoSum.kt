fun twoSum(nums:IntArray,target:Int) : IntArray {
  val hp = mutableMapOf<Int,Int>()
    for(i in 0 until nums.size) {
        val diff = target - nums[i]
        if(hp.containsKey(diff)) {
            return intArrayOf(hp[diff]!!,i)
        } else {
            hp[nums[i]] = i
        }
    }

    return IntArray(2) {-1}
}
fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val array = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
        val target = readln().toInt()
        println(twoSum(array,target).joinToString())
    }
}
