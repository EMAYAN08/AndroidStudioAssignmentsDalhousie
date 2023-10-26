package com.example.partblibrarymanagementsystem

// Importing the Scanner class from the java.util package to enable user input
import java.util.*

// Main function where the program starts execution
fun main() {
    // Creating an instance of the Library class
    val library = Library()

    // Creating an instance of the Scanner class to read user input from the console
    val scanner = Scanner(System.`in`)

    // A loop that keeps running until explicitly exited
    while (true) {
        // Displaying the menu for the library management system
        println("|=====================================|")
        println("|      Library Management System      |")
        println("|=====================================|")
        println("|  Option  |          Operation       |")
        println("|=====================================|")
        println("|    1     |         Add Book         |")
        println("|    2     |       Delete Book        |")
        println("|    3     |     Check Out Book       |")
        println("|    4     |        Return Book       |")
        println("|    5     |    List Available Books  |")
        println("|    6     |    List Checked Out Books|")
        println("|    7     | Print Books by Pub. Year |")
        println("|    8     |           Exit           |")
        println("======================================|")
        print("Enter your choice: ")

        // Reading the user's choice
        when (val choice = scanner.nextInt()) {
            1 -> {
                // Consuming the newline character left in the buffer
                scanner.nextLine()

                // Adding a book to the library
                println("\n===== Add Book =====")
                print("Enter title: ")
                val title = scanner.nextLine()
                print("Enter author: ")
                val author = scanner.nextLine()
                print("Enter publication year: ")
                val year = scanner.nextInt()
                library.addBook(title, author, year)
                println("\nBook added successfully.")
            }
            2 -> {
                // Deleting a book from the library
                println("\n===== Delete Book =====")
                print("Enter book ID to delete: ")
                val id = scanner.nextInt()
                library.deleteBook(id)
                println("\nBook deleted successfully.")
            }
            3 -> {
                // Checking out a book from the library
                println("\n===== Check Out Book =====")
                print("Enter book ID to check out: ")
                val id = scanner.nextInt()
                library.checkOutBook(id)
                println("\nBook checked out successfully.")
            }
            4 -> {
                // Returning a book to the library
                println("\n===== Return Book =====")
                print("Enter book ID to return: ")
                val id = scanner.nextInt()
                library.returnBook(id)
                println("\nBook returned successfully.")
            }
            5 -> {
                // Listing available books
                println("\n===== Available Books =====")
                library.listAvailableBooks()
            }
            6 -> {
                // Listing checked out books
                println("\n===== Checked Out Books =====")
                library.listCheckedOutBooks()
            }
            7 -> {
                // Printing books based on publication year
                println("\n===== Print Books by Publication Year =====")
                print("Enter publication year: ")
                val year = scanner.nextInt()
                library.printBooksByPublicationYear(year)
            }
            8 -> return // Exiting the program
            else -> println("\nInvalid choice. Please try again.") // Handling invalid input
        }
    }
}

