package com.poc.binlog;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BinlogPocApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BinlogPocApplication.class, args);
		binglog();
	}

	public static void binglog() throws IOException {
		BinaryLogClient client = new BinaryLogClient("127.0.0.1", 9999, "repl", "repl");
		client.registerEventListener(event -> System.out.println(event));
		client.connect();
	}

}
