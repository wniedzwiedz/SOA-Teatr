package pl.agh.kis.soa.teatr.impl;

import javax.naming.directory.SearchControls;

public class Seat {

    private boolean available;

    private int row;
    private int column;

    private int price;

    public Seat(int r, int c){
        this.row=r;
        this.column=c;
        this.available=true;
        if (row<=5 && column >=5 && column <=15 ){
            this.price=97;
        }
        else if (row<=7){
            this.price=76;
        }
        else{
            this.price=55;
        }
    }

    public int getPrice(){
        return price;
    }

    public void changeAvailability(boolean state){
        available=state;
    }

    public boolean isAvailable(){
        return available;
    }

}
