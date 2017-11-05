package app.searchlistingapp.com.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import app.searchlistingapp.com.BR;
import app.searchlistingapp.com.R;
import app.searchlistingapp.com.data.Hits;
import app.searchlistingapp.com.injection.ActivityContext;


/**
 * Created by debu on 5/11/17.
 */

public class AdapterListing extends RecyclerView.Adapter<AdapterListing.ListHolder>{

    private List<Hits> listResponses;
    private Context context;

    @Inject
    public AdapterListing(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListHolder(DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false)));
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.getDataBinding().setVariable(BR.model,listResponses.get(holder.getAdapterPosition()));
        holder.getDataBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return listResponses != null ? listResponses.size():0;
    }

    class ListHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding dataBinding;
        ListHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public ViewDataBinding getDataBinding() {
            return dataBinding;
        }
    }

    public void setListResponses(List<Hits> listResponses) {
        this.listResponses = listResponses;
        notifyDataSetChanged();
    }
}
