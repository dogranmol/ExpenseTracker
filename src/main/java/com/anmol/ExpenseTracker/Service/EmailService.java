package com.anmol.ExpenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.anmol.ExpenseTracker.Entity.ExpenseInfo;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String toEmail, String subject, String content) {
		// TODO Auto-generated method stub
		
		var mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
		/*
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * sb.append(
		 * "---------------------------------------------------------------------------------------------"
		 * ); sb.append('\n');
		 * sb.append("CATEGORY"+'\t'+"DATE"+'\t'+'\t'+'\t'+"AMOUNT"+'\t'+'\t'+"DESC");
		 * sb.append('\n'); sb.append(
		 * "---------------------------------------------------------------------------------------------"
		 * );
		 * 
		 * for(int i=0;i<list.size();i++) { sb.append('\n');
		 * sb.append(list.get(i).getCategory()+'\t'+'\t'+list.get(i).getDate()+'\t'+'\t'
		 * +list.get(i).getAmount()+'\t'+'\t'+list.get(i).getDetails()); }
		 * sb.append('\n'); sb.append(
		 * "---------------------------------------------------------------------------------------------"
		 * );
		 */
	        
        
        
        
        
        
        mailMessage.setText(content);

        mailMessage.setFrom("expense.e.tracker@gmail.com");

       javaMailSender.send(mailMessage);
		
		
		
	}

}
