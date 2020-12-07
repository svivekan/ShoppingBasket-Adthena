case class Offer(offerName: String, offerQuantity: Int, discount: Double)

case class ItemWithOffer(itemName: String, itemPrice: Double, itemQuantity: Int, offer: Option[Offer])

case class OfferDisplay(offerName: String, discount: Double) {
  override def toString = s"$offerName: " + discount
}

val appleOffer = Offer("apple-offer", 1, 0.9)
val orangeOffer = Offer("orange-offer", 2, 1.5)

val apple = ItemWithOffer("apple", 1.0, 2, Some(appleOffer))
val orange = ItemWithOffer("orange", 2.0, 6, Some(orangeOffer))
val melon = ItemWithOffer("melon", 2.0, 5, None)

def getTotalDiscountPerItem(item: ItemWithOffer): Double = {
  val offerQty = item.offer.map(p =>p.offerQuantity).getOrElse(0)
  val offerDiscount = item.offer.map(p =>p.discount).getOrElse(0.0)

  if(offerQty == 0) return 0.0

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

val itemsList = List(apple, orange, melon)

val discounts = getTotalAmountAfterDiscount(itemsList)

val totalAmtAfterDiscount = getTotalAmountAfterDiscount(itemsList).sum


def getCurrentOffers(items: List[ItemWithOffer]): List[OfferDisplay] = {
  for {
    item <- items
    offer <- item.offer
  } yield OfferDisplay(offer.offerName, ((item.itemQuantity * item.itemPrice) - getTotalDiscountPerItem(item)))
//  } yield OfferDisplay(offer.offerName, ((item.itemQuantity * item.itemPrice)))
}

getCurrentOffers(itemsList)