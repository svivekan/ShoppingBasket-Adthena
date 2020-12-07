package com.adthena.shoppingbasket.domain

import com.adthena.shoppingbasket.types._

object OfferBuilder {

  def getItemsWithOffers(basket: Basket, prices: List[ItemPrice], offers: List[Offer]): List[ItemWithOffer] = {
    for {
      item <- basket.items
      offer <- offers if offer.itemName.equals(item.itemName)
      price <- prices if price.itemName.equals(offer.itemName)
    } yield ItemWithOffer(item.itemName, price.price, item.quantity, Some(offer))
  }

  def getTotalDiscountPerItem(item: ItemWithOffer): Double = {
    val offerQty = item.offer.map(p => p.offerQuantity).getOrElse(0)
    val offerDiscount = item.offer.map(p => p.discount).getOrElse(0.0)

    if (offerQty == 0) return 0.0

    if (item.itemQuantity % offerQty == 0) (item.itemQuantity / offerQty) * offerDiscount
    else {
      item.itemQuantity * item.itemPrice
    }
  }

  def getTotalAmountAfterDiscount(items: List[ItemWithOffer]): List[Double] = {
    for {
      item <- items
    } yield getTotalDiscountPerItem(item)

  }

  def getCurrentOffers(items: List[ItemWithOffer]): List[OfferDisplay] = {
    for {
      item <- items
      offer <- item.offer
    } yield OfferDisplay(offer.offerName, ((item.itemQuantity * item.itemPrice) - getTotalDiscountPerItem(item)))
  }

}
