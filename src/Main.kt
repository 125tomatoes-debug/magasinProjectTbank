

val magasin:Magasin = Magasin()

fun addToBusket(customer: Customer){
    println("выберите товары из ассортимента:")
    magasin.showinfo()
    var choice:Int = readln().toInt()
    println("выберите количество (1-10)")
    var amount:Int = readln().toInt()
    when(choice) {
        1->customer.addToBasket(ProductType.IRON_SWORD, amount)
        2->customer.addToBasket(ProductType.HEALTH_POTION, amount)
        3->customer.addToBasket(ProductType.WOODEN_SHIELD, amount)
        else ->println("некоректный ввод")
    }
}


fun remooveFromBusket(customer: Customer){
    println("выберите товары из ассортимента:")
    magasin.showinfo()
    var choice:Int = readln().toInt()
    println("выберите количество (1-10)")
    var amount:Int = readln().toInt()
    when(choice) {
        1->customer.removeFromBasket(ProductType.IRON_SWORD, amount)
        2->customer.removeFromBasket(ProductType.HEALTH_POTION, amount)
        3->customer.removeFromBasket(ProductType.WOODEN_SHIELD, amount)
        else ->println("некоректный ввод")
    }
}

fun confermPerchase(customer: Customer){
    when(magasin.confermPerchase(customer)){
        PurchaceStatus.Success -> println("покупка прошла успешно")
        PurchaceStatus.NotEnoughMoney -> println("недостаточно деняк")
        PurchaceStatus.EmptyCart -> print("")
        PurchaceStatus.NotEnoughStock -> println("товара нет в наличии")
        else -> println("неизвестная ошибка")
    }
}


fun enterPromo(customer: Customer){
    println("Ведите промокод")
    val promo:String = readln()
    if(customer.activatePromocode(promo) is PurchaceStatus.InvalidPromoCode){
        println("Такого промокода нет")
    }
}

fun main() {

    println("введите имя покупателя")
    val nameOfBuyer: String = readln()
    println("является ли ваш покупатель постоянным?"+'\n'+ "1 - Да"+ '\n' + "2 - Нет")
    val ConstB:Int = readln().toInt()
    var isConstB:Boolean = false
    if(ConstB == 1){
        isConstB = true
    }
    val customer:Customer = Customer(nameOfBuyer, isConstB)
    var exitShop = false
    while(!exitShop) {
        println("=== ADVENTURE SHOP ===\n" +
                "\n" +
                "Покупатель: ${customer.getName()}\n" +
                "Баланс: ${customer.getBallance()} монет\n" +
                "\n" +
                "1. Посмотреть товары\n" +
                "2. Добавить товар в корзину\n" +
                "3. Удалить товар из корзины\n" +
                "4. Посмотреть корзину\n" +
                "5. Оформить покупку\n" +
                "6. Посмотреть баланс\n" +
                "7. Ввести промокод\n" +
                "0. Выход\n" +
                "\n" +
                "Выберите действие:")
        var choice:Int = readln().toInt() % 8
        when(choice) {
            1 -> magasin.showinfo()
            2 -> addToBusket(customer)
            3 -> remooveFromBusket(customer)
            4 -> customer.showBusket()
            5 -> confermPerchase(customer)
            6 -> println("Баланс: ${customer.getBallance()} монет (указано выше)")
            7 ->enterPromo(customer)
            0 -> exitShop = true
        }

    }

}