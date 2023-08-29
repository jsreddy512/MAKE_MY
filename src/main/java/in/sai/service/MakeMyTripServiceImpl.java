package in.sai.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.sai.request.Passenger;
import in.sai.responce.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL="http://54.80.241.109:4520/ticket";
	
	private String GET_TICKET_URL="http://54.80.241.109:4520/ticket/{ticketNum}";
	@Override
	public Ticket bookTicket(Passenger passenger) {
		RestTemplate rt=new RestTemplate();		
		ResponseEntity<Ticket> respEntity= rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket =respEntity.getBody();
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNumber) {
		RestTemplate rt=new RestTemplate();	
		ResponseEntity<Ticket> respEntity=rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNumber);
		Ticket ticket=respEntity.getBody();
		return ticket;
	}

}
