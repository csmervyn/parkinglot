package com.mervyn.parkinglot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SuperParkingBoyTest {

    private SuperParkingBoy superParkingBoy;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;

    @Before
    public void before() {
        parkingLot1 = new ParkingLot("ParkingLot-1");
        parkingLot2 = new ParkingLot("ParkingLot-2");

        superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot1,parkingLot2));
    }


    @Test
    public void given_one_car_when_a_parkinglotA_vacancy_rate_more_then_parkinglotB_then_return_ticket() {
        ParkingLot parkingLot3 = new ParkingLot("ParkingLot-3",100);
        ParkingLot parkingLot4 = new ParkingLot("ParkingLot-4",1);

        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot3,parkingLot4));

        Car car0 = new Car("car-0");
        Ticket ticket0 = superParkingBoy.park(car0);

        Car mycar = parkingLot3.pick(ticket0);
        Assert.assertEquals(mycar,car0);
    }

    @Test
    public void given_one_car_when_a_parkinglotB_vacancy_rate_more_then_parkinglotA_then_return_ticket() {
        Car car0 = new Car("car-0");
        Ticket ticket0 = superParkingBoy.park(car0);
        Car car1 = new Car("car-1");
        Ticket ticket1 = superParkingBoy.park(car1);

        Car mycar = parkingLot2.pick(ticket1);
        Assert.assertEquals(car1, mycar);
    }


    @Test
    public void given_one_car_when_a_parkinglotA_vacancy_rate_equals_parkinglotB_then_return_ticket() {
        Car car0 = new Car("car-0");
        Ticket ticket0 = superParkingBoy.park(car0);
        Car car1 = new Car("car-1");
        Ticket ticket1 = superParkingBoy.park(car1);

        Car car2 = new Car("car-2");
        Ticket ticket2 = superParkingBoy.park(car2);


        Car mycar = parkingLot1.pick(ticket2);
        Assert.assertEquals(car2, mycar);
    }


    @Test(expected = ParkingLotException.class)
    public void given_one_car_when_a_parkinglotA_not_empty_parkinglotB_not_empty_then_return_ticket() {
        IntStream.range(0, 200).forEach(i -> {
            Car car = new Car("car-" + i);
            Ticket ticket = superParkingBoy.park(car);
        });
        Car car2 = new Car("car-2");
        superParkingBoy.park(car2);
    }


    @Test
    public void given_one_ticket_when_save_then_return_car(){
        Car car = new Car("car-1");
        Ticket ticket = superParkingBoy.park(car);

        Car mycar = superParkingBoy.pick(ticket);
        Assert.assertEquals(mycar,car);
    }

    @Test(expected = ParkingLotException.class)
    public void given_one_ticket_when_not_save_then_return_exception(){
        Ticket ticket = new Ticket();
        superParkingBoy.pick(ticket);
    }


    @Test(expected = ParkingLotException.class)
    public void given_one_ticket_when_picked_then_return_exception(){
        Car car = new Car("car-1");
        Ticket ticket = superParkingBoy.park(car);
        superParkingBoy.pick(ticket);

        superParkingBoy.pick(ticket);
    }

}
