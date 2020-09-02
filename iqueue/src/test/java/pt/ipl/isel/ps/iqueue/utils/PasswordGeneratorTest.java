package pt.ipl.isel.ps.iqueue.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class PasswordGeneratorTest extends TestCase {
    private final PasswordGenerator passwordGenerator = new PasswordGenerator();

    private final int EXPECTED_PASSWORD_LENGTH = 10;

    @Test
    public void testGeneratePassword() {
        String generatedPassword = passwordGenerator.generatePassword();
        assertNotNull(generatedPassword);
        assertEquals(EXPECTED_PASSWORD_LENGTH, generatedPassword.length());
    }
}