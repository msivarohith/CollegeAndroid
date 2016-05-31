package android.necit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Entrance_Test extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrance_test);
        Button btn = (Button)findViewById(R.id.button1);
    	btn.setOnClickListener(new View.OnClickListener(){

    		public void onClick(View v) {
    			
    			Context c = getApplicationContext();
    			
    	Mock_Database dbUser = new Mock_Database(Entrance_Test.this);
    			  dbUser.AddTest();
    		
    			// TODO Auto-generated method stub
    			Intent intent = new Intent(getApplicationContext(),Mock_Test.class);
    			//intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
    		
    			startActivity(intent);
    			
    		}   		
    	});

    }
    
}