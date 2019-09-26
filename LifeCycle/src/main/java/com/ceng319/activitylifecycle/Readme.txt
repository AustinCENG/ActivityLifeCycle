Introduction:

This is the code to show the Activity Life Cycle in Android.

In this code, the local variable mCounter is increased by 1 every time when a callback method
(OnStart, OnResume, etc.)is called. So when the cellphone rotates, it should keep on increasing.

If onSaveInstanceState and onRestoreInstanceState are not commented out, the local variable mCounter
will be reset every time when the cellphone rotates. When the cellphone roates, the activity will be destroyed and
recreated when it goes back to foreground.

Please try these:
1. Without the onSaveInstanceState and onRestoreInstanceState methods, see what value of mCounter
   will be printed on the screen. Does it update properly when the screen rotates?

2. Add the onSaveInstanceState and onRestoreInstanceState methods back to the code and run the code again,
   Will the value of mCounter update properly now?

Explanation:

To save the local data in activities, we need to follow the following steps:
1. Generate an override method onSaveInstanceState and save your data into some predefined keys by
   calling putInt, putLong, putAll, etc.

2. When the cellphone rotates, the OnCreate method will be called, and onRestoreInstanceState
   will be executed after that.

3. In onRestoreInstanceState method, load the saved data back from savedInstanceState by calling getInt, getAll, etc.