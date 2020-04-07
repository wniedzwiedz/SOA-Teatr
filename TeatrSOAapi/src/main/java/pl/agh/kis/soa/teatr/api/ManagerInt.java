package pl.agh.kis.soa.teatr.api;

public interface ManagerInt {

    int getSeat(int row, int col);
    int getSeatPrice(int row, int col);
    int buyTicket(int row, int col, int balance);
}
