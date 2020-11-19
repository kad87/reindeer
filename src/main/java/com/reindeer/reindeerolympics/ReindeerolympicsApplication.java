package com.reindeer.reindeerolympics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReindeerolympicsApplication implements CommandLineRunner {

	/**
	 *Setup the duration we want rank our Reindeers with
	 */
	private static Integer DURATION = 1000;


	/**
	 * {@link Launcher} launcher
	 */
	@Autowired
	private Launcher launcher;

	public static void main(String[] args) {

		SpringApplication.run(ReindeerolympicsApplication.class, args).close();
	}

	/**
	 * run
	 *
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) {
		launcher.launch(DURATION);
	}
}
