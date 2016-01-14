package com.foemates.killem;

/**
 * Created by Shivam on 31-Dec-15.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class OneFragment extends Fragment {

    ListView medList;
    ArrayList<MedicineDetails> details;
    AdapterView.AdapterContextMenuInfo info;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_one, container, false);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);

        /*
        medList = (ListView) root.findViewById(R.id.list);
        details = new ArrayList<MedicineDetails>();

        MedicineDetails Detail;
        Detail = new MedicineDetails();
        Detail.setIcon(R.mipmap.ic_launcher);
        Detail.setMedName("Crocin 500 mg");
        Detail.setBrandName("Cipla");
        Detail.setSaltName("Paracetamol");
        Detail.setUploadTime("12/12/2012 12:12");
        details.add(Detail);

        Detail = new MedicineDetails();
        Detail.setIcon(R.drawable.phamaero);
        Detail.setMedName("Nimulid");
        Detail.setBrandName("Dabur");
        Detail.setSaltName("Paracetamol");
        Detail.setUploadTime("13/12/2012 10:12");
        details.add(Detail);

        Detail = new MedicineDetails();
        Detail.setIcon(R.drawable.phamaero);
        Detail.setMedName("Zeptin");
        Detail.setBrandName("Western Digital");
        Detail.setSaltName("Paracetamol");
        Detail.setUploadTime("13/12/2012 02:12");
        details.add(Detail);

        medList.setAdapter(new CustomAdapter(details, getActivity()));
        registerForContextMenu(medList);
        medList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView a, View v, int position, long id) {

                String s =(String) ((TextView) v.findViewById(R.id.medName)).getText();
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        }); */
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                          MyRecyclerViewAdapter.MyClickListener() {
                                                                              @Override
                                                                              public void onItemClick(int position, View v) {
                                                                                  Log.i(LOG_TAG, " Clicked on Item " + position);
                                                                              }
                                                                          });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 5; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }
    /*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);

        info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(details.get(info.position).getMedName());
        menu.add(Menu.NONE, v.getId(), 0, "");
        menu.add(Menu.NONE, v.getId(), 0, "Reply All");
        menu.add(Menu.NONE, v.getId(), 0, "Forward");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Reply") {
            //Do your working
        }
        else if (item.getTitle() == "Reply All") {
            //Do your working
        }
        else if (item.getTitle() == "Reply All") {
            //Do your working
        }
        else     {
            return false;
        }
        return true;
    }
*/
}