package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Unit test for simple App.
 */
public class AppTest {
	//Username e password comentados//
	private String userName = "**********";
	private String password = "**********";
	  @org.junit.Test
   public void testeEmail() {
			/*Olhe as configurações smtp do seu e-mail*/
		  try {
			   Properties properties = new Properties();
			   properties.put("mail.smtp.auth", "true");//Autorização//
			   properties.put("mail.smtp.starttls", "true");//Autenticação//
			   properties.put("mail.smtp.host", "smtp.gmail.com");//servidor gmail google//
			   properties.put("mail.smtp.port", "465");//porta do servidor//
			   properties.put("mail.smtp.socketFactory.port", "465");//Expecifica a porta a ser conectada//
			   properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexão smtp//
			   
			   Session session = Session.getInstance(properties, new Authenticator() {
				 @Override
				 
				 protected PasswordAuthentication getPasswordAuthentication() {
					 return new PasswordAuthentication(userName, "boscxxopbzxgpeya");
				 }
			   });
			   
			   Address[] toUser = InternetAddress.parse("*********"); //endereços de email dos disparos//
			   Message message = new MimeMessage(session);
			   message.setFrom(new InternetAddress(userName)); 
			   message.setRecipients(Message.RecipientType.TO,toUser);
			   message.setSubject("Chegou o e-mail enviado com java");
			   message.setText("Olá programador, vc acaba de receber um e-mail enviado com Java.");
			   
			   Transport.send(message);
			
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	 

		  
	
   }

}
