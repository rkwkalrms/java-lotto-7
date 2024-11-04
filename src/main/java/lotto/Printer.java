package lotto;

import java.util.List;
import java.util.Map;

public class Printer {
    public static void printTickets(List<Lotto> tickets) {
        System.out.printf("%d개를 구매했습니다.%n", tickets.size());
        for(Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
        Messenger.writePrintln();
    }

    public static void printStatistics(Map<LottoRank, Integer> statistics, double earningRate) {
        System.out.println("당첨 통계 \n---");
        for(LottoRank rank : LottoRank.values()) {
            int count = statistics.getOrDefault(rank, 0);
            printStatistic(rank, count);
        }
        System.out.printf("총 수익률은 %.2f%%입니다.\n", earningRate);
    }

    private static void printStatistic(LottoRank rank, int count) {
        System.out.printf("%d개 일치 (%,d원) - %d개\n", rank.getMatchCount(), rank.getPrize(), count);
    }
}
