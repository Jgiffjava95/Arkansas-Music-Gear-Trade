package itemService;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import model.EmailMessage;
import model.item;

public class SnsPub {
	
	private static final String ACCESS_KEY = "AKIAW6ZRIHK7XA7OGKO4";
	private static final String SECRET_KEY = "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";

	private static final String myTopic = "arn:aws:sns:us-east-1:478455282367:AMGT-Email-Notification";

	private static AmazonSNSClient getAwsClient() {

		AmazonSNSClient snsClient = new AmazonSNSClient(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY));

		return snsClient;

	}

	public static void publishNewItem(item item) {
				
			PublishRequest publishRequest = new PublishRequest();
			publishRequest.setTargetArn(myTopic);
			String newMovieMessage = "Item Name: " + item.getItemName() 
			+ "\nCategory: " + item.getItemCat()
			+ "\nPrice: " + item.getItemPrice() 
			+ "\nDescription: " + item.getItemDesc()
			+ "\nLocation: " + item.getLocation()
			+ "\nContact: " + item.getContact();
			publishRequest.setMessage(newMovieMessage);
			publishRequest.setSubject("New Item Posting Alert.");
			
			AmazonSNSClient snsClient = getAwsClient();
			
			PublishResult publishResult = snsClient.publish(publishRequest);
			
			System.out.println("MessageId -" + publishResult.getMessageId());
			
		}
	
public String sendEmail(EmailMessage message) {
		
		PublishRequest request = new PublishRequest();
		request.setTopicArn(SnsPub.myTopic);
		request.setMessage(message.getEmailText());
		request.setSubject(message.getEmailSubject());
		
		AmazonSNSClient snsClient = getAwsClient();
		PublishResult result = snsClient.publish(request);
		
		System.out.println("message id : " + result.getMessageId());
		
		return result.getMessageId();
	}

}
