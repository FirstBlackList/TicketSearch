package ru.netology.manager;

import ru.netology.repository.TicketRepository;
import ru.netology.domain.TicketInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    TicketInformation ticket1 = new TicketInformation(1, 26_000, "VKO", "LED");
    TicketInformation ticket2 = new TicketInformation(2, 19_900, "LNX", "ROV");
    TicketInformation ticket3 = new TicketInformation(3, 8_800, "YKS", "SVO");
    TicketInformation ticket4 = new TicketInformation(4, 18_800, "STW", "VKO");
    TicketInformation ticket5 = new TicketInformation(5, 21_000, "VKO", "LED");
    TicketInformation ticket6 = new TicketInformation(6, 13_300, "VKO", "LED");
    TicketInformation ticket7 = new TicketInformation(7, 8_800, "VKO", "SVO");
    TicketInformation ticket8 = new TicketInformation(8, 10_300, "VKO", "LED");


    @Test
    public void returnAllTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        TicketInformation[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};

        Assertions.assertArrayEquals(expected, manager.AllTickets());
    }

    @Test
    public void returnFourTicketsWithTheAppropriateParameters() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        TicketInformation[] expected = {ticket8, ticket6, ticket5, ticket1};
        TicketInformation[] actual = manager.findAll("VKO", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnOneTicketWithTheAppropriateParameters() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        TicketInformation[] expected = {ticket2};
        TicketInformation[] actual = manager.findAll("LNX", "ROV");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnZeroTickets() {
        TicketInformation[] expected = {};
        TicketInformation[] actual = manager.findAll("STW", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareTOTicketMaxPrice_AboveZero() {
        System.out.println(ticket2.compareTo(ticket4));
    }

    @Test
    public void testCompareTOTicketCostIsEqual_Null() {
        System.out.println(ticket7.compareTo(ticket3));
    }

    @Test
    public void testCompareTOTicketMinPrice_BelowZero() {
        System.out.println(ticket6.compareTo(ticket1));
    }

}
