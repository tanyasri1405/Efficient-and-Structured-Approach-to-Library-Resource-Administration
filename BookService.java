
package backend;

import java.util.*;

public class BookService {

    static class Book {
        String title;
        String topic;
        String genre;
        int rating;

        Book(String title,String topic,String genre,int rating){
            this.title=title;
            this.topic=topic;
            this.genre=genre;
            this.rating=rating;
        }
    }

    List<Book> books = new ArrayList<>();

    public BookService(){

        books.add(new Book("Concepts of Physics","science","study",5));
        books.add(new Book("Brief History of Time","science","study",4));
        books.add(new Book("The Martian","science","story",4));

        books.add(new Book("World History","history","study",4));
        books.add(new Book("The Book Thief","history","story",5));

        books.add(new Book("Atomic Habits","motivation","study",5));
        books.add(new Book("The Alchemist","motivation","story",4));

        books.add(new Book("AI Basics","technology","study",5));
        books.add(new Book("Digital Fortress","technology","story",4));
    }

    // DSA Priority Recommendation using Sorting
    public List<String> getBooks(String topic,String genre){

        List<Book> filtered = new ArrayList<>();

        for(Book b: books){
            if(b.topic.equalsIgnoreCase(topic) &&
               b.genre.equalsIgnoreCase(genre)){
                filtered.add(b);
            }
        }

        // sort by rating (priority recommendation)
        Collections.sort(filtered,(a,b)->b.rating-a.rating);

        List<String> result = new ArrayList<>();
        for(Book b:filtered){
            result.add(b.title + " (Rating:"+b.rating+")");
        }

        return result;
    }
}
