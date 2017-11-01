package soo.coder;

public class KiwiJuiceEasy {

  public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int toId[]) {
    for (int i = 0; i < fromId.length; i++) {
      int f = fromId[i];
      int t = toId[i];

      int fromBottle = bottles[f];
      int toCapacitie = capacities[t];
      int toBottle = bottles[t];

      int toExtraSpace = toCapacitie - toBottle;

      if (toExtraSpace >= fromBottle) {
        bottles[f] = 0;
        bottles[t] += fromBottle;
      } else {
        bottles[f] -= toExtraSpace;
        bottles[t] += toExtraSpace;
      }
    }

    return bottles;
  }

  public int[] thePouringRefactor1(int[] capacities, int[] bottles, int[] fromId, int toId[]) {
    for (int i = 0; i < fromId.length; i++) {
      int f = fromId[i];
      int t = toId[i];
      int vol = Math.min(bottles[f], capacities[t] - bottles[t]);

      bottles[f] -= vol;
      bottles[t] += vol;
    }

    return bottles;
  }
}
