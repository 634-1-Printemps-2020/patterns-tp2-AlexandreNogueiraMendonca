package game;

import materials.Coin;
import materials.CoinState;

import java.util.List;

public class Rules {

  private static Rules instance = null;

  public Rules() {
  }

  public static Rules getInstance(){
    if (instance == null){
      instance = new Rules();
    }
    return instance;
  }

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    int nbPile = 0;
    if (states.size() < 2) { return false;}
    for (int i = 0; i<states.size(); i++){
      if (states.get(i).equals(CoinState.HEADS)){
        nbPile++;
        if (nbPile == 3){
          return true;
        }
      } else {
        nbPile = 0;
      }
    }
    return false;
  }
}
