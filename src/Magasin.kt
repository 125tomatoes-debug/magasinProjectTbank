class Magasin {
    private var sotckOfSwords = 3
    private var stockOfPoitions = 5
    private var stockOfShields = 2

    public fun confermPerchase(customer: Customer): PurchaceStatus{
        if(sotckOfSwords >= customer.getBasket().get_iron_swords_amount() && stockOfShields >= customer.getBasket().get_wooden_shield_ammount() && stockOfPoitions >= customer.getBasket().get_potion_ammount()) {
            if(customer.canAffordBasket()) {
                sotckOfSwords -= customer.getBasket().get_iron_swords_amount()
                stockOfShields -= customer.getBasket().get_wooden_shield_ammount()
                stockOfPoitions -= customer.getBasket().get_potion_ammount()
                if(customer.buyBasket() is PurchaceStatus.EmptyCart){
                    println("Невозможно купить пустую корзину")
                    return PurchaceStatus.EmptyCart
                }else {
                    return PurchaceStatus.Success
                }
            }else{
                return PurchaceStatus.NotEnoughMoney
            }
        }else{
            return PurchaceStatus.NotEnoughStock
        }
    }

    public fun showinfo(){
        println("ассортимент: ${'\n'}1) железные мечи - X$sotckOfSwords ${'\n'}2) лечебные зелья - X$stockOfPoitions ${'\n'}3) деревяные щиты - X$stockOfShields")
    }
}