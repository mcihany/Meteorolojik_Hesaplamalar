package mcy.cihanyeter.meteoroloji.meteorolojihesaplamalar;

import android.icu.text.DecimalFormat;
import android.renderscript.Double2;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by mcyel on 11.11.2016.
 */

public class CevirimFragment extends Fragment {

    EditText cevirim_celcius_text;
    EditText cevirim_kelvin_text;
    EditText cevirim_fahrenayt_text;
    EditText cevirim_ruzgar_knot_text;
    EditText cevirim_ruzgar_kmh_text;
    EditText cevirim_ruzgar_mil_text;
    EditText cevirim_ruzgar_msn_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_masalar, container, false);


        View view = inflater.inflate(R.layout.cevirim_fragment, null);

        cevirim_celcius_text = (EditText) view.findViewById(R.id.cevirim_sicaklik_celcius_text);
        cevirim_kelvin_text = (EditText) view.findViewById(R.id.cevirim_sicaklik_kelvin_text);
        cevirim_fahrenayt_text = (EditText) view.findViewById(R.id.cevirim_sicaklik_fahrenayt_text);
        cevirim_celcius_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(cevirim_celcius_text.hasFocus())
                    sicaklik_cevirim_text_changed(sicaklik.Celcius);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cevirim_fahrenayt_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(cevirim_fahrenayt_text.hasFocus())
                    sicaklik_cevirim_text_changed(sicaklik.Fahrenayt);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cevirim_kelvin_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(cevirim_kelvin_text.hasFocus())
                    sicaklik_cevirim_text_changed(sicaklik.Kelvin);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        cevirim_ruzgar_kmh_text=(EditText)view.findViewById(R.id.cevirim_ruzgar_kmh_text);
        cevirim_ruzgar_knot_text=(EditText)view.findViewById(R.id.cevirim_ruzgar_knot_text);
        cevirim_ruzgar_mil_text=(EditText)view.findViewById(R.id.cevirim_ruzgar_mil_text);
        cevirim_ruzgar_msn_text=(EditText)view.findViewById(R.id.cevirim_ruzgar_msn_text);

        cevirim_ruzgar_kmh_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(cevirim_ruzgar_kmh_text.hasFocus())
                    ruzgar_cevirim_text_changed(ruzgar.kmh);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cevirim_ruzgar_knot_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(cevirim_ruzgar_knot_text.hasFocus())
                    ruzgar_cevirim_text_changed(ruzgar.knot);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cevirim_ruzgar_mil_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(cevirim_ruzgar_mil_text.hasFocus())
                ruzgar_cevirim_text_changed(ruzgar.mil);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cevirim_ruzgar_msn_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(cevirim_ruzgar_msn_text.hasFocus())
                    ruzgar_cevirim_text_changed(ruzgar.msn);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;


    }

    private enum sicaklik {Celcius, Kelvin, Fahrenayt}
    private  enum ruzgar{knot,kmh,msn,mil}
    private void sicaklik_cevirim_text_changed(sicaklik s) {
        double celcius_sicaklik, kelvin_sicaklik, fahrenayt_sicaklik;
        if (s == sicaklik.Celcius) {

            String s_celcius = cevirim_celcius_text.getText().toString();
            if (s_celcius != null && !s_celcius.isEmpty()) {

                try {
                    celcius_sicaklik = Double.parseDouble(s_celcius);
                    kelvin_sicaklik = 273.15 + celcius_sicaklik;
                    fahrenayt_sicaklik = (celcius_sicaklik * 1.8) + 32;
                    cevirim_fahrenayt_text.setText(String.format("%.2f",fahrenayt_sicaklik));
                    cevirim_kelvin_text.setText(String.format("%.2f",kelvin_sicaklik));

                } catch (NumberFormatException ex) {

                    ex.printStackTrace();
                }
            }else{
                cevirim_fahrenayt_text.setText("");
                cevirim_kelvin_text.setText("");
            }
        }else if(s==sicaklik.Kelvin){
            String s_kelvin=cevirim_kelvin_text.getText().toString();
            if(s_kelvin!=null && !s_kelvin.isEmpty()){

                try {
                    kelvin_sicaklik = Double.parseDouble(s_kelvin);
                    celcius_sicaklik = kelvin_sicaklik - 273.15;
                    fahrenayt_sicaklik = (kelvin_sicaklik * (9 / 5)) - 459.67;
                    cevirim_fahrenayt_text.setText(String.format("%.2f", fahrenayt_sicaklik));
                    cevirim_celcius_text.setText(String.format("%.2f", celcius_sicaklik));
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }else {
                cevirim_fahrenayt_text.setText("");
                cevirim_celcius_text.setText("");
            }


        }else if(s==sicaklik.Fahrenayt){
            String s_fahreayt=cevirim_fahrenayt_text.getText().toString();

            if(s_fahreayt!=null && !s_fahreayt.isEmpty()){
                try {
                    fahrenayt_sicaklik = Double.parseDouble(s_fahreayt);
                    celcius_sicaklik=(fahrenayt_sicaklik-32)/1.8;
                    kelvin_sicaklik=(fahrenayt_sicaklik+459.67)/(9/5);
                    cevirim_celcius_text.setText(String.format("%.2f",celcius_sicaklik));
                    cevirim_kelvin_text.setText(String.format("%.2f",kelvin_sicaklik));
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                }

            }else{

                cevirim_celcius_text.setText("");
                cevirim_kelvin_text.setText("");
            }


        }


    }

    private void ruzgar_cevirim_text_changed(ruzgar r){
        double knot_ruzgar,kmh_ruzgar,msn_ruzgar,mil_ruzgar;

        if(r==ruzgar.kmh){
            String s_kmh=cevirim_ruzgar_kmh_text.getText().toString();
            if(s_kmh!=null && !s_kmh.isEmpty()){

                try{
                    kmh_ruzgar=Double.parseDouble(s_kmh);
                    knot_ruzgar=kmh_ruzgar/1.852;
                    msn_ruzgar=kmh_ruzgar*0.27;
                    mil_ruzgar=kmh_ruzgar*0.62;
                    cevirim_ruzgar_knot_text.setText(String.format("%.2f",knot_ruzgar));
                    cevirim_ruzgar_mil_text.setText(String.format("%.2f",mil_ruzgar));
                    cevirim_ruzgar_msn_text.setText(String.format("%.2f",msn_ruzgar));
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }else {
                cevirim_ruzgar_knot_text.setText("");
                cevirim_ruzgar_mil_text.setText("");
                cevirim_ruzgar_msn_text.setText("");
            }
        }else if(r==ruzgar.knot){

            String s_knot=cevirim_ruzgar_knot_text.getText().toString();
            if(s_knot!=null && !s_knot.isEmpty()){
                try{
                    knot_ruzgar=Double.parseDouble(s_knot);
                    kmh_ruzgar=knot_ruzgar*1.852;
                    msn_ruzgar=knot_ruzgar*0.514;
                    mil_ruzgar=knot_ruzgar*1.150;
                    cevirim_ruzgar_kmh_text.setText(String.format("%.2f",kmh_ruzgar));
                    cevirim_ruzgar_mil_text.setText(String.format("%.2f",mil_ruzgar));
                    cevirim_ruzgar_msn_text.setText(String.format("%.2f",msn_ruzgar));

                }catch (
                        NumberFormatException ex){ex.printStackTrace();
                }
            }else{
                cevirim_ruzgar_kmh_text.setText("");
                cevirim_ruzgar_mil_text.setText("");
                cevirim_ruzgar_msn_text.setText("");
            }
        }else if(r==ruzgar.mil){
            String s_mil=cevirim_ruzgar_mil_text.getText().toString();

            if(s_mil!=null && !s_mil.isEmpty()){
                try{
                    mil_ruzgar=Double.parseDouble(s_mil);
                    kmh_ruzgar=mil_ruzgar/0.62;
                    knot_ruzgar=mil_ruzgar/1.150;
                    msn_ruzgar=mil_ruzgar*0.447;
                    cevirim_ruzgar_knot_text.setText(String.format("%.2f",knot_ruzgar));
                    cevirim_ruzgar_kmh_text.setText(String.format("%.2f",kmh_ruzgar));
                    cevirim_ruzgar_msn_text.setText(String.format("%.2f",msn_ruzgar));

                }catch (NumberFormatException ex){
                   ex.printStackTrace();
                }
            }else {
                cevirim_ruzgar_kmh_text.setText("");
                cevirim_ruzgar_knot_text.setText("");
                cevirim_ruzgar_msn_text.setText("");
            }
        }else if(r==ruzgar.msn){

            String s_msn=cevirim_ruzgar_msn_text.getText().toString();
            if(s_msn!=null && !s_msn.isEmpty()){
                try {
                    msn_ruzgar=Double.parseDouble(s_msn);
                    kmh_ruzgar=msn_ruzgar/0.27;
                    knot_ruzgar=msn_ruzgar/0.514;
                    mil_ruzgar=msn_ruzgar/0.447;
                    cevirim_ruzgar_knot_text.setText(String.format("%.2f",knot_ruzgar));
                    cevirim_ruzgar_kmh_text.setText(String.format("%.2f",kmh_ruzgar));
                    cevirim_ruzgar_mil_text.setText(String.format("%.2f",mil_ruzgar));

                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                }



            }else{
                cevirim_ruzgar_kmh_text.setText("");
                cevirim_ruzgar_knot_text.setText("");
                cevirim_ruzgar_mil_text.setText("");
            }

        }
    }
}
