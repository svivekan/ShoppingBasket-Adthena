package com.adthena.shoppingbasket.utils

import com.adthena.shoppingbasket.types.{ItemPrice, Offer}

object IOUtils {

  def getItemPriceList: List[ItemPrice] = {

    val soupPrice = ItemPrice("Soup", 0.65)
    val breadPrice = ItemPrice("Bread", 0.80)
    val milkPrice = ItemPrice("Milk", 1.30)
    val applePrice = ItemPrice("Apple", 1.00)

    List(soupPrice, breadPrice, milkPrice, applePrice)
  }

  def getItemWithOfferList: List[Offer] = {

    val appleOffer = Offer("Apple", "Apples 10% off:", 1, 0.9)
    val soupOffer = Offer("Soup", "Buy 2 tins of soup and get a loaf of bread for half price:", 2, 0.9)

    List(appleOffer, soupOffer)
  }


}
