package behavioral.iterador.example1;

import java.util.Iterator;
import java.util.List;

public class SystemLog implements Log {
    private List<LogEntry> logEntries;

    public SystemLog(List<LogEntry> logEntries) {
        this.logEntries = logEntries;
    }

    @Override
    public Iterator<LogEntry> createIterator() {
        return new SystemLogIterator(this);
    }

    private static class SystemLogIterator implements Iterator<LogEntry> {
        private SystemLog systemLog;
        private int position;

        public SystemLogIterator(SystemLog systemLog) {
            this.systemLog = systemLog;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < systemLog.logEntries.size();
        }

        @Override
        public LogEntry next() {
            if (hasNext()) {
                LogEntry entry = systemLog.logEntries.get(position);
                position++;
                return entry;
            }
            return null;
        }
    }
}
