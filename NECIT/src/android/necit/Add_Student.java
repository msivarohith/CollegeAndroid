package android.necit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Student extends Activity {

	
	EditText regid,regpwd,regname,regadd,regphone,regemail;
	
	Button register;
	
    String id,name,pwd,phone,add,email;
    
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_student);
		
		regid = (EditText)findViewById(R.id.regid);
		
		regname = (EditText)findViewById(R.id.regname);
		
		regphone = (EditText)findViewById(R.id.regphone);
		
		regpwd = (EditText)findViewById(R.id.regpwd);
		
		regadd = (EditText)findViewById(R.id.regadd);
		
		regemail = (EditText)findViewById(R.id.regemail);
		
		
		register=(Button)findViewById(R.id.register);
		
		register.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				id=regid.getText().toString();
				
				name=regname.getText().toString();
				
				pwd=regpwd.getText().toString();
				
				phone=regphone.getText().toString();
				
				add=regadd.getText().toString();
				
				email=regemail.getText().toString();
				
                regid.setText("");
				
				regpwd.setText("");
				
				regname.setText("");
				
				regadd.setText("");
				
				regemail.setText("");
				
				regphone.setText("");
				
				
				Database db=new Database(Add_Student.this);
				
				db.open();
				
				if(db.add_student(id, pwd, name, add, phone, email)){
					 
					Toast.makeText(getApplicationContext(), id+" RECORD REGISTRED",Toast.LENGTH_LONG).show();
					
				}
					
				else{
					
					Toast.makeText(getApplicationContext(),id+ " RECORD ALREADY EXISTED",Toast.LENGTH_LONG).show();
				}
					
			db.close(); 

			}
			});
	
		
				
				
		
		
		  	  	
	}
    

}