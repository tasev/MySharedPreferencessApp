package example.sharedpreferences.com.mysharedprefs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.firstName)
    EditText firstName;

    @BindView(R.id.lastName)
    EditText lastName;

    @BindView(R.id.age)
    EditText age;

    @BindView(R.id.isMale)
    RadioButton isMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_save_user_details)
    public void saveUserDetails() {
        PreferencesManager.setFirstName(firstName.getText().toString(), this);
        PreferencesManager.setLastName(lastName.getText().toString(), this);
        PreferencesManager.setAge(age.getText().toString(), this);
        PreferencesManager.setIsmale(isMale.isChecked(), this);

        User user = new User();
        user.setAge(age.getText().toString());
        user.setFirstName(firstName.getText().toString());
        user.setLastName(lastName.getText().toString());
        user.setMale(isMale.isChecked());

        PreferencesManager.addUser(user,this);


        Toast.makeText(this, "User details Saved", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_see_user_details)
    public void seeUserDetails() {
        startActivity(new Intent(MainActivity.this, UserDetails.class));
    }
}
