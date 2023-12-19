package uz.jasurbekruzimov.deliveryapp.Activity;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.Objects;

import uz.jasurbekruzimov.deliveryapp.R;
import uz.jasurbekruzimov.deliveryapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseActivity {
    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();


    }

    private void setVariable() {
        binding.btnSignUp.setOnClickListener(v -> {
            String email = Objects.requireNonNull(binding.edtEmail.getText()).toString();
            String password = Objects.requireNonNull(binding.edtPassword.getText()).toString();

            if (email.isEmpty()) {
                binding.edtEmail.setError("Email is required");
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isComplete()) {
                                Log.i(TAG, "onComplete:");
                                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                            } else {
                                Log.i(TAG, "failure: " + task.getException());
                            }
                            }
                    });

        });
    }
}