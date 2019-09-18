package com.ceng319.activitylifecycle;

import android.graphics.Color;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity {
    private static final String LOCAL_VALUE = "KEY_LOCAL";
    private TextView textview;
    private int mCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textview);
        textview.setText("");
        recordMethod("onCreate Called");
        }

    @Override
    protected void onStart() {
        super.onStart();
        recordMethod("onStart Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        recordMethod("onStop Called -- Entering onStop State");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recordMethod("onDestroy Called -- Entering onDestroy State");
    }

    @Override
    protected void onPause() {
        recordMethod("onPause Called -- \n Entering Pause State");
        super.onPause();

    }

    /**
     * This method is called after {@link #onStart} when the activity is
     * being re-initialized from a previously saved state, given here in
     * <var>savedInstanceState</var>.  Most implementations will simply use {@link #onCreate}
     * to restore their state, but it is sometimes convenient to do it here
     * after all of the initialization has been done or to allow subclasses to
     * decide whether to use your default implementation.  The default
     * implementation of this method performs a restore of any view state that
     * had previously been frozen by {@link #onSaveInstanceState}.
     * <p>
     * <p>This method is called between {@link #onStart} and
     * {@link #onPostCreate}.
     *
     * @param savedInstanceState the data most recently supplied in {@link #onSaveInstanceState}.
     * @see #onCreate
     * @see #onPostCreate
     * @see #onResume
     * @see #onSaveInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            recordMethod("First Time onCreate Called");
        } else if (savedInstanceState.get(LOCAL_VALUE) != null) {
            mCounter = savedInstanceState.getInt(LOCAL_VALUE);
        }
        recordMethod("onRestoreInstanceState Called ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // outState.putInt(LOCAL_VALUE, mCounter);
        outState.putInt(LOCAL_VALUE, mCounter);  // save mCounter into Bundle outStates
        recordMethod("onSaveInstanceState Called");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recordMethod("onResume Called  -- Entering Resumed State");
    }

    /**
     * Called after {@link #onStop} when the current activity is being
     * re-displayed to the user (the user has navigated back to it).  It will
     * be followed by {@link #onStart} and then {@link #onResume}.
     * <p>
     * <p>For activities that are using raw {@link Cursor} objects (instead of
     * creating them through
     * {@link #managedQuery(Uri, String[], String, String[], String)},
     * this is usually the place
     * where the cursor should be requeried (because you had deactivated it in
     * {@link #onStop}.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onStop
     * @see #onStart
     * @see #onResume
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        recordMethod("onRestart Called");
    }

    private void recordMethod(String str){
        //Attach a time stamp.
        long time = (long) (System.currentTimeMillis());
        Timestamp tsTemp = new Timestamp(time);
        String tstr =  tsTemp.toString();
        textview.append(str + " at: \n" + tstr + "\n\n");

        Log.d("MapleLeaf", str + " at: " + tstr);
        // Just as an indicator, not really used to calculate any values.
        mCounter = mCounter + 1;

        // Set view1 to indicate the local variable status.
        TextView view1 = findViewById(R.id.localValueText);
        view1.setText("The Local Private Value mCounter is: " + mCounter);
    }

}
