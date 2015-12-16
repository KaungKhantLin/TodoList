package model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by kaungkhantlynn on 12/13/15.
 */
@Table(name = "Todos")
public class Todo extends Model {


    @Column(name = "Articles")
    public String articles;

    @Column(name = "Date")
    public String mdate;

    @Column(name = "Year")
    public int year;

    @Column(name = "Month")
    public int month;

    @Column(name = "Day")
    public int day;

    public Todo() {
        super();
    }

    public Todo(String articles, String mdate, int year, int month, int day) {

        super();
        this.articles = articles;
        this.mdate = mdate;
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
