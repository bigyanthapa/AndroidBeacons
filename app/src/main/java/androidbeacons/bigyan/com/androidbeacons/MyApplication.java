package androidbeacons.bigyan.com.androidbeacons;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.startup.BootstrapNotifier;
import org.altbeacon.beacon.startup.RegionBootstrap;

/**
 * Created by bigyanthapa on 12/30/15.
 */
public class MyApplication extends Application implements BootstrapNotifier {

    public static final String TAG = "BeaconsEverywhere";
    private RegionBootstrap regionBootstrap;


    /** Override onCreate Method */
    @Override
    public void onCreate(){
        super.onCreate();

        Log.d(TAG, "App Started UP");
        BeaconManager beaconManager = BeaconManager.getInstanceForApplication(this);


        final Region region = new Region("myBeacons" , Identifier.parse("01122334-4556-6778-899A-ABBCCDDEEFF0"), null, null);
        regionBootstrap = new RegionBootstrap(this, region);
    }



    /** Override Methods from BootStrapNotifier*/
    @Override
    public void didEnterRegion(Region region) {
        Log.d(TAG,"Entered didEnterRegion");

        /** This call to disable will make it so the activity below only gets launched the first time a beacon is seen (until the next time the app is launched)
         if you want the Activity to launch every single time beacons come into view, remove this call.  */

        regionBootstrap.disable();
        Intent intent = new Intent(this, MainActivity.class);

        /** IMPORTANT: in the AndroidManifest.xml definition of this activity, you must set android:launchMode="singleInstance" or you will get two instances
         created when a user launches the activity manually and it gets launched from here. */

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    @Override
    public void didExitRegion(Region region) {
        Log.d(TAG," Entered didExitRegion");
    }

    @Override
    public void didDetermineStateForRegion(int i, Region region) {
        //Not required now
    }
}
