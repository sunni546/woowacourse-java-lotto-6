package lotto.controller;

import static lotto.view.message.SystemMessage.INPUT_BONUS;
import static lotto.view.message.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.view.message.SystemMessage.INPUT_WINNING_LOTTO;
import static lotto.view.message.SystemMessage.OUTPUT_PURCHASE_AMOUNT;
import static lotto.view.message.SystemMessage.OUTPUT_RESULT;

import java.util.HashMap;
import lotto.RankType;
import lotto.domain.Referee;
import lotto.domain.Win;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.message.RankMessage;

public class GameController {
    public void run() {
        int purchaseAmount = readPurchaseAmount();
        LottoController lottoController = new LottoController(purchaseAmount);
        printLottoAmountAndLottos(lottoController);

        Win win = new Win();
        win.setWinningLotto(readWinningLotto());
        win.setBonus(readBonus());

        Referee referee = new Referee();
        referee.compare(lottoController.getLottos(), win.getWinningLotto(), win.getBonus());
        printResult(referee);
        makeRateOfReturn(referee, purchaseAmount);
    }

    private static int readPurchaseAmount() {
        OutputView.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());
        return Integer.parseInt(InputView.read());
    }

    private void printLottoAmountAndLottos(LottoController lottoController) {
        OutputView.printMessage(String.format(OUTPUT_PURCHASE_AMOUNT.getMessage(), lottoController.getLottoAmount()));
        lottoController.printLottos();
    }

    private static String readWinningLotto() {
        OutputView.printMessage(INPUT_WINNING_LOTTO.getMessage());
        return InputView.read();
    }

    private static int readBonus() {
        OutputView.printMessage(INPUT_BONUS.getMessage());
        return Integer.parseInt(InputView.read());
    }

    private void printResult(Referee referee) {
        OutputView.printMessage(OUTPUT_RESULT.getMessage());

        HashMap<Integer, Integer> result = referee.getResult();
        for (int i = 5; i > 0; i--) {
            String rankResult = String.format(RankMessage.findByRank(i).getMessage(), result.get(i));
            OutputView.printMessage(rankResult);
        }
    }

    private float makeRateOfReturn(Referee referee, int purchaseAmount) {
        HashMap<Integer, Integer> result = referee.getResult();
        return (makeTotalReturn(result) / purchaseAmount) * 100;
    }

    private float makeTotalReturn(HashMap<Integer, Integer> result) {
        float totalReturn = 0;
        for (int i = 5; i > 0; i--) {
            totalReturn += RankType.findByRank(i).getPrice() * result.get(i);
        }
        return totalReturn;
    }
}
