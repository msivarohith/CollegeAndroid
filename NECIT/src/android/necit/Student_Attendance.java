package android.necit;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Student_Attendance extends Activity{
	
	TextView  attend, cond, per,req1;
	
	
	
	 public void onCreate(Bundle savedInstanceState) {
		 
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.student_attendance);
        
        attend = (TextView)findViewById(R.id.getatt);
        
        cond = (TextView)findViewById(R.id.getcon);
        
        per = (TextView)findViewById(R.id.getper);
        
        req1 = (TextView)findViewById(R.id.req);
        
        SharedPreferences prefs = getSharedPreferences("MY", MODE_WORLD_WRITEABLE);
        
        
        final  String user =prefs.getString("id", "No Id Is There");
        
       
        
       Database db=new Database(Student_Attendance.this);
        
       db.open();
       
       Cursor c =  db.get_attendance(user);
        
       
        
         db.close();
        
      
        
       String sb0 = c.getString(0).toString();
       
       String sb1 = c.getString(1).toString();
        
        attend.setText(sb0);
        
        cond.setText(sb1);
        
        
        
        float a = Float.parseFloat(sb0);
        
        float b = Float.parseFloat(sb1);
        
        
        float p = ((a/b)*100);
        
       
        
       
        
        if(p < 75.0){
        	
        	per.setBackgroundColor(Color.RED);
        	
        	 per.setText(String.valueOf(p)); 
      
        	req1.setText("YOU HAVE LESS ATTENDANCE ");
        }
        
        else{
        	
        	per.setBackgroundColor(Color.GREEN);
        	
       	 per.setText(String.valueOf(p)); 
     
       	req1.setText("KEEP IT UP :-) ");
        	
        }
        
        
        

}
}