package la.gov.nit.nitn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import la.gov.nit.nitn.R;

/**
 * Created by Jaink on 14-09-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Model> dataset;
    private Context mContext;


    public RecyclerViewAdapter(ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder{


        TextView title, subtitle;
        ImageView imageView;
        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.title = (TextView)  itemView.findViewById(R.id.title);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            this.imageView = (ImageView) itemView.findViewById(R.id.Icon);


        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.postdetails, parent, false);
        return new ImageTypeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Model object = dataset.get(position);

        ( (ImageTypeViewHolder) holder).title.setText( object.title );
        ( (ImageTypeViewHolder) holder).subtitle.setText( object.subtitle );


        if (!object.Image.equalsIgnoreCase("")) {
            Picasso.get().load(object.Image).placeholder(R.drawable.ic_launcher_background)// Place holder image from drawable folder
                    .error(R.drawable.ic_launcher_foreground).resize(250, 250).centerCrop()
                    .into(((ImageTypeViewHolder) holder).imageView);
        }else {
            // Should change default image to your logo
            ( (ImageTypeViewHolder) holder).imageView.setImageResource(R.drawable.ic_launcher_background);
        }


        ( (ImageTypeViewHolder) holder).title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WPPostDetails.class);
                intent.putExtra("itemPosition", position);
                mContext.startActivity(intent);
            }
        });
        ( (ImageTypeViewHolder) holder).subtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WPPostDetails.class);
                intent.putExtra("itemPosition", position);
                mContext.startActivity(intent);
            }
        });
        ( (ImageTypeViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WPPostDetails.class);
                intent.putExtra("itemPosition", position);
                mContext.startActivity(intent);
            }
        });

        /// dataset.get(position)
    }

    @Override
    public int getItemCount() {
        return dataset.size() ;
    }

    public String getthumbnail(String objUrl){
        String ImgUrl="";
        return ImgUrl;
    }
}
