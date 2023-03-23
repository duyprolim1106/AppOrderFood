//package com.example.apporderfood;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//    private List<String> mData;
//
//    public MyAdapter(List<String> data) {
//        mData = data;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        String item = mData.get(position);
//        holder.textView.setText(item);
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView textView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.text_view);
//        }
//    }
//}
//
