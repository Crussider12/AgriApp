package agri.app.Adapter.CropSelectionAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import agri.app.DataModule.CropItemSelectionPOJO;
import agri.app.Interfaces.FragmentCommunicationCrop;
import agri.app.R;

import static android.support.constraint.Constraints.TAG;

public class CropSelectionGridAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<CropItemSelectionPOJO> listStorage;
    private Context context;
    private ArrayList<Integer> po = new ArrayList<Integer>();
    FragmentCommunicationCrop fragmentCommunicationCrop;
    int selectedPosition = -1;


    public CropSelectionGridAdapter(Context context, List<CropItemSelectionPOJO> customizedListView) {
        this.context = context;
        layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
        fragmentCommunicationCrop = (FragmentCommunicationCrop) context;
    }


    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.crop_selection_item, parent, false);
            listViewHolder.textInListView = (TextView) convertView.findViewById(R.id.crop_selection_name);
            listViewHolder.imageInListView = (ImageView) convertView.findViewById(R.id.crop_selection_image);
            listViewHolder.selectinList = (ImageView) convertView.findViewById(R.id.crop_selected);
            listViewHolder.mCommunication = fragmentCommunicationCrop;
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ViewHolder) convertView.getTag();
        }

        listViewHolder.textInListView.setText(listStorage.get(position).getContent());

        Glide.with(context)
                .load(listStorage.get(position).getImageResource())
                .into(listViewHolder.imageInListView);

        listViewHolder.br = false;
        listViewHolder.imageInListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listViewHolder.br == true) {
                    listViewHolder.selectinList.setVisibility(View.INVISIBLE);

                    for (int i = 0; i < po.size(); i++) {
                        if (po.get(i) == position) {
                            po.remove(i);
                        }
                    }

                    listViewHolder.br = false;
                } else {
                    listViewHolder.selectinList.setVisibility(View.VISIBLE);
                    Log.d(TAG, "onClick: " + listViewHolder.selectinList.getVisibility());

                    po.add(position);

                    selectedPosition = position;
                    Log.d(TAG, "onClick: addition add" + po);
                    listViewHolder.br = true;
                }
                fragmentCommunicationCrop.respond(po);

            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView textInListView;
        ImageView imageInListView, selectinList;
        Boolean br;
        FragmentCommunicationCrop mCommunication;

    }


}
