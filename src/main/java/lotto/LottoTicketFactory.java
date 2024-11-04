package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketFactory {
    public static List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for(int i=0; i< ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45 ,6);
            Collections.sort(numbers);
            tickets.add(new Lotto(new ArrayList<>(numbers)));
        }
        return tickets;
    }
}
