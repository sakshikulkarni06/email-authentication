import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailAuthentication {

    public static void main(String[] args) {
        // Sender's email credentials
        String senderEmail = "sakshikulkarni0612@gmail.com";
        String senderPassword = "Sakshi@006";

        // Recipient's email address
        String recipientEmail = "kulkarnisakshi767@gmail.com";

        // SMTP server settings
        String host = "smtp.example.com";
        int port = 587; // or 465 for SSL/TLS
        String protocol = "smtp";

        // Create properties for the email session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", String.valueOf(port));
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Create an authenticator for the email session
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        };

        // Create a session with the properties and authenticator
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            // Set the sender address
            message.setFrom(new InternetAddress(senderEmail));
            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            // Set the email subject
            message.setSubject("Test Email");
            // Set the email content
            message.setText("This is a test email sent using JavaMail API.");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
