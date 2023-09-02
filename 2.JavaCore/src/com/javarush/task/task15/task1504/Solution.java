package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            if (getBook() instanceof AgathaChristieBook) output = agathaChristieOutput;
            else if (getBook() instanceof MarkTwainBook) output = markTwainOutput;

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {
        private static final String author = "Mark Twain";
        private String title;

        public MarkTwainBook(String title) {
            super(author);
            this.title = title;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static class AgathaChristieBook extends Book {
        private static final String author = "Agatha Christie";
        private String title;

        public AgathaChristieBook(String title) {
            super(author);
            this.title = title;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
