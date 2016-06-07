package ca.ubc.cs.cpsc210.snake.tests.model;

import ca.ubc.cs.cpsc210.snake.model.Cell;
import ca.ubc.cs.cpsc210.snake.model.Food;
import ca.ubc.cs.cpsc210.snake.model.SnakeGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// jUnit tests for Food class
public class FoodTest {
    private Food testFood;
    private Food testFood2;

    @Before
    public void runBefore() {
        testFood = new Food(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
        testFood2 = new Food(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2), Food.INITIAL_NUTRITIONAL_VALUE / 2);
    }

    @Test
    public void testConstructor1() {
        assertEquals(testFood.getPosition(),new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
        assertEquals(testFood.getNutritionalValue(), Food.INITIAL_NUTRITIONAL_VALUE);
    }

    @Test
    public void testConstructor2() {
        assertEquals(testFood2.getPosition(),new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
        assertEquals(testFood2.getNutritionalValue(), Food.INITIAL_NUTRITIONAL_VALUE / 2);
    }

    @Test
    public void testDecay() {
        testFood.decay();
        assertEquals(testFood.getNutritionalValue(), Food.INITIAL_NUTRITIONAL_VALUE - Food.DECAY_AMOUNT);
    }

    @Test
    public void testDecayHalf() {
        final int NUM_DECAY = Food.INITIAL_NUTRITIONAL_VALUE / Food.DECAY_AMOUNT / 2;
        for (int count = 0; count < NUM_DECAY; count++) {
            testFood.decay();
        }

        assertEquals(Food.INITIAL_NUTRITIONAL_VALUE / 2, testFood.getNutritionalValue());
    }

    @Test
    public void testDecayMinimum() {
        while (testFood.getNutritionalValue() > Food.MIN_NUTRITIONAL_VALUE) {
            testFood.decay();
        }
        testFood.decay();

        assertEquals(Food.MIN_NUTRITIONAL_VALUE, testFood.getNutritionalValue());
    }

}