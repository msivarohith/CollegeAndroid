package android.necit;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Student_Marks extends Activity{
	
	TextView  s1, s2, s3,s4,s5,s6;
	
	
	
	 public void onCreate(Bundle savedInstanceState) {
		 
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.student_marks);
        
        s1 = (TextView)findViewById(R.id.gets1);
        s2 = (TextView)findViewById(R.id.gets2);
        s3 = (TextView)findViewById(R.id.gets3);
        
        s4 = (TextView)findViewById(R.id.gets4);
        s5 = (TextView)findViewById(R.id.gets5);
        s6 = (TextView)findViewById(R.id.gets6);
        
        
        
        SharedPreferences prefs = getSharedPreferences("MY", MODE_WORLD_WRITEABLE);
        
        
        final  String user =prefs.getString("id", "No Id Is There");
        
       
        
       Database db=new Database(Student_Marks.this);
        
       db.open();
       
       Cursor c =  db.get_marks(user);
        
       
        
         db.close();
        
      
        
       String sb0 = c.getString(0).toString();
       
       String sb1 = c.getString(1).toString();
       String sb2 = c.getString(2).toString();
       
       String sb3 = c.getString(3).toString();
       String sb4 = c.getString(4).toString();
       
       String sb5 = c.getString(5).toString();
        
        s1.setText(sb0);
        
        s2.setText(sb1);
        s3.setText(sb2);
        
        s4.setText(sb3);
        s5.setText(sb4);
        
        s6.setText(sb5);
        
        
       

}
}