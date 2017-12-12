package example.sharedpreferences.com.mysharedprefs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserDetails extends AppCompatActivity {

    @BindView(R.id.firstName)
    TextView firstName;

    @BindView(R.id.lastName)
    TextView lastName;

    @BindView(R.id.age)
    TextView age;

    @BindView(R.id.sex)
    TextView isMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_details);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_load_user_details)
    public void showUserDetails() {
        firstName.setText(PreferencesManager.getFirstName(this));
        lastName.setText(PreferencesManager.getLastName(this));
        age.setText(PreferencesManager.getAge(this));
        isMale.setText(PreferencesManager.isMale(this) ? "Male" : "Female");
    }
}
