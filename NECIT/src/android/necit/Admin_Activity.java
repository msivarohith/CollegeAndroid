package android.necit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Admin_Activity extends Activity{
	
	ImageView registration, attendance, marks, logout;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);
        
        //GETTING IDS
        
        registration = (ImageView)findViewById(R.id.registration);
        
        attendance = (ImageView)findViewById(R.id.attendance);
        
        marks = (ImageView)findViewById(R.id.marks);
        
       logout = (ImageView)findViewById(R.id.logout);
        
       
	
	
	}
	
	
  //User Defined Method Click
    
    public void click(View v){
    	
    	switch ( v.getId()) {
    	
    	//REGISTRATION
    	
    	
		case R.id.registration:
			Intent reg=new Intent(Admin_Activity.this,Registration_Tab.class);
			
			reg.setFlags(reg.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(reg);
			
			break;
			
		case R.id.attendance:
			Intent atn=new Intent(Admin_Activity.this,Attendance_Tab.class);
			
			atn.setFlags(atn.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(atn);
			
			break;
			
			//MARKS
			
		case R.id.marks:
			Intent marks=new Intent(Admin_Activity.this,Marks_Tab.class);
			
			marks.setFlags(marks.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(marks);
			
			break;

			
			//LOGOUT
			

		case R.id.logout:
			
			Intent logout=new Intent(Admin_Activity.this, Login.class);
			
			logout.setFlags(logout.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(logout);
			
			break;
			
			

		}
    }
}
