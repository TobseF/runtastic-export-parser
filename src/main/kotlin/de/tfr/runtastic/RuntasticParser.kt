package de.tfr.runtastic

import com.beust.klaxon.Klaxon
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


/**
 * Provide the path to the `Weight` directory of a runtastic export.
 * The CSV formatted output will be printed to the console.
 */
fun main(args: Array<String>) {
    val weightDir = args.first()
    File(weightDir).walk().filter { it.isFile }.forEach {
        parseFile(it)
    }
}

private fun parseFile(file: File) {
    val result = Klaxon().parse<Weight>(file)
    if (result != null) {
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        val date = formatter.format(Date(result.start_time))
        val weight = String.format(Locale.GERMAN, "%.1f", result.weight)
        println("$date;$weight")
    }
}

class Weight(val start_time: Long,
        val created_at: Long,
        val updated_at: Long,
        val start_time_timezone_offset: Long,
        val weight: Double,
        val id: String,
        val origin_type: String)
