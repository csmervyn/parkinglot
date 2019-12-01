package com.mervyn.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Before
    public void init() {
        parkingLot = new ParkingLot();

    }

    @Test
    public void should_given_one_car_when_parking_lot_empty_then_return_ticket() {
        Car car = new Car("car-1");
        Ticket ticket = parkingLot.park(car);
        Assert.assertNotNull(ticket);
    }

    @Test(expected = ParkingLotException.class)
    public void should_given_one_car_when_parking_lot__not_empty_then_return_exception() {
        IntStream.range(0, 100).forEach(i -> {
            Car car = new Car("car-" + i);
            Ticket ticket = parkingLot.park(car);
        });
        Ticket ticket = parkingLot.park(new Car("car-101"));
    }

    @Test
    public void should_given_one_ticket_when_parking_park_then_return_car() {
        Car car = new Car("car-1");
        Ticket ticket = parkingLot.park(car);
        Car mycar = parkingLot.pick(ticket);
        Assert.assertEquals(car, mycar);
    }

    @Test(expected = ParkingLotException.class)
    public void should_given_invalid_ticket_when_not_park_then_return_exception() {
        Car mycar = parkingLot.pick(new Ticket());
        Assert.assertNull(mycar);
    }
}
