package apitests.pactdemo

import au.com.dius.pact.consumer.ConsumerPactBuilder
import org.testng.annotations.Test

class PactExample {

    @Test
    fun pactTest() {
        val pact = ConsumerPactBuilder
                .consumer("Consumer")
                .hasPactWith("Kilat")
                .uponReceiving("A request for serviceability")
                .path("/gosend/v10/serviceability")
    }

}