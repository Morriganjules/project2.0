package org.bedu.project20

import android.os.Parcel
import android.os.Parcelable

data class Product (
    var title:String,
    var rate: Float,
    var category: String,
    var image: String,
    var price: Double,
    var description: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p: Parcel, p1: Int) {
        p.writeString(title)
        p.writeFloat(rate)
        p.writeString(category)
        p.writeString(image)
        p.writeDouble(price)
        p.writeString(description)

    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}