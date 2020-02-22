package testFrameworks.testNG.setupTearDown

import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.ThreadLocalRandom

enum class BookingType(val type: String) {
    RAPID("rapid"),
    SLOW("slow")
}

class BookingNotFound(message: String) : Exception(message)


class Booking {
    companion object {
        private val bookingDB = hashMapOf<BookingType, ArrayList<Int>>()
    }

    init {
        bookingDB[BookingType.RAPID] = arrayListOf()
        bookingDB[BookingType.SLOW] = arrayListOf()
    }

    fun makeBooking(type: BookingType): Int {
        val orderId = getRandomInt()
        addBookingToDb(type, orderId)

        return orderId
    }

    private fun getRandomInt() = ThreadLocalRandom.current().nextInt(1, 1000)
    private fun addBookingToDb(type: BookingType, orderId: Int) {
        bookingDB[type]?.add(orderId)
    }

    fun cancelBooking(type: BookingType, orderId: Int) {
        val doesOrderExist = doesBookingExists(type, orderId)
        cancelBookingIfFound(doesOrderExist, orderId, type)
    }


    fun doesBookingExists(type: BookingType, orderId: Int): Boolean? {
        return bookingDB[type]?.contains(orderId)
    }

    private fun cancelBookingIfFound(
        doesOrderExist: Boolean?,
        orderId: Int,
        type: BookingType
    ) {
        if (doesOrderExist == null) {
            throw BookingNotFound("Order $orderId not found in db. Cannot cancel.")
        } else {
            bookingDB[type]?.remove(orderId)
            println("Order <$orderId> successfully removed")
        }
    }
}

class SetupTeardownWithDataProvider {
    @Test
    fun testBookingCreation() {
        val bookingType = BookingType.SLOW

        val booking = Booking()
        val orderId = booking.makeBooking(bookingType)

        val isBookingCreated = booking.doesBookingExists(bookingType, orderId)
        Assert.assertNotNull(isBookingCreated)
    }

    @Test
    fun testBookingCancellation() {
        val bookingType = BookingType.SLOW

        val booking = Booking()
        val orderId = booking.makeBooking(bookingType)

        val isBookingCreated = booking.doesBookingExists(bookingType, orderId)
        Assert.assertNotNull(isBookingCreated)

        booking.cancelBooking(bookingType, orderId)
        val isBookingFound = booking.doesBookingExists(bookingType, orderId)

        Assert.assertNotNull(isBookingCreated)
        Assert.assertFalse(isBookingFound!!)
    }
}