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

val items = Array("Apple", "Apple", "Soup", "Soup")

val basket = buildBasketFromInput(items)

getPricedBasketItems(basket, priceList)

def getPricedBasketItemsX(basket: Basket, prices: List[ItemPrice], offers: List[Offer]): List[ItemWithOffer] = {

  for {
    item <- basket.items
    price <- prices
    offer <- offers if offer.itemName.equals(item.itemName)
  } yield ItemWithOffer(item.itemName, price.price, item.quantity, Some(offer))
}

getPricedBasketItemsX(basket, priceList, offerList)