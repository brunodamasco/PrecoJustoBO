package bd.mercado.control;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import bd.mercado.R;
import bd.mercado.model.DescontoBO;
import bd.mercado.model.Produto;
import bd.mercado.model.ProdutoBO;

public class MainControl {
    private Activity activity;
    private EditText editNome, editValor, editParcela, editJuros;
    private LinearLayout lyResultado;
    private CheckBox cbEntrada;
    private ProdutoBO produtoBO;
    private Produto produto;
    private DescontoBO descontoBO;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
        produtoBO = new ProdutoBO();
        editNome.requestFocus();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editValor = activity.findViewById(R.id.editValor);
        editParcela = activity.findViewById(R.id.editParcelas);
        editJuros = activity.findViewById(R.id.editJuros);
        lyResultado = activity.findViewById(R.id.lyResultado);
        cbEntrada = activity.findViewById(R.id.cbEntrada);
    }

    public void calcularAction() {
        if (cbEntrada.isChecked() == true) {
            preencheEdit();

            if (produto.getNome().isEmpty()){
                editNome.setError("Digite o nome corretamente");
                editNome.requestFocus();
                return;
            }

            if (!ProdutoBO.validaValor(produto)) {
                editValor.setError(activity.getString(R.string.erro_valor));
                Toast.makeText(activity, R.string.erro_valor, Toast.LENGTH_SHORT).show();
                return;
            }

            if (!ProdutoBO.validaParcela(produto)) {
                editParcela.setError(activity.getString(R.string.erro_parcela));
                Toast.makeText(activity, R.string.erro_parcela, Toast.LENGTH_SHORT).show();
                return;
            }

            if (!ProdutoBO.validaJuros(produto)) {
                editJuros.setError(activity.getString(R.string.erro_juros));
                Toast.makeText(activity, R.string.erro_juros, Toast.LENGTH_SHORT).show();
                return;
            }

            TextView tvNewResultado = new TextView(activity);
            tvNewResultado.setText(String.valueOf(descontoBO.toString()));
            lyResultado.addView(tvNewResultado);
            limparForm();
        }
        preencheEdit();
        if (produto.getNome().isEmpty()){
            editNome.setError("Digite o nome corretamente");
            editNome.requestFocus();
            return;
        }

        if (!ProdutoBO.validaValor(produto)) {
            editValor.setError(activity.getString(R.string.erro_valor));
            Toast.makeText(activity, R.string.erro_valor, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!ProdutoBO.validaParcela(produto)) {
            editParcela.setError(activity.getString(R.string.erro_parcela));
            Toast.makeText(activity, R.string.erro_parcela, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!ProdutoBO.validaJuros(produto)) {
            editJuros.setError(activity.getString(R.string.erro_juros));
            Toast.makeText(activity, R.string.erro_juros, Toast.LENGTH_SHORT).show();
            return;
        }

        TextView tvNewResultado = new TextView(activity);
        tvNewResultado.setText(String.valueOf(produtoBO.toString()));
        lyResultado.addView(tvNewResultado);
        limparForm();
    }

    private void preencheEdit() {
        produto = new Produto();
        descontoBO = new DescontoBO(produto);
        produtoBO = new ProdutoBO(produto);
        produto.setNome(editNome.getText().toString());
        produto.setValor(editValor.getText().toString());
        produto.setParcela(editParcela.getText().toString());
        produto.setJuros(editJuros.getText().toString());
    }


    private void validaCampo() {
        if (!ProdutoBO.validaNome(produto)) {
            editNome.setError(activity.getString(R.string.erro_nome));
            Toast.makeText(activity, R.string.erro_nome, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!ProdutoBO.validaValor(produto)) {
            editValor.setError(activity.getString(R.string.erro_valor));
            Toast.makeText(activity, R.string.erro_valor, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!ProdutoBO.validaParcela(produto)) {
            editParcela.setError(activity.getString(R.string.erro_parcela));
            Toast.makeText(activity, R.string.erro_parcela, Toast.LENGTH_SHORT).show();
            return;
        }

        if (!ProdutoBO.validaJuros(produto)) {
            editJuros.setError(activity.getString(R.string.erro_juros));
            Toast.makeText(activity, R.string.erro_juros, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void limparForm() {
        editNome.setText("");
        editValor.setText("");
        editParcela.setText("");
        editJuros.setText("");
        editNome.requestFocus();
    }
    public void limparAction() {
        limparForm();
        lyResultado.removeAllViews();
    }
}
