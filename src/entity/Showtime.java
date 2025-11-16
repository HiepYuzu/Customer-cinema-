package entity;
import java.time.*;
import java.util.HashSet;
import java.util.Set;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Win10
 */
public class Showtime {
    private String id;
    private Movie movie;
    private Room room;
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;
    private Double price;
    private Set<String> bookedSeats;
        public Showtime(){}
        public Showtime (String id, Movie movie, Room room, LocalDate date, LocalTime start_time, Double show_price ){
            this.id = id;
            this.movie = movie;
            this.room = room;
            this.date= date;
            this.start_time = start_time;           
            this.price = show_price;
            this.bookedSeats=new HashSet<>();
            this.end_time = start_time.plusMinutes(movie.getDuration());           
        }
    public void bookSeat(String seatNum){
       if(bookedSeats.contains(seatNum)){
            return;
       }
       bookedSeats.add(seatNum);
    }
    public boolean seatAvailable(String seatNum){
       return !bookedSeats.contains(seatNum);
    }
    public int getAvailableSeat(){
       return room.getSeatCount()-bookedSeats.size();
    }    
    public String getId() {
        return id;
    }
    
     public void setId(String Show_ID) {
        this.id = Show_ID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate Show_date) {
        this.date = Show_date;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime Start_time) {
        this.start_time = Start_time;
        this.end_time = start_time.plusMinutes(this.movie.getDuration());
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public Double getShow_price() {
        return price;
    }

    public void setShow_price(Double Show_price) {
        this.price = Show_price;
    }
    public Set<String> getBookedSeats() {
        return bookedSeats;
    }    
}
