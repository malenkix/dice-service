package io.github.malenkix.diceservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DiceServiceTest {

  private DiceService diceService;

  @Before
  public void before() {
    this.diceService = new DiceService(1);
  }

  @Test
  public void testRollSomeDicesShouldGiveResults() {
    final int[][] result = diceService.roll(2, 3, 20);
    assertEquals("[[6, 9, 8], [14, 15, 5]]", Arrays.deepToString(result));
  }

  @Test
  public void testIllegalArgumentsShouldGiveError() {
    assertIllegalRun(-1, 1, 2);
    assertIllegalRun(1, -1, 2);
    assertIllegalRun(1, 1, -1);
    assertIllegalRun(0, 1, 2);
    assertIllegalRun(1, 0, 2);
    assertIllegalRun(1, 1, 1);
  }

  private void assertIllegalRun(int runs, int dices, int sides) {
    try {
      diceService.roll(runs, dices, sides);
      fail(String.format("Expected arguments to be rejected. (rolls=%s, dices=%s, sides=%s)", runs, dices, sides));
    } catch (IllegalArgumentException ex) {
    }
  }
}
