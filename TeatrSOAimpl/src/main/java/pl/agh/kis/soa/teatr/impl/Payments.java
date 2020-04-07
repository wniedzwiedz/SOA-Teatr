package pl.agh.kis.soa.teatr.impl;

import pl.agh.kis.soa.teatr.api.PaymentInt;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.Stateful;

@Stateful
public class Payments implements PaymentInt {

    private int balance;
    private Exception e = new Exception("Can't buy ticket");

    public Payments(){
        this.balance=100;
    }

    @EJB
    private Manager manager = new Manager();

    @EJB
    private Availability availability = new Availability();



    @Lock
    @Override
    public int getBalance() {
        return balance;
    }

    @Lock
    public boolean buyTicket(int row,int col) {
        try {

            if (manager.getSeatPrice(row, col) <= balance && availability.getSeatAvailability(manager.getSeatAt(row, col))) {
                balance = manager.buyTicket(row, col, balance);
                return true;
            } else {
                throw e;
            }
        } catch (Exception e){
            return false;
        }
    }

}
