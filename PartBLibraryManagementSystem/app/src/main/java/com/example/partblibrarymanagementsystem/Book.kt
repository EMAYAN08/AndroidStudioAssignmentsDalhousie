// This line specifies the package where the Book class belongs to.
package com.example.partblibrarymanagementsystem

// This line declares a data class named 'Book' which represents a book in the library.
// It contains properties like 'id', 'title', 'author', 'publicationYear', and 'isCheckedOut'.
data class Book(
    val id: Int,           // Unique identifier for the book.
    val title: String,     // The title of the book.
    val author: String,    // The author of the book.
    val publicationYear: Int,   // The year the book was published.
    var isCheckedOut: Boolean   // Indicates if the book is currently checked out.
)
