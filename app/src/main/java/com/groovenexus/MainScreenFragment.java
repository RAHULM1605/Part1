package com.groovenexus;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LinearLayout horizontalLayout;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NewsBox> list = new ArrayList<>();
    ArtistItem[] items;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainScreenFragment() {

    }
    public class NewsBox
    {
        public String pic;
        public String text1,text2;
        public boolean imgRight;

        public NewsBox(String pic, String text1/*, String text2, boolean imgRight*/) {
            this.pic = pic;
            this.text1 = text1;
//            this.text2 = text2;
//            this.imgRight = imgRight;
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainScreenFragment newInstance(String param1, String param2) {
        MainScreenFragment fragment = new MainScreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.activity_main_screen, container, false);

        horizontalLayout = v.findViewById(R.id.linearlayout1);
        recyclerView = v.findViewById(R.id.recyclerView);

        for (int i = 0; i < 10; i++) {
            ImageView view = new ImageView(v.getContext());
            Picasso.with(v.getContext()).load(R.drawable.artistsample).resize(275, 275).into(view);
            horizontalLayout.addView(view);
        }



        recyclerView.setHasFixedSize(true);

//
        String exampleText1 = "Hello world", exampleText2 = "If you smell what the Rock is Cooking!!! And that's the bottomline, coz Stone Cold said so!!!";
//        for(int i=0;i<20;i++)
//            list.add(new NewsBox("https://www.groovenexus.com/wp-content/uploads/rythdmdee.jpg",exampleText1/*,exampleText2,false*/));

        parseJSON();
//        ArtistItem[] items;
//        String url = "https://www.demo.groovenexus.info/wp-json/mobileapp/v1/djmeta?artist_type=Disc%20Jockey";
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                GsonBuilder gsonBuilder = new GsonBuilder();
//                Gson gson = gsonBuilder.create();
//                items = gson.fromJson(response,ArtistItem[].class);
//                for(int i=0;i<items.length;i++)
//                    list.add(new NewsBox(items[i].getImgUrl(),items[i].getDisplayName()));
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(),"Something went wrong", Toast.LENGTH_SHORT).show();
//            }
//        });
//        RequestQueue requestQueue = Volley.newRequestQueue(v.getContext());
//        requestQueue.add(stringRequest);

        adapter = new MainScreenAdapter(v.getContext(),list);
        recyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void parseJSON() {

        final String url = "https://www.demo.groovenexus.info/wp-json/mobileapp/v1/djmeta?artist_type=Disc%20Jockey";
        StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                ArtistItem[] items = gson.fromJson(response,ArtistItem[].class);

                for(int i = 0; i<items.length; i++)
                {
                    String img = items[i].getImgUrl();
                    String name = items[i].getDisplayName();
//                                int likes = hit.getInt("likes");
//                                String img = hit.getString("");
//                                String name = hit.getString();
//                                int likes = hit.getInt("likes");

                    list.add(new NewsBox(img, name));

                    //  String name = hit.getString("post_title");
                    // list.add(new Item(name));
                }

                adapter = new MainScreenAdapter(getContext(),list);
                recyclerView.setAdapter(adapter);

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}
