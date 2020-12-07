import com.adthena.shoppingbasket.types.Basket.buildBasketFromInput
import com.adthena.shoppingbasket.types.{Basket, ItemPrice, ItemWithOffer, Offer}
import com.adthena.shoppingbasket.utils.IOUtils.{getItemPriceList, getItemWithOfferList}


val priceList = getItemPriceList

val offerList = getItemWithOfferList

val items = Array("Apple", "Apple", "Soup")

val basket = buildBasketFromInput(items)

//case class BasketItem(itemName: String, quantity: Int)
//case class ItemPrice(itemName: String, price: Double)
//case class Offer(itemName: String, offerName: String, offerQuantity: Int, discount: Double)
//case class ItemWithOffer(itemName: String, itemPrice: Double, itemQuantity: Int, offer: Option[Offer])



def getPricedBasketItemsX(basket: Basket, prices: List[ItemPrice], offers: List[Offer]): List[ItemWithOffer] = {
  for {
    item <- basket.items
    price <- prices
    offer <- offers
    if (item.itemName).equals(offer.itemName)
  } yield ItemWithOffer(item.itemName, price.price, item.quantity, Some(offer))
}


getPricedBasketItemsX(basket, priceList, offerList)

