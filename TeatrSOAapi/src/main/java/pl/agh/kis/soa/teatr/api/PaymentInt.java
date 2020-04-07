package pl.agh.kis.soa.teatr.api;

public interface PaymentInt {

    boolean buyTicket(int row,int col);
    int getBalance();

}
