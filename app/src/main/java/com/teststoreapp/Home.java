package com.teststoreapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HP on 1/24/2018.
 */

public class Home extends Fragment {

    View view;
    SquareSlider squareSlider;
    RecyclerView recyclerView;

    List<CategoryItem> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.frag_home_page,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        squareSlider = view.findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "https://cdn.pixabay.com/photo/2018/01/14/23/05/visa-3082813_960_720.jpg");
        url_maps.put("Big Bang Theory", "https://cdn.pixabay.com/photo/2018/01/08/02/34/technology-3068617_960_720.jpg");
        url_maps.put("House of Cards", "https://cdn.pixabay.com/photo/2015/11/19/21/14/phone-1052023_960_720.jpg");
        url_maps.put("Game of Thrones", "https://cdn.pixabay.com/photo/2015/01/01/23/55/telephone-586266__340.jpg");

        list = new ArrayList<>();

        for (String name : url_maps.keySet()){

            CategoryItem item = new CategoryItem();

            item.setCategory_name(name);
            item.setExtra_detail(name.substring(0,3));
            item.setImage_url(url_maps.get(name));

            list.add(item);

            ImgWithTextSliderView textSliderView = new ImgWithTextSliderView(getActivity());
            textSliderView.image(url_maps.get(name)).setScaleType(BaseSliderView.ScaleType.CenterCrop).description(name);
            textSliderView.bundle(new Bundle());
            squareSlider.addSlider(textSliderView);
        }

        squareSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        squareSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        squareSlider.setDuration(4000);

        recyclerView.setAdapter(new CategoryAdapter(getActivity(),list));

        return view;
    }

    public void Login(){



    }

}
