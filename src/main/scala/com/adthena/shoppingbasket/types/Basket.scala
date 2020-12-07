package com.adthena.shoppingbasket.types

case class Basket(items: List[BasketItem])

object Basket {
  def buildBasketFromInput(inputArgs: Array[String]): Basket = {
    new Basket(inputArgs
      .groupBy(x => x)
      .mapValues[BasketItem](x => BasketItem(x.head, x.length))
      .values.toList
    )
  }
}

case class BasketItem(itemName: String, quantity: Int)

case class ItemPrice(itemName: String, price: Double)

case class PricedBasketItem(item: BasketItem, totalPrice: Double)

case class PricedBasket(items: List[PricedBasketItem], total: Double) {
  override def toString = "Subtotal: " + total
}

