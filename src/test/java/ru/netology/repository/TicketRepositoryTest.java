package ru.netology.repository;

import ru.netology.domain.TicketInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    TicketInformation ticket1 = new TicketInformation(1, 26_000, "VKO", "LED");
    TicketInformation ticket2 = new TicketInformation(2, 19_900, "LNX", "ROV");
    TicketInformation ticket3 = new TicketInformation(3, 8_800, "YKS", "SVO");
    TicketInformation ticket4 = new TicketInformation(4, 18_800, "STW", "VKO");
    TicketInformation ticket5 = new TicketInformation(5, 21_000, "VKO", "LED");
    TicketInformation ticket6 = new TicketInformation(6, 13_300, "VKO", "LED");
    TicketInformation ticket7 = new TicketInformation(7, 8_800, "VKO", "SVO");
    TicketInformation ticket8 = new TicketInformation(8, 10_300, "VKO", "LED");


    @Test
    public void returnAllAddedTickets() {
        repository.addTicketInformation(ticket1);
        repository.addTicketInformation(ticket2);
        repository.addTicketInformation(ticket3);
        repository.addTicketInformation(ticket4);
        repository.addTicketInformation(ticket5);
        repository.addTicketInformation(ticket6);
        repository.addTicketInformation(ticket7);
        repository.addTicketInformation(ticket8);

        TicketInformation[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        TicketInformation[] actual = repository.getTicketData();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnFourAddedTickets() {
        repository.addTicketInformation(ticket1);
        repository.addTicketInformation(ticket3);
        repository.addTicketInformation(ticket5);
        repository.addTicketInformation(ticket7);

        TicketInformation[] expected = {ticket1, ticket3, ticket5, ticket7};
        TicketInformation[] actual = repository.getTicketData();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnOneAddTicket() {
        repository.addTicketInformation(ticket1);

        TicketInformation[] expected = {ticket1};
        TicketInformation[] actual = repository.getTicketData();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnZeroTickets() {
        TicketInformation[] expected = {};
        TicketInformation[] actual = repository.getTicketData();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdEveryoneAllAddedTickets() {
        repository.addTicketInformation(ticket1);
        repository.addTicketInformation(ticket2);
        repository.addTicketInformation(ticket3);
        repository.addTicketInformation(ticket4);
        repository.addTicketInformation(ticket5);
        repository.addTicketInformation(ticket6);
        repository.addTicketInformation(ticket7);
        repository.addTicketInformation(ticket8);
        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        repository.removeById(5);
        repository.removeById(6);
        repository.removeById(7);
        repository.removeById(8);

        TicketInformation[] expected = {};
        TicketInformation[] actual = repository.getTicketData();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdOneAddTicket() {
        repository.addTicketInformation(ticket1);
        repository.addTicketInformation(ticket2);
        repository.addTicketInformation(ticket3);
        repository.addTicketInformation(ticket4);
        repository.addTicketInformation(ticket5);
        repository.addTicketInformation(ticket6);
        repository.addTicketInformation(ticket7);
        repository.addTicketInformation(ticket8);
        repository.removeById(4);

        TicketInformation[] expected = {ticket1, ticket2, ticket3, ticket5, ticket6, ticket7, ticket8};
        TicketInformation[] actual = repository.getTicketData();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdSelectivelyTickets() {
        repository.addTicketInformation(ticket1);
        repository.addTicketInformation(ticket2);
        repository.addTicketInformation(ticket3);
        repository.addTicketInformation(ticket4);
        repository.addTicketInformation(ticket5);
        repository.addTicketInformation(ticket6);
        repository.addTicketInformation(ticket7);
        repository.addTicketInformation(ticket8);
        repository.removeById(1);
        repository.removeById(8);

        TicketInformation[] expected = {ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        TicketInformation[] actual = repository.getTicketData();

        Assertions.assertArrayEquals(expected, actual);
    }
}
