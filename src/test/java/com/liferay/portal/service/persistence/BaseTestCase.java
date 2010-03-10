package com.liferay.portal.service.persistence;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.test.TestCase;
import com.liferay.portal.util.InitUtil;
import com.liferay.util.PwdGenerator;

import java.util.Date;
import java.util.Random;

/**
 * <a href="BaseTestCase.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 * @author Ganesh Ram
 *
 */
public class BaseTestCase extends TestCase {

	public BaseTestCase() {
		if (System.getProperty("external-properties") == null) {
			System.setProperty("external-properties", "portal-test.properties");
		}

		InitUtil.initWithSpring();
	}

	protected Date nextDate() throws Exception {
		return new Date();
	}

	protected double nextDouble() throws Exception {
		return CounterLocalServiceUtil.increment();
	}

	protected int nextInt() throws Exception {
		return (int)CounterLocalServiceUtil.increment();
	}

	protected long nextLong() throws Exception {
		return CounterLocalServiceUtil.increment();
	}

	protected boolean randomBoolean() throws Exception {
		return _random.nextBoolean();
	}

	protected String randomString() throws Exception {
		return PwdGenerator.getPassword();
	}

	private Random _random = new Random();

}