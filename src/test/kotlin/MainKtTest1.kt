import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun totalTransferVisaWithoutDiscont() {
        val transfer = 300
        val userCard = "Visa"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(35, result)
    }

    @Test
    fun totalTransferVisaFall() {
        val transfer = 50
        val userCard = "Visa"
        val mounthLimit = 1_000_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! Сумма месячных переводов по Visa превышена", result)
    }

    @Test
    fun totalTransferVisaMin() {
        val transfer = 35
        val userCard = "Visa"
        val mounthLimit = 1_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(35, result)
    }

    @Test
    fun totalTransferVisaWithMinDiscont() {
        val transfer = 500
        val userCard = "Visa"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(37, result)
    }

    @Test
    fun totalTransferVisaWithDiscount() {
        val transfer = 205_000
        val userCard = "Visa"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(15375, result)
    }

    @Test
    fun totalTransferVisaLimit() {
        val transfer = 25_000
        val userCard = "Visa"
        val mounthLimit = 650_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! Сумма месячных переводов по Visa превышена", result)
    }

    @Test
    fun totalTransferMirWihtMinDiscount() {
        val transfer = 300
        val userCard = "Mir"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(35, result)
    }

    @Test
    fun totalTransferMirMin() {
        val transfer = 35
        val userCard = "Mir"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(35, result)
    }

    @Test
    fun totalTransferMirWihtoutDiscount() {
        val transfer = 500
        val userCard = "Mir"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(37, result)
    }

    @Test
    fun totalTransferMirWihtDiscount() {
        val transfer = 350_000
        val userCard = "Mir"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(26250, result)
    }

    @Test
    fun totalTransferMirLimit() {
        val transfer = 5_000
        val userCard = "Mir"
        val mounthLimit = 650_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! Сумма месячных переводов по Mir превышена", result)
    }

    @Test
    fun totalTransferVKWihtLimit() {
        val transfer = 10_000
        val userCard = "VK_pay"
        val mounthLimit = 40_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! Сумма месячных переводов по VK_pay превышена", result)
    }

    @Test
    fun totalTransferVKWihtoutLimit() {
        val transfer = 50_000
        val userCard = "VK_pay"
        val mounthLimit = 5_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(0, result)
    }

    @Test
    fun totalTransferVKWihtoutDiscount() {
        val transfer = 10_000
        val userCard = "VK_pay"
        val mounthLimit = 10_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(0, result)
    }

    @Test
    fun totalTransferMaestroWithoutDiscont() {
        val transfer = 5_000
        val userCard = "Maestro"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(0, result)
    }

    @Test
    fun totalTransferMaestroWithDiscont() {
        val transfer = 85_000
        val userCard = "Maestro"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(530, result)
    }

    @Test
    fun totalTransferMaestroLimit() {
        val transfer = 5_000
        val userCard = "Maestro"
        val mounthLimit = 650_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! Сумма месячных переводов по Maestro превышена", result)
    }

    @Test
    fun totalTransferMasterCardWithDiscount() {
        val transfer = 5_000
        val userCard = "MasterCard"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(0, result)
    }


    @Test
    fun totalTransferMasterCardWithoutDiscount() {
        val transfer = 100_000
        val userCard = "MasterCard"
        val mounthLimit = 50_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals(620, result)
    }

    @Test
    fun totalTransferMasterCardLimit() {
        val transfer = 5_000
        val userCard = "MasterCard"
        val mounthLimit = 850_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! Сумма месячных переводов по MasterCard превышена", result)
    }

    @Test
    fun totalTransferUnknown() {
        val transfer = 10_000
        val userCard = "Cash"
        val mounthLimit = 10_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! внесены не корректные данные", result)
    }

    @Test
    fun totalTransferMax() {
        val transfer = 1_000_000
        val userCard = "Cash"
        val mounthLimit = 1_500_000

        val result = totalTransfer(transfer, userCard, mounthLimit)

        assertEquals("Внимание! внесены не корректные данные", result)
    }
}