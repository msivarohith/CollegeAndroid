package android.necit;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;



public class Notification extends Activity {
	
	
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		
		TextView notification = (TextView)findViewById(R.id.student_notification);
		
				InputStream is = getResources().openRawResource(R.raw.notification);
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String str = null;
				try {
				while ((str = br.readLine()) != null) {
					
					if(str.contains("@")){
						
						
						notification.setTextColor(Color.BLACK);
						notification.append(str+"\n\n\n");
						
					
						
						
					}
					
					else if(str.contains(":")|str.contains(",")){
						
						
						notification.setTextColor(Color.BLACK);
						notification.append(str+"\n");
						
					
						
						
					}
					
					
					else{
							notification.append(str);
					}
				
				}
				is.close();
				br.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
				
			}
			
		
}