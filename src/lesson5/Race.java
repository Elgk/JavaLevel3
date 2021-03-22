package lesson5;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Race {
    private CopyOnWriteArrayList<Stage> stages;

    public Race(Stage...  stages) {
        this.stages = new CopyOnWriteArrayList<>(Arrays.asList(stages));
    }

    public CopyOnWriteArrayList<Stage> getStages() {
        return stages;
    }
}
