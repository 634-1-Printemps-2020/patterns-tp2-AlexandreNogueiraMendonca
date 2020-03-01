package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    private float moyenne;
    private int plusPetit;
    private int plusGrand;
    private int total;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
        history.put(player, null);
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
        moyenne = 0;
        plusPetit = Integer.MAX_VALUE;
        plusGrand = Integer.MIN_VALUE;
        coin = coin.getInstance();
        rules = rules.getInstance();
        List<CoinState> lCoinState;
        for (Player p : history.keySet()) {
            lCoinState = new ArrayList<>();
            while (rules.checkWin(lCoinState) == false){
                p.play(coin);
                lCoinState.add(coin.getState());
                total++;
            }
            history.put(p, lCoinState);
            if (lCoinState.size() < plusPetit){
                plusPetit = lCoinState.size();
            }
            if (lCoinState.size() > plusGrand){
                plusGrand = lCoinState.size();
            }
        }
        moyenne = total / history.size();
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
        Statistics stats = new Statistics(moyenne, plusPetit, plusGrand, total);
        return stats;
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      return history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      return history.get(player);
    }

}
