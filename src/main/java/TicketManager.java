import javax.management.StringValueExp;
import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void addTicket(Ticket ticket) {
        repo.add(ticket);
    }

    public void removeTicketById(int id) {
        repo.removeById(id);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getFrom().contains(from)) {
                Ticket[] tmp = new Ticket[result.length +1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            } else if (ticket.getTo().contains(to)) {
                Ticket[] tmp = new Ticket[result.length +1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length -1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
