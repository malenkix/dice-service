package io.github.malenkix.diceservice;

import static org.junit.Assert.assertEquals;

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
}
