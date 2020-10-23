package com.example.myapplication.myapplication22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String TableauxDObjets = "[{\"Designation\":\"ROADSTER\",\"ModeleCommercial\":\"ROADSTER\",\"CNIT\":\
            "M10TSLVP000C002\",\"Id\":41124,\"ModeleDossier\":\"ROADSTER\"},{\"Designati
    on\":\"ROADSTER\",\"ModeleCommercial\":\"ROADSTER\",\"CNIT\":\"M10TSLVP000D0
            03\",\"Id\":41125,\"ModeleDossier\":\"ROADSTER\"}]";

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONArray array = null;
        Log.e(TAG, "Debut de parsing dans la function");

        try{
            array = new JSONArray(tableauDObjets);
            Log.i(TAG, "Nombre d'objets dans le tableau:" + array.length());
        }catch(JSONException e){
            Log.e(TAG, "Erreur lors du parsing JSON:"  + e.getMessage());
        }

        for(int i = 0; i < array.length(); i++){
            try{
                Log.i(TAG, "-----------");
                JSONObject objet = array.getJSONObject(i);

                Log.i(TAG,"Contenu de l'objet numéro : " + i + " : " +  objet.toString());
                Log.i(TAG,"Désignation de la voiture : " +  objet.get("Designation"));
                Log.i(TAG,"Modèle commercial de la voiture : " + objet.get("ModeleCommercial"));
                Log.i(TAG,"CNIT de la voiture : " + objet.get("CNIT"));
                Log.i(TAG,"Id de la voiture : " + objet.get("Id"));
                Log.i(TAG,"Modèle dossier de la voiture : " + objet.get("ModeleDossier"));
                Log.i(TAG,"---------------------------------------");
            }catch (JSONException e){
                Log.e(TAG,"Erreur lors de l'extraction des infos d'un objet " + e.getMessage());
                Log.e(TAG,"Index de l'objet en erreur : " + i);
            }
        }
    }
}