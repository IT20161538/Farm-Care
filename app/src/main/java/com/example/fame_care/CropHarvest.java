package com.example.fame_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CropHarvest extends AppCompatActivity {

    private Button addnewcrop, print;
    private ListView cropharvestlist;
    private ImageView imgHome;
    //private SearchView searchcrop;
    Context context;
    private List<CropHarvestMethods> charvestlist;
    //private ArrayAdapter<String> arrayAdapter;
    DBHelper3 DB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_harvest);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        addnewcrop = (Button) findViewById(R.id.btn_addcrpharvest);
        //print = (Button) findViewById(R.id.btn_cropprint);
        cropharvestlist = findViewById(R.id.cropharvestlist);
        imgHome = findViewById(R.id.imageView12);
        //searchcrop = findViewById(R.id.srch1);
        context = this;
        charvestlist = new ArrayList<>();
        DB3 = new DBHelper3(this);

        //arrayAdapter = new ArrayAdapter<String>(this, R.layout.crop_harvest_view, R.id.cropharvestlist);
        //cropharvestlist.setAdapter(arrayAdapter);
        charvestlist = DB3.getCropHarvest();

        CropHarvestAdapter cadapter = new CropHarvestAdapter(context, R.layout.crop_harvest_view, charvestlist);
        cropharvestlist.setAdapter(cadapter);

        /*searchcrop.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                CropHarvest.this.arrayAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                CropHarvest.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });*/
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadHome();
            }
        });

        addnewcrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadaddcroppage();
                Toast.makeText(CropHarvest.this, "Please Wait!", Toast.LENGTH_LONG).show();
            }
        });

        cropharvestlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                CropHarvestMethods methods = charvestlist.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Crop Harvest");
                builder.setMessage("Select Actions");

                builder.setPositiveButton("Compare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CropHarvest.this, "Please Wait!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, CropHarvestCompare.class);
                        intent.putExtra("id", String.valueOf(methods.getId()));
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(CropHarvest.this, "Please Wait!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, EditCropHarvest.class);
                        intent.putExtra("id", String.valueOf(methods.getId()));
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DB3.deleteCropHarvest(methods.getId());
                        Toast.makeText(CropHarvest.this, "Record Deleted!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(context, CropHarvest.class));
                    }
                });
                builder.show();
            }
        });
    }

    public void loadHome(){
        Intent intent = new Intent(this, FarmCareHome.class);
        startActivity(intent);
    }

    public void loadaddcroppage(){
        Intent intent = new Intent(this, AddCropHarvest.class);
        startActivity(intent);
    }

    public void printHarvest(View view){
        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        Paint paint = new Paint();
        String list = charvestlist.getClass().toString();
        int x = 10, y = 25;
        page.getCanvas().drawText(list, x, y, paint);
        pdfDocument.finishPage(page);

        String filepath = Environment.getExternalStorageDirectory().getPath() + "/Harvest.pdf";

        File file = new File(filepath);

        try{
            pdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(this, "Printing!", Toast.LENGTH_LONG).show();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show();
        }

        pdfDocument.close();
    }

}