package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    public void createQueueWithSizeOfZero() {
        Queue emptyQueue = new Queue(0);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyQueue.arr.length;
        int actualFrontResult = emptyQueue.front;
        int actualRearResult = emptyQueue.rear;

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }

    @Test
    public void createQueueWithNegativeSize() {
        Queue emptyQueue = new Queue(-2);
        int expectedLengthResult = 10;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyQueue.arr.length;
        int actualFrontResult = emptyQueue.front;
        int actualRearResult = emptyQueue.rear;

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }


    @Test
    public void createQueueWithSizeOfTwo() {
        Queue emptyQueue = new Queue(2);
        int expectedLengthResult = 2;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyQueue.arr.length;
        int actualFrontResult = emptyQueue.front;
        int actualRearResult = emptyQueue.rear;

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }

    @Test
    public void addElementInAFullQueue() {
        Queue fullQueue = new Queue(2);
        fullQueue.addRear(1);
        fullQueue.addRear(2);
        boolean actualResult = fullQueue.addRear(3);

        assertFalse(actualResult);
        assertEquals(1, fullQueue.rear);
        assertEquals(0, fullQueue.front);
    }

    @Test
    public void addElementInAnEmptyQueue() {
        Queue queue = new Queue(2);
        boolean actualResult = queue.addRear(10);

        assertTrue(actualResult);
        assertEquals(0, queue.front);
        assertEquals(0, queue.rear);
    }

    @Test
    public void addElementNormalBehavior() {
        Queue queue = new Queue(5);
        queue.addRear(10);
        queue.addRear(15);
        boolean actualResult = queue.addRear(20);

        assertTrue(actualResult);
        assertEquals(0, queue.front);
        assertEquals(2, queue.rear);
    }

    @Test
    public void deleteLastElementFromTheQueue() {
        Queue queue = new Queue(3);
        queue.addRear(10);
        queue.addRear(20);
        queue.addRear(30);
        int expectedResult = 30;

        queue.deleteFront();
        queue.deleteFront();
        int actualResult = queue.deleteFront();

        assertEquals(expectedResult, actualResult);
        assertEquals(-1, queue.front);
        assertEquals(-1, queue.rear);
    }


    @Test
    public void deleteElementFromAnEmptyQueue() {
        Queue emptyQueue = new Queue(1);
        emptyQueue.addRear(10);
        emptyQueue.deleteFront();

        assertThrows(IllegalStateException.class, emptyQueue::deleteFront);
        assertEquals(-1, emptyQueue.front);
        assertEquals(-1, emptyQueue.rear);
    }

    @Test
    public void deleteElementNormalBehavior() {
        Queue queue = new Queue(3);
        queue.addRear(10);
        queue.addRear(20);
        queue.addRear(30);
        int expectedResult = 10;

        int actualResult = queue.deleteFront();

        assertEquals(expectedResult, actualResult);
        assertEquals(1, queue.front);
        assertEquals(2, queue.rear);
    }


    @Test
    public void shouldReturnTheQueueWhenCallToString() {
        Queue queue = new Queue(5);
        for (int i = 0; i < 10; i += 2) {
            queue.addRear(i);
        }
        String expectedResult = "Queue{arr=[0, 2, 4, 6, 8]}";

        String actualResult = queue.toString();

        assertEquals(expectedResult, actualResult);
    }
}