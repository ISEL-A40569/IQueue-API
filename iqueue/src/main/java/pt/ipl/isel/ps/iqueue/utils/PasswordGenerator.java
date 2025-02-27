package pt.ipl.isel.ps.iqueue.utils;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {
    private final String[] characters = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "m", "o", "p",
            "q", "r", "s", "t", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "V", "W", "X",
            "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ";", ":", "!",
            "?", "(", ")", "[", "]", "{", "}"
    };

    public String generatePassword() {
        final int PASSWORD_LENGTH = 6;

        StringBuilder newPassword = new StringBuilder();

        for (int i = 0; i < PASSWORD_LENGTH; ++i) {
            newPassword.append(characters[(int) (Math.random() * characters.length)]);
        }

        return newPassword.toString();
    }
}
