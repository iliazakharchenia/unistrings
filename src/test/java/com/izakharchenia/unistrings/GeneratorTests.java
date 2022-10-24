package com.izakharchenia.unistrings;

import com.izakharchenia.unistrings.exceptions.ParametersDataException;
import com.izakharchenia.unistrings.generators.UnistringsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneratorTests {

    private UnistringsGenerator generator = new UnistringsGenerator();

    @Test
    void correctSizeOfSet() {
        if (generator.generate("qwer", 1, 2, 6).size() != 6) throw new AssertionError();
        generator.clearResultSet();
        if (generator.generate("qwe", 2, 2, 2).size() != 2) throw new AssertionError();
        generator.clearResultSet();
    }

    @Test
    void correctExceptionThrowing() {
        try {
            generator.generate("qwe", 2, 2, 25);
        } catch (ParametersDataException e) {
            generator.clearResultSet();
            assert e.getMessage().equals(generator.getErrMessage());
            assert e.getMessage().equals("Max quantity of permutations of the unique char sequence " +
                    "from requested string < requested quantity");
        }
        generator.clearResultSet();
    }

}
