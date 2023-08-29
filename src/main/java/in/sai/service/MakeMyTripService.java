package in.sai.service;

import in.sai.request.Passenger;
import in.sai.responce.Ticket;

public interface MakeMyTripService {
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicketByNum(Integer ticketNumber);

}
