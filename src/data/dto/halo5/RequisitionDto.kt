package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

// TODO => Map enum
@JsonClass(generateAdapter = true)
data class RequisitionDto(
    /**
     * This lists all the game modes that this requisition is redeemable in. Options are:
     *   - Arena
     *   - Campaign
     *   - Custom
     *   - Warzone
     */
    val supportedGameModes: List<String>,

    /** A localized name, suitable for display to users. The text is title cased. */
    val name: String?,

    /** A localized description, suitable for display to users. */
    val description: String?,

    /**
     * The non-localized rarity. Indicates the scarcity and thus rarity of the
     * requisition. The options are (in increasing order of rarity):
     *   - Common
     *   - Uncommon
     *   - Rare
     *   - UltraRare
     *   - Legendary
     */
    val rarityType: String,

    /**
     * The localized rarity suitable for display to users. Indicates the scarcity and
     * thus rarity of the requisition
     */
    val rarity: String,

    /** Indicates if this requisition has been flagged as having 'mythic status'. */
    val isMythic: Boolean,

    /**
     * Indicates if this item is a Certification. Certifications will always be durable
     * and are required to earn certain other requisitions.
     */
    val isCertification: Boolean,

    /** Indicates whether the requisition is wearable. */
    val isWearable: Boolean,

    /**
     * Indicates if the requisition counts towards collection completion. If true, this
     * requisition will not be shown as unearned in the game.
     * This behavior is typically used for specialty requisitions that aren't awarded
     * through normal progression flows.
     */
    val hideIfNotAcquired: Boolean,

    /**
     * Indicates how the requisition card may be used. Options are:
     *   - Consumable
     *   - Durable
     *   - Boost
     *   - CreditGranting
     * Consumable: The requisition can be called in and used while in -game. When players
     * call in a consumable requisition it is removed from the players inventory.
     * Durable: The requisition is not usable in -game. Players can only earn one of each
     * durable requisition and it is used to model awards such as armor suits, helmets,
     * emblems or other items such as stickers. Durables are never removed from the
     * player inventory.
     * Boost: The requisition is used prior to a match beginning and will modify how many
     * XP or Credits the player will earn at the end of the match. When put into effect,
     * it is removed from the player inventory.
     * Credit Granting: When obtained, the requisition will grant the player some amount
     * of credits. Once the credits are granted the requisition is immediately removed
     * from the player inventory.
     */
    val useType: String,

    /**
     * A reference to a large image for icon use. This may be null if there is no image
     * defined.
     */
    val largeImageUrl: String?,

    /**
     * A reference to a medium image for icon use. This may be null if there is no image
     * defined.
     */
    val mediumImageUrl: String?,

    /**
     * A reference to a small image for icon use. This may be null if there is no image
     * defined.
     */
    val smallImageUrl: String?,

    /**
     * A localized name for the category of the requisition, suitable for display to
     * users. The text is title cased.
     */
    val categoryName: String,

    /** Internal use. A non-localized name for the category of the requisition. */
    val internalCategoryName: String,

    /**
     * A localized name for the sub-category of the requisition, suitable for display to
     * users. The text is title cased.
     * */
    val subcategoryName: String,

    /** The order of the subcategory in the category. */
    val subcategoryOrder: Int,

    /**
     * This field indicates how many credits the player will receive if they wish to
     * discard this requisition. When SellPrice is zero, the card cannot be sold back for
     * credits.
     */
    val sellPrice: Int,

    /** The energy level required in order to use this requisition in a Warzone game. */
    val levelRequirement: Int,

    /**
     * For requisitions where the useType is CreditGranting, this field indicates how
     * many credits the player is rewarded with. When the requisition is not
     * CreditGranting, this value is zero.
     */
    val creditsAwarded: Int,

    /**
     * If this is set, this is the ID of the Certification Requisition that is required
     * to earn this requisition.
     */
    val certificationRequisitionId: String,

    /** The ID that uniquely identifies this requisition. */
    val id: String,

    /** Internal use only. Do not use. */
    val contentId: String
)