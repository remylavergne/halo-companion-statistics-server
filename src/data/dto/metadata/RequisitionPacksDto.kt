package dev.remylavergne.halo.data.dto.metadata

data class RequisitionPacksDto(
    val name: String,
    val description: String,
    val largeImageUrlval: String?,
    val isStack: Boolean,
    val isFeatured: Boolean,
    val isNew: Boolean,
    val creditPrice: Int,
    val isPurchasableWithCredits: Boolean,
    val isPurchasableFromMarketplace: Boolean,
    val xboxMarketplaceProductId: String?,
    val xboxMarketplaceProductUrl: String?,
    val merchandisingOrder: Int,
    val flair: String?,
    val isGiftOnly: Boolean,
    val giftableAcquisitionMethods: Int,
    val id: String,
    val contentId: String
)