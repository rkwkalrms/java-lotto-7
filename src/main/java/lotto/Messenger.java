package lotto;

public class Messenger {
    public static final String PAY_MONEY = "구입금액을 입력해 주세요.";

    public static final String WRITE_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static final String WRITE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String NOT_NUMBER_TYPE = "[ERROR] 유효하지 않은 입력입니다. 다시 입력해주세요.";

    public static final String NEGATIVE_NUMBER = "[ERROR] 음수는 입력할 수 없습니다. 양수를 입력하세요.";

    public static final String NOT_DIVISIBLE_BY_1000 = "[ERROR] 1000으로 나누어 떨어져야 합니다.";

    public static final String NOT_SIX_WINNING_NUMBER = "[ERROR] 당첨 번호는 6개여야 합니다.";

    public static final String DUPLICATE_NUMBER = "[ERROR] 중복되는 당첨 번호가 있습니다.";

    public static final String OUT_OF_RANGE = "[ERROR] 범위를 벗어난 번호입니다.";

    public static void howMuchPay() { System.out.println(PAY_MONEY); }

    public static void writeWinningNumbers() { System.out.println(WRITE_WINNING_NUMBERS) ;}

    public static void writeBonusNumber() { System.out.println(WRITE_BONUS_NUMBER); }

    public static void notNumberType() { System.out.println(NOT_NUMBER_TYPE); }

    public static void writePrintln() { System.out.println(); }
}
