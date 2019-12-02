package com.mervyn.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GraduateParkingBoyTest {

    private GraduateParkingBoy parkingBoy;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;

    @Before
    public void before(){
        parkingLot1 = new ParkingLot("ParkingLot-1");
        parkingLot2 = new ParkingLot("ParkingLot-2");

        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingBoy = new GraduateParkingBoy(parkingLots);
    }

    @Test
    public void given_one_car_when_a_parkinglot_empty_then_return_ticket(){
        Car car = new Car("car-1");
        Ticket ticket = parkingBoy.park(car);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void given_one_car_when_a_parkinglot_not_empty_b_empty_then_return_ticket(){
        IntStream.range(0, 100).forEach(i -> {
            Car car = new Car("car-" + i);
            Ticket ticket = parkingBoy.park(car);
        });
        Car car = new Car("car-101");
        Ticket ticket = parkingBoy.park(car);
        Assert.assertNotNull(parkingLot2.pick(ticket));
    }


    @Test(expected = ParkingLotException.class)
    public void given_one_car_when_a_parkinglot_not_empty_b_not_empty_then_return_ticket(){
        IntStream.range(0, 200).forEach(i -> {
            Car car = new Car("car-" + i);
            Ticket ticket = parkingBoy.park(car);
        });
        Car car = new Car("car-201");
        parkingBoy.park(car);
    }

    @Test
    public void given_one_ticket_when_save_then_return_car(){
        Car car = new Car("car-1");
        Ticket ticket = parkingBoy.park(car);

        Car mycar = parkingBoy.pick(ticket);
        Assert.assertEquals(mycar,car);
    }

    @Test(expected = ParkingLotException.class)
    public void given_one_ticket_when_not_save_then_return_exception(){
        Ticket ticket = new Ticket();
        parkingBoy.pick(ticket);
    }


    @Test(expected = ParkingLotException.class)
    public void given_one_ticket_when_picked_then_return_exception(){
        Car car = new Car("car-1");
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.pick(ticket);

        parkingBoy.pick(ticket);
    }
}
