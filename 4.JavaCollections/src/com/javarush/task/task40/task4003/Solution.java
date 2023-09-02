package com.javarush.task.task40.task4003;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* 
Отправка письма с файлом
*/

public class Solution {
    public static final String PATH_TO_PROPERTIES = "/Users/nikita.z/myJava/ideaProject/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task40/task4003/config.properties";


    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            String username = properties.getProperty("username");
            String app = properties.getProperty("app");
            String password = properties.getProperty("password");
            String recipients = "test_email@gmail.com";

            solution.sendMail(username, password, recipients, app);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMail(final String username, final String password, final String recipients, String app) {
        Properties props = new Properties();

        props.put("mail.from", username);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.transport.protocol", "smtp");

        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");


        props.put("mail.smtp.user", app);
        props.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));

            setSubject(message, "Тестовое письмо");
            setAttachment(message, "/Users/nikita.z/Desktop/task3913.zip");

            Transport.send(message);
            System.out.println("Письмо было отправлено.");

        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке: " + e.toString());
        }
    }

    public static void setSubject(Message message, String subject) throws MessagingException {
        message.setSubject(subject);
    }

    public static void setAttachment(Message message, String filename) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();

        FileDataSource fds = new FileDataSource(filename);
        mimeBodyPart.setDataHandler(new DataHandler(fds));
        mimeBodyPart.setFileName(fds.getName());

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
    }
}