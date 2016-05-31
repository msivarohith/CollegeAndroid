package android.necit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
   
	
	
	EditText user_id , password;
	
	Button login;
	
	String id, pwd;
	
	SharedPreferences sp;
	
    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        
 /*...............................GETTING IDS.........................*/
        
         
        user_id = (EditText)findViewById(R.id.userid);
        
        password = (EditText)findViewById(R.id.password);
        
        login = (Button)findViewById(R.id.login);
      
        
        /*...............................ANONYMOUS.........................*/
               
        login.setOnClickListener(new OnClickListener() {
						
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Database db = new Database(Login.this);
				
				id = user_id.getText().toString();
		        pwd = password.getText().toString();
		        
		    
			 
					 //..................ADMIN................//
					 
			         if(id.equals("admin") && pwd.equals("admin"))   
			         {
			        	 Intent admin=new Intent(Login.this,Admin_Activity.class);
			        	 
			        	 admin.setFlags(admin.FLAG_ACTIVITY_CLEAR_TOP);
			        	 
			        	 startActivity(admin);
			         }
			         
			         
			         
			         
			         //.............PRINCIPAL......................//
			         
			         else if(id.equals("principal") && pwd.equals("nec")){
			        	 
			        	 {
				        	 Intent principal=new Intent(Login.this,Complaint_Principal.class);
				        	 
				        	 principal.setFlags(principal.FLAG_ACTIVITY_CLEAR_TOP);
				        	 
				        	 startActivity(principal);
				         }
			         }
			         
			      
			         
			         //..................STUDENT.......................//
			         
			         
			         
			         else if(id.length() > 0 && pwd.length() > 0)
				        {                	
			        	 
			        	 	db.open();
					        
					        if(db.Login(id, pwd))
					        {                	
					        	Intent student = new Intent(Login.this,Student_Activity.class);
					        	
					        	 student.setFlags(student.FLAG_ACTIVITY_CLEAR_TOP);
					        	
					        	sp = getSharedPreferences("MY", MODE_WORLD_READABLE);
			                	
			                	Editor editor = sp.edit();
			                	
			                	editor.putString("id",id);
			                	
			                	editor.commit();
			                	
			                	
					        	startActivity(student);
					        }
					        
					        else
					        {
					        	Toast.makeText(getApplicationContext(), "Invalid UserId Password",Toast.LENGTH_LONG).show();
					        }
					        
					        db.close();
					        
					     }
			          
			          else{
					        	Toast.makeText(getApplicationContext(), "please Enter UserId Password",Toast.LENGTH_LONG).show();
					        } 
					        
			         
			        
			        
			      
			 }
		});
       
    }
}