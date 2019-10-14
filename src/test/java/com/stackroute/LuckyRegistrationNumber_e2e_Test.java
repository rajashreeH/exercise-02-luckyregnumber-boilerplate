package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.stackroute.LuckyRegistrationNumber;

@RunWith(Parameterized.class)
public class LuckyRegistrationNumber_e2e_Test {

	private static final String MSG_01 = "Should print Lucky Registration Number for the given input";
	private static final String MSG_02 = "Should print Valid Registration Number for the given input";
	private static final String MSG_03 = "Should print Invalid Registration Number for the given input";

	private static final String LUCKY = "Lucky Registration Number";
	private static final String VALID = "Valid Registration Number";
	private static final String INVALID = "Invalid Registration Number";

	private PrintStream out;
	private ByteArrayOutputStream myOutStream;
	private InputStream in;
	private ByteArrayInputStream myInputStream;

	private String inputRegNo;
	private String expected;
	private String message;

	public LuckyRegistrationNumber_e2e_Test(String inputRegNo, String expected, String message) {
		this.inputRegNo = inputRegNo;
		this.expected = expected;
		this.message = message;
	}

	@Before
	public void setUp() {
		in = System.in;
		out = System.out;
		myOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOutStream));
	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Parameters(name = "{index}: Main Method Input ({0}) - Should display ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "KA01MG2130", LUCKY, MSG_01 });
		params.add(new Object[] { "KA09GG1234", VALID, MSG_02 });
		params.add(new Object[] { "KA01GM0839", INVALID, MSG_03 });
		return params;
	}

	@Test
	public void testLuckyRegistrationNumber_e2e() {
		myInputStream = new ByteArrayInputStream(inputRegNo.getBytes());
		System.setIn(myInputStream);

		LuckyRegistrationNumber.main(null);
		String actual = myOutStream.toString().replaceAll("\\s+", "");

		assertThat(message, actual, is(expected.replaceAll("\\s+", "")));
	}
}