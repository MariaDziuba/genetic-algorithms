package lab5;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {

    public List<double[]> apply(List<double[]> population, Random random) {
        int dimension = population.get(0).length;
        double rangeMin = -5.0;
        double rangeMax = 5.0;
        for (double[] ind : population){
            for (int i = 0; i < dimension; i++) {
                if (random.nextDouble() < 0.01) {
                    ind[i] = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                }
            }
        }
        return population;
    }
}
