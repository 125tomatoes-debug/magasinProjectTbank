class FixetDiscount: Discount {
    public override fun calculate(amount: Int, total:Int): Int {
        if(amount >= total) {
            return amount - total
        }else{
            return 0
        }
    }
}