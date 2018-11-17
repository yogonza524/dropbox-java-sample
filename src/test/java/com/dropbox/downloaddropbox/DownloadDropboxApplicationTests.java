package com.dropbox.downloaddropbox;

import com.dropbox.downloaddropbox.util.LevelEnum;
import com.dropbox.downloaddropbox.util.LoggerBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadDropboxApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void loggerBuilderTest() {
		LoggerBuilder log = new LoggerBuilder(DownloadDropboxApplicationTests.class)
				.and("ejemplo", 12321.2)
				.and("String ej", "Mi nombre")
				.and("Integer", 34667)
				.and("Long", 55L)
//				.level(LevelEnum.WARN)
				;

		log.show(LevelEnum.INFO);

		StringBuilder string = new StringBuilder("ejemplo");

		log.and("Salida de StringBuilder", string.append("=").append(12321.2).toString()).show(LevelEnum.INFO);
	}
}
