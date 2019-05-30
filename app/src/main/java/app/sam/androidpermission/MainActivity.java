package app.sam.androidpermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn , btn1 , btn2 ,btn3 ;
    ArrayList<String> permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.requestPermissonButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    int accessCamera = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
                    permissions = new ArrayList();

                     if(accessCamera == PackageManager.PERMISSION_DENIED){
                        permissions.add(Manifest.permission.CAMERA);
                    }

                    if(permissions.size() > 0) {
                        ActivityCompat.requestPermissions(MainActivity.this, permissions.toArray(new String[permissions.size()]), 1);
                    }else{
                      //  Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btn1 = (Button) findViewById(R.id.requestPermissonButton2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    int externalStorage = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

                    permissions = new ArrayList();

                    if (externalStorage == PackageManager.PERMISSION_DENIED) {
                        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
                    }

                    if(permissions.size() > 0) {
                        ActivityCompat.requestPermissions(MainActivity.this, permissions.toArray(new String[permissions.size()]), 1);
                    }else{
                      //  Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


        btn2 = (Button) findViewById(R.id.requestPermissonButton3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    int accessLocation = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);

                    permissions = new ArrayList();

                    if (accessLocation == PackageManager.PERMISSION_DENIED) {
                        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
                    }

                    if(permissions.size() > 0) {
                        ActivityCompat.requestPermissions(MainActivity.this, permissions.toArray(new String[permissions.size()]), 1);
                    }else{
                        //  Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btn3 = (Button) findViewById(R.id.requestPermissonButton4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    int sendSms = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS);

                    permissions = new ArrayList();

                    if (sendSms == PackageManager.PERMISSION_DENIED) {
                        permissions.add(Manifest.permission.SEND_SMS);
                    }

                    if(permissions.size() > 0) {
                        ActivityCompat.requestPermissions(MainActivity.this, permissions.toArray(new String[permissions.size()]), 1);

                    }else{
                        //  Toast.makeText(MainActivity.this,"Permission Granted",Toast.LENGTH_LONG).show();

                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(" phone number ", null, "sms permission", null, null);
                    }
                }
            }

        });



    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){

        if(requestCode == 1){
            for (int i=0; i<grantResults.length; i++){
                if(grantResults[i] == PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this,"Oops you just denied the permission to "+permissions[i],Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}
