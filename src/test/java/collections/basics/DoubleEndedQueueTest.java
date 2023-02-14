package collections.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    @Test
    public void createDoubleEndedQueueWithSizeOfZero() {
        DoubleEndedQueue emptyDoubleEndedQueue = new DoubleEndedQueue(0);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyDoubleEndedQueue.getArr().length;
        int actualFrontResult = emptyDoubleEndedQueue.getFront();
        int actualRearResult = emptyDoubleEndedQueue.getRear();

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }

    @Test
    public void createDoubleEndedQueueWithNegativeSize() {
        DoubleEndedQueue emptyDoubleEndedQueue = new DoubleEndedQueue(-2);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyDoubleEndedQueue.getArr().length;
        int actualFrontResult = emptyDoubleEndedQueue.getFront();
        int actualRearResult = emptyDoubleEndedQueue.getRear();

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }


    @Test
    public void createDoubleEndedQueueWithSizeOfTwo() {
        DoubleEndedQueue emptyDoubleEndedQueue = new DoubleEndedQueue(2);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyDoubleEndedQueue.getArr().length;
        int actualFrontResult = emptyDoubleEndedQueue.getFront();
        int actualRearResult = emptyDoubleEndedQueue.getRear();

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }

    @Test
    public void addRearElementInAFullDoubleEndedQueue() {
        DoubleEndedQueue fullDoubleEndedQueue = new DoubleEndedQueue(2);
        fullDoubleEndedQueue.addRear(1);
        fullDoubleEndedQueue.addRear(2);
        boolean actualResult = fullDoubleEndedQueue.addRear(3);

        assertFalse(actualResult);
        assertEquals(1, fullDoubleEndedQueue.getRear());
        assertEquals(0, fullDoubleEndedQueue.getFront());
    }

    @Test
    public void addRearElementInAnEmptyDoubleEndedQueue() {
        DoubleEndedQueue emptyDoubleEndedQueue = new DoubleEndedQueue(1);
        boolean addRear = emptyDoubleEndedQueue.addRear(10);
        int[] expectedResult = {10};
        int[] actualResult = emptyDoubleEndedQueue.getArr();

        assertTrue(addRear);
        assertEquals(0, emptyDoubleEndedQueue.getFront());
        assertEquals(0, emptyDoubleEndedQueue.getRear());
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void addRearElementInAnNormalDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(5);
        doubleEndedQueue.addRear(10);
        doubleEndedQueue.addRear(20);
        doubleEndedQueue.addRear(15);
        int[] expectedResult = {10, 20, 15};
        int[] actualResult = doubleEndedQueue.getArr();

        assertEquals(0, doubleEndedQueue.getFront());
        assertEquals(2, doubleEndedQueue.getRear());
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void addFrontElementInAFullDoubleEndedQueue() {
        DoubleEndedQueue fullDoubleEndedQueue = new DoubleEndedQueue(2);
        fullDoubleEndedQueue.addFront(20);
        boolean actualResult = fullDoubleEndedQueue.addFront(10);

        assertFalse(actualResult);
        assertEquals(0, fullDoubleEndedQueue.getFront());
        assertEquals(0, fullDoubleEndedQueue.getRear());
    }

    @Test
    public void addFrontElementInAnEmptyDoubleEndedQueue() {
        DoubleEndedQueue emptyDoubleEndedQueue = new DoubleEndedQueue(2);
        boolean addFront = emptyDoubleEndedQueue.addFront(10);
        int[] expectedResult = {10};

        int[] actualResult = emptyDoubleEndedQueue.getArr();

        assertTrue(addFront);
        assertEquals(0, emptyDoubleEndedQueue.getFront());
        assertEquals(0, emptyDoubleEndedQueue.getRear());

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void addFrontElementInANormalDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(3);
        doubleEndedQueue.addRear(10);
        doubleEndedQueue.addRear(5);
        doubleEndedQueue.deleteFront();
        doubleEndedQueue.addFront(50);
        int[] expectedResult = {50, 5};

        int[] actualResult = doubleEndedQueue.getArr();
        assertArrayEquals(expectedResult, actualResult);
        assertEquals(0, doubleEndedQueue.getFront());
        assertEquals(1, doubleEndedQueue.getRear());
    }

    @Test
    public void deleteFrontEmptyDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(5);
        assertThrows(IllegalStateException.class, doubleEndedQueue::deleteFront);
    }

    @Test
    public void deleteFrontLastElementInDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(1);
        doubleEndedQueue.addFront(10);
        int actualResult = doubleEndedQueue.deleteFront();

        assertEquals(10, actualResult);
        assertEquals(-1, doubleEndedQueue.getFront());
        assertEquals(-1, doubleEndedQueue.getRear());
        assertArrayEquals(new int[0], doubleEndedQueue.getArr());
    }

    @Test
    public void deleteFrontNormalElementInDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(3);
        doubleEndedQueue.addFront(10);
        doubleEndedQueue.addRear(15);
        doubleEndedQueue.addRear(20);

        int actualResult = doubleEndedQueue.deleteFront();
        doubleEndedQueue.addFront(5);

        assertEquals(10, actualResult);
        assertEquals(0, doubleEndedQueue.getFront());
        assertEquals(2, doubleEndedQueue.getRear());
        assertArrayEquals(new int[] {5, 15, 20}, doubleEndedQueue.getArr());
    }

    @Test
    public void deleteRearEmptyDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(5);
        assertThrows(IllegalStateException.class, doubleEndedQueue::deleteRear);
    }

    @Test
    public void deleteRearLastElementInDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(1);
        doubleEndedQueue.addRear(10);
        int actualResult = doubleEndedQueue.deleteRear();

        assertEquals(10, actualResult);
        assertEquals(-1, doubleEndedQueue.getFront());
        assertEquals(-1, doubleEndedQueue.getRear());
        assertArrayEquals(new int[0], doubleEndedQueue.getArr());
    }


    @Test
    public void deleteRearNormalElementInDoubleEndedQueue() {
        DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue(3);
        doubleEndedQueue.addFront(10);
        doubleEndedQueue.addRear(15);
        doubleEndedQueue.addRear(20);

        int actualResult = doubleEndedQueue.deleteRear();

        assertEquals(20, actualResult);
        assertEquals(0, doubleEndedQueue.getFront());
        assertEquals(1, doubleEndedQueue.getRear());
        assertArrayEquals(new int[] {10, 15}, doubleEndedQueue.getArr());
    }
}