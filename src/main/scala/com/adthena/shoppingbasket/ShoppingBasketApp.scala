package com.adthena.shoppingbasket

import com.adthena.shoppingbasket.domain.BasketBuilder.{checkoutBasket, checkoutFinalTotal, getPricedBasketItems}
import com.adthena.shoppingbasket.domain.OfferBuilder.{getCurrentOffers, getItemsWithOffers}
import com.adthena.shoppingbasket.types.Basket.buildBasketFromInput
import com.adthena.shoppingbasket.types._
import com.adthena.shoppingbasket.utils.IOUtils.{getItemPriceList, getItemWithOfferList}


object ShoppingBasketApp extends App {

  val priceList = getItemPriceList

  val offerList = getItemWithOfferList

  val basket = buildBasketFromInput(args)

  val basketList: List[PricedBasketItem] = getPricedBasketItems(basket, priceList)

  val basketWithItems = checkoutBasket(basketList)

  Console.println(basketWithItems)

  val itemsWithOffers = getItemsWithOffers(basket, priceList, offerList)

  val currentOffers = getCurrentOffers(itemsWithOffers)

  Console.println("Offers: " + currentOffers)

  Console.println("Total Price: " + checkoutFinalTotal(currentOffers, basketWithItems))

}

