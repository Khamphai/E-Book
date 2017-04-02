package kphai.noobswe.com.e_book;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by K'Phai on 5/18/2016.
 */
public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_PAGER_LAYOUT = 1;
    private Context mContext;
    private static String[] name, cr;
    private static int[] image;

    private OnGridItemSelectedListener mOnGridItemSelectedListener;

    public MainAdapter(Context mContext, String[] textview1, String[] textview2, int[] image) {
        this.mContext = mContext;
        name = textview1;
        cr = textview2;
        this.image = image;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home, null);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        RecyclerViewHolder genericViewHolder = (RecyclerViewHolder) holder;

        genericViewHolder.textView1.setText(name[position]);
        genericViewHolder.textView2.setText(cr[position]);
        genericViewHolder.image.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), image[position]));

    }

    @Override
    public int getItemCount() {
        return name.length;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView image;
        public TextView textView1, textView2;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            //implementing onClickListener
            itemView.setOnClickListener(this);
            textView1 = (TextView) itemView.findViewById(R.id.title1);
            textView2 = (TextView) itemView.findViewById(R.id.title2);
            image = (ImageView)itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View view) {

            //mOnGridItemSelectedListener.onGridItemClick(view,getLayoutPosition() - HEADER_PAGER_LAYOUT);
        }
    }

}
