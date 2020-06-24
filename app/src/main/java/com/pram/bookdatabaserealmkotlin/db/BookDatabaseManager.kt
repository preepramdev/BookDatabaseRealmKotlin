package com.pram.bookdatabaserealmkotlin.db

import com.pram.bookdatabaserealmkotlin.model.Book
import io.realm.Realm
import io.realm.RealmResults

class BookDatabaseManager {
    val realm: Realm

    init {
        realm = Realm.getDefaultInstance()
    }

    companion object {
        var instance: BookDatabaseManager? = null
            get() {
                if (field == null) {
                    field =
                        BookDatabaseManager()
                }
                return field
            }
            private set
    }

    fun getAllBooks(): RealmResults<Book>? {
        return realm.where(Book::class.java).findAll()
    }

    fun getBook(bookId: Int): Book? {
        return realm.where(Book::class.java)
            .equalTo("id", bookId).findFirst()
    }

    fun createBook(book: Book) {
        book.id = nextId()
        realm.beginTransaction()
        realm.insert(book)
        realm.commitTransaction()
    }

    private fun nextId(): Int {
        val student =
            realm.where(Book::class.java)
                .max("id")
        return if (student == null) 0 else student.toInt() + 1
    }

    fun updateBook(book: Book) {
        realm.beginTransaction()
        realm.insertOrUpdate(book)
        realm.commitTransaction()
    }

    fun removeBook(bookId: Int) {
        realm.beginTransaction()
        realm.where(Book::class.java)
            .equalTo("id", bookId)
            .findFirst()
            ?.deleteFromRealm()
        realm.commitTransaction()
    }
}