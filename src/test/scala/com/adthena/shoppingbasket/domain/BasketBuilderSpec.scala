package com.adthena.shoppingbasket.domain

import com.adthena.shoppingbasket.domain.BasketBuilder.{checkoutBasket, checkoutFinalTotal, getPricedBasketItems}
import com.adthena.shoppingbasket.domain.OfferBuilder.{getCurrentOffers, getItemsWithOffers}
import com.adthena.shoppingbasket.types.Basket.buildBasketFromInput
import com.adthena.shoppingbasket.types.{ItemPrice, Offer, PricedBasketItem}
import com.adthena.shoppingbasket.utils.IOUtils.{getItemPriceList, getItemWithOfferList}
import org.scalatest.{Matchers, WordSpecLike}

class BasketBuilderSpec extends WordSpecLike with Matchers {

  val priceList: List[ItemPrice] = getItemPriceList

  val offerList: List[Offer] = getItemWithOfferList

  "checkoutFinalTotal" should {

    "return Zero when Basket is Empty" in {
      val basket = buildBasketFromInput(Array[String]())
      val basketList: List[PricedBasketItem] = getPricedBasketItems(basket, priceList)
      val checkedBasket = checkoutBasket(basketList)
      val itemsWithOffers = getItemsWithOffers(basket, priceList, offerList)
      val currentOffers = getCurrentOffers(itemsWithOffers)
      assert(checkoutFinalTotal(currentOffers, checkedBasket) == 0)
    }

    "correctly price 2 Apples" in {
      val basket = buildBasketFromInput(Array("Apple", "Apple"))
      val basketList: List[PricedBasketItem] = getPricedBasketItems(basket, priceList)
      val checkedBasket = checkoutBasket(basketList)
      val itemsWithOffers = getItemsWithOffers(basket, priceList, offerList)
      val currentOffers = getCurrentOffers(itemsWithOffers)
      assert(checkoutFinalTotal(currentOffers, checkedBasket) == 1.8)
    }

    "correctly price 2 Apples, Milk" in {
      val basket = buildBasketFromInput(Array("Apple", "Apple", "Milk"))
      val basketList: List[PricedBasketItem] = getPricedBasketItems(basket, priceList)
      val checkedBasket = checkoutBasket(basketList)
      val itemsWithOffers = getItemsWithOffers(basket, priceList, offerList)
      val currentOffers = getCurrentOffers(itemsWithOffers)
      assert(checkoutFinalTotal(currentOffers, checkedBasket) == 3.0999999999999996)
    }

    "correctly price 2 Apples, Soup" in {
      val basket = buildBasketFromInput(Array("Apple", "Apple", "Soup"))
      val basketList: List[PricedBasketItem] = getPricedBasketItems(basket, priceList)
      val checkedBasket = checkoutBasket(basketList)
      val itemsWithOffers = getItemsWithOffers(basket, priceList, offerList)
      val currentOffers = getCurrentOffers(itemsWithOffers)
      assert(checkoutFinalTotal(currentOffers, checkedBasket) == 2.45)
    }

    "correctly price 2 Apples, 2 Soup" in {
      val basket = buildBasketFromInput(Array("Apple", "Apple", "Soup", "Soup"))
      val basketList: List[PricedBasketItem] = getPricedBasketItems(basket, priceList)
      val checkedBasket = checkoutBasket(basketList)
      val itemsWithOffers = getItemsWithOffers(basket, priceList, offerList)
      val currentOffers = getCurrentOffers(itemsWithOffers)
      assert(checkoutFinalTotal(currentOffers, checkedBasket) == 2.6999999999999997)
    }


  }

}
