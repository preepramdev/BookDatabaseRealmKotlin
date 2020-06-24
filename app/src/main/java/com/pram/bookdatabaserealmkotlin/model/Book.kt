package com.pram.bookdatabaserealmkotlin.model

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Book(
    /**
     * @Required กำหนดให้ Field นั้น ห้ามมีค่า null
     * @PrimaryKey กำหนดให้ Field นั้นเป็น primary key
     * @Ignore เป็นการกำหนดว่า Field นั้นไม่ต้องการเก็บลงใน Database
     * @Index เป็นการเพิ่ม Search index ให้กับ Field นั้นๆ ใช้สำหรับการ Query
     */
    @PrimaryKey
    var id: Int = 0,
    var title: String = "",
    var author: String = "",
    var pages: String = ""
) : RealmObject(), Parcelable {

    constructor(title: String, author: String, pages: String) : this() {
        this.title = title
        this.author = author
        this.pages = pages
    }

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeString(pages)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}