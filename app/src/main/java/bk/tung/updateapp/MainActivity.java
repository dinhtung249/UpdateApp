package bk.tung.updateapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {
    UpdateApp updateApp = new UpdateApp();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPerms();
        updateApp.setContext(this);
        updateApp.execute("https://download1497.mediafire.com/2t7ely3yn8zg/yfuwjshz8pz1niw/hello.apk");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult (requestCode, permissions, grantResults, this);
    }

    private void checkPerms(){
        String []perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)){
            Log.d("TAG", "OK");
        }else
            EasyPermissions.requestPermissions(this, "Need perms", 100, perms);
    }
}

