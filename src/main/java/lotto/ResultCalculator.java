package lotto;

import jdk.dynalink.beans.StaticClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {

    public static Map<LottoRank, Integer> calculateEarnings(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> statistics = new HashMap<>();
        for(Lotto ticket : tickets) {
            int matchCount = countMatch(ticket, winningNumbers);
            boolean hasBonus = ticketContainsBonus(ticket, bonusNumber, winningNumbers);
            LottoRank rank = LottoRank.fromMathcCount(matchCount, hasBonus);
            updateStatistics(statistics, rank);
        }
        return statistics;
    }

    private static int countMatch(Lotto ticket, List<Integer> winningNumbers) {
        int count = 0;
        for(Integer number : ticket.getNumbers()) {
            if(winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean ticketContainsBonus(Lotto ticket, int bonusNumber, List<Integer> winningNumbers) {
        return ticket.getNumbers().contains(bonusNumber);
    }

    private static void updateStatistics(Map<LottoRank, Integer> statistics, LottoRank rank) {
        if(!statistics.containsKey(rank)) {
            statistics.put(rank, 0);
        }
        statistics.put(rank, statistics.get(rank) + 1);
    }

    public static double calculateProfitRate(Map<LottoRank, Integer> statistics, int purchaseAmount) {
        int totalPrize = calculateTotalPrize(statistics);
        return (totalPrize / (double)purchaseAmount) * 100;
    }

    private static int calculateTotalPrize(Map<LottoRank, Integer> statistics) {
        int total = 0;
        for(LottoRank rank : statistics.keySet()) {
            total +=rank.getPrize() * statistics.get(rank);
        }
        return total;
    }
}
