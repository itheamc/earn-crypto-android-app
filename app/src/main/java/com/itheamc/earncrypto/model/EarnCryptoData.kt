package com.itheamc.earncrypto.model

data class CryptoApp(val id: Int, val name: String, val tagLine: String, val coin: String, val dailyEarning: Double, val desc: String, val iconUrl: String, val linkUrl: String, val views: Int, val isActive: Boolean = true)

data class CryptoGame(val id: Int, val name: String, val tagLine: String, val coin: String, val dailyEarning: Double, val desc: String, val iconUrl: String, val linkUrl: String, val views: Int, val isActive: Boolean = true)

data class CryptoWebsite(val id: Int, val name: String, val tagLine: String, val coin: String, val dailyEarning: Double, val desc: String, val iconUrl: String, val linkUrl: String, val views: Int, val isActive: Boolean = true)

data class CryptoAirdrop(val id: Int, val name: String, val tagLine: String, val coin: String, val dailyEarning: Double, val desc: String, val iconUrl: String, val linkUrl: String, val views: Int, val isActive: Boolean = true)