class Customer(private val name: String, private  val isConstantBuyer: Boolean) {
    private var balance:Int = 1000
    private val basket:Basket = Basket()
    private var presentageDiscount:Int = 0
    private var numinalDiscount:Int = 0
    private val prds: PersentageDiscount = PersentageDiscount()
    private val cnstds: FixetDiscount = FixetDiscount()

    init{
        if(isConstantBuyer){
            presentageDiscount = 10
        }
    }

    public fun getName():String = name
    public fun getBallance():Int = balance


    public fun activatePromocode(promocode:String):PurchaceStatus{
        if(promocode == "June20"){
            presentageDiscount += 20
            return PurchaceStatus.ValidPromoCode
        }
        if(promocode == "september50"){
            numinalDiscount += 50
            return PurchaceStatus.ValidPromoCode
        }
        return PurchaceStatus.InvalidPromoCode
    }

    public fun getBasket():Basket {return basket}

    public fun canAffordBasket():Boolean = basket.getTotalCost() - prds.calculate(basket.getTotalCost(), presentageDiscount) - cnstds.calculate(basket.getTotalCost(), numinalDiscount) <= balance

    public fun addToBasket(productType: ProductType, amount:Int) {
        basket.addProduct(productType, amount)
    }

    public fun removeFromBasket(productType: ProductType, amount:Int) {
        basket.deleteProduct(productType, amount)
    }

    public fun showBusket(){
        basket.showinfo()
    }

    public fun buyBasket(): PurchaceStatus{
        if(!basket.isEmpty()) {
            balance += (basket.getTotalCost() - prds.calculate(
                basket.getTotalCost(),
                presentageDiscount
            ) - cnstds.calculate(basket.getTotalCost(), numinalDiscount))
            basket.deleteAllItems()
            return PurchaceStatus.NotEmptyCart
        }else{
            return PurchaceStatus.EmptyCart
        }
    }
}