package com.creativeshare.emdad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.models.OtherServiceContainerSizeModel;

import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Spinner_Other_Container_Size_Adapter extends BaseAdapter {
    private List<OtherServiceContainerSizeModel.Size> containerSizeModelList;
    private LayoutInflater inflater;
    private String current_language;

    public Spinner_Other_Container_Size_Adapter(Context context, List<OtherServiceContainerSizeModel.Size> containerSizeModelList) {
        this.containerSizeModelList = containerSizeModelList;
        inflater = LayoutInflater.from(context);
        Paper.init(context);
        current_language = Paper.book().read("lang", Locale.getDefault().getLanguage());
    }

    @Override
    public int getCount() {
        return containerSizeModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return containerSizeModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_row, parent, false);

        }
        TextView tv_name = convertView.findViewById(R.id.tv_name);

        OtherServiceContainerSizeModel.Size containerSizeModel = containerSizeModelList.get(position);
        if (current_language.equals("ar")||current_language.equals("ur")) {
            tv_name.setText(containerSizeModel.getAr_size());
        } else {
            tv_name.setText(containerSizeModel.getEn_size());

        }
        return convertView;
    }
}
