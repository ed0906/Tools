package algorithm.machine.learning;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.matrix.Matrix;

public class GradientDescentTest {

	private final static double FLOAT_ERROR = 0.1;
	private final static double EXCEPTABLE_ERROR = 0.3;
	private GradientDescent api;

	@Before
	public void setUp() {
		Matrix x = new Matrix(2, 3);

		// x0
		x.set(0, 0, 1);
		x.set(0, 1, 1);
		x.set(0, 2, 1);

		// x1
		x.set(1, 0, 1);
		x.set(1, 1, 2);
		x.set(1, 2, 3);

		Matrix y = new Matrix(1, 3);
		y.set(0, 0, 1);
		y.set(0, 1, 2);
		y.set(0, 2, 3);

		api = new GradientDescent(x, y);
	}

	@Test
	public void shouldStartWithZeroHypothesis() {
		Hypothesis h = api.getHypothesis();
		Matrix theta = h.getWeights();

		assertEquals(0, theta.get(0, 0), FLOAT_ERROR);
		assertEquals(0, theta.get(1, 0), FLOAT_ERROR);
	}

	@Test
	public void shouldFindLinearFit() {
		Hypothesis h = api.getMinimizedHypothesis();
		Matrix theta = h.getWeights();
		
		assertEquals(0, theta.get(0, 0), EXCEPTABLE_ERROR);
		assertEquals(1, theta.get(1, 0), EXCEPTABLE_ERROR);
	}
}