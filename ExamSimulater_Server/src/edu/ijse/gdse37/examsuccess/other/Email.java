/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.examsuccess.other;

/**
 *
 * @author Ashan Tharuka
 */
import edu.ijse.gdse37.examsuccess.model.Student;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Ashan Tharuka
 *
 */
public class Email {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

//    public static void main(String args[]) throws AddressException, MessagingException {
//        generateAndSendEmail();
//        System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
//    }

    /**
     *
     * @param studentEmail
     * @param subject
     * @param msg
     * @param ownerEmail
     * @param ownerPassword
     * @return
     * @throws AddressException
     * @throws MessagingException
     * generateAndSendEmail method
     */
        public static boolean generateAndSendEmail(String studentEmail, String subject, String msg, String ownerEmail, String ownerPassword) throws AddressException, MessagingException {

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        System.out.println("my E mail :" + studentEmail);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(studentEmail));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(studentEmail));
        generateMailMessage.setSubject(subject);
        //String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
        generateMailMessage.setContent(msg, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", ownerEmail, ownerPassword);
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();

        return true;
    }

    /**
     *
     * @param emailList
     * @param subject
     * @param msg
     * @param ownerEmail
     * @param ownerPassword
     * @return
     * @throws AddressException
     * @throws MessagingException
     * generateAndSendEmail method
     */
    public static boolean generateAndSendEmail(ArrayList<Student> emailList, String subject, String msg, String ownerEmail, String ownerPassword) throws AddressException, MessagingException {

        for (Student stuEmail : emailList) {
            if (stuEmail.getEmail() == null || stuEmail.getEmail().isEmpty()) {

            } else {
                // Step1
                System.out.println("\n 1st ===> setup Mail Server Properties..");
                mailServerProperties = System.getProperties();
                mailServerProperties.put("mail.smtp.port", "587");
                mailServerProperties.put("mail.smtp.auth", "true");
                mailServerProperties.put("mail.smtp.starttls.enable", "true");
                System.out.println("Mail Server Properties have been setup successfully..");

                // Step2
                System.out.println("\n\n 2nd ===> get Mail Session..");
                getMailSession = Session.getDefaultInstance(mailServerProperties, null);
                generateMailMessage = new MimeMessage(getMailSession);
                System.out.println("my E mail :" + stuEmail);
                generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stuEmail.getEmail()));
                generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(stuEmail.getEmail()));
                generateMailMessage.setSubject(subject);
                //String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
                generateMailMessage.setContent(msg, "text/html");
                System.out.println("Mail Session has been created successfully..");

                // Step3
                System.out.println("\n\n 3rd ===> Get Session and Send mail");
                Transport transport = getMailSession.getTransport("smtp");

                // Enter your correct gmail UserID and Password
                // if you have 2FA enabled then provide App Specific Password
                transport.connect("smtp.gmail.com", ownerEmail, ownerPassword);
                transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
                transport.close();

            }

        }
        return true;

    }
}
