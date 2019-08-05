package bd.mercado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import bd.mercado.R;
import bd.mercado.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }

    public void calcular(View view) {
        control.calcularAction();
    }

    public void limpar(View view) {
        control.limparAction();
    }
}
