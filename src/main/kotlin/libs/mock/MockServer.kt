package libs.mock

import org.mockserver.client.MockServerClient
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import java.io.File
import java.util.concurrent.TimeUnit


class MockServer {
    fun addExpectation() {
        // Create an instance of libs.mock server client
        val mock = MockServerClient("localhost", 1080)

        // Read JSON response from a file
        val json = File("src/main/resources/users.json").readText()

        // Setup expectations (purposely introducing a delay of 250 ms)
        mock.`when`(
            HttpRequest.request().withMethod("GET").withPath("/users")
        )
            .respond(
                HttpResponse.response().withStatusCode(200).withBody(json).withDelay(TimeUnit.MILLISECONDS, 250)
            )
    }
}

fun main() {
    MockServer().addExpectation()
}
