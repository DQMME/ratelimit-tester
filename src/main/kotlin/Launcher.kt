import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlin.system.exitProcess

suspend fun main() {
    println("Enter the API URL")
    val url = readLine()!!
    val client = HttpClient(CIO)
    val timer = Timer()
    var count = 0

    timer.start()

    while (true) {
        count++
        println("Requesting: Try $count (second ${timer.seconds})")
        if(!request(url, client)) {
            println("Request not success after $count tries and ${timer.seconds} seconds.")
            exitProcess(0)
        }
    }
}

suspend fun request(url: String, client: HttpClient): Boolean {
    val response = client.get(url)

    println(response.bodyAsText())

    return response.status.isSuccess()
}