package com.adthena.shoppingbasket.types

case class Offer(itemName: String, offerName: String, offerQuantity: Int, discount: Double)

case class ItemWithOffer(itemName: String, itemPrice: Double, itemQuantity: Int, offer: Option[Offer])

case class OfferDisplay(offerName: String, discount: Double) {
  override def toString = s"$offerName " + discount
}


