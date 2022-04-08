public class TennisGame {


    private String player1;
    private String player2;

    private final String[] GAME_STRINGS = {"Love", "Fifteen", "Thirty", "Forty"};
    private final String[] GAME_STATE_STRINGS = {"Advantage player1", "Advantage player2",
            "Win for player1", "Win for player2"};


    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore(int mScore1, int mScore2) {
        if (mScore1 == mScore2) {
           return scoreIsEqualString(mScore1);
        }
        else if (mScore1 >= 4 || mScore2 >= 4) {
           return playerHasFourPointsOrMoreString(mScore1, mScore2);
        }
        else return alternativeSituationString(mScore1, mScore2);
    }

    //geval gelijke score
    private String scoreIsEqualString(int mScore1) {
        if (mScore1 < 0 || mScore1 > 3) return "Deuce";
        else return GAME_STRINGS[mScore1] + "-All";
    }

    //in het geval 1 van de spelers gelijk aan of meer dan 4 punten heeft
    private String playerHasFourPointsOrMoreString(int mScore1, int mScore2) {
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) return GAME_STATE_STRINGS[0];
        else if (minusResult == -1) return GAME_STATE_STRINGS[1];
        else if (minusResult >= 2) return GAME_STATE_STRINGS[2];
        return GAME_STATE_STRINGS[3];
    }

    //een andere situatie, deze (vreemde) loop plakt scores van beide spelers aan elkaar
    //maar het ging om het refactoren ;P
    private String alternativeSituationString(int mScore1, int mScore2) {
        String scoreInWords = "";
        String addScore = "-";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = mScore1;
            else {
                scoreInWords = scoreInWords.concat(addScore);
                tempScore = mScore2;
            }
            scoreInWords = scoreInWords.concat(tempScoreConcatString(tempScore));
        }
        return scoreInWords;
    }

    //hulpje van bovenstaande methode
    private String tempScoreConcatString(int tempScore) {
        return GAME_STRINGS[tempScore];
    }


}
