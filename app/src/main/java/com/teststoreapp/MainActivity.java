package com.teststoreapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.teststoreapp.ItemAdapter.SPAN_COUNT_ONE;
import static com.teststoreapp.ItemAdapter.SPAN_COUNT_THREE;

public class MainActivity extends AppCompatActivity {

    EmptyRecyclerView recyclerView;
    ImageView empty_image;
    TextView empty_text;
    LinearLayout empty_view;

    AutoCompleteTextView auto_text;

    List<String> months;
    ListAdapter adapter;

    ItemAdapter itemAdapter;
    GridLayoutManager gridLayoutManager;
    MenuItem itemCart;
    LayerDrawable icon;

    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        months = new ArrayList<>();
        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT_ONE);
        itemAdapter = new ItemAdapter(months, gridLayoutManager);

        recyclerView = (EmptyRecyclerView) findViewById(R.id.recycler_view);
        empty_image = (ImageView) findViewById(R.id.empty_image);
        empty_text = (TextView) findViewById(R.id.empty_text);
        empty_text.setText("List is empty");

        auto_text = (AutoCompleteTextView) findViewById(R.id.auto_text);

        empty_view = (LinearLayout) findViewById(R.id.empty_view);

        recyclerView.setEmptyView(empty_view);

        /*LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);*/

        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        auto_text.setAdapter(adapter);
        /*adapter = new ListAdapter(this,months);
        recyclerView.setAdapter(adapter);*/

        //AddItems();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        itemCart = menu.findItem(R.id.action_cart);
        icon = (LayerDrawable) itemCart.getIcon();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //setBadgeCount(this, icon, "9");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                AddItems();
                return true;
            case R.id.clear:
                months.clear();
                itemAdapter.notifyDataSetChanged();
                return true;
            case R.id.toggle:
                /*boolean isSwitched = adapter.toggleItemViewType();
                recyclerView.setLayoutManager(isSwitched ? new LinearLayoutManager(this) : new GridLayoutManager(this, 2));
                adapter.notifyDataSetChanged();*/

//                switchLayout();

                startActivity(new Intent(MainActivity.this,Main3Activity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        } else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.getItemCount());
    }

    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BadgeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);

    }

    public void AddItems(){
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        itemAdapter.notifyDataSetChanged();

        setBadgeCount(this, icon, ""+months.size());
        itemCart.setIcon(icon);
    }

}
