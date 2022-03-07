package com.greenply.crm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;

import com.greenply.crm.Adapter.MenuAdapter;
import com.greenply.crm.Modal.Menu;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class HomeScreen extends AppCompatActivity {

    ArrayList<Menu> mListMenu = new ArrayList<>();
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
        mDrawerList = (ListView) findViewById(R.id.mDrawerList);
        initList();
        menuAdapter = new MenuAdapter(HomeScreen.this, mListMenu);
        mDrawerList.setAdapter(menuAdapter);

        FragmentDashbord fragmentDiscover = new FragmentDashbord();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragmentDiscover, "ABC1")
                .commit();


    }

    private void initList() {
     Menu menu = new Menu();
     menu.setmStrMenuName("Dashboard");
     menu.setmIntMenuImg(R.drawable.ic_menu_dashbord);
     mListMenu.add(menu);

        Menu menu1 = new Menu();
        menu1.setmStrMenuName("Estimates");
        menu1.setmIntMenuImg(R.drawable.ic_menu_dashbord);
        mListMenu.add(menu1);

        Menu menu2 = new Menu();
        menu2.setmStrMenuName("Accounts");
        menu2.setmIntMenuImg(R.drawable.ic_menu_account);
        mListMenu.add(menu2);

        Menu menu3 = new Menu();
        menu3.setmStrMenuName("Notes");
        menu3.setmIntMenuImg(R.drawable.ic_menu_notes);
        mListMenu.add(menu3);

        Menu menu4 = new Menu();
        menu4.setmStrMenuName("Reminders");
        menu4.setmIntMenuImg(R.drawable.ic_menu_reminders);
        mListMenu.add(menu4);

        Menu menu5 = new Menu();
        menu5.setmStrMenuName("History");
        menu5.setmIntMenuImg(R.drawable.ic_menu_history);
        mListMenu.add(menu5);

        Menu menu6 = new Menu();
        menu6.setmStrMenuName("Projects");
        menu6.setmIntMenuImg(R.drawable.ic_menu_projects);
        mListMenu.add(menu6);

        Menu menu7 = new Menu();
        menu7.setmStrMenuName("Services");
        menu7.setmIntMenuImg(R.drawable.ic_menu_services);
        mListMenu.add(menu7);

        Menu menu8 = new Menu();
        menu8.setmStrMenuName("Password");
        menu8.setmIntMenuImg(R.drawable.ic_menu_password);
        mListMenu.add(menu8);

        Menu menu9 = new Menu();
        menu9.setmStrMenuName("Logout");
        menu9.setmIntMenuImg(R.drawable.ic_menu_logout);
        mListMenu.add(menu9);


    }
}