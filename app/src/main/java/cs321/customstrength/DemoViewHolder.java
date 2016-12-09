package cs321.customstrength;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Savindi on 11/29/2016.
 */
public abstract class DemoViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public DemoViewHolder(View view) {
        super(view);
        this.title = (TextView) view.findViewById(R.id.cardTitle);
    }
}
