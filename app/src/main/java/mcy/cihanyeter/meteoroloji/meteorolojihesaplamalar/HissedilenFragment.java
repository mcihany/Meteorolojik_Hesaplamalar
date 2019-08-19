package mcy.cihanyeter.meteoroloji.meteorolojihesaplamalar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * Created by mcyel on 11.11.2016.
 */

public class HissedilenFragment extends Fragment {

    Button hesapla_btn;
    EditText sicaklik_text;
    EditText ruzgar_text;
    EditText nem_text;
    TextView sonuc_text;

    public HissedilenFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_masalar, container, false);


        View view = inflater.inflate(R.layout.hissedilen_fragment, null);
        sicaklik_text = (EditText) view.findViewById(R.id.his_sicaklik_text);
        ruzgar_text = (EditText) view.findViewById(R.id.his_ruzgar_text);
        nem_text = (EditText) view.findViewById(R.id.his_nem_text);
        sonuc_text = (TextView) view.findViewById(R.id.his_sicaklik_sonuc_text);

        hesapla_btn = (Button) view.findViewById(R.id.his_sicaklik_hesapla_btn);
        hesapla_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hissedilen_sicaklik=0;
                String s_sicaklik = sicaklik_text.getText().toString();
                String s_ruzgar = ruzgar_text.getText().toString();
                String s_nem = nem_text.getText().toString();
                if (s_sicaklik != null && !s_sicaklik.isEmpty()) {

                    int sicaklik = Integer.parseInt(s_sicaklik);

                    if (s_ruzgar != null && !s_ruzgar.isEmpty()) {

                        int ruzgar = Integer.parseInt(s_ruzgar);
                        if(ruzgar>=0) {
                            if (s_nem != null && !s_nem.isEmpty()) {


                                int nem = Integer.parseInt(s_nem);

                                if(nem>=5 && nem<=100){

                                    if(sicaklik>=26){

                                        hissedilen_sicaklik=(int)hissedilen.nemden_hissedilen((double) nem,cevirimler.celcius_to_fahrenayt(sicaklik));
                                        hissedilen_sicaklik=(int)cevirimler.fahrenayt_to_celcius(hissedilen_sicaklik);

                                    }else if(sicaklik<26 && sicaklik>9){

                                        hissedilen_sicaklik=sicaklik;

                                    }else{
                                        ruzgar=(int)cevirimler.kmh_to_mph((double)ruzgar);

                                        hissedilen_sicaklik=(int)hissedilen.ruzgardan_hissedilen((double)ruzgar,cevirimler.celcius_to_fahrenayt(sicaklik));
                                        hissedilen_sicaklik=(int)cevirimler.fahrenayt_to_celcius(hissedilen_sicaklik);

                                    }

                                    klavyeGizle();
                                    sonuc_text.setText("Hissedilen Sıcaklık: "+String.valueOf(hissedilen_sicaklik)+" ºC") ;

                                    PieChart chart = (PieChart) getActivity().findViewById(R.id.grafik_ekrani);
                                    ArrayList<Entry> entries=new ArrayList<>();

                                    entries.add(new Entry(sicaklik, 0));
                                    entries.add(new Entry(hissedilen_sicaklik, 1));


                                    PieDataSet dataSet=new PieDataSet(entries,"hissedilen");
                                    ArrayList<String> labels=new ArrayList<String>();
                                    labels.add("Ölçülen");
                                    labels.add("Hissedilen");

                                    chart.setDescription("Hissedilen Sıcaklık");

                                    dataSet.setSliceSpace(2f);
                                    if(hissedilen_sicaklik>sicaklik){
                                        dataSet.setColors(ColorTemplate.createColors(getResources(),new int[]{R.color.hissedilen_soguk,R.color.hissedilen_sicak}));
                                    }else if(hissedilen_sicaklik<sicaklik){

                                        dataSet.setColors(ColorTemplate.createColors(getResources(),new int[]{R.color.hissedilen_sicak,R.color.hissedilen_soguk}));
                                    }else{
                                        dataSet.setColors(ColorTemplate.createColors(getResources(),new int[]{R.color.hissedilen_ayni,R.color.hissedilen_ayni}));

                                    }

                                    PieData data = new PieData(labels, dataSet);

                                    chart.setData(data);
                                    chart.animateY(1500);


                                }else {
                                    sonuc_text.setText("");
                                    Toast.makeText(getContext(),"Nem Değeri Aralık Dışında!",Toast.LENGTH_LONG).show();
                                }

                            } else {
                                sonuc_text.setText("");
                                Toast.makeText(getContext(),"Nem Değeri Boş Olamaz!",Toast.LENGTH_LONG).show();

                            }
                        }else {

                            sonuc_text.setText("");

                            Toast.makeText(getContext(),"Rüzgar Değeri Negatif Olamaz!",Toast.LENGTH_LONG).show();
                        }

                    } else {
                        sonuc_text.setText("");
                        Toast.makeText(getContext(),"Rüzgar Değeri Boş Olamaz!",Toast.LENGTH_LONG).show();
                    }

                } else {
                    sonuc_text.setText("");
                    Toast.makeText(getContext(),"Sıcaklık Değeri Boş Olamaz!",Toast.LENGTH_LONG).show();
                }

            }
        });


        return view;
    }

    private void klavyeGizle() {

        View view = getActivity().getCurrentFocus();
        if (view != null) {
            try {
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
