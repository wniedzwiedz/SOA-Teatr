package pl.agh.kis.soa.teatr.impl;

import pl.agh.kis.soa.teatr.api.ManagerInt;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Manager implements ManagerInt {
    List<Seat> seats = new ArrayList<Seat>();




    public Manager(){
        for (int col=0; col<=20; col++){
            for (int row=0; row<17; row++){
                seats.add(new Seat(row,col));
            }
        }
}
    @Override
    public int getSeat(int row, int col){
        return seats.indexOf(new Seat(row,col));
    }
    public Seat getSeatAt(int row, int col){
        return seats.get(seats.indexOf(new Seat(row,col)));
    }


    public List<Seat> getSeatList(){
        return seats;
    }
    @Override
    public int getSeatPrice(int row, int col){
        Seat seat = seats.get(getSeat(row,col));
        return seat.getPrice();

    }

    @Lock
    @Override
    public int buyTicket(int row, int col, int balance){
        Seat seat = seats.get(getSeat(row,col));
        balance=balance-seat.getPrice();
        seat.changeAvailability(false);
        return balance;

    }

}
