package com.example.cryptoapp.model

data class CryptoValue(
    val all_transactions: List<AllTransaction>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)