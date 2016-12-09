package cs321.customstrength;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Savindi on 11/30/2016.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private final ArrayList<String> items;
    private final OnItemClickListener listener;
    //private Context context;

    public interface OnItemClickListener {
        void onItemClick(String exercise);
    }

    public ContentAdapter(ArrayList<String> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }
    public String getText()
    {
        String exercise = listener.toString();

        return exercise;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position), listener);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.cardTitle);
        }

        public void bind(final String item, final OnItemClickListener listener) {
            name.setText(item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                    Intent intent = new Intent(v.getContext(), ExerciseInfo.class);
                    intent.putExtra("Exercise", item);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
