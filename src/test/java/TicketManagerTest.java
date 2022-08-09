import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1,333,"LED", "OGZ", 200);
    Ticket ticket2 = new Ticket(2, 200, "KUF", "GOJ", 300);
    Ticket ticket3 = new Ticket(3, 300, "LED", "KUF", 500);
    Ticket ticket4 = new Ticket(4, 150, "OGZ", "FRU", 444);
    Ticket ticket5 = new Ticket(5,500, "EGO", "GOJ", 123);

    @Test
    public void shouldFromToSortByPrice() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);

        Ticket[] expected = {ticket2, ticket3, ticket1, ticket5};
        Ticket[] actual = manager.findAll("LED", "GOJ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPrice() {

        Ticket ticket22 = new Ticket(22, 5, "LED", "GOJ", 1);
        Ticket ticket33 = new Ticket(22, 4, "LED", "GOJ", 1);
        Ticket ticket44 = new Ticket(22, 5, "LED", "GOJ", 1);
        Ticket ticket55 = new Ticket(22, 2, "LED", "GOJ", 1);
        Ticket ticket66 = new Ticket(22, 1, "LED", "GOJ", 1);

        manager.addTicket(ticket22);
        manager.addTicket(ticket33);
        manager.addTicket(ticket44);
        manager.addTicket(ticket55);
        manager.addTicket(ticket66);


        Ticket[] expected = {ticket66, ticket55, ticket33, ticket22 , ticket44};
        Ticket[] actual = manager.findAll("LED", "EKB");

        Assertions.assertArrayEquals(expected, actual);
    }
}