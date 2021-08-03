package searchtext;

import java.util.*;

class Book {
    int id;
    String summary;

    public Book(int id, String summary) {
        this.id = id;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

class Data {
    int id_loc;
    int count;

    public Data(int id_loc, int count) {
        this.id_loc = id_loc;
        this.count = count;
    }

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

public class BookSearch {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Book in Three Sentences: Practicing meditation and mindfulness will make you at least 10 percent happier. Being mindful doesn\\u2019t change the problems in your life, but mindfulness does help you respond to your problems rather than react to them. Mindfulness helps you realize that striving for success is fine as long as you accept that the outcome is outside your control."));
        books.add(new Book(2, "The Book in Three Sentences: The 10X Rule says that 1) you should set targets for yourself that are 10X greater than what you believe you can achieve and 2) you should take actions that are 10X greater than what you believe are necessary to achieve your goals. The biggest mistake most people make in life is not setting goals high enough. Taking massive action is the only way to fulfill your true potential."));
        books.add(new Book(3, "The Book in Three Sentences: Practicing meditation and mindfulness will make you at least 10 percent happier. Being mindful doesn\\u2019t change the problems in your life, but mindfulness does help you respond to your problems rather than react to them. Mindfulness helps you realize that striving for success is fine as long as you accept that the outcome is outside your control."));
        books.add(new Book(4, "The Book in Three Sentences: Practicing meditation and mindfulness will make you at least 10 percent happier. Being mindful doesn\\u2019t change the problems in your life, but mindfulness does help you respond to your problems rather than react to them. Mindfulness helps you realize that striving for success is fine as long as you accept that the outcome is outside your control."));

        Map<String, Data> bookMap = preProcess(books);


    }

    public static Map<String, Data> preProcess(List<Book> books) {
        Map<String, Data> bookMap = new HashMap();
        int count=1;
        for (Book book : books) {
            //Clean up data
            List<String> keywordList = dataCleanUp(book.getSummary());

            //Staging the data
            for (String s : keywordList) {
                if (bookMap.containsKey(s)) {
                    count = bookMap.get(s).getCount();
                    count++;
                    bookMap.put(s, new Data(book.getId(), count));
                } else {
                    bookMap.put(s, new Data(book.getId(), 1));
                }
            }


        }

    return bookMap;
    }

    public static List<String> dataCleanUp(String summary){
        List<String> dictionary = new ArrayList<>(Arrays.asList("The","is","a","you","and","or"));

        for(String word : dictionary) {
            summary.replace(word,"");
        }

        return new ArrayList<String>(Arrays.asList(summary.split(" ")));

    }

}
