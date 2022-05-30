package lotto.application.vo

private const val LOTTO_PRICE = 1000

data class Purchase private constructor(
    val amount: Amount,
    val purchaseCounts: PurchaseCounts
) {
    companion object {
        fun create(
            amount: Long,
            manualLottoCount: Int
        ): Purchase {
            require(manualLottoCount * LOTTO_PRICE <= amount) { "수동 로또 갯수가 구입 금액보다 클수 없습니다." }

            val autoLottoCount: Int = ((amount - manualLottoCount * LOTTO_PRICE) / LOTTO_PRICE).toInt()
            val purchaseCounts = PurchaseCounts(PurchaseCount(autoLottoCount), PurchaseCount(manualLottoCount))
            val amount = Amount(amount)

            return Purchase(amount, purchaseCounts)
        }
    }
}
