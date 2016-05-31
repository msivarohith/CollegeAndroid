package android.necit;

import android.app.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pwd_Change extends Activity {
	
	EditText new_pwd, conf_pwd;
	
	Button pwd_submit;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.change_pwd);
        
        
        new_pwd=(EditText)findViewById(R.id.n_pwd);
        
        conf_pwd=(EditText)findViewById(R.id.c_pwd);
        
        pwd_submit=(Button)findViewById(R.id.pwd_submit);
        
        pwd_submit.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				  Database db = new Database(Pwd_Change.this);
			        
			        
			        SharedPreferences prefs = getSharedPreferences("MY", MODE_WORLD_WRITEABLE);
			        
			        
			        final  String user =prefs.getString("id", "No Id Is There"); 
			        
			       // Toast.makeText(getApplicationContext(), user, 2000).show();
			        
			       
			        
			        String now = new_pwd.getText().toString();
			      //Toast.makeText(getApplicationContext(), now, 2000).show();
			        
			        String con = conf_pwd.getText().toString();
			      //Toast.makeText(getApplicationContext(), old, 2000).show();
			        if(now.equals(con)){
			       
			        db.open();	
			        	
			     	if(db.pwd_change(user,now)){
			        		
			        		Toast.makeText(getApplicationContext(), "SUCCESS", 2000).show();
			        	}
			        
			        else{
			        	
			        	Toast.makeText(getApplicationContext(), "SORRY", 2000).show();
			      } 
			     	
			     	db.close();
			     	
			        }
			        
			        else{
			        	
			        	Toast.makeText(getApplicationContext(), "PASSWORD MIS MATCHED!TRY AGAIN", 2000).show();
			        }
			}
		});
        
        
        
      
        
        
        
	}

}
