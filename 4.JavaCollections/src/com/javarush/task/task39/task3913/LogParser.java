package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<Log> logs = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogParser(Path logDir) {
        this.logDir = logDir;
        readLogs(logDir);
    }

    private void readLogs(Path logDir) {
        File dir = logDir.toFile();
        String logExtension = ".log";
        String line;
        if (dir.isDirectory()) {
            for (File l : dir.listFiles()) {
                if (l.toString().endsWith(logExtension)) {
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(l))) {
                        while ((line = bufferedReader.readLine()) != null) {
                            String[] content = line.split("\t");
                            String ip = content[0];
                            String name = content[1];
                            Date date = dateFormat.parse(content[2]);
                            Event event = readEvent(content[3]);
                            int task = -1;
                            if (event.equals(Event.SOLVE_TASK) || event.equals(Event.DONE_TASK)) {
                                task = Integer.parseInt(content[3].split(" ")[1]);
                            }
                            Status status = readStatus(content[4]);
                            Log log = new Log(ip, name, date, event, task, status);
                            logs.add(log);
                        }
                    } catch (IOException | ParseException e) {
                        throw new RuntimeException();
                    }
                }
            }
        }
    }

    private Event readEvent(String str) {
        str = str.split(" ")[0];
        Event event = null;
        switch (str) {
            case "LOGIN": {
                event = Event.LOGIN;
                break;
            }
            case "DOWNLOAD_PLUGIN": {
                event = Event.DOWNLOAD_PLUGIN;
                break;
            }
            case "WRITE_MESSAGE": {
                event = Event.WRITE_MESSAGE;
                break;
            }
            case "SOLVE_TASK": {
                event = Event.SOLVE_TASK;
                break;
            }
            case "DONE_TASK": {
                event = Event.DONE_TASK;
                break;
            }
        }
        return event;
    }

    private Status readStatus(String str) {
        Status status = null;
        switch (str) {
            case "OK": {
                status = Status.OK;
                break;
            }
            case "FAILED": {
                status = Status.FAILED;
                break;
            }
            case "ERROR": {
                status = Status.ERROR;
                break;
            }
        }
        return status;
    }

    private boolean isDateBetweenDates(Date date, Date after, Date before) {
        if (after == null) after = new Date(0);
        if (before == null) before = new Date(Long.MAX_VALUE);
        return (after.getTime() < date.getTime() && date.getTime() < before.getTime());
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before)) {
                ips.add(log.getIp());
            }
        }
        return ips.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(event)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getStatus().equals(status)) {
                ips.add(log.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            users.add(log.getUser());
        }
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before)) {
                users.add(log.getUser());
            }
        }
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user)) {
                events.add(log.getEvent());
            }
        }
        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getIp().equals(ip)) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.LOGIN)) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.WRITE_MESSAGE)) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.SOLVE_TASK)) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.SOLVE_TASK) && log.getTask() == task) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.DONE_TASK)) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.DONE_TASK) && log.getTask() == task) {
                users.add(log.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user) && log.getEvent().equals(event)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getStatus().equals(Status.FAILED)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getStatus().equals(Status.ERROR)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        TreeSet<Date> dates = new TreeSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user) && log.getEvent().equals(Event.LOGIN)) {
                dates.add(log.getDate());
            }
        }
        return !dates.isEmpty() ? dates.first() : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        TreeSet<Date> dates = new TreeSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user) && log.getEvent().equals(Event.SOLVE_TASK) && log.getTask() == task) {
                dates.add(log.getDate());
            }
        }
        return !dates.isEmpty() ? dates.first() : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        TreeSet<Date> dates = new TreeSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user) && log.getEvent().equals(Event.DONE_TASK) && log.getTask() == task) {
                dates.add(log.getDate());
            }
        }
        return !dates.isEmpty() ? dates.first() : null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user) && log.getEvent().equals(Event.WRITE_MESSAGE)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user) && log.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                dates.add(log.getDate());
            }
        }
        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before)) {
                events.add(log.getEvent());
            }
        }
        return events.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before)) {
                events.add(log.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getIp().equals(ip)) {
                events.add(log.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getUser().equals(user)) {
                events.add(log.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getStatus().equals(Status.FAILED)) {
                events.add(log.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getStatus().equals(Status.ERROR)) {
                events.add(log.getEvent());
            }
        }
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.SOLVE_TASK) && log.getTask() == task) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.DONE_TASK) && log.getTask() == task) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> solvedTasks = new HashMap<>();
        int task;
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.SOLVE_TASK)) {
                task = log.getTask();
                if (!solvedTasks.containsKey(task)) {
                    solvedTasks.put(task, 1);
                } else {
                    solvedTasks.put(task, solvedTasks.get(task) + 1);
                }
            }
        }
        return solvedTasks;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> doneTask = new HashMap<>();
        int task;
        for (Log log : logs) {
            if (isDateBetweenDates(log.getDate(), after, before) && log.getEvent().equals(Event.DONE_TASK)) {
                task = log.getTask();
                if (!doneTask.containsKey(task)) {
                    doneTask.put(task, 1);
                } else {
                    doneTask.put(task, doneTask.get(task) + 1);
                }
            }
        }
        return doneTask;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> set = new HashSet<>();

        String field1;
        String field2 = null;
        String value1 = null;
        Date after = null;
        Date before = null;

        Pattern pattern = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");
        Matcher matcher = pattern.matcher(query);
        matcher.find();

        field1 = matcher.group(1);
        if (matcher.group(2) != null) {
            field2 = matcher.group(3);
            value1 = matcher.group(4);
        }
        if (matcher.group(5) != null) {
            try {
                after = dateFormat.parse(matcher.group(6));
                before = dateFormat.parse(matcher.group(7));
            } catch (ParseException e) {
            }
        }

        if (field2 != null) {
            for (Log log : logs) {
                if (isDateBetweenDates(log.getDate(), after, before)) {
                    if (field2.equals("date")) {
                        try {
                            if (log.getDate().getTime() == dateFormat.parse(value1).getTime()) {
                                set.add(getValueByCommand(log, field1));
                            }
                        } catch (ParseException e) {
                        }

                    } else {
                        if (value1.equals(getValueByCommand(log, field2).toString())) {
                            set.add(getValueByCommand(log, field1));
                        }
                    }
                }
            }
        } else {
            for (Log log : logs) {
                set.add(getValueByCommand(log, field1));
            }
        }
        return set;
    }

    public Object getValueByCommand(Log log, String field) {
        Object value = null;
        switch (field) {
            case ("ip"): {
                Command command = new GetIpCommand(log);
                value = command.execute();
                break;
            }
            case ("user"): {
                Command command = new GetUserCommand(log);
                value = command.execute();
                break;
            }
            case ("date"): {
                Command command = new GetDateCommand(log);
                value = command.execute();
                break;
            }
            case ("event"): {
                Command command = new GetEventCommand(log);
                value = command.execute();
                break;
            }
            case ("status"): {
                Command command = new GetStatusCommand(log);
                value = command.execute();
                break;
            }
        }
        return value;
    }

    private class Log {
        private String ip;
        private String user;
        private Date date;
        private Event event;
        private Status status;
        private int task;

        public Log(String ip, String user, Date date, Event event, int task, Status status) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.event = event;
            this.task = task;
            this.status = status;
        }

        public String getIp() {
            return ip;
        }

        public String getUser() {
            return user;
        }

        public Date getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public int getTask() {
            return task;
        }

        public Status getStatus() {
            return status;
        }
    }

    private abstract class Command {
        protected Log log;

        abstract Object execute();
    }

    private class GetIpCommand extends Command {

        public GetIpCommand(Log log) {
            this.log = log;
        }

        @Override
        public Object execute() {
            return log.getIp();
        }
    }

    private class GetUserCommand extends Command {
        private Log log;

        public GetUserCommand(Log log) {
            this.log = log;
        }

        @Override
        public Object execute() {
            return log.getUser();
        }
    }

    private class GetDateCommand extends Command {
        private Log log;

        public GetDateCommand(Log log) {
            this.log = log;
        }

        @Override
        public Object execute() {
            return log.getDate();
        }
    }

    private class GetEventCommand extends Command {
        private Log log;

        public GetEventCommand(Log log) {
            this.log = log;
        }

        @Override
        public Object execute() {
            return log.getEvent();
        }
    }

    private class GetStatusCommand extends Command {
        private Log log;

        public GetStatusCommand(Log log) {
            this.log = log;
        }

        @Override
        public Object execute() {
            return log.getStatus();
        }
    }
}