import com.adthena.shoppingbasket.types.Basket.buildBasketFromInput
import com.adthena.shoppingbasket.types.{Basket, ItemPrice, ItemWithOffer, Offer, PricedBasketItem}
import com.adthena.shoppingbasket.utils.IOUtils.{getItemPriceList, getItemWithOfferList}

def getPricedBasketItems(basket: Basket, prices: List[ItemPrice]): List[PricedBasketItem] = {
  for {
    item <- basket.items
    price <- prices
    if item.itemName.equals(price.itemName)
  } yield PricedBasketItem(item, item.quantity * price.price)
}

val priceList = getItemPriceList

val offerList = getItemWithOfferList

val items = Array("Apple", "Apple", "Soup", "Soup", "Bread")

val basket = buildBasketFromInput(items)

getPricedBasketItems(basket, priceList)

def getItemsWithOffers(basket: Basket, prices: List[ItemPrice], offers: List[Offer]): List[String] = {
  for {
    item <- basket.items
    offer <- offers if (offer.itemName != item.itemName)
//    price <- prices if (price.itemName != offer.itemName)
  } yield item.itemName
}

getItemsWithOffers(basket, priceList, offerList)

val hello = "Hello1"
val hello1 = "Hello1"

hello == hello1