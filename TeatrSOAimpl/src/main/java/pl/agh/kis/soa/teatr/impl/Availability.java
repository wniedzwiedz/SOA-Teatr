package pl.agh.kis.soa.teatr.impl;

import pl.agh.kis.soa.teatr.api.AvailabilityInt;

import javax.ejb.Stateless;

@Stateless
public class Availability implements AvailabilityInt {

    public boolean getSeatAvailability(Seat seat){
        return seat.isAvailable();

    }
}
