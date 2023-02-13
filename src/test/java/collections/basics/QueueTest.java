package collections.basics;

import collections.basics.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    public void createQueueWithSizeOfZero() {
        Queue emptyQueue = new Queue(0);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyQueue.getArr().length;
        int actualFrontResult = emptyQueue.getFront();
        int actualRearResult = emptyQueue.getRear();

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

        int actualLengthResult = emptyQueue.getArr().length;
        int actualFrontResult = emptyQueue.getFront();
        int actualRearResult = emptyQueue.getRear();

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

        int actualLengthResult = emptyQueue.getArr().length;
        int actualFrontResult = emptyQueue.getFront();
        int actualRearResult = emptyQueue.getRear();

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
        assertEquals(1, fullQueue.getRear());
        assertEquals(0, fullQueue.getFront());
    }

    @Test
    public void addElementInAnEmptyQueue() {
        Queue queue = new Queue(2);
        boolean actualResult = queue.addRear(10);

        assertTrue(actualResult);
        assertEquals(0, queue.getFront());
        assertEquals(0, queue.getRear());
    }

    @Test
    public void addElementNormalBehavior() {
        Queue queue = new Queue(5);
        queue.addRear(10);
        queue.addRear(15);
        boolean actualResult = queue.addRear(20);

        assertTrue(actualResult);
        assertEquals(0, queue.getFront());
        assertEquals(2, queue.getRear());
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
        assertEquals(-1, queue.getFront());
        assertEquals(-1, queue.getRear());
    }


    @Test
    public void deleteElementFromAnEmptyQueue() {
        Queue emptyQueue = new Queue(1);
        emptyQueue.addRear(10);
        emptyQueue.deleteFront();

        assertThrows(IllegalStateException.class, emptyQueue::deleteFront);
        assertEquals(-1, emptyQueue.getFront());
        assertEquals(-1, emptyQueue.getRear());
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
        assertEquals(1, queue.getFront());
        assertEquals(2, queue.getRear());
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