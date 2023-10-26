package com.example.partblibrarymanagementsystem

class Library {
    private val books = mutableListOf<Book>()

    // Function to add a book to the library
    fun addBook(title: String, author: String, publicationYear: Int) {
        val id = generateUniqueId()
        val book = Book(id, title, author, publicationYear, false)
        books.add(book)
    }

    // Function to delete a book from the library
    fun deleteBook(id: Int) {
        val index = books.indexOfFirst { it.id == id }
        if (index != -1) {
            books.removeAt(index)
        } else {
            println("Book with ID $id not found.")
        }
    }

    // Function to check out a book
    fun checkOutBook(id: Int) {
        val book = findBookById(id)
        if (book != null) {
            if (!book.isCheckedOut) {
                book.isCheckedOut = true
            } else {
                println("Book with ID $id is already checked out.")
            }
        } else {
            println("Book with ID $id not found.")
        }
    }

    // Function to return a book
    fun returnBook(id: Int) {
        val book = findBookById(id)
        if (book != null) {
            if (book.isCheckedOut) {
                book.isCheckedOut = false
            } else {
                println("Book with ID $id is not checked out.")
            }
        } else {
            println("Book with ID $id not found.")
        }
    }

    // Function to list available books
    fun listAvailableBooks() {
        val availableBooks = books.filter { !it.isCheckedOut }
        printBooks(availableBooks, "Available Books")
    }

    // Function to list checked-out books
    fun listCheckedOutBooks() {
        val checkedOutBooks = books.filter { it.isCheckedOut }
        printBooks(checkedOutBooks, "Checked Out Books")
    }

    // Function to print books based on the publication year
    fun printBooksByPublicationYear(year: Int) {
        val booksByYear = books.filter { it.publicationYear == year }
        printBooks(booksByYear, "Books published in $year")
    }

    // Helper function to find a book by its ID
    private fun findBookById(id: Int): Book? {
        return books.find { it.id == id }
    }

    // Helper function to generate a unique ID for a book
    private fun generateUniqueId(): Int {
        return books.size + 1
    }

    // Helper function to print a list of books
    private fun printBooks(books: List<Book>, heading: String) {
        if (books.isEmpty()) {
            println("$heading: No books found.")
        } else {
            println("$heading:")
            books.forEach {
                println("ID: ${it.id}, Title: ${it.title}, Author: ${it.author}, Year: ${it.publicationYear}")
            }
        }
    }
}
