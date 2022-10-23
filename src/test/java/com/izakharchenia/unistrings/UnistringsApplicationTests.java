package com.izakharchenia.unistrings;

import com.izakharchenia.unistrings.logic.UnistringsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnistringsApplicationTests {

	UnistringsGenerator generator = new UnistringsGenerator();

	@Test
	void contextLoads() {
	}

	@Test
	void correctSizeOfSet() {
		assert generator.generate("qwer", 1, 2, 6).size()==6;
		generator.clearResultSet();
		assert generator.generate("qwe", 2, 2, 2).size()==2;
		generator.clearResultSet();
	}

}
