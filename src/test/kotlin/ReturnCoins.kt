import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.specs.StringSpec

//RETURN COINS
//As a customer
//I want to have my money returned
//So that I can change my mind about buying stuff from the vending machine
//
//When the return coins button is pressed, the money the customer has placed
//in the machine is returned and the display shows INSERT COIN.
class ReturnCoins : StringSpec({
    "No coin inserted"{
        val machine = VendingMachine()
                .pressCoinReturn();

        machine.coinReturn().shouldBeEmpty()
    }
    "Insert quarter"{
        val machine = VendingMachine()
                .insert(quarter())
                .pressCoinReturn();

        machine.coinReturn().shouldContainAll(quarter())
    }
    "Insert 1 dollar"{
        val machine = VendingMachine()
            .insert(quarter())
            .insert(dime())
            .insert(dime())
            .insert(quarter())
            .insert(dime())
            .insert(dime())
            .insert(dime())
            .pressCoinReturn();

        machine.coinReturn().shouldContainAll(quarter(), dime(), dime(), quarter(), dime(), dime(), dime())
    }
})