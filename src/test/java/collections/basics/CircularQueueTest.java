package collections.basics;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {

    @Test
    public void createCircularQueueWithSizeOfZero() {
        CircularQueue emptyCircularQueue = new CircularQueue(0);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyCircularQueue.getArr().size();
        int actualFrontResult = emptyCircularQueue.getFront();
        int actualRearResult = emptyCircularQueue.getRear();

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }

    @Test
    public void createCircularQueueWithNegativeSize() {
        CircularQueue emptyCircularQueue = new CircularQueue(-2);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyCircularQueue.getArr().size();
        int actualFrontResult = emptyCircularQueue.getFront();
        int actualRearResult = emptyCircularQueue.getRear();

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }


    @Test
    public void createCircularQueueWithSizeOfTwo() {
        CircularQueue emptyCircularQueue = new CircularQueue(2);
        int expectedLengthResult = 0;
        int expectedFrontResult = -1;
        int expectedRearResult = -1;

        int actualLengthResult = emptyCircularQueue.getArr().size();
        int actualFrontResult = emptyCircularQueue.getFront();
        int actualRearResult = emptyCircularQueue.getRear();

        assertEquals(expectedFrontResult, actualFrontResult);
        assertEquals(expectedLengthResult, actualLengthResult);
        assertEquals(expectedRearResult, actualRearResult);
    }

    @Test
    public void addElementInAnEmptyCircularQueue() {
        CircularQueue circularQueue = new CircularQueue(2);
        boolean actualResult = circularQueue.addRear(10);

        assertTrue(actualResult);
        assertEquals(0, circularQueue.getFront());
        assertEquals(0, circularQueue.getRear());
        List<Integer> arr = circularQueue.getArr();
        int[] result = new int[arr.size()];

        int j = 0;
        for (Integer i : arr) {
            result[j] = i;
            j++;
        }

        assertArrayEquals(new int[]{10}, result);
    }


    @Test
    public void addElementInANormalCircularQueue() {
        CircularQueue circularQueue = new CircularQueue(2);
        circularQueue.addRear(5);
        boolean actualResult = circularQueue.addRear(10);

        System.out.println(circularQueue);
        assertTrue(actualResult);
        assertEquals(0, circularQueue.getFront());
        assertEquals(1, circularQueue.getRear());
        List<Integer> arr = circularQueue.getArr();
        int[] result = new int[arr.size()];

        int j = 0;
        for (Integer i : arr) {
            result[j] = i;
            j++;
        }
        assertArrayEquals(new int[]{5, 10}, result);
    }

    @Test
    public void deleteElementInAnEmptyCircularQueue() {
        CircularQueue circularQueue = new CircularQueue(0);

        assertThrows(IllegalStateException.class,
                circularQueue::deleteFront);
    }

    @Test
    public void deleteLastElementInACircularQueue() {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.addRear(10);
        int actualResult = circularQueue.deleteFront();

        assertEquals(10, actualResult);
        assertEquals(-1, circularQueue.getFront());
        assertEquals(-1, circularQueue.getRear());
        List<Integer> arr = circularQueue.getArr();
        int[] result = new int[arr.size()];

        int j = 0;
        for (Integer i : arr) {
            if (circularQueue.getFront() == -1) {
                break;
            }
            result[j] = i;
            j++;
        }
        assertArrayEquals(new int[]{}, result);
    }


    @Test
    public void deleteAnElementInACircularQueue() {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.addRear(10);
        circularQueue.addRear(20);
        circularQueue.addRear(30);
        int actualResult = circularQueue.deleteFront();

        assertEquals(10, actualResult);
        assertEquals(1, circularQueue.getFront());
        assertEquals(2, circularQueue.getRear());
        List<Integer> arr = circularQueue.getArr();
        int[] result = new int[arr.size()];

        int j = 0;
        for (Integer i : arr) {
            result[j] = i;
            j++;
        }
        assertArrayEquals(new int[]{20, 30}, result);
    }


    @Test
    public void addAnElementInAFullCircularQueue() {
        CircularQueue circularQueue = new CircularQueue(2);
        circularQueue.addRear(10);
        circularQueue.addRear(20);
        boolean actualResult = circularQueue.addRear(30);

        assertFalse(actualResult);
        assertEquals(0, circularQueue.getFront());
        assertEquals(1, circularQueue.getRear());
        List<Integer> arr = circularQueue.getArr();
        int[] result = new int[arr.size()];

        int j = 0;
        for (Integer i : arr) {
            result[j] = i;
            j++;
        }
        assertArrayEquals(new int[] {10, 20}, result);
    }

    @Test
    public void addAnElementInANormalCircularQueue() {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.addRear(10);
        circularQueue.addRear(20);
        circularQueue.deleteFront();
        circularQueue.addRear(30);
        circularQueue.addRear(50);

        assertEquals(1, circularQueue.getFront());
        assertEquals(0, circularQueue.getRear());
        System.out.println(circularQueue.getArr());
        List<Integer> arr = circularQueue.getArr();
        int[] result = new int[arr.size()];

        int j = 0;
        for (Integer i : arr) {
            result[j] = i;
            j++;
        }
        assertArrayEquals(new int[]{50, 20, 30}, result);
    }
}