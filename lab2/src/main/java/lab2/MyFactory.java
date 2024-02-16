package lab2;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;

import java.util.Random;

public class MyFactory extends AbstractCandidateFactory<double[]> {

    private int dimension;

    public MyFactory(int dimension) {
        this.dimension = dimension;
    }

    public double[] generateRandomCandidate(Random random) {
        double[] solution = new double[dimension];
        // x from -5.0 to 5.0
        double rangeMin = -5.0;
        double rangeMax = 5.0;
        for (int i = 0; i < dimension; i++) {
            solution[i] = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        }
        return solution;
    }
}

