package uz.jasurbekruzimov.deliveryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import uz.jasurbekruzimov.deliveryapp.R;
import uz.jasurbekruzimov.deliveryapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setVariable();


    }

    private void setVariable() {
        binding.btnLogin.setOnClickListener(v -> {
            String email = Objects.requireNonNull(binding.edtEmail.getText()).toString();
            String password = Objects.requireNonNull(binding.edtPassword.getText()).toString();

            if (!email.isEmpty() && !password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                Toast.makeText(LoginActivity.this, "Please fill username and password", Toast.LENGTH_SHORT).show();
            }

        });
    }


}