package pt.ipl.isel.ps.iqueue.utils;

import junit.framework.TestCase;
import org.junit.Test;

public class PasswordGeneratorTest extends TestCase {
    private final PasswordGenerator passwordGenerator = new PasswordGenerator();

    @Test
    public void testGeneratePassword() {
        String generatedPassword = passwordGenerator.generatePassword();
        assertNotNull(generatedPassword);
        assertEquals(10, generatedPassword.length());
    }
}