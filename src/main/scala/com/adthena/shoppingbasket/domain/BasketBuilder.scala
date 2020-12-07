package com.adthena.shoppingbasket.domain

import com.adthena.shoppingbasket.types._

object BasketBuilder {

  def getPricedBasketItems(basket: Basket, prices: List[ItemPrice]): List[PricedBasketItem] = {
    for {
      item <- basket.items
      price <- prices
      if item.itemName.equals(price.itemName)
    } yield PricedBasketItem(item, item.quantity * price.price)
  }

  def checkoutBasket(items: List[PricedBasketItem]): PricedBasket = {
    PricedBasket(items, items.foldLeft(0.0)(_ + _.totalPrice))
  }

  def checkoutFinalTotal(offers: List[OfferDisplay], basket: PricedBasket): Double = {
    basket.total - offers.foldLeft(0.0)(_ + _.discount)
  }

}
