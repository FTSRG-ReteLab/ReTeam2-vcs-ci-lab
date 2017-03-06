package hu.bme.mit.train.controller;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TachoGraph extends TrainControllerImpl {
    public Table<Integer, Integer, Integer> tachoGraph = HashBasedTable.create();

    public TachoGraph(Integer currentTime, Integer joystickPos, Integer referenceSpeed) {
        this.tachoGraph.put(currentTime, joystickPos, referenceSpeed);
    }

    public boolean empty() {
        return tachoGraph.isEmpty();
    }
}
