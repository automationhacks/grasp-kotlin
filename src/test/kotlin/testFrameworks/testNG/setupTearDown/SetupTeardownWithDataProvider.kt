package testFrameworks.testNG.setupTearDown

import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.util.concurrent.ThreadLocalRandom

enum class VehicleType() {
    CAR,
    CAR_XL
}

class BookingNotFound(message: String) : Exception(message)


class Booking {
    companion object {
        private val bookingDB = hashMapOf<VehicleType, ArrayList<Int>>()
    }

    init {
        bookingDB[VehicleType.CAR] = arrayListOf()
        bookingDB[VehicleType.CAR_XL] = arrayListOf()
    }

    fun makeBooking(type: VehicleType): Int {
        val orderId = getRandomInt()
        addBookingToDb(type, orderId)

        return orderId
    }

    private fun getRandomInt() = ThreadLocalRandom.current().nextInt(1, 1000)
    private fun addBookingToDb(type: VehicleType, orderId: Int) {
        bookingDB[type]?.add(orderId)
    }

    fun cancelBooking(type: VehicleType, orderId: Int) {
        val doesOrderExist = doesBookingExists(type, orderId)
        cancelBookingIfFound(doesOrderExist, orderId, type)
    }


    fun doesBookingExists(type: VehicleType, orderId: Int): Boolean? {
        return bookingDB[type]?.contains(orderId)
    }

    private fun cancelBookingIfFound(
        doesOrderExist: Boolean?,
        orderId: Int,
        type: VehicleType
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
    @DataProvider
    fun getVehicleTypes(): MutableIterator<Array<Any>> {
        val vehicles = arrayListOf<Array<Any>>()

        vehicles.add(arrayOf(VehicleType.CAR))
        vehicles.add(arrayOf(VehicleType.CAR_XL))

        return vehicles.iterator()
    }

    @Test(dataProvider = "getVehicleTypes")
    fun testBookingCreation(vehicleType: VehicleType) {
        val booking = Booking()
        val orderId = booking.makeBooking(vehicleType)

        val isBookingCreated = booking.doesBookingExists(vehicleType, orderId)
        Assert.assertNotNull(isBookingCreated)
    }

    @Test
    fun testBookingCancellation() {
        val vehicleType = VehicleType.CAR_XL

        val booking = Booking()
        val orderId = booking.makeBooking(vehicleType)

        val isBookingCreated = booking.doesBookingExists(vehicleType, orderId)
        Assert.assertNotNull(isBookingCreated)

        booking.cancelBooking(vehicleType, orderId)
        val isBookingFound = booking.doesBookingExists(vehicleType, orderId)

        Assert.assertNotNull(isBookingCreated)
        Assert.assertFalse(isBookingFound!!)
    }
}