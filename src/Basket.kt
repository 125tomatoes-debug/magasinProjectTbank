class Basket {

    private var iron_swords_amount: Int = 0
    public fun get_iron_swords_amount():Int {return iron_swords_amount}
    private var potion_ammount: Int = 0
    public fun get_potion_ammount():Int {return potion_ammount}
    private var wooden_shield_ammount: Int = 0
    public fun get_wooden_shield_ammount():Int {return wooden_shield_ammount}

    public fun addProduct(product: ProductType, size: Int) {
        if(size in 1..10) {
            when (product) {
                ProductType.IRON_SWORD ->if(iron_swords_amount + size in 1..10){ iron_swords_amount += size}
                ProductType.HEALTH_POTION -> if(potion_ammount + size in 1..10){potion_ammount += size}
                ProductType.WOODEN_SHIELD -> if(potion_ammount + size in 1..10){wooden_shield_ammount += size}
            }
        }
    }

    public fun deleteProduct(product: ProductType, size: Int) {
        if(size in 1..10) {
            when (product) {
                ProductType.IRON_SWORD -> if (iron_swords_amount >= size) {
                    iron_swords_amount -= size
                }

                ProductType.HEALTH_POTION -> if (potion_ammount >= size) {
                    potion_ammount -= size
                }

                ProductType.WOODEN_SHIELD -> if (wooden_shield_ammount >= size) {
                    wooden_shield_ammount -= size
                }
            }
        }
    }

    public fun showinfo(){
        println("=== КОРЗИНА ===\n" +
                "\n" +
                "Железный меч      x$iron_swords_amount - ${ProductType.IRON_SWORD.prise * iron_swords_amount}\n" +
                "Зелье здоровья    x$potion_ammount - ${ProductType.HEALTH_POTION.prise * potion_ammount}\n" +
                "Деревянный щит    x$wooden_shield_ammount - ${ProductType.WOODEN_SHIELD.prise * wooden_shield_ammount}\n" +
                "\n" +
                "Итого без скидок: ${ProductType.IRON_SWORD.prise * iron_swords_amount + ProductType.HEALTH_POTION.prise * potion_ammount + ProductType.WOODEN_SHIELD.prise * wooden_shield_ammount}")
    }

    public fun getTotalCost():Int{
        return ProductType.IRON_SWORD.prise * iron_swords_amount + ProductType.HEALTH_POTION.prise * potion_ammount + ProductType.WOODEN_SHIELD.prise * wooden_shield_ammount
    }

    public fun deleteAllItems(){
        iron_swords_amount = 0
        potion_ammount = 0
        wooden_shield_ammount = 0
    }

    public fun isEmpty():Boolean{
        return iron_swords_amount == 0 && potion_ammount==0 && wooden_shield_ammount==0
    }
}