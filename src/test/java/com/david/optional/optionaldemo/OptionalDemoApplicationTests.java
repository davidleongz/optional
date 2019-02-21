package com.david.optional.optionaldemo;


import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalDemoApplicationTests {



	@Test(expected = NoSuchElementException.class)
	public void whenCreateEmptyOptional_thenNull() {

		final Optional<User> emptyOpt = Optional.empty();
		emptyOpt.get();
	}


	@Test(expected = NullPointerException.class)
	public void whenCreateEmptyOptional_thenNullPointerException() {

		final User user = null;
		final Optional<User> opt = Optional.of(user);
	}

}
