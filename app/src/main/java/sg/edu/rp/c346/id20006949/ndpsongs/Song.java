package sg.edu.rp.c346.id20006949.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private 	int _id;
    private 	String title;
    private String singers;
    private int year;
    private int stars;

    public Song( String title, String singers, int year, int stars ) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }
    public int get_id() {  return _id;  }
    public String getTitle() { return title; }
    public String getSingers() { return singers; }
    public int getYear() { return year; }
    public int getStar() { return stars; }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setSongContent(String title, String singers, int year, int stars ) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.stars = stars;
    }
    @Override
    public String toString() {
        String numberstars = "";
        if (stars == 1){
            numberstars= "1";
        }else if(stars ==2){
            numberstars = "2";
        }else if(stars ==3){
            numberstars="3";
        }else if(stars ==4){
            numberstars="4";
        }else if(stars==5){
            numberstars="5";
        }
        return "ID: " + _id + "\nTitle: "+ title + "\nSingers: " + singers+ "\nYear: " + year + "\nStars: " + numberstars;
    }
}