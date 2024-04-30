package com.example.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class effetSwipe extends ItemTouchHelper.SimpleCallback  {

    private Context context;
    List<Items> mesItems;
    MonAdapter monAdapter;

    private Items items;
    private List<Items> archivesListItem = new ArrayList<>();

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        final int pos = viewHolder.getAbsoluteAdapterPosition();

        switch (direction){
            case ItemTouchHelper.LEFT:
                break;
            case ItemTouchHelper.RIGHT:

                items = mesItems.get(pos);
                archivesListItem.add(items);
                mesItems.remove(pos);
                monAdapter.notifyItemRemoved(pos);

                Snackbar.make(viewHolder.itemView, "Archivage en cour" , Snackbar.LENGTH_LONG)
                        .setAction("Annuler", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                archivesListItem.remove(archivesListItem.lastIndexOf(items));
                                mesItems.add(pos, items);
                                monAdapter.notifyItemInserted(pos);
                            }
                        }).show();

                break;

        }
    }

    public effetSwipe(int dragDirs, int swipeDirs, Context context, List<Items> mesItems, MonAdapter monAdapter) {
        super(dragDirs, swipeDirs);
        this.context = context;
        this.monAdapter = monAdapter;
        this.mesItems = mesItems;
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                //.addBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.red))
                //.addActionIcon(R.drawable.baseline_restore_from_trash_24)
                .addSwipeLeftActionIcon(R.drawable.baseline_restore_from_trash_24)
                .addSwipeLeftBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.red))
                .addSwipeRightActionIcon(R.drawable.baseline_archive_24)
                .addSwipeRightBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.green))
                .create()
                .decorate();
    }
}
