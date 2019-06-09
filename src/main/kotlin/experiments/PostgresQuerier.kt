package experiments

import org.testng.Reporter
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class PostgresClient(
        private val host: String,
        private val dbName: String,
        private val user: String,
        private val password: String) {

    private var connection: Connection? = null

    private fun connect(): Connection? {

        val jdbcConnString = "jdbc:postgresql://%s:5432/%s"
        try {
            Class.forName("org.postgresql.Driver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }

        try {
            connection = DriverManager.getConnection(
                    String.format(jdbcConnString, host, dbName), user, password
            )
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return connection

    }

    fun read(query: String): List<Any> {
        val rows = ArrayList<Any>()

        try {
            connect()!!.use { conn ->
                conn.createStatement().use { statement ->
                    statement.executeQuery(query).use { rs ->
                        while (rs.next()) {
                            val tempRows = arrayListOf<Any>()

                            tempRows.add(rs.getString("id"))
                            tempRows.add(rs.getString("name"))
                            tempRows.add(rs.getString("shipper_price"))

                            rows.add(tempRows)

                        }
                    }
                }
            }
        } catch (e: SQLException) {
            Reporter.log("Oops something went wrong while executing query for $host")
            e.printStackTrace()
        }

        return rows
    }
}

fun main(args: Array<String>) {
    val client = PostgresClient("", "", "", "")
    val result = client.read("select * from boxes")
    print(result)

}

