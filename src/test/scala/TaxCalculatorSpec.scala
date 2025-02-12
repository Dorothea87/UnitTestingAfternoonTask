import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
//1.Now you have an MVP branch, spend time having a look through the repository and see what you have been given.
//2. Use TDD methodology. Write failing tests around the placeholder methods created.
//3. Run the tests, making sure they fail. (To run the tests, you can use the green play button in your Spec, or in terminal, run ‘sbt test’.)

class TaxCalculatorSpec extends AnyWordSpec {

  val taxCalculator: TaxCalculator = new TaxCalculator

  // I've done the first test for you!
  "TaxCalculator.calculateTax" should {
    "return the total amount of tax to pay" when {
      "the income is below the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(5000)

        assert(result == 0)
      }
    }
    "return the total amount of tax to pay" when {
      "the income is exactly on the personal tax limit" in {
        val result: Double = taxCalculator.calculateTax(10000)

        assert(result == 0)
      }
    }
  }
}
