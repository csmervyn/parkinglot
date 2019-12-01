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
    public void testParkSuccess() {
        Car car = new Car("car-1");
        Ticket ticket = parkingLot.park(car);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void testParkFail() {
        IntStream.range(0, 100).forEach(i -> {
            Car car = new Car("car-" + i);
            Ticket ticket = parkingLot.park(car);
        });
        Ticket ticket = parkingLot.park(new Car("car-101"));
        Assert.assertNull(ticket);
    }

    @Test
    public void testPickSuccess() {
        Car car = new Car("car-1");
        Ticket ticket = parkingLot.park(car);
        Car mycar = parkingLot.pick(ticket);
        Assert.assertEquals(car, mycar);
    }

    @Test
    public void testPickFail() {
        Car mycar = parkingLot.pick(new Ticket());
        Assert.assertNull(mycar);
    }
}
