class PersentageDiscount: Discount {
    public override fun calculate(amount: Int, total:Int): Int {
        if(total <= 100) {
            return amount - amount * total / 100
        }else{
            return 0
        }
    }
}