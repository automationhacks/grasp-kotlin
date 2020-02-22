package testFrameworks.testNG.setupTearDown

import org.testng.Assert
import org.testng.annotations.BeforeMethod
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
        private val bookingDB = hashMapOf<VehicleType, ArrayList<String>>()
    }

    init {
        bookingDB[VehicleType.CAR] = arrayListOf()
        bookingDB[VehicleType.CAR_XL] = arrayListOf()
    }

    fun makeBooking(type: VehicleType): String {
        val orderId = getRandomInt().toString()
        addBookingToDb(type, orderId)

        return orderId
    }

    private fun getRandomInt() = ThreadLocalRandom.current().nextInt(1, 1000)
    private fun addBookingToDb(type: VehicleType, orderId: String) {
        bookingDB[type]?.add(orderId)
    }

    fun cancelBooking(type: VehicleType, orderId: String) {
        val doesOrderExist = doesBookingExists(type, orderId)
        cancelBookingIfFound(doesOrderExist, orderId, type)
    }


    fun doesBookingExists(type: VehicleType, orderId: String): Boolean? {
        return bookingDB[type]?.contains(orderId)
    }

    private fun cancelBookingIfFound(
        doesOrderExist: Boolean?,
        orderId: String,
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
    private lateinit var vehicleType: VehicleType
    private lateinit var orderId: String
    private val booking = Booking()

    @DataProvider
    fun getVehicleTypes(): MutableIterator<Array<Any>> {
        val vehicles = arrayListOf<Array<Any>>()

        vehicles.add(arrayOf(VehicleType.CAR))
        vehicles.add(arrayOf(VehicleType.CAR_XL))

        return vehicles.iterator()
    }

    @BeforeMethod
    fun givenBookingIsCreated(testParams: Array<Any>) {
        val vehicleType = testParams[0] as VehicleType
        orderId = booking.makeBooking(vehicleType)
    }

    @Test(dataProvider = "getVehicleTypes")
    fun testBookingCreation(vehicleType: VehicleType) {
        val isBookingCreated = booking.doesBookingExists(vehicleType, orderId)
        Assert.assertNotNull(isBookingCreated)
    }

    @Test(dataProvider = "getVehicleTypes")
    fun testBookingCancellation(vehicleType: VehicleType) {
        val isBookingCreated = booking.doesBookingExists(vehicleType, orderId)
        Assert.assertNotNull(isBookingCreated)

        booking.cancelBooking(vehicleType, orderId)
        val isBookingFound = booking.doesBookingExists(vehicleType, orderId)

        Assert.assertNotNull(isBookingCreated)
        Assert.assertFalse(isBookingFound!!)
    }
}