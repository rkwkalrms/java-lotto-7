package lotto;

import java.util.List;
import java.util.Map;

public class LottoHandler {
    static final int ticketPrice = 1000;

    public void startLotto() {
        int purchaseAmount = InputManager.getPurchaseAmount();
        List<Lotto> tickets = LottoTicketFactory.generateTickets(purchaseAmount/ticketPrice);
        Printer.printTickets(tickets);

        List<Integer> winningNumbers = InputManager.getWinningNumbers();
        int bonusNumber = InputManager.getBonusNumber();
        //Map?? List??
        Map<LottoRank, Integer> statistics = ResultCalculator.calculateEarnings(tickets, winningNumbers, bonusNumber);
        double earningRate = ResultCalculator.calculateProfitRate(statistics, purchaseAmount);

        Printer.printStatistics(statistics, earningRate);
    }
}
