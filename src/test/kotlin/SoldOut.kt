import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class SoldOut : StringSpec({
  "first test"{
      val machine = VendingMachine()
      machine.display() shouldBe "INSERT COIN"
  }
})