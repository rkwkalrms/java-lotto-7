package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static int checkType(String inputPurchaseAmountOrBonus) {
        try {
            int amountOrBonus = Integer.parseInt(inputPurchaseAmountOrBonus);
            return amountOrBonus;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(Messenger.NOT_NUMBER_TYPE);
        }
    }

    public static void checkAmount(int amount) {
        checkMinus(amount);
        checkDivibleByThousand(amount);
    }

    private static void checkDivibleByThousand(int amount) {
        if(amount%1000 !=0){
            throw new IllegalArgumentException(Messenger.NOT_DIVISIBLE_BY_1000);
        }
    }

    private static void checkMinus(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(Messenger.NEGATIVE_NUMBER);
        }
    }

    public static List<Integer> checkAndParse(String inputWinningNumbers) {
        String[] winningNumbers = getWinningNumbers(inputWinningNumbers);
        checkWinningNumbers(winningNumbers);

        List<Integer> winningNumberList = new ArrayList<>();
        for(String num : winningNumbers) {
            winningNumberList.add(Integer.parseInt(num));
        }
        return winningNumberList;
    }

    private static String[] getWinningNumbers(String inputWinningNumbers) {
        String[] winningNumbers = inputWinningNumbers.replace(" ", "").split(",");
        return winningNumbers;
    }

    public static void checkWinningNumbers(String[] winningNumbers) {
        checkLength(winningNumbers);
        checkWinningNumberType(winningNumbers);
        checkDuplicates(winningNumbers);
        checkMinusNumbers(winningNumbers);
        checkRange(winningNumbers);
    }

    private static void checkLength(String[] winningNumbers) {
        if(winningNumbers.length != 6) {
            throw new IllegalArgumentException(Messenger.NOT_SIX_WINNING_NUMBER);
        }
    }

    private static void checkWinningNumberType(String[] winningNumbers) {
        for(String num : winningNumbers) {
            try{
                Integer.parseInt(num);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException(Messenger.NOT_NUMBER_TYPE + num);
            }
        }
    }

    private static void checkDuplicates(String[] winningNumbers) {
        Set<String> uniqueNumbers = new HashSet<>();
        for(String num : winningNumbers) {
            if(!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException(Messenger.DUPLICATE_NUMBER + num);
            }
        }
    }

    private static void checkMinusNumbers(String[] winningNumbers) {
        for(String num : winningNumbers) {
            int number = Integer.parseInt(num);
            if(number < 0) {
                throw new IllegalArgumentException(Messenger.NEGATIVE_NUMBER + number);
            }
        }
    }

    private static void checkRange(String[] winningNumbers) {
        for(String num : winningNumbers) {
            int number = Integer.parseInt(num);
            if(number <= 1 || number >= 45) {
                throw new IllegalArgumentException(Messenger.OUT_OF_RANGE + number);
            }
        }
    }

    public static void checkBonusNumber(int bonusNumber) {
        checkMinus(bonusNumber);
        checkBonusRange(bonusNumber);
    }

    private static void checkBonusRange(int bonusNumber) {
        if(bonusNumber <= 1 || bonusNumber >= 45) {
            throw new IllegalArgumentException(Messenger.OUT_OF_RANGE + bonusNumber);
        }
    }
}
