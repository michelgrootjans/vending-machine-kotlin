import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.forAll
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

//MAKE CHANGE
//As a vendor
//I want customers to receive correct change
//So that they will use the vending machine again
//
//When a product is selected that costs less than the amount of money in the machine,
// then the remaining amount is placed in the coin return.
class MakeChange : StringSpec({
    "No change for normal sale"{
        val machine = VendingMachine()
                .insert(quarter())
                .insert(quarter())
                .insert(quarter())
                .insert(quarter())
                .pressButton1()

        machine.coinReturn().shouldBeEmpty()
    }
    "one quarter returned"{
        val machine = VendingMachine()
                .insert(quarter())
                .insert(quarter())
                .insert(quarter())
                .insert(quarter())
                .insert(quarter())
                .pressButton1()

        machine.coinReturn().shouldContain(quarter())
    }
})

class CalculateChange : StringSpec({
    "no change expected" {
        table(
                headers("coins", "price"),
                row(listOf(quarter()), 0.25),
                row(listOf(dime()), 0.10),
                row(listOf(nickel()), 0.05),
                row(listOf(dime(), dime()), 0.20)
        ).forAll{coins, price -> Balance().add(coins).changeFor(price).shouldBeEmpty()}
    }

    "change expected" {
        table(
                headers("coins", "price", "change"),
                row(listOf(quarter()), 0.00, listOf(quarter())),
                row(listOf(dime()), 0.00, listOf(dime()))
        ).forAll{coins, price, change -> Balance().add(coins).changeFor(price).shouldContainAll(change)}
    }
})
