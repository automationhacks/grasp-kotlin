package libs.opencsv

import com.opencsv.CSVWriter
import java.io.File
import java.io.FileWriter
import java.nio.file.Path

fun writeCSV(rows: List<Array<String>>, path: Path) {
    val csv = CSVWriter(FileWriter(path.toString()))
    csv.writeAll(rows)
    csv.close()
}

fun main() {
    val row1 = arrayOf("Hello", "World")
    val rows2 = arrayOf("Kotlin", "Is Nice")
    val rows = arrayListOf(row1, rows2)

    val results = File(System.getProperty("user.dir") + "/output")
    results.mkdirs()
    val filePath = File(results, "/data.csv").toPath()

    writeCSV(rows, filePath)
}