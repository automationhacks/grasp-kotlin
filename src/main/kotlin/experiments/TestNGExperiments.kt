package experiments

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

val someJson = """
    {
  "cases": [
    {
      "name": "foo",
      "desc": "foo desc "
    },
    {
      "name": "bar",
      "desc": "bar desc"
    }
  ]
}

""".trimIndent()

data class Cases(
        val cases: List<Case>
)

data class Case(
        val name: String,
        val desc: String
)

fun getData(): Cases {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val adapter = moshi.adapter(Cases::class.java)
    return adapter.fromJson(someJson)!!
}

class SomeTests {
    @DataProvider(name = "theDP")
    fun dataProvider(): MutableIterator<Array<Any>> {
        val cases = getData()
        val dp: ArrayList<Array<Any>> = ArrayList()

        for (case in cases.cases) {
            dp.add(arrayOf(case.name, case.desc))
        }

        return dp.iterator()
    }

    @Test(dataProvider = "theDP")
    fun someTest(name: String, description: String) {
        println("$name $description")
    }

}
