package io.github.anthonyeef.v2jobs.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import io.github.anthonyeef.v2jobs.R;
import io.github.anthonyeef.v2jobs.app.AppController;
import io.github.anthonyeef.v2jobs.data.FeedItem;

/**
 * Created by anthonyeef on 8/15/15.
 */
public class FeedListAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<FeedItem> feedItems;
    ImageLoader imageLoader = AppController.getmInstance().getImageLoader();

    public FeedListAdapter(Activity activity, List<FeedItem> feedItems) {
        this.activity = activity;
        this.feedItems = feedItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null)
            convertView = inflater.inflate(R.layout.feed_item, null);
        if (imageLoader == null)
            imageLoader = AppController.getmInstance().getImageLoader();

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView timestamp = (TextView) convertView.findViewById(R.id.timestamp);

        NetworkImageView avatar = (NetworkImageView) convertView.findViewById(R.id.avatar);

        FeedItem item = feedItems.get(position);

        title.setText(item.getTitle());

        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
                Long.parseLong(item.getTimeStamp()),
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
        timestamp.setText(timeAgo);

        avatar.setImageUrl(item.getAvatar(), imageLoader);

        return convertView;
    }
}
