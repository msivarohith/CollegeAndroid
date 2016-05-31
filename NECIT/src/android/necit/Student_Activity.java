package android.necit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Student_Activity extends Activity {
	
	
	
	

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.student_activity);
        
        Database db = new Database(Student_Activity.this);
        
        
        SharedPreferences prefs = getSharedPreferences("MY", MODE_WORLD_WRITEABLE);
        
        
        final  String user =prefs.getString("id", "No Id Is There");
        
        Cursor c = db.select_id(user) ;
    	
    	String studentname = c.getString(0);
    	
    	Toast.makeText(getApplicationContext(),"Welcome "+ studentname, 5000).show();
    	
        
        
        
	}
	
	public void click(View v){
		
		
		switch (v.getId()) {
		
		case R.id.student_attendance:
			
			Intent i=new Intent(Student_Activity.this, Student_Attendance.class);
			
			i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(i);
			
			
			break;
			
		case R.id.student_marks:
			
			Intent i2=new Intent(Student_Activity.this, Student_Marks.class);
			
			i2.setFlags(i2.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(i2);
			
			
			break;
			
		case R.id.complaint:
			
			Intent i3=new Intent(Student_Activity.this, Student_Complaint.class);
			
			i3.setFlags(i3.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(i3);
			
			
			break;
			
		case R.id.notification:
			
			Intent i4=new Intent(Student_Activity.this,Notification.class);
			
			i4.setFlags(i4.FLAG_ACTIVITY_CLEAR_TOP);
			
			startActivity(i4);
			
			
			break;
			
case R.id.questions:
	
	Intent i5=new Intent(Student_Activity.this, Questions.class);
	
	i5.setFlags(i5.FLAG_ACTIVITY_CLEAR_TOP);
	
	startActivity(i5);
	
	
	break;
	
case R.id.mock_test:
	
	Intent i6=new Intent(Student_Activity.this, Entrance_Test.class);
	
	i6.setFlags(i6.FLAG_ACTIVITY_CLEAR_TOP);
	
	startActivity(i6);
	
	
	break;
	
case R.id.reset_pwd:
	
	Intent i7=new Intent(Student_Activity.this, Pwd_Change.class);
	
	i7.setFlags(i7.FLAG_ACTIVITY_CLEAR_TOP);
	
	startActivity(i7);
	
	
	break;
	
	case R.id.student_logout:
	
	Intent i8=new Intent(Student_Activity.this, Login.class);
	
	i8.setFlags(i8.FLAG_ACTIVITY_CLEAR_TOP);
	
	startActivity(i8);
	
	
	break;
			
		
		}
		
		
	}


}
