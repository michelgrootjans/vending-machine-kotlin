import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.specs.StringSpec

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
    "no change for 0"{
        Balance().changeFor(0.00).shouldBeEmpty()
    }
    "change for a quqrter"{
        Balance(listOf(quarter())).changeFor(0.00).shouldContain(quarter())
    }
})
