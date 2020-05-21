import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

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
class AcceptCoins : StringSpec({
    "At rest" {
        val machine = VendingMachine()

        machine.display() shouldBe "INSERT COIN"
        machine.coinReject().shouldBeEmpty()
    }
    "Insert Cent" {
        val machine = VendingMachine()
                .insert(cent())

        machine.display() shouldBe "INSERT COIN"
        machine.coinReject().shouldContainAll(cent())
    }
    "Insert Nickel" {
        val machine = VendingMachine()
                .insert(nickel())

        machine.display() shouldBe "0.05"
        machine.coinReject().shouldBeEmpty()
    }
    "Insert Dime" {
        val machine = VendingMachine()
                .insert(dime())
        machine.display() shouldBe "0.10"
        machine.coinReject().shouldBeEmpty()
    }
    "Insert Quarter" {
        val machine = VendingMachine()
                .insert(quarter())
        machine.display() shouldBe "0.25"
        machine.coinReject().shouldBeEmpty()
    }
    "Insert Fake Dime with different weight" {
        val fakeDime = Coin("2.260 g", "17.91 mm")
        val machine = VendingMachine()
                .insert(fakeDime)

        machine.display() shouldBe "INSERT COIN"
        machine.coinReject().shouldContainAll(fakeDime)
    }
    "Insert Fake Dime with different dimension" {
        val fakeDime = Coin("2.268 g", "17.9 mm")
        val machine = VendingMachine()
                .insert(fakeDime)

        machine.display() shouldBe "INSERT COIN"
        machine.coinReject().shouldContainAll(fakeDime)
    }
    "Insert Nickel twice" {
        val machine = VendingMachine()
                .insert(nickel())
                .insert(nickel())

        machine.display() shouldBe "0.10"
        machine.coinReject().shouldBeEmpty()
    }
    "Insert Dime twice" {
        val machine = VendingMachine()
                .insert(dime())
                .insert(dime())

        machine.display() shouldBe "0.20"
        machine.coinReject().shouldBeEmpty()
    }
    "Insert Nickel and Fake Dime" {
        val fakeDime = Coin("2.268 g", "17.9 mm")
        val machine = VendingMachine()
                .insert(fakeDime)
                .insert(nickel())

        machine.display() shouldBe "0.05"
        machine.coinReject().shouldContainAll(fakeDime)
    }
})

