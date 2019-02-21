package com.david.optional.demo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalDemoTests {



	@Test(expected = NoSuchElementException.class)
	public void whenOptionalEmptyAndGet_thenKO() {

		final Optional<User> emptyOpt = Optional.empty();
		emptyOpt.get();
	}


	@Test(expected = NullPointerException.class)
	public void whenOptionalOfNull_thenKO() {

		final User user = null;
		final Optional<User> opt = Optional.of(user);
	}

	@Test
	public void whenOptionalOfNullableOfString_thenOK() {

		final String name = "David";
		final Optional<String> opt = Optional.ofNullable(name);
		assertEquals("David", opt.get());
	}


	@Test
	public void whenCheckIfPresent_thenOk() {

		final User user = new User();
		user.setName("David");
		user.setPassword("password");

		final Optional<User> opt = Optional.ofNullable(user);

		assertTrue(opt.isPresent());
		assertEquals(user.getName(), opt.get().getName());

	}

	@Test
	public void whenCheckIfPresentWhitLambda_thenOk() {

		final User user = new User();
		user.setName("David");
		user.setPassword("password");

		final Optional<User> opt = Optional.ofNullable(user);

		opt.ifPresent(u -> assertEquals(user.getName(), u.getName()));

	}

}
