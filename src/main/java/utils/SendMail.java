package utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

    public static void main(String[] args) {

        // Sender's email address
        final String senderEmail = "**************";
        final String senderPassword = "************"; // Sender's email password

        
        // Receiver's email address
        String receiverEmail = "mohammad.umar@instantsys.com";

        // Mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Use 465 for SSL/TLS

        // Create a mail session with the properties
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender's email address
            message.setFrom(new InternetAddress(senderEmail));

            // Set the recipient's email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));

            // Set the email subject and content
            message.setSubject("JavaMail API Test");
            message.setText("Hello,\nThis is a test email sent using JavaMail API.");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

