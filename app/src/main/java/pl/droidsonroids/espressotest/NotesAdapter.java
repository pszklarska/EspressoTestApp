package pl.droidsonroids.espressotest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    private final Context mContext;
    private final List<Note> mNotesList;

    public NotesAdapter(final Context context, final List<Note> notesList) {
        mContext = context;
        mNotesList = notesList;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new NotesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(final NotesViewHolder holder, final int position) {
        holder.bind(mNotesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNotesList.size();
    }
}
