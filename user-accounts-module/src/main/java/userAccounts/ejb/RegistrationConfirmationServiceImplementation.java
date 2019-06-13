package userAccounts.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Stateless
public class RegistrationConfirmationServiceImplementation implements RegistrationConfirmationService
{
    private final String username = "simplefoodsolutions.online@gmail.com";
    private final String password = "w]e/<@U4.M/<";

    @Override
    @Asynchronous
    public void sendRegistrationConfirmationEmail(String userEmail)
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password);
            }
        });
        try
        {
            System.out.println(session.getProperties());

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("simplefoodsolutions.online@gmail.com"));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

            message.setSubject("Registration successful");

            message.setText("Thank you for registering!");

            Transport.send(message);

        } catch (MessagingException messagingException)
        {
            messagingException.printStackTrace();
        }
    }
}
