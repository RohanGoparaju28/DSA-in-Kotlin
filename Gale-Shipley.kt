fun Gale_Shapley(
    men: MutableMap<String, MutableList<String>>,
    women: MutableMap<String, MutableList<String>>
): Map<String, String> {
    val freeMan = men.keys.toMutableList()
    val optimal_partner = mutableMapOf<String, String>()
    val menPreferenceIndex = mutableMapOf<String, Int>().apply { men.keys.forEach { this[it] = 0 } }
    val womenRanking = mutableMapOf<String, Map<String, Int>>()
    for ((woman, preference) in women) {
        womenRanking[woman] = preference.withIndex().associate { it.value to it.index }
    }
    while (freeMan.isNotEmpty()) {
        val man = freeMan.removeAt(0)
        val womanPreference = men[man]!![menPreferenceIndex[man]!!]
        menPreferenceIndex[man] = menPreferenceIndex[man]!! + 1
        if (!optimal_partner.containsKey(womanPreference)) {

            optimal_partner[womanPreference] = man
        } else {

            val currentPartner = optimal_partner[womanPreference]!!
            if (womenRanking[womanPreference]!![man]!! < womenRanking[womanPreference]!![currentPartner]!!) {
                freeMan.add(currentPartner)
                optimal_partner[womanPreference] = man
            } else {

                freeMan.add(man)
            }
        }
    }

    return optimal_partner
}

fun main() {
    print("Enter number of men & women that participates in Gale-Shapley algorithm: ")
    val n:Int = readln().toInt();
    val men = mutableMapOf<String,MutableList<String>>()
    val women = mutableMapOf<String,MutableList<String>>()
    val menNames = mutableListOf<String>();
    for(i in 0 until n) {
        print("Enter men name ");
        menNames.add(readln());
    }
    val womenNames = mutableListOf<String>();
    for(i in 0 until n){
        print("Enter Women names")
        womenNames.add(readln());
    }
    for (menName in menNames) {
        val preference = mutableListOf<String>()
        for(j in 0 until  n){
            print("Enter $menName preference ")
            val preferred = readln()
            if(preferred in womenNames) {
                preference.add(preferred);
            } else {
                print("$preferred does not exit in $womenNames ")
            }
        }
        if(preference.isNotEmpty()){
            men[menName] = preference
        }
    }
    for(womenName in womenNames) {
        val preference = mutableListOf<String>();
        for(i in 0 until n) {
            print("Enter $womenName preference ");
            val preferred = readln()
            if(preferred in menNames){
                preference.add(preferred);
            } else {
                println("$preferred is not present in $menNames ")
            }
        }
        if(preference.isNotEmpty()){
            women[womenName] = preference;
        }
    }
    println("Men List: $men")
    println("Women List: $women")
   val res = Gale_Shapley(men,women);
    for((keys,value) in res) {
        println("$value $keys")
    }
}