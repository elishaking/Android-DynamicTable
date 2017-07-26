package dynamic.kingf1shar.king.dynamictable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] coursesArray = {"Logic Design", "English", "Calculus I", "Circuit Theory I", "Chemistry"};

    int N = coursesArray.length;

    double[] creditHours = {4, 3, 4, 4, 4};

    double[] credit = {14.8, 12, 14.8, 16, 13.2};

    String[] grade = {"A-", "A", "A-", "A", "B"};

    TableLayout expectedTranscript;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expectedTranscript = (TableLayout) findViewById(R.id.ExpectedTranscript);

        for(int i = 0; i <= N; i++){
            if(i == 0) {
                addCourse("Courses", "CR", "CH", "Grade", i);
            }else {
                addCourse(coursesArray[i-1], round(credit[i-1]), round(creditHours[i-1]), grade[i-1], i);
            }
        }

    }

    private String round(double input){
        if(input == (int)input){
            return String.valueOf((int)input);
        }else {
            return String.valueOf(input);
        }
    }

    private void addCourse(String course, String cr, String ch, String grade, int arrayIndex){

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View newRow = inflater.inflate(R.layout.transcript, null);

        TextView Course = (TextView) newRow.findViewById(R.id.course);
        Course.setText(course);
        Course.setTextColor(getResources().getColor(R.color.white));

        TextView CR = (TextView) newRow.findViewById(R.id.CR);
        CR.setText(cr);
        CR.setTextColor(getResources().getColor(R.color.black));

        TextView CH = (TextView) newRow.findViewById(R.id.CH);
        CH.setText(ch);
        CH.setTextColor(getResources().getColor(R.color.black));

        TextView Grade = (TextView) newRow.findViewById(R.id.Grade);
        Grade.setText(grade);
        Grade.setTextColor(getResources().getColor(R.color.black));

        expectedTranscript.addView(newRow, arrayIndex);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
