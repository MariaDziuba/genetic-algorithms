package lab5;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected double[] doArithmeticCrossover(double[] p1, double[] p2, int i, Random random, double alpha) {
        int dimension = p1.length;
        ArrayList<Integer> crossover_points = new ArrayList<>(Collections.nCopies(i, 0));
        int j = 0;
        while (j < i) {
            int rnd = random.nextInt(dimension);
            if (!crossover_points.contains(rnd)) {
                crossover_points.set(j, rnd);
                j++;
            }
        }

        double[] c1 = new double[dimension];
        System.arraycopy(p1, 0, c1, 0, dimension);
        for (int k: crossover_points) {
            c1[k] = alpha * p1[k] + (1 - alpha) * p2[k];
        }

        return c1;
    }
    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList<double[]> children = new ArrayList<>();
        double alpha = 0.45;
        children.add(doArithmeticCrossover(p2, p1, i, random, alpha));
        children.add(doArithmeticCrossover(p1, p2, i, random, alpha));
        return children;
    }
}
