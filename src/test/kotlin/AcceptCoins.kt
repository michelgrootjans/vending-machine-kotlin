import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

//    ACCEPT COINS
//            As a vendor
//    I want a vending machine that accepts coins
//            So that I can collect money from the customer
//
//
//    The vending machine will accept valid coins (nickels, dimes, and quarters)
//    and reject invalid ones (pennies). When a valid coin is inserted
//            the amount of the coin will be added to the current amount
//            and the display will be updated. When there are no coins inserted,
//    the machine displays INSERT COIN. Rejected coins are placed in the coin return.
//
//NOTE: The temptation here will be to create Coin objects that know their value.
//    However, this is not how a real vending machine works. Instead, it identifies
//    coins by their weight and size and then assigns a value to what was inserted.
//    You will need to do something similar. This can be simulated using strings,
//    constants, enums, symbols, or something of that nature.
class AcceptCoins {
    @Test
    fun `At rest`() {
        val machine = VendingMachine()

        assertThat(machine.display()).isEqualTo("INSERT COIN")
        assertThat(machine.coinReturn()).isEmpty()
    }

    @Test
    fun `Insert Cent`() {
        val machine = VendingMachine()
            .insert(cent())

        assertThat(machine.display()).isEqualTo("INSERT COIN")
        assertThat(machine.coinReturn()).containsExactly(cent())
    }

    @Test
    fun `Insert Nickel`() {
        val machine = VendingMachine()
            .insert(nickel())

        assertThat(machine.display()).isEqualTo("0.05")
        assertThat(machine.coinReturn()).isEmpty()
    }

    @Test
    fun `Insert Dime`() {
        val machine = VendingMachine()
            .insert(dime())
        assertThat(machine.display()).isEqualTo("0.10")
        assertThat(machine.coinReturn()).isEmpty()
    }

    @Test
    fun `Insert Quarter`() {
        val machine = VendingMachine()
            .insert(quarter())
        assertThat(machine.display()).isEqualTo("0.25")
        assertThat(machine.coinReturn()).isEmpty()
    }

    @Test
    fun `Insert Fake Dime with different weight`() {
        val fakeDime = Coin("2.260 g", "17.91 mm")
        val machine = VendingMachine()
            .insert(fakeDime)

        assertThat(machine.display()).isEqualTo("INSERT COIN")
        assertThat(machine.coinReturn()).containsExactly(fakeDime)
    }

    @Test
    fun `Insert Fake Dime with different dimension`() {
        val fakeDime = Coin("2.268 g", "17.9 mm")
        val machine = VendingMachine()
            .insert(fakeDime)

        assertThat(machine.display()).isEqualTo("INSERT COIN")
        assertThat(machine.coinReturn()).containsExactly(fakeDime)
    }

    @Test
    fun `Insert Nickel twice`() {
        val machine = VendingMachine()
            .insert(nickel())
            .insert(nickel())

        assertThat(machine.display()).isEqualTo("0.10")
        assertThat(machine.coinReturn()).isEmpty()
    }

    @Test
    fun `Insert Dime twice`() {
        val machine = VendingMachine()
            .insert(dime())
            .insert(dime())

        assertThat(machine.display()).isEqualTo("0.20")
        assertThat(machine.coinReturn()).isEmpty()
    }

    @Test
    fun `Insert Nickel and Fake Dime`() {
        val fakeDime = Coin("2.268 g", "17.9 mm")
        val machine = VendingMachine()
            .insert(fakeDime)
            .insert(nickel())

        assertThat(machine.display()).isEqualTo("0.05")
        assertThat(machine.coinReturn()).containsExactly(fakeDime)
    }
}