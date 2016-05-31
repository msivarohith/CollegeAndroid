package android.necit;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import android.widget.TextView;

public class Mock_Test extends Activity {
	private	TextView question = null;
	private	TextView answer_area = null;
	private TextView correct_wrong = null;
	private	TextView correctSymbol = null;
	private TextView wrongSymbol = null;
	private TextView  mTextField= null;
	private ImageView  qtimage= null;

	private TextView qtno;
	 int imageid ;
	int correct = 0;
	int incorrect = 1;
	
	public static String ans; 
	
	public static MediaPlayer mp;
	
	private static int ctr = 1;
	private Button A=null;
	private Button B=null;
	private Button C=null;
	private Button D=null;
	private ImageButton next = null;
	private ImageButton previous= null;
	Intent getData;
	Button Back;
	String topicname ;
	int fr1;
	

	 ImageView img;
	 int num = 0;
	    public int imgID = 0;
	
	
	
	private Intent intent;
	
		public Mock_Test() {
		super();

		new CountDownTimer(600000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 int seconds = (int) (millisUntilFinished / 1000) % 60 ;
		    	 int minutes = (int) ((millisUntilFinished / (1000*60)) % 60);
		    	 
		         mTextField.setText("Time"+minutes +":"+ seconds );
		     }

		     public void onFinish() {
		         mTextField.setText("done!");
		        // intent= new Intent(getApplicationContext(),MainActivity.class);
					//startActivity(intent);
					
		        
		     }
		  }.start();
		}		
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mock_test);

        
        
        img=(ImageView)findViewById(R.id.qtimage);
      /*
        try
        {
            imgID = getResources().getIdentifier("sample_"+num, "drawable", "in.co.shivaji");
                    img.setImageResource(imgID);
        }catch(Exception e){
                   Toast.makeText(mocktest.this,e.getMessage() , Toast.LENGTH_SHORT).show();
        }

*/
        
        TextView tv = (TextView)findViewById(R.id.marquee_text_id);
       tv.setSelected(true);
        
    Back = (Button)findViewById(R.id.exitofsymbolshome);
    
    	Back.setOnClickListener(new View.OnClickListener(){

    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			Intent intent = new Intent(getApplicationContext(),Entrance_Test.class);
    			intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
    			startActivity(intent);
    		}   		
    	});
    	 question = (TextView)findViewById(R.id.question_area);
    	 qtno = (TextView)findViewById(R.id.qtno);
         answer_area = (TextView)findViewById(R.id.answer_area);
         answer_area.setBackgroundColor(Color.CYAN);
         correct_wrong = (TextView)findViewById(R.id.correct_wrong);
         correctSymbol = (TextView)findViewById(R.id.correct_text);
         wrongSymbol= (TextView)findViewById(R.id.wrong_text);
         qtimage = (ImageView)findViewById(R.id.qtimage);
         
         
         A = (Button)findViewById(R.id.buttonA);
         A.setSelected(true);
         B = (Button)findViewById(R.id.buttonB);
         B.setSelected(true);
         C = (Button)findViewById(R.id.buttonC);
        
         D = (Button)findViewById(R.id.buttonD);
        
			
         final Mock_Database dbUser = new Mock_Database(Mock_Test.this);
			   
			try {
				
				Cursor c= dbUser.GetData(ctr);
				 
				
				 c.moveToFirst();
	
		
			 ans = c.getString(6).toString();
			   //Toast.makeText(getApplicationContext(),"in ans",Toast.LENGTH_SHORT).show();
			   qtno.setText("Qt NO : " +c.getString(0).toString()+"/20");
			    question.setText(c.getString(1).toString());	    
			    A.setText(c.getString(2).toString());		   
			    B.setText(c.getString(3).toString());		   
			    C.setText(c.getString(4).toString());		   
			    D.setText(c.getString(5).toString());
			    
			    ctr++;
			  
	 			 //Toast.makeText(getApplicationContext(),ctr,Toast.LENGTH_LONG).show();
			 
	     			
			
			} catch (Exception e) {
				
				//Toast.makeText(getApplicationContext(),"It is in catch",Toast.LENGTH_LONG).show();
			}

         
         next = (ImageButton)findViewById(R.id.next);
         previous = (ImageButton)findViewById(R.id.previous);
         
         
         A.setOnClickListener(listener);
         B.setOnClickListener(listener);
         C.setOnClickListener(listener);
         D.setOnClickListener(listener);
         next.setOnClickListener(listener);
         previous.setOnClickListener(listener);
     
        
        mTextField = (TextView)findViewById(R.id.tv);
    }
	
	
OnClickListener listener = new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch (v.getId()) {
			
			case R.id.buttonA:
			
				if((A.getText().toString()).equals(ans)){
				B.setClickable(false);
				C.setClickable(false);
				D.setClickable(false);
					correct_wrong.setText("Correct");
					A.setHighlightColor(Color.GREEN);
					correct_wrong.setBackgroundColor(Color.GREEN);
					correct++;
					correctSymbol.setText(String.valueOf(correct));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_correct1);
					mp.start();
					 mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});
					
					}
				
				else{
					A.setClickable(false);
					B.setClickable(false);
					C.setClickable(false);
					D.setClickable(false);
					
					correct_wrong.setText("Incorrect");
					correct_wrong.setBackgroundColor(Color.RED);
					A.setHighlightColor(Color.RED);
					answer_area.setText("Answer is :"+ans);
					wrongSymbol.setText(String.valueOf(incorrect++));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_wrong1);
					mp.start();
					 mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});
					
				}
					
				break;
				
			case R.id.buttonB:

				if((B.getText().toString()).equals(ans)){
				A.setClickable(false);
				C.setClickable(false);
				D.setClickable(false);
					correct_wrong.setText("Correct");
					correct_wrong.setBackgroundColor(Color.GREEN);
					correct++;
					correctSymbol.setText(String.valueOf(correct));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_correct1);
					mp.start();
					 mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});
					}
				
				else{
					A.setClickable(false);
					B.setClickable(false);
					C.setClickable(false);
					D.setClickable(false);
					
					correct_wrong.setText("Incorrect");
					correct_wrong.setBackgroundColor(Color.RED);
					//B.setHighlightColor(Color.RED);
					answer_area.setText("Answer is :"+ans);
					wrongSymbol.setText(String.valueOf(incorrect++));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_wrong1);
					mp.start();
					mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});
				}
				break;
				
			case R.id.buttonC:

				if((C.getText().toString()).equals(ans)){
				B.setClickable(false);
				A.setClickable(false);
				D.setClickable(false);
					correct_wrong.setText("Correct");
					//C.setHighlightColor(Color.GREEN);
					correct_wrong.setBackgroundColor(Color.GREEN);
					correct++;
					correctSymbol.setText(String.valueOf(correct));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_correct1);
					mp.start();
					mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});		}
				
				else{
					A.setClickable(false);
					B.setClickable(false);
					C.setClickable(false);
					D.setClickable(false);
					
					correct_wrong.setText("Incorrect");
					correct_wrong.setBackgroundColor(Color.RED);
					//C.setHighlightColor(Color.RED);
					answer_area.setText("Answer is :"+ans);
					wrongSymbol.setText(String.valueOf(incorrect++));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_wrong1);
					mp.start();
					 mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});
				}
				break;
				

			case R.id.buttonD:
				
				if((D.getText().toString()).equals(ans)){
				A.setClickable(false);
				B.setClickable(false);
				C.setClickable(false);
					correct_wrong.setText("Correct");
					D.setHighlightColor(Color.GREEN);
					correct_wrong.setBackgroundColor(Color.GREEN);
					correct++;
					correctSymbol.setText(String.valueOf(correct));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_correct1);
					mp.start();
					 mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});
					
					}
				
				else{
					A.setClickable(false);
					B.setClickable(false);
					C.setClickable(false);
					D.setClickable(false);
					
					correct_wrong.setText("Incorrect");
					correct_wrong.setBackgroundColor(Color.RED);
					D.setHighlightColor(Color.RED);
					answer_area.setText("Answer is :"+ans);
					wrongSymbol.setText(String.valueOf(incorrect++));
					
					mp = MediaPlayer.create(getApplicationContext(),R.raw.audio_wrong1);
					mp.start();
					 mp.setOnCompletionListener(new OnCompletionListener() {
						
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}
					});
					
				}
					
				break;
				
				
			case R.id.next:
				
			//Toast.makeText(getApplicationContext(),"before setclickable",Toast.LENGTH_SHORT).show();
				
				A.setClickable(true);
				B.setClickable(true);
				C.setClickable(true);
				D.setClickable(true);
					
				answer_area.setBackgroundColor(Color.CYAN);
				answer_area.setText("");
				correct_wrong.setBackgroundColor(Color.CYAN);
				correct_wrong.setText("");	

				
					
				final Mock_Database dbUser = new Mock_Database(Mock_Test.this);
				   
	
				try {
	 
					
					Cursor c= dbUser.GetData(ctr);
					ctr++;			

				
						
							 	c.moveToFirst();
					   ans = c.getString(6).toString();
					   String image = c.getString(7).toString();
					   imageid = Integer.parseInt(image);							

					   int  ID = getResources().getIdentifier("sample_"+imageid, "drawable", "in.co.shivaji");
                       img.setImageResource(ID);              

           		
           				qtno.setText("Qt NO : " +c.getString(0).toString()+"/20");
					    question.setText(c.getString(1).toString());	    
					    A.setText(c.getString(2).toString());		   
					    B.setText(c.getString(3).toString());		   
					    C.setText(c.getString(4).toString());		   
					    D.setText(c.getString(5).toString());
					     
					    
					    c.close();
					    dbUser.close();
			 	
					 
			     			
					
					} catch (Exception e) {
						
						Toast.makeText(getApplicationContext(),"It is in catch",Toast.LENGTH_LONG).show();
					}
					
				break;
				
			case R.id.previous:
				break;

			
			}
			
		}
	};

}