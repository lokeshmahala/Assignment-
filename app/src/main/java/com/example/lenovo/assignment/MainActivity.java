package com.example.lenovo.assignment;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String item[] =  {"Fragment 1" ,"Fragment 2 " ," Fragment 3 "};

        final String value[] = {"com.example.lenovo.assignment.Fragment1","com.example.lenovo.assignment.Fragment2","com.example.lenovo.assignment.Fragment3"};

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Pariksha");







        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,item);
       final  DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,  R.string.open, R.string.close);
       //drawerLayout.setDrawerListener(actionBarDrawerToggle);

        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();

            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {


                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {

                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                        fragmentTransaction.replace(R.id.frameLayout, android.support.v4.app.Fragment.instantiate(getApplicationContext(), value[position]));
                        fragmentTransaction.commit();


                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {

                    }
                });
                drawerLayout.closeDrawer(listView);


            }
        });
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, android.support.v4.app.Fragment.instantiate(getApplicationContext(), value[0]));
        fragmentTransaction.commit();










    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
