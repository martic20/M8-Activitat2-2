package martic20.ximo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends AppCompatActivity {
    TextView n1;
    TextView n2;
    TextView n1suma;
    TextView n2suma;
    TextView total;
    TextView tipus;
    int n1int =2;
    int n2int=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SeekBar b1 = (SeekBar) findViewById(R.id.b1);
        SeekBar b2 = (SeekBar) findViewById(R.id.b2);
        b1.setProgress(n1int);
        b2.setProgress(n2int);
        n1 = (TextView) findViewById(R.id.n1);
        n2 = (TextView) findViewById(R.id.n2);
        n1suma = (TextView) findViewById(R.id.n1suma);
        n2suma = (TextView) findViewById(R.id.n2suma);
        total = (TextView) findViewById(R.id.total);
        tipus = (TextView) findViewById(R.id.tipus);

        b1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                n1int=progresValue;
                sumar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

                n2int=progresValue;
                sumar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void sumar(){
        int t = n1int+n2int;
        n1.setText(String.valueOf(n1int));
        n1suma.setText(String.valueOf(n1int));
        n2.setText(String.valueOf(n2int));
        n2suma.setText(String.valueOf(n2int));
        total.setText(String.valueOf(t));

        if (t % 2 == 0) {
            tipus.setText("Parell");
        } else {
            tipus.setText("Senar");
        }

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
        if (id == R.id.action_close) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
