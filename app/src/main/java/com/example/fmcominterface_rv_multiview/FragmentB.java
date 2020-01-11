package com.example.fmcominterface_rv_multiview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//Todo Step 3 ==> Create FM B
public class FragmentB extends Fragment {

    // get Agruments
    ImageView imageView;
    TextView tvCountry, tvRates, tvCalRates;
    EditText edittext;
    Button button;

    MyChidModel myChidModel = new MyChidModel();
    MyChidModel myChidModel2 = new MyChidModel();

    double input;

    public FragmentB() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_b, container, false);
        findView(v);

        if (getArguments() != null) {
            myChidModel = getArguments().getParcelable("key");

            imageView.setImageResource(myChidModel.getImageFlags());
            tvCountry.setText(myChidModel.getCountryNames());
            tvRates.setText("" + myChidModel.getRates());

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        input = Double.parseDouble(edittext.getText().toString());
                        if (input > 0) {
                            myChidModel2 = new MyChidModel(myChidModel.getRates(), input);
                            tvCalRates.setText("" + myChidModel2.getResult());
                        } else {
                            tvCalRates.setText("number > 0  only");
                        }

                    } catch (NumberFormatException e) {
                        tvCalRates.setText("input number only");
                    }
                }
            });
        }

        return v;
    }

    private void findView(View v) {
        imageView = v.findViewById(R.id.imageView);
        tvCountry = v.findViewById(R.id.tvCountry);
        tvRates = v.findViewById(R.id.tvRates);
        tvCalRates = v.findViewById(R.id.tvCalRates);
        edittext = v.findViewById(R.id.edittext);
        button = v.findViewById(R.id.button);

    }

}
