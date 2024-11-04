package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    public static int getPurchaseAmount() {
        int amount = 0;
        while (true) {
            Messenger.howMuchPay();
            String inputPurchaseAmount = Console.readLine();
            try {
                amount = Validator.checkType(inputPurchaseAmount);
                Validator.checkAmount(amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (true) {
            Messenger.writeWinningNumbers();
            String inputWinningNumbers = Console.readLine();
            Messenger.writePrintln();
            try {
                winningNumbers = Validator.checkAndParse(inputWinningNumbers);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public static int getBonusNumber() {
        int bonusNumber = 0;
        while (true) {
            Messenger.writeBonusNumber();
            String inputBonusNumber = Console.readLine();
            Messenger.writePrintln();
            try {
                bonusNumber = Validator.checkType(inputBonusNumber);
                Validator.checkBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }
}
