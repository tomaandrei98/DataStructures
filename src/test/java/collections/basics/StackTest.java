package collections.basics;

import collections.basics.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void createStackWithSizeOfZero() {
        Stack emptyStack = new Stack(0);
        int expectedLenResult = 0;
        int expectedLengthResult = 0;
        int expectedTopResult = -1;

        int actualLenResult = emptyStack.getLen();
        int actualLengthResult = emptyStack.getArr().length;
        int actualTopResult = emptyStack.getTop();

        assertEquals(expectedLenResult, actualLenResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedTopResult, actualTopResult);
    }

    @Test
    public void createStackWithNegativeSize() {
        Stack emptyStack = new Stack(-2);
        int expectedLenResult = 10;
        int expectedLengthResult = 10;
        int expectedTopResult = -1;

        int actualLenResult = emptyStack.getLen();
        int actualLengthResult = emptyStack.getArr().length;
        int actualTopResult = emptyStack.getTop();

        assertEquals(expectedLenResult, actualLenResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedTopResult, actualTopResult);
    }

    @Test
    public void createStackWithSizeOfTwo() {
        Stack emptyStack = new Stack(2);
        int expectedLenResult = 2;
        int expectedLengthResult = 2;
        int expectedTopResult = -1;

        int actualLenResult = emptyStack.getLen();
        int actualLengthResult = emptyStack.getArr().length;
        int actualTopResult = emptyStack.getTop();

        assertEquals(expectedLenResult, actualLenResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedTopResult, actualTopResult);
    }

    @Test
    public void shouldReturnFalseForPushingAnElementInAFullStack() {
        Stack stack = new Stack(0);
        boolean actualResult = stack.push(10);

        assertFalse(actualResult);
    }

    @Test
    public void shouldReturnTrueForPushingAnElementInAStack() {
        Stack stack = new Stack(2);
        boolean actualResult = stack.push(10);

        assertTrue(actualResult);
        assertEquals(stack.getTop(), 0);
    }

    @Test
    public void shouldThrowExceptionForPoppingAnElementFromAnEmptyStack() {
        Stack stack = new Stack(0);

        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    public void shouldReturnTheSingleElementFromTheStackWhenPop() {
        Stack stack = new Stack(2);
        stack.push(10);
        int expectedResult = 10;

        int actualResult = stack.pop();

        assertEquals(expectedResult, actualResult);
        assertEquals(stack.getTop(), -1);
    }


    @Test
    public void shouldReturnTheLastElementFromTheStackWhenPop() {
        Stack stack = new Stack(5);
        for (int i = 0; i < 10; i += 2) {
            stack.push(i);
        }
        int expectedResult = 8;

        int actualResult = stack.pop();

        assertEquals(expectedResult, actualResult);
        assertEquals(stack.getTop(), 3);
    }

    @Test
    public void shouldReturnTheSecondLastElementFromTheStackWhenPopTwice() {
        Stack stack = new Stack(5);
        for (int i = 0; i < 10; i += 2) {
            stack.push(i);
        }
        int expectedResult = 6;

        stack.pop();
        int actualResult = stack.pop();

        assertEquals(expectedResult, actualResult);
        assertEquals(stack.getTop(), 2);
    }

    @Test
    public void shouldReturnTheStackWhenCallToString() {
        Stack stack = new Stack(5);
        for (int i = 0; i < 10; i += 2) {
            stack.push(i);
        }
        String expectedResult = "Stack{arr=[0, 2, 4, 6, 8]}";

        String actualResult = stack.toString();

        assertEquals(expectedResult, actualResult);
    }


}