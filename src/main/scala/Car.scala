class Car {
  var topClassExtraCost = 0
  private var roadTax = 100

  def cost(basicCost:Int)= basicCost + topClassExtraCost + roadTax

  def checkTax()={
    roadTax = 10 // Unintentional. Done by Mistake
    roadTax
  }

  def printTax = roadTax

}
