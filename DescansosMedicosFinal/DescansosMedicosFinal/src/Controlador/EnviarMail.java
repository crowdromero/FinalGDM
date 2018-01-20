package Controlador;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Ejemplo de envio de correo simple con JavaMail
 *
 * @author Chuidiang
 *
  */
public class EnviarMail
{
    /**
     * main de prueba
     * @param args Se ignoran.
     */
    public static void main(String[] args)
    {
        /*try
        {
            // Propiedades de la conexi�n
            Properties props = new Properties();
            //props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.host", "smtp.live.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "richardlbn@hotmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("richardlbn@hotmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress("richard.berrocal@gmail.com"));
            message.setSubject("Hola");
            message.setText(
                "Mensajito con Java Mail" + "de los buenos." + "poque si");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("richardlbn@hotmail.com", "XXXX");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }
    
    public static void EnvioCorreo(String correo,String asunto,String mensaje){
        try
        {
            // Propiedades de la conexi�n
            Properties props = new Properties();
            //props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.host", "smtp.live.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "correopruebacrow@hotmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("correopruebacrow@hotmail.com"));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(correo));
            message.setSubject(asunto);
            message.setText(mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("correopruebacrow@hotmail.com", "prueba123456");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}