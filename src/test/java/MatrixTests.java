import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MatrixTests {
    private static long startTime;
    private long testStartTime;
    private final int sutSize = 8;
    Matrix sut = new Matrix(sutSize);

    @BeforeAll
    public static void init() {
        System.out.println("Testing started");
        startTime = System.nanoTime();
    }

    @AfterAll
    public static void completedAll() {
        System.out.println("All tests completed in " + (System.nanoTime() - startTime));
    }

    @BeforeEach
    public void startTest() {
        System.out.println("Test started");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void testCompleted() {
        System.out.println("Test completed in " + (System.nanoTime() - testStartTime));
    }

    @Test
    public void matrixTest() {
        assertThat(sut, notNullValue());
    }

    @Test
    public void amountOfElementsTest() {
        assertThat((sutSize * sutSize),equalTo(sut.amountOfElements()));
    }

    @Test
    public void rotate90Test() {
        int[][] basic = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4}
        };
        int[][] expected = {
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
                {4, 3, 2, 1, 0},
        };
        assertThat(sut.rotate90(basic), equalTo(expected));
    }

    @Test
    public void rotate180Test() {
        int[][] basic = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4}
        };
        int[][] expected = {
                {4, 4, 4, 4, 4},
                {3, 3, 3, 3, 3},
                {2, 2, 2, 2, 2},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
        };
        assertThat(sut.rotate180(basic), equalTo(expected));
    }

    @Test
    public void rotate270Test() {
        int[][] basic = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4}
        };
        int[][] expected = {
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
                {0, 1, 2, 3, 4},
        };
        assertThat(sut.rotate270(basic), equalTo(expected));
    }

    @Test
    public void getFirstNumTest() {
        int[][] basic = sut.getMatrix();
        assertThat(basic[0][0], equalTo(sut.getFirstNum()));
    }

    @Test
    public void getLastNumTest() {
        int[][] basic = sut.getMatrix();
        assertThat(basic[0][0], equalTo(sut.getFirstNum()));
    }

    @Test
    public void getMatrixTest() {
        assertThat(sut.getMatrix(), not(emptyArray()));
    }

    @Test
    public void getMatrixSize() {
        int[][] basic = new int[5][5];
        assertThat(sut.getSIZE(basic), is(equalTo(5)));
    }

    @Test
    public void classTest() {
        Matrix matrix = new Matrix(5);
        assertThat(matrix, instanceOf(Matrix.class));
        assertThat(matrix, isA(Matrix.class));
    }
}