package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LuckyRegistrationNumberTest {

	private static final String MSG_01 = "Return value for Lucky registration number should be 1. Check whether all rules for Lucky Reg Number are implemented";
	private static final String MSG_02 = "Return value for Valid registration number should be 0. Check whether all rules for Valid Reg Number are implemented";
	private static final String MSG_03 = "Return value for Invalid registration number should be -1. Check whether all rules for Valid Reg Number are implemented";

	private String inputRegNo;
	private int expected;
	private String message;

	public LuckyRegistrationNumberTest(String inputRegNo, int expected, String message) {
		this.inputRegNo = inputRegNo;
		this.expected = expected;
		this.message = message;
	}

	@Parameters(name = "{index}: checkRegistrationNumber({0}) - Should Return ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "KA06MM2005", 0, MSG_01 });
		params.add(new Object[] { "DL01GM8826", 1, MSG_02 });
		params.add(new Object[] { "KA11ZZ3333", -1, MSG_03 });
		return params;
	}

	@Test
	public void testCheckRegistrationNumber() {
		assertThat(message, LuckyRegistrationNumber.checkRegistrationNumber(inputRegNo), is(expected));
	}
}