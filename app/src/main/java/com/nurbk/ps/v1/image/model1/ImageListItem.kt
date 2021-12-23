package com.nurbk.ps.v1.image.model1

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nurbk.ps.v1.image.model1.modelImage.*
import java.io.Serializable


@Entity(
    tableName = "ImageListItem"
)
class ImageListItem(
    val alt_description: String?,
    val color: String?,
    val created_at: String?,
    val description: String?,
    val height: Int?,
    val id: String?,
    val liked_by_user: Boolean?,
    val likes: Int?,
    val links: Links?,
    val promoted_at: String?,
    val updated_at: String?,
    val urls: Urls?,
    val user: User?,
    val width: Int?,
    var status: Int = 0
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var ids: Int? = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("links"),
        parcel.readString(),
        parcel.readString(),
        TODO("urls"),
        TODO("user"),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt()
    ) {
        ids = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(alt_description)
        parcel.writeString(color)
        parcel.writeString(created_at)
        parcel.writeString(description)
        parcel.writeValue(height)
        parcel.writeString(id)
        parcel.writeValue(liked_by_user)
        parcel.writeValue(likes)
        parcel.writeString(promoted_at)
        parcel.writeString(updated_at)
        parcel.writeValue(width)
        parcel.writeValue(ids)
        parcel.writeInt(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageListItem> {
        override fun createFromParcel(parcel: Parcel): ImageListItem {
            return ImageListItem(parcel)
        }

        override fun newArray(size: Int): Array<ImageListItem?> {
            return arrayOfNulls(size)
        }
    }

}