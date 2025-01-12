package helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;

import helloworld.entitys.User;

/**
 * Handler for requests to Lambda function.
 */
public class App  {

	public String getNoting() {
		return "Just Say My Name";
	}
	
	public void getContext(Context context) {
		System.out.println("\n\n====Get In Enveroment "+System.getenv("google")+"======\n\n");
		
		System.out.println("getRemainingTimeInMillis =>"+context.getRemainingTimeInMillis());
		System.out.println("getFunctionName =>"+context.getFunctionName());
		System.out.println("getFunctionVersion =>"+context.getFunctionVersion());
		System.out.println("getInvokedFunctionArn =>"+context.getInvokedFunctionArn());
		System.out.println("getMemoryLimitInMB =>"+context.getMemoryLimitInMB());
		System.out.println("getAwsRequestId =>"+context.getAwsRequestId());
		System.out.println("getLogGroupName =>"+context.getLogGroupName());
		System.out.println("getLogStreamName =>"+context.getLogStreamName());
		System.out.println("getIdentity =>"+context.getIdentity());
		System.out.println("getClientContext =>"+context.getClientContext());
		System.out.println("getLogger =>"+context.getLogger().toString());
	}
	
	
    public String handleRequest(String name) {
        return "My Name is => "+name;
    }
    
    public List<String> toUpper( List<String>  data)  {
    	return data.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
    
    
    public Map<String, Integer> map(Map<String, Integer> data) {
    	return data;
    }
    
    public User user(User user) throws InterruptedException {
    	System.out.println("work ");
    	Thread.sleep(1000);
    	user.setCraetedDate(new Date());
    	return user;
    }

    public List<User> listOfUser() {
    	
    	List<User> result = new LinkedList<>();
    	
    	for(int i=1;i <= 10;i++) 
    		result.add(new User(i,"my name "+i, i*2, new Date()));
    	
    	return result;
    }
    
    public void inputAndOutput(InputStream input, OutputStream output) throws IOException {
    	int data;
    	while((data=input.read()) !=-1)
    		output.write(Character.toLowerCase(data));
    }

}
