package pt.ipl.isel.ps.iqueue.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SQLTimestampToLocalDateTimeConverter {

    static public LocalDateTime convertSQLTimestampToLocalDateTime (Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
