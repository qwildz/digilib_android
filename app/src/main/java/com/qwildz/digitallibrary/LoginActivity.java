package com.qwildz.digitallibrary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qwildz.digitallibrary.injector.components.DaggerInjectorComponent;
import com.qwildz.digitallibrary.injector.components.InjectorComponent;
import com.qwildz.digitallibrary.models.Repository;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import timber.log.Timber;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.button_login)
    Button btnLogin;

    ProgressDialog pdialog;

    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    OkHttpClient okHttpClient;

    private boolean successLogin = false;
    private String username, password;

    public static void navigate(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        MyApplication application = (MyApplication) getApplication();
        InjectorComponent injectorComponent = DaggerInjectorComponent.builder()
                .baseComponent(application.getBaseComponent())
                .build();

        injectorComponent.inject(this);

        pdialog = new ProgressDialog(this);
        pdialog.setCancelable(true);
        pdialog.setMessage("Login...");
    }

    @OnClick(R.id.button_login)
    public void login() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        username = inputUsername.getText().toString();
        password = inputPassword.getText().toString();

        if (username.length() == 0 || password.length() == 0) {
            pdialog.hide();
            final AlertDialog.Builder aDialog2 = new AlertDialog.Builder(this);
            aDialog2.setMessage("Please input username and password!");
            aDialog2.setPositiveButton("OK", null);
            aDialog2.create().show();
            return;
        }

        new Login().execute(username, password);

    }

    private class Login extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            pdialog.show();
        }

        protected Void doInBackground(final String... login) {
            Request request = new Request.Builder()
                    .url(Repository.END_POINT + "session/login?nis=" + username + "&password=" + password)
                    .build();

            String responseJson = null;
            try {
                Response response = okHttpClient.newCall(request).execute();
                responseJson = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            Timber.d(responseJson);

            try {
                JSONObject LData = new JSONObject(responseJson);
                boolean status = LData.getBoolean("login_status");

                if(status) {
                    sharedPreferences.edit()
                            .putBoolean("logedin", true)
                            .putString("userid", LData.getJSONObject("users").getString("id"))
                            .putString("token", LData.getString("token")).commit();

                    successLogin = true;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(Void unused) {
            pdialog.dismiss();

            if (successLogin == true) {
                Intent home = new Intent(getApplicationContext(), MainActivity.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(home);
                finish();
            } else {
                final AlertDialog.Builder aDialog2 = new AlertDialog.Builder(LoginActivity.this);
                aDialog2.setMessage("Username or password incorrect!");
                aDialog2.setPositiveButton("OK", null);
                aDialog2.create().show();
            }
        }
    }
}

