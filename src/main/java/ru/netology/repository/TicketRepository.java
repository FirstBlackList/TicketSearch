package ru.netology.repository;

import ru.netology.domain.TicketInformation;

public class TicketRepository {
    private TicketInformation[] ticketData = new TicketInformation[0];

    public void addTicketInformation(TicketInformation ticket) {
        TicketInformation[] tmp = new TicketInformation[ticketData.length + 1];
        for (int i = 0; i < ticketData.length; i++) {
            tmp[i] = ticketData[i];
        }
        tmp[tmp.length - 1] = ticket;
        ticketData = tmp;
    }

    public void removeById(int id) {
        TicketInformation[] tmp = new TicketInformation[ticketData.length - 1];
        int indexCopy = 0;
        for (TicketInformation tData : ticketData) {
            if (tData.getId() != id) {
                tmp[indexCopy] = tData;
                indexCopy++;
            }
        }
        ticketData = tmp;
    }

    public TicketInformation[] getTicketData() {
        return ticketData;
    }
}
