class TaxCalculator {

  // Tax bands (simplified to make testing a bit easier)
  private val personalAllowance: Int = 12570
  private val basicRateLimit: Int = 50270
  private val higherRateLimit: Int = 125140

  // Tax rates
  private val personalAllowanceRate: Double = 0
  private val basicRate: Double = 0.2
  private val higherRate: Double = 0.4
  private val additionalRate: Double = 0.45

  // A method to calculate the total amount of tax to be paid, returned as a double
  def calculateTax(income: Double): Double = {
    if (income <= personalAllowance) {
      income * personalAllowanceRate
    } else if (income > personalAllowance && income <= basicRateLimit) {
      (income - personalAllowance) * basicRate
    } else if (income > basicRateLimit && income <= higherRateLimit) {
      (personalAllowance * personalAllowanceRate) + ((basicRateLimit - personalAllowance) * basicRate) + ((income - basicRateLimit) * higherRate)
    } else if ( income > higherRateLimit) {
      (basicRateLimit * basicRate) + ((higherRateLimit - basicRateLimit) * higherRate) + ((income - higherRateLimit) * additionalRate)
    } else {
      0.0
    }

  }

  // A method which can tell you if someone is a higher rate taxpayer
  def isHigherRateTaxpayer(income: Double): Boolean = {
    if (income > higherRateLimit ) {
      true
    } else {
      false
    }
  }

  // A method that will return a string with the income limit of their current tax band.
  // The return will also be formatted, E.g: "£12,500" or "No limit"
  def formattedCurrentTaxAllowance(income: Double): String = {
    if (income <= personalAllowance) {
      s"£$personalAllowance"
    } else if (income > personalAllowance && income <= basicRateLimit) {
      s"£$basicRateLimit"
    } else if ( income > basicRateLimit && income <= higherRateLimit) {
      s"£$higherRateLimit"
    } else {
      "No limit"
    }
  }

}
