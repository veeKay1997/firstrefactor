public class TennisGame {

    private static final String ADDSCORE = "-";
    private static final String EQUAL_SCORE_DEFAULT = "Deuce";
    private static final String[] GAME_STRINGS = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String[] GAME_STATE_STRINGS = {"Advantage player1", "Advantage player2", "Win for player1",
            "Win for player2"};


    public static String getScore(String player1Name, String player2Name, int mScore1, int mScore2) {
        String score = "";
        int tempScore = 0;
        if (mScore1 == mScore2) {
            score = scoreIsEqualString(mScore1);
        }
        else if (mScore1 >= 4 || mScore2 >= 4) {
            score = scoreAtFourPointsOrMore(mScore1, mScore2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = mScore1;
                else {
                    score = score.concat(ADDSCORE);
                    tempScore = mScore2;
                }
                score = score.concat(tempScoreConcatString(tempScore));
            }
        }
        return score;
    }

    public static String scoreIsEqualString(int mScore1) {
        if (mScore1 < 0 || mScore1 > 3) return EQUAL_SCORE_DEFAULT;
        else return GAME_STRINGS[mScore1] + "-All";
    }

    public static String tempScoreConcatString(int tempscore) {
        return GAME_STRINGS[tempscore];
    }

    public static String scoreAtFourPointsOrMore(int mScore1, int mScore2) {
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) return GAME_STATE_STRINGS[0];
        else if (minusResult == -1) return GAME_STATE_STRINGS[1];
        else if (minusResult >= 2) return GAME_STATE_STRINGS[2];
        return GAME_STATE_STRINGS[3];
    }
}
