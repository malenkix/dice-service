package io.github.malenkix.diceservice;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiceService {

  private final Random random;

  public DiceService(@Value("${x-random.seed:10121988}") long seed) {
    this.random = new Random(seed);
  }

  public int[][] roll(int runs, int dices, int sides) {
    if (runs < 0 || dices < 0 || sides < 0) {
      throw new IllegalArgumentException(
          String.format("All arguments need to be positive! (rolls=%s, dices=%s, sides=%s)", runs, dices, sides));
    }
    if (runs == 0 || dices == 0 || sides <= 1) {
      throw new IllegalArgumentException(
          String.format("There needs to be at least one run, one dice and two sides. (rolls=%s, dices=%s, sides=%s)",
              runs, dices, sides));
    }
    final int[][] results = new int[runs][dices];
    for (int run = 0; run < runs; run++) {
      for (int dice = 0; dice < dices; dice++) {
        results[run][dice] = roll(sides);
      }
    }
    return results;
  }

  private int roll(int sides) {
    return this.random.nextInt(sides) + 1;
  }
}
