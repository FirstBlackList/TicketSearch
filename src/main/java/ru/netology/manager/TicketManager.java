package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketInformation ticket) {
        repository.addTicketInformation(ticket);
    }

    public TicketInformation[] findAll(String departureAirport, String arrivalAirport) {
        TicketInformation[] result = new TicketInformation[0];
        for (TicketInformation ticket : repository.getTicketData()) {
            if (ticket.getDepartureAirport().equals(departureAirport) && ticket.getArrivalAirport().equals(arrivalAirport)) {
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public TicketInformation[] AllTickets() {
        return repository.getTicketData();
    }

}
