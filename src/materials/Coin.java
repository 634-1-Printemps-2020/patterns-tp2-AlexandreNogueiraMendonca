package materials;

import java.util.Random;

public class Coin {

  private static Coin instance = null;

  private CoinState coinState;

  private Coin() {
  }

  public static Coin getInstance(){
    if (instance == null){
      instance = new Coin();
    }
    return instance;
  }

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    Random random = new Random();
    if (random.nextBoolean()) {
      coinState = CoinState.HEADS;
    } else {
      coinState = CoinState.TAILS;
    }
    //coinState = CoinState.HEADS;
  }

  public CoinState getState() {
    return coinState;
  }


}
