package net.mizofumi.chinachu4j.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.mizofumi.chinachu4j.BasicAuthenticator;
import net.mizofumi.chinachu4j.Chinachu4J;
import net.mizofumi.chinachu4j.Program;

import org.json.JSONException;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Chinachu4J chinachu4J = new Chinachu4J("http://hogefuga:10772/api/",new BasicAuthenticator(
                        "username",
                        "password"
                ));

                try {
                    Program[] programs = chinachu4J.getNowChannelSchedule();

                    Log.d(MainActivity.this.getLocalClassName(), String.valueOf(programs.length));

                    for (int i = 0; i < programs.length; i++) {
                        Log.d(MainActivity.this.getLocalClassName(),programs[i].getTitle());
                    }

                } catch (KeyManagementException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
