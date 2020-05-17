package vendingmachine

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SelectProduct : StringSpec({
    "Buy a cola" {
        val machine = VendingMachine()
            .insert(quarter())
            .insert(quarter())
            .insert(quarter())
            .insert(quarter())
            .pressButton()

        machine.display() shouldBe "THANK YOU"
        machine.dispenser().shouldContainAll("cola")
    }
})
