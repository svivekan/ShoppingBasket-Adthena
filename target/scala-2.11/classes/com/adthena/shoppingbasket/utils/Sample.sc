case class Offer(itemName: String, discount: Double)
case class Item(itemName: String)
case class ItemWithOffer(itemName: String, offer: Option[Double])

val apple = Item("apple")
val orange = Item("orange")
val melon = Item("melon")

val items = List(apple, orange, melon)

val appleOffer = Offer("apple", 10)
val orangeOffer = Offer("orange", 10)

val offers = List(appleOffer, orangeOffer)

for {
  item <- items
  offer <- offers
  if item.itemName.exists(offer.itemName)
}