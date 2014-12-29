package me.zsr.collect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.avos.avoscloud.AVObject;

import java.util.List;

/**
 * @description:
 * @author: Saul
 * @date: 14-10-24
 * @version: 1.0
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<AVObject> mAVObjects;
    private ImageLoader mImageLoader;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public NetworkImageView mCover;
        public TextView mName;
        public TextView mAuthor;
        public TextView mCollectDate;
        public ViewHolder(View rootView) {
            super(rootView);
            mCover = (NetworkImageView) rootView.findViewById(R.id.book_cover_img);
            mName = (TextView) rootView.findViewById(R.id.book_name_txt);
            mAuthor = (TextView) rootView.findViewById(R.id.book_author_txt);
            mCollectDate = (TextView) rootView.findViewById(R.id.book_collect_date_txt);
        }
    }

    public BookAdapter(List<AVObject> avObjects, Context context) {
        mAVObjects = avObjects;
        mImageLoader = MySingleton.getInstance(context).getImageLoader();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(rootView);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        AVObject avObject = mAVObjects.get(position);
        holder.mCover.setImageUrl(avObject.getString("cover"), mImageLoader);
        holder.mName.setText("《" + avObject.getString("name") + "》");
        holder.mAuthor.setText(avObject.getString("author"));
        holder.mCollectDate.setText(avObject.getString("collectDate"));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mAVObjects.size();
    }
}
