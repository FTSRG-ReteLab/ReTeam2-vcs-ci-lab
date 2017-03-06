package hu.bme.mit.train.system.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.controller.TachoGraph;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.system.TrainSystem;

public class TrainSystemTest {

	TrainController controller;
	TrainSensor sensor;
	TrainUser user;
	TachoGraph tachoGraph;

	@Before
	public void before() {
		TrainSystem system = new TrainSystem();
		controller = system.getController();
		sensor = system.getSensor();
		user = system.getUser();

		sensor.overrideSpeedLimit(50);
	}

	@Test
	public void test1() {
		sensor.overrideSpeedLimit(10);
		Assert.assertEquals(0, controller.getReferenceSpeed());
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		Assert.assertEquals(5, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
		controller.followSpeed();
		Assert.assertEquals(10, controller.getReferenceSpeed());
	}

	@Test
	public void test2() {
		user.overrideJoystickPosition(5);
		controller.followSpeed();
		user.overrideJoystickPosition(-5);
		controller.followSpeed();
		Assert.assertEquals(0, controller.getReferenceSpeed());
	}

	public void test3() {
		sensor.overrideSpeedLimit(15);
		user.overrideJoystickPosition(15);
		controller.followSpeed();
		Assert.assertEquals(15, controller.getReferenceSpeed());
	}

	public void test4() {
		tachoGraph = new TachoGraph(66,35,84);
 		Assert.assertEquals(false, tachoGraph.empty());
	}
}
