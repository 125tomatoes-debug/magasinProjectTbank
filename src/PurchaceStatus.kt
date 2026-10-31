sealed class PurchaceStatus {
    object Success : PurchaceStatus()
    object EmptyCart : PurchaceStatus()
    object NotEmptyCart : PurchaceStatus()
    object NotEnoughStock : PurchaceStatus()
    object NotEnoughMoney : PurchaceStatus()
    object InvalidPromoCode : PurchaceStatus()
    object ValidPromoCode : PurchaceStatus()
}