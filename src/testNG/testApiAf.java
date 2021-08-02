package testNG;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.Assert;

public class testApiAf {
	
	private OkHttpClient client = new OkHttpClient();
	
  @Test
  public void checkResponse() throws IOException {
	  // Build API Request
	  Request request = new Request.Builder()
			  .url("https://www.aumni.fund/")
			  .build();
	  // Call API Return the response as object
	  Response response = client.newCall(request).execute();
	  response.body();
	  
	  // Verify Response Code
	  Assert.assertEquals(200, response.code(), "Response code needs to be:");
	  
	  // Verify Response Body
	  String responseStr = response.body().string();
	  responseStr.contains("<!DOCTYPE html><!-- Last Published:");
  }
}