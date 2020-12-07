import com.adthena.shoppingbasket.types.Basket.buildBasketFromInput
import com.adthena.shoppingbasket.types.{Basket, ItemPrice, ItemWithOffer, Offer}
import com.adthena.shoppingbasket.utils.IOUtils.{getItemPriceList, getItemWithOfferList}



val priceList = getItemPriceList

val offerList = getItemWithOfferList

val items = Array("Apple", "Apple", "Bread")

val basket = buildBasketFromInput(items)



def getPricedBasketItems(basket: Basket, prices: List[ItemPrice], offers: List[Offer]): List[ItemWithOffer] = {
  for {
    item <- basket.items
    price <- prices
    offer <- offers
    if item.itemName.equals(offer.itemName)
  } yield ItemWithOffer(item.itemName, price.price, item.quantity, Some(offer))
}

