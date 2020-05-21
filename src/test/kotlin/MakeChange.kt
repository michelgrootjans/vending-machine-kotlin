import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

//MAKE CHANGE
//As a vendor
//I want customers to receive correct change
//So that they will use the vending machine again
//
//When a product is selected that costs less than the amount of
//money in the machine, then the remaining amount is placed in the coin return.

class MakeChange : StringSpec({
    "No change for normal sale"{
        val machine = VendingMachine()
                .insert(quarter())
                .insert(quarter())
                .insert(quarter())
                .insert(quarter())
                .pressButton1()

        machine.coinReject().shouldBeEmpty()
    }
})
