import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendAttachmentEmail
{
   public static void send(String mail,String path)
   {
      String to=mail;
      String filename=path;
      
      final String username = "projectsystem21@gmail.com";
      final String password = "ujhrlmnhbgbosgyk";

       Properties props = new Properties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "25");

      Session session = Session.getInstance(props,new javax.mail.Authenticator()
      {
            protected PasswordAuthentication getPasswordAuthentication()
            {
               return new PasswordAuthentication(username, password);
            }
       });

      try
      {
         // Part one is Text Message
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(username));
         message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
         message.setSubject("Testing Subject");

         // Part two is attachment
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("This is message body");

         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);

         messageBodyPart = new MimeBodyPart();

         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         message.setContent(multipart);
         Transport.send(message);
         System.out.println("Sent message With Attachments successfully....");
      }
      catch (MessagingException e)
      {
         throw new RuntimeException(e);
      }
   }
}