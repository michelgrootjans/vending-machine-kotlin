package vendingmachine

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SelectProduct : StringSpec({
    "Buy a cola" {
        val machine = VendingMachine()
            .pressButton1()

        machine.display() shouldBe "THANK YOU"
        machine.dispenser().shouldContainAll("cola")
    }
    "Buy chips" {
        val machine = VendingMachine()
            .pressButton2()

        machine.display() shouldBe "THANK YOU"
        machine.dispenser().shouldContainAll("chips")
    }
    "Buy candy" {
        val machine = VendingMachine()
            .pressButton3()

        machine.display() shouldBe "THANK YOU"
        machine.dispenser().shouldContainAll("candy")
    }
})
