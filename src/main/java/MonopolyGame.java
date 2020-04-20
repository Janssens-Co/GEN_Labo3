/**
 *  _____ _____ _   _       _      ___ ______ _____ _____
 * |  __ |  ___| \ | |  _  | |    / _ \| ___ |  _  |____ |
 * | |  \| |__ |  \| | (_) | |   / /_\ | |_/ | | | |   / /
 * | | __|  __|| . ` |     | |   |  _  | ___ | | | |   \ \
 * | |_\ | |___| |\  |  _  | |___| | | | |_/ \ \_/ .___/ /
 *  \____\____/\_| \_/ (_) \_____\_| |_\____/ \___/\____/
 *
 * AUTHORS : Mattei Simon, Janssens Emmanuel, Potet Bastien
 */

public class MonopolyGame {

    
    private int roundCnt;
    private final int N = 20;
    private Player[] players;
    private Cup diceCup;
    private Board board;
    
    public MonopolyGame() {
        roundCnt = 0;

        players = new Player[]{new Player("Simon"),new Player("Bastien"),new Player("Emmanuel")};
        diceCup = new Cup(2);
        board = new Board();
    }

    public void playGame() {
        while(roundCnt < N){
            playRound();
            roundCnt++;
        }
    }

    private void playRound(){
        System.out.println("===Round #" + (roundCnt + 1) + "===");
        for(Player p : players)
            p.takeTurn(diceCup,board);

    }
}
