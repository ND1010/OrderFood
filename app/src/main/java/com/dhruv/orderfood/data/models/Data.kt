package com.dhruv.orderfood.data.models

import androidx.annotation.Nullable
import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*Data start*/
@Entity(tableName = "screen_saver_master")
data class ScreenSaverMaster(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ScreenSaverID")
    @Expose
    @SerializedName("ScreenSaverID")
    var screenSaverID: Int? = 0,
    @Expose
    @SerializedName("ImagePath")
    var imagePath: String? = null
)


data class CategoryRaw(
    @Embedded
    val categoryMaster: CategoryMaster?,
    @Relation(
        parentColumn = "CategoryID",
        entityColumn = "Cat_ID"
    )
    @Nullable
    val categoryImage: CategoryImage?
){
    override fun toString(): String {
        return "CategoryRaw(categoryMaster=$categoryMaster, albums=$categoryImage)"
    }
}


@Entity(
    tableName = "category_image", foreignKeys = arrayOf(
        ForeignKey(
            entity = CategoryMaster::class,
            parentColumns = arrayOf("CategoryID"),
            childColumns = arrayOf("Cat_ID"),
            onDelete = CASCADE
        )
    )
)
data class CategoryImage(
    @Nullable
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CImgID")
    @SerializedName("CImgID")
    var cImgID: Int?=0,
    @Nullable
    @ColumnInfo(name = "Cat_ID")
    @SerializedName("CategoryID")
    var categoryID: Int?=0,
    @Nullable
    @SerializedName("ImageUrl")
    var imageUrl: String?=null
)


@Entity(tableName = "category_master")
data class CategoryMaster(
    @Nullable
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "CategoryID")
    @SerializedName("CategoryID")
    var categoryID: Int?=0,
    @Nullable
    @SerializedName("Name")
    var name:  String?=null,
    @Nullable
    @SerializedName("Description")
    var description: String?=null
)

@Entity(tableName = "item_category_mapping")
data class ItemCategoryMapping(
    @PrimaryKey(autoGenerate = true)
    @Nullable
    @ColumnInfo(name = "PCMappingID")
    @SerializedName("PCMappingID")
    var pCMappingID: Int?=0,
    @Nullable
    @SerializedName("CategoryID")
    var categoryID: String?=null,
    @Nullable
    @SerializedName("DisplayOrder")
    var displayOrder: String?=null,
    @Nullable
    @SerializedName("ItemID")
    var itemID: Int?=0
)


/*@Entity(primaryKeys = ["PCMappingID", "ItemID"])
data class ItemListCrossRef(
    @Nullable
    val PCMappingID: Int?,
    @Nullable
    val ItemID: Int?
)*/


/*data class ItemlistWithCategory(

    @Embedded val itemCategoryMapping: ItemCategoryMapping,
    @Relation(
        parentColumn = "PCMappingID",
        entityColumn = "ItemID",
        associateBy = Junction(ItemListCrossRef::class)
    )
    @Nullable
    val songs: List<Item>
)*/


@Entity(
    tableName = "item_image", foreignKeys = arrayOf(
        ForeignKey(
            entity = Item::class,
            parentColumns = arrayOf("ItemID"),
            childColumns = arrayOf("ItemID"),
            onDelete = CASCADE
        )
    )
)
data class ItemImage(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IImgID")
    @SerializedName("IImgID")
    @Nullable
    var iImgID: Int?=0,
    @Nullable
    @SerializedName("ImageUrl")
    var imageUrl: String?=null,
    @Nullable
    @ColumnInfo(name = "ItemID")
    @SerializedName("ItemID")
    var itemID: String?=null
)


@Entity(tableName = "item")
data class Item(
    @Nullable
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ItemID")
    @SerializedName("ItemID")
    var itemID: Int?=0,
    @Nullable
    @SerializedName("Name")
    var name: String?=null,
    @Nullable
    @SerializedName("FullDescription")
    var fullDescription: String?=null,
    @Nullable
    @SerializedName("Price")
    var price: String?=null
)

data class ItemWithImage(
    @Embedded
    val item: Item?,
    @Relation(
        parentColumn = "ItemID",
        entityColumn = "ItemID")
    @Nullable
    val itemImage: ItemImage?
)

data class ProductItem(
    @Embedded(prefix = "item_data")
    val item: Item?,
    @Embedded(prefix = "image_item_data")
    val itemImage: ItemImage?,
    @Embedded(prefix = "cat_item_mapping")
    val itemCategoryMapping: ItemCategoryMapping?
)

/*Data end*/
