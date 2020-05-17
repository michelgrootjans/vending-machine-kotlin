package vendingmachine

import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

//SELECT A PRODUCT
//As a vendor
//I want customers to select products
//So that I can give them an incentive to put money in the machine
//
//There are three products: cola for $1.00, chips for $0.50, and
//candy for $0.65. When the respective button is pressed
//and enough money has been inserted, the product is dispensed
//and the machine displays THANK YOU.
//If the display is checked again, it will display INSERT COIN
//and the current amount will be set to $0.00.
//If there is not enough money inserted then the machine displays PRICE
//and the price of the item and subsequent checks of the
//display will display either INSERT COIN or the current amount as appropriate.
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

    // TODO: product pricing
})
